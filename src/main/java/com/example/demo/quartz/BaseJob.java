package com.example.demo.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by lj on 2018/12/22.
 */
public interface  BaseJob extends Job {
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException;
}
