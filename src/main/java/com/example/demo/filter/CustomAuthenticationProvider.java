package com.example.demo.filter;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

/**
 * Created by lj on 2019/1/11.
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private UserDetailsService userDetailsService;

	private PasswordEncoder passwordEncoder;
	public CustomAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder){
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// 获取认证的用户名 & 密码
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		// 认证逻辑
		UserDetails userDetails = userDetailsService.loadUserByUsername(name);
		if (null != userDetails) {
			if (passwordEncoder.matches(password, userDetails.getPassword())) {
				// 生成令牌 这里令牌里面存入了:name,password,authorities, 当然你也可以放其他内容
				Authentication auth = new UsernamePasswordAuthenticationToken(name, password, userDetails.getAuthorities());
				return auth;
			} else {
				throw new BadCredentialsException("密码错误");
			}
		} else {
			throw new UsernameNotFoundException("用户不存在");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
