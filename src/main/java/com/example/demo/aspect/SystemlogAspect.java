package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * Created by lj on 2018/12/18.
 */
@Aspect
@Component
public class SystemlogAspect {
//service层切点
	@Pointcut("@annotation(com.example.demo.annotation.SystemServiceLog)")
public void serviceAspect(){}
	//controller切点
	@Pointcut("@annotation(com.example.demo.annotation.SystemControllerLog)")
	public void controllerAspect(){}
}
