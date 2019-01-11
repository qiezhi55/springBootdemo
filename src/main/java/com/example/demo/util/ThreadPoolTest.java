package com.example.demo.util;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by lj on 2018/12/24.
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
		ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(5));//Executors.newCachedThreadPool();
		for (int i = 0; i <20 ; i++) {
          MyTask myTask=new MyTask(i);
			Boolean tag=true;
			while (tag){
				if (poolExecutor.getQueue().size()<5){
					poolExecutor.execute(myTask);
					tag=false;
				}else {
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("线程池中线程数目："+poolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
					poolExecutor.getQueue().size()+"，已执行玩别的任务数目："+poolExecutor.getCompletedTaskCount());
		}
		poolExecutor.shutdown();
	}
}
class MyTask implements Runnable{
	private int taskNum;

	public MyTask(int num) {
		this.taskNum = num;
	}
	@Override
	public void run() {
		System.out.println("正在执行task "+taskNum);
		try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("执行任务线程:"+Thread.currentThread().getName()+",task "+taskNum+"执行完毕");
	}
}