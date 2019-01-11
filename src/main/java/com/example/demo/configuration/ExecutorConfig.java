package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by lj on 2019/1/2.
 */
@EnableAsync
@Configuration
public class ExecutorConfig {
	@Value("${async.executor.thread.core_pool_size}")
	private int corePoolSize;
	@Value("${async.executor.thread.max_pool_size}")
	private int maxPoolSize;
	@Value("${async.executor.thread.queue_capacity}")
	private int queueCapacity;
	@Value("${async.executor.thread.name.prefix}")
	private String namePrefix;
	@Bean(name="asyncServiceExecutor")
	public Executor asyncServiceExecutor(){
		ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
		//配置核心线程数
		executor.setCorePoolSize(corePoolSize);
		//配置最大线程数
		executor.setMaxPoolSize(maxPoolSize);
		//配置队列大小
		executor.setQueueCapacity(queueCapacity);
		//配置线程池中的线程的名称前缀
		executor.setThreadNamePrefix(namePrefix);
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.initialize();
		return executor;
	}
}
