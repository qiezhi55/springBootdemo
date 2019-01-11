package com.example.demo.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by lj on 2018/12/18.
 */
//@Configuration
public class RabbitConfig {
	@Bean
	public Queue queue(){
		return new Queue("hello");
	}
}
