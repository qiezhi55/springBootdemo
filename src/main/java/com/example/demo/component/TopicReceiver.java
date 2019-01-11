package com.example.demo.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lj on 2018/12/18.
 */
@Component
public class TopicReceiver {

	@RabbitHandler
	public void process(String message) {
		System.out.println("Topic Receiver1  : " + message);
	}

}
