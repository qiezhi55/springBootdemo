package com.example.demo.controller;

import com.example.demo.model.Info;
import com.example.demo.model.User;
import com.example.demo.quartz.HelloJob;
import com.example.demo.service.AsyncService;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lj on 2018/12/9.
 */
@Controller
public class HelloController {
	@Autowired
	private UserService userService;
	@Autowired
	private Info info;
	@Autowired
	@Qualifier("Scheduler")
	private Scheduler scheduler;
	@Autowired
	private AsyncService asyncService;
	@RequestMapping("/user/{id}")
	@ResponseBody
	public User getUser(@PathVariable String id){
		return userService.getUser(id);
	}
	@RequestMapping("/info")
	@ResponseBody
	public Info getInfo(){
		return info;
	}
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/getInfo")
	public String getInfo(HttpServletRequest request){
		try {
			// 启动调度器
			scheduler.start();
			//构建job信息
			JobDetail jobDetail= JobBuilder.newJob(HelloJob.class).withIdentity("helloJob","helloJobGroup").build();
			//表达式调度构建器(即任务执行的时间)
			CronScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
			Trigger trigger= TriggerBuilder.newTrigger().withIdentity("helloJob","helloJobGroup").withSchedule(scheduleBuilder).build();
			scheduler.scheduleJob(jobDetail,trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		info.setFrom("changeFrom");
		request.setAttribute("info",info);
		return "info";
	}

	@RequestMapping("/async")
	@ResponseBody
	@ApiOperation(value = "測試綫程")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "sn", value = "编号", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "query")
	})
	public void async(){
		System.out.println("测试线程池");
		asyncService.executeAsync();
	}
}
