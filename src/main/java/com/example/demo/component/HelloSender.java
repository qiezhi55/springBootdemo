package com.example.demo.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lj on 2018/12/18.
 */
@Component
public class HelloSender {
//	@Autowired
	private AmqpTemplate rabbitTemplate;
	public void send(){
		String context="hello"+new Date();
		System.out.println("Sender : " + context);
		rabbitTemplate.convertAndSend(context);
	}
}
