package com.example.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by lj on 2018/12/16.
 */
@Component
public class Info implements Serializable {
	private static final long serialVersionUID = -1L;
	@Value("${info.profile}")
	private String profile;
	@Value("${info.from}")
	private String from;

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
