package com.example.demo.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lj on 2018/12/18.
 */
@Component
//@RabbitListener(queues = "topic.messages")
public class TopicReceiver2 {

	@RabbitHandler
	public void process(String message) {
		System.out.println("Topic Receiver2  : " + message);
	}

}
