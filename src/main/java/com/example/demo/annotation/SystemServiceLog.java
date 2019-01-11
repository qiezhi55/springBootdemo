package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by lj on 2018/12/18.
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
	String description() default "";
}
