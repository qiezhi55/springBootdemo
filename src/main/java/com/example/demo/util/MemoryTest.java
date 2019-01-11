package com.example.demo.util;

import com.example.demo.model.User;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by lj on 2018/12/28.
 */
public class MemoryTest extends Test.Test1 {
	/**1.new方式会生成对象同时加入常量池,相当于生成了两个对象
	 * 2.String c = "aa" + "bb";  其中的aa/bb只要有任何一个不是字符串字面常量形式，都不会在常量池生成"aabb". 且此时jvm做了优化，不会同时生成"aa"和"bb"在字符串常量池中
	 * 3.intern()方法在jdk1.7以后支持将对象引用加入常量池
	 *  @param args
	 */
	public static void main(String[] args) {
		String s1 = new String("aaa");
		String s2 = "aaa";
		System.out.println(s1 == s2);    // false

		s1 = new String("bbb").intern();
		s2 = "bbb";
		System.out.println(s1 == s2);    // true

		s1 = "ccc";
		s2 = "ccc";
		System.out.println(s1 == s2);    // true

		s1 = new String("ddd").intern();
		s2 = new String("ddd").intern();
		System.out.println(s1 == s2);    // true

		s1 = "ab" + "cd";
		s2 = "abcd";
		System.out.println(s1 == s2);    // true

		String temp = "hh";
		s1 = "a" + temp;
// 如果调用s1.intern 则最终返回true
		s2 = "ahh";
		System.out.println(s1 == s2);    // false

		temp = "hh".intern();
		s1 = "a" + temp;
		s2 = "ahh";
		System.out.println(s1 == s2);    // false

		temp = "hh".intern();
		s1 = ("a" + temp).intern();
		s2 = "ahh";
		System.out.println(s1 == s2);    // true

		s1 = new String("1");    // 同时会生成堆中的对象 以及常量池中1的对象，但是此时s1是指向堆中的对象的
		s1.intern();            // 常量池中的已经存在
		s2 = "1";
		System.out.println(s1 == s2);    // false

		String s3 = new String("1") + new String("1");    // 此时生成了四个对象 常量池中的"1" + 2个堆中的"1" + s3指向的堆中的对象（注此时常量池不会生成"11"）
		s3.intern();    // jdk1.7之后，常量池不仅仅可以存储对象，还可以存储对象的引用，会直接将s3的地址存储在常量池
		String s4 = "11";    // jdk1.7之后，常量池中的地址其实就是s3的地址
		System.out.println(s3 == s4); // jdk1.7之前false， jdk1.7之后true

		s3 = new String("2") + new String("2");
		s4 = "22";        // 常量池中不存在22，所以会新开辟一个存储22对象的常量池地址
		s3.intern();    // 常量池22的地址和s3的地址不同
		System.out.println(s3 == s4); // false// 对于什么时候会在常量池存储字符串对象，我想我们可以基本得出结论: 1. 显示调用String的intern方法的时候; 2. 直接声明字符串字面常量的时候，例如: String a = "aaa";// 3. 字符串直接常量相加的时候，例如: String c = "aa" + "bb";  其中的aa/bb只要有任何一个不是字符串字面常量形式，都不会在常量池生成"aabb". 且此时jvm做了优化，不//   会同时生成"aa"和"bb"在字符串常量池中
	}
	MemoryTest(Test test){
		test.super();
	}
}
class Test{
	public class Test1{
		Test1(){
			System.out.println("test1");
		}
	}
	synchronized public  void threadTest(String s){
		System.out.println("父类同步方法开始:"+s);
		if (s=="a"){
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
            System.out.println("父类同步方法结束:"+s);
	}
	public Test(){
		System.out.println("test");
	}
	public  static final void ch(int i){
		System.out.println("int");
	}
}
class Egg2{
	protected class Yolk{
		public Yolk(){
			System.out.println("Egg2.Yolk()");
		}
		public void f(){
			System.out.println("Egg2.Yolk.f()");
		}
	}



	private Yolk y = new Yolk();

	public Egg2(){
		System.out.println("new Egg2()");
	}

	public void insertYolk(Yolk yy) {
		y = yy;
	}

	public void g() {
		y.f();
	}
}
 class BigEgg2 extends Egg2 {
	public class Yolk extends Egg2.Yolk{
		public Yolk(){
			System.out.println("BigEgg2.Yolk()");
		}

		 public void f(){
			System.out.println("BigEgg2.Yolk.f()");
		}
	}

	public BigEgg2(){
		insertYolk(new Yolk());
	}

	public static void main(String[] args) {
		Egg2 e2 = new BigEgg2();
		e2.g();
	}
}