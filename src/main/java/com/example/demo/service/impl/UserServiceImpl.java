package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lj on 2018/12/9.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Resource
	private UserMapper userMapper;
	@Override
	@Transactional
	public User getUser(String id) {
		User user= userMapper.selectByPrimaryKey(Integer.parseInt(id));
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return null;
	}
}
