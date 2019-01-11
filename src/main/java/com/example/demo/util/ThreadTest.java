package com.example.demo.util;

/**
 * Created by lj on 2018/12/29.
 */
public class ThreadTest {
	public volatile Holder holder;
	public void init(){
		holder=new Holder(42);
	}
	public  synchronized void test(int i){
		System.out.println(i);
		if (i==0) return;
		test(--i);
	}
	public  synchronized void test1(int i){
		System.out.println(i);
		if (i==0) return;
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		ThreadTest test=new ThreadTest();
		for (int i = 0; i <10 ; i++) {
			final int a=i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					test.init();
					test.holder.assertSanity();
				}
			}).start();
		}

	}
}
class NoVisibility{
	private static boolean ready;
	private static int number;
	private static class ReaderThread extends Thread{
		@Override
		public void run(){
			int count=0;
          while (!ready){
			  count++;
			  Thread.yield();
		  }
          System.out.println(number);
			System.out.println(count);
		}
	}

	public static void main(String[] args) {
		new ReaderThread().start();
		number=42;
		ready=true;
	}
}
class Father extends ThreadTest{
	public  void test1(int i){
		System.out.println(i);
		super.test1(i);
	}
}

class Holder{
   private int n;
   public Holder(int n){
   	this.n=n;
   }
   public void assertSanity(){
   	if (n!=n)System.out.println("test");
   	System.out.println(n);
   }
}