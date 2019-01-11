package com.example.demo;

import com.example.demo.component.HelloSender;
import com.example.demo.model.Info;
import com.example.demo.quartz.HelloJob;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
    @Autowired
	private Info info;
	@Test
	public void contextLoads() {
	}
	@Test
	public void test() throws Exception {

//		// 保存字符串
//		stringRedisTemplate.opsForValue().set("object","test");
//		System.out.println(stringRedisTemplate.opsForValue().get("object"));

		redisTemplate.opsForValue().set("info",info);
		Info testInfo=(Info) redisTemplate.opsForValue().get("info");
		System.out.println(testInfo.getProfile());

	}

	@Autowired
	private HelloSender helloSender;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Test
	public void hello() throws Exception {
		String context = "hi, i am message 1";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
		String contexts = "hi, i am messages 2";
		System.out.println("Sender : " + contexts);
		this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
	}
}
