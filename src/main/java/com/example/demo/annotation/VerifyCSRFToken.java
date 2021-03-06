package com.example.demo.annotation;

/**
 * Created by lj on 2017/6/2.
 */
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 跨站请求仿照注解
 */
@Target({ java.lang.annotation.ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifyCSRFToken {

    /**
     * 需要验证防跨站请求
     *
     */
    public abstract boolean verify() default true;

}
