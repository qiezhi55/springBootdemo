package com.example.demo.configuration;

import com.example.demo.filter.CustomAuthenticationProvider;
import com.example.demo.filter.JWTAuthenticationFilter;
import com.example.demo.filter.JWTLoginFilter;
import com.example.demo.security.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 徐靖峰
 * Date 2018-04-19
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserService customUserService;

	// password 方案三：支持多种编码，通过密码的前缀区分编码方式,推荐
	@Bean
	PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	//
//    /**
//     * 这一步的配置是必不可少的，否则SpringBoot会自动配置一个AuthenticationManager,覆盖掉内存中的用户
//     */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		AuthenticationManager manager = super.authenticationManagerBean();
		return manager;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
				 //we don't need CSRF because our token is invulnerable
//				.csrf().disable()
//				// don't create session
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.requestMatchers().anyRequest()
				.and()
				.authorizeRequests()
				.antMatchers("/oauth/**","/loginauthenticationManager", "/home").permitAll()
				.and()
//				.addFilter(new JWTLoginFilter(authenticationManager()))
//				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
		.httpBasic().disable();
		// @formatter:on
		http
				.headers()
				.frameOptions().sameOrigin()  // required to set for H2 else H2 Console will be blank.
				.cacheControl();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService).passwordEncoder( PasswordEncoderFactories.createDelegatingPasswordEncoder());
//		auth.authenticationProvider(new CustomAuthenticationProvider(customUserService, PasswordEncoderFactories.createDelegatingPasswordEncoder()));
	}

}
