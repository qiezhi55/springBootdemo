package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by lj on 2018/12/18.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {

	String description() default "";


}