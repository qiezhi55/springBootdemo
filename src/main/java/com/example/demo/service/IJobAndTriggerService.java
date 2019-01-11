package com.example.demo.service;

/**
 * Created by lj on 2018/12/22.
 */
import com.example.demo.model.JobAndTrigger;
import com.github.pagehelper.PageInfo;

public interface IJobAndTriggerService {
	public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);
}