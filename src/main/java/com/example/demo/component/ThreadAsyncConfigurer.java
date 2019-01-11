package com.example.demo.component;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * Created by lj on 2019/1/2.
 */
@Component
public class ThreadAsyncConfigurer implements AsyncConfigurer {
	@Bean(name="asyncExecutor")
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
		//设置核心线程数
		threadPool.setCorePoolSize(10);
		//设置最大线程数
		threadPool.setMaxPoolSize(100);
		//线程池所使用的缓冲队列
		threadPool.setQueueCapacity(10);
		//等待任务在关机时完成--表明等待所有线程执行完
		threadPool.setWaitForTasksToCompleteOnShutdown(true);
		// 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
		threadPool.setAwaitTerminationSeconds(60);
		//  线程名称前缀
		threadPool.setThreadNamePrefix("MyAsync-");
		// 初始化线程
		threadPool.initialize();
		return threadPool;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}
}
