package com.example.demo.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lj on 2018/12/18.
 */
public class TopicRabbitConfig {
	@Bean
	public Queue queueMessage(){
		return  new Queue("topic.message");
	}
	@Bean
	public Queue queueMessages(){
		return new Queue("topic.messages");
	}
	@Bean
	public TopicExchange exchange(){
		return new TopicExchange("exchange");
	}
	@Bean
	public Binding bindingExchangeMessages(Queue queueMessages,TopicExchange exchange){
		return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
	}
	@Bean
	public Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}
}
