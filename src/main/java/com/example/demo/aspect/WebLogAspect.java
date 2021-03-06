package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by lj on 2018/12/18.
 */
@Aspect
@Component
public class WebLogAspect {
	ThreadLocal<Long> startTime = new ThreadLocal<>();
	@Pointcut("execution(public * com.example.demo.controller..*.*(..))")
	public void webLog(){}
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		startTime.set(System.currentTimeMillis());

		// 省略日志记录内容
	}
	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		System.out.println("RESPONSE : " + ret);
		System.out.println("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
	}
}
