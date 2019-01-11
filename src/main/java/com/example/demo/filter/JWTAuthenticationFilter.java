package com.example.demo.filter;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lj on 2019/1/11.
 */
public class JWTAuthenticationFilter  extends BasicAuthenticationFilter {
	public static final String SIGNING_KEY = "spring-security-@Jwt!&Secret^#";
	private static final Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String header = request.getHeader("Authorization");
		if (header == null || !header.startsWith("Bearer ")) {
			chain.doFilter(request, response);
			return;
		}
		UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		long start = System.currentTimeMillis();
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty()) {
			throw new RuntimeException("Token为空");
		}
		// parse the token.
		String user = null;
		try {
			user = Jwts.parser()
					.setSigningKey(SIGNING_KEY)
					.parseClaimsJws(token.replace("Bearer ", ""))
					.getBody()
					.getSubject();
			long end = System.currentTimeMillis();
			logger.info("执行时间: {}", (end - start) + " 毫秒");
			if (user != null) {
				String[] split = user.split("-")[1].split(",");
				ArrayList<GrantedAuthority> authorities = new ArrayList<>();
				for (int i=0; i < split.length; i++) {
					authorities.add(new SimpleGrantedAuthority(split[i]));
				}
				return new UsernamePasswordAuthenticationToken(user, null, authorities);
			}

		} catch (ExpiredJwtException e) {
			logger.error("Token已过期: {} " + e);
			throw new RuntimeException("Token已过期");
		} catch (UnsupportedJwtException e) {
			logger.error("Token格式错误: {} " + e);
			throw new RuntimeException("Token格式错误");
		} catch (MalformedJwtException e) {
			logger.error("Token没有被正确构造: {} " + e);
			throw new RuntimeException("Token没有被正确构造");
		} catch (SignatureException e) {
			logger.error("签名失败: {} " + e);
			throw new RuntimeException("签名失败");
		} catch (IllegalArgumentException e) {
			logger.error("非法参数异常: {} " + e);
			throw new RuntimeException("非法参数异常");
		}

		return null;
	}

}
