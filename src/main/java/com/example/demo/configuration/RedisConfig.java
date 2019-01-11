package com.example.demo.configuration;

import com.example.demo.util.RedisObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by lj on 2018/12/18.
 */
@Configuration
public class RedisConfig {
	@Bean
	public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		RedisObjectSerializer redisObjectSerializer=new RedisObjectSerializer();
		RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		redisTemplate.setKeySerializer(stringRedisSerializer);
		redisTemplate.setValueSerializer(redisObjectSerializer);
		return redisTemplate;
	}
}
