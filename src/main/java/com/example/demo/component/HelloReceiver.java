package com.example.demo.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lj on 2018/12/18.
 */
@Component
//@RabbitListener(queues = "hello")
public class HelloReceiver {
	@RabbitHandler
	public void process(String info){
		System.out.println("Receiver  : " + info);
	}
}
