package com.example.demo.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by lj on 2018/12/27.
 */
public class AtomicTest {

	public static void main(String[] args) {
		AtomicReference<People> atomicReference=new AtomicReference<>();
		People people1=new People(1,"a",1);
		People people2=new People(2,"b",2);
		boolean a=atomicReference.compareAndSet(null,people1);
		System.out.println("test1:"+a);
		boolean b=atomicReference.compareAndSet(people1,people2);
		System.out.println("test2:"+b);

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread1-----------");

				People people = atomicReference.get();
				people.setName("Tom1");
				people.setAge(people.getAge()+1);
				atomicReference.getAndSet(people);
				System.out.println("Thread1:"+atomicReference.get().toString());
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				atomicReference.compareAndSet(people2,people1);
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread2-----------");
				boolean tr=atomicReference.compareAndSet(people1,people2);
				System.out.println(tr);
				People people = atomicReference.get();
				people.setName("Tom2");
				people.setAge(people.getAge()+1);
				System.out.println("Thread2:"+atomicReference.getAndSet(people).toString());
			}
		}).start();
	}
}
class People {
	Integer id;
	String name;
	Integer age;
	@Override
	public String toString() {
		return "People{" +
				"id='" + id + '\'' +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
	public People(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}