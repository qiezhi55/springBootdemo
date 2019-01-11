package com.example.demo.model;

/**
 * Created by lj on 2019/1/7.
 */
public class Msg {
	private String title;
	private String content;
	private String etraInfo;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEtraInfo() {
		return etraInfo;
	}

	public void setEtraInfo(String etraInfo) {
		this.etraInfo = etraInfo;
	}

	public Msg(String title, String content, String etraInfo) {
		this.title = title;
		this.content = content;
		this.etraInfo = etraInfo;
	}
}
