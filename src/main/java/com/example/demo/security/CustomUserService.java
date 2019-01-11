package com.example.demo.security;

import com.example.demo.mapper.SysUserMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by lj on 2019/1/7.
 */
@Service
public class CustomUserService implements UserDetailsService  {
	@Autowired
	private SysUserMapper userMapper;
  @Autowired
  private PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户
		SysUser user = userMapper.findByUserName(username);
		if(user == null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return user;
	}
}
