package com.example.demo.util;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lj on 2018/12/28.
 */
public class ProxyTest {
	public static void main(String[] args) {
		Obj obj=new Obj();
		ProTest proTest=(ProTest) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),new DynamicProxy(obj));
		proTest.say();
		proTest.eat();
		//cglib
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(Obj.class);
		enhancer.setCallback(new ObjProxy());
		Obj obj1=(Obj)enhancer.create();
		obj1.say();
		obj1.eat();
	}
}
class Obj implements ProTest{

	@Override
	public boolean say() {
		System.out.println("say obj");
		return true;
	}

	@Override
	public boolean eat() {
		System.out.println("eat obj");
		return false;
	}
}
interface ProTest{
	boolean say();
	boolean eat();
}
class DynamicProxy implements InvocationHandler{
	private Obj obj;
	DynamicProxy(Obj obj){
		this.obj=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("eat")){
			System.out.println("eat eat obj");
		}
		return method.invoke(obj,args);
	}
}
class  ObjProxy implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("Before Method Invoke:"+method.getName());
		Object object=methodProxy.invokeSuper(o,objects);
		System.out.println("After Method Invoke");
		return object;
	}
}