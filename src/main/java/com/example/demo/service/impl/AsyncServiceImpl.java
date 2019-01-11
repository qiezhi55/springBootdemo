package com.example.demo.service.impl;

import com.example.demo.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by lj on 2019/1/2.
 */
@Service
public class AsyncServiceImpl implements AsyncService {
	@Override
	@Async("asyncExecutor")
	public void executeAsync() {
		System.out.println("start executeAsync");
		System.out.println("线程名称："+Thread.currentThread().getName());
		System.out.println("异步线程要做的事情");
		System.out.println("可以在这里执行批量插入等耗时的事情");

		System.out.println("end executeAsync");

	}
}
