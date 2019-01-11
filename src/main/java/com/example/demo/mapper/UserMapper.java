package com.example.demo.mapper;

import com.example.demo.model.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
@CacheConfig(cacheNames="users")
public interface UserMapper {
    @CacheEvict(key ="#p0",allEntries=true)
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);
    @Cacheable(key = "#p0")
    User selectByPrimaryKey(Integer id);
     @CachePut(key = "#p0.id")
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}