package com.example.demo.util;

import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lj on 2018/12/19.
 */
public class SortUtil{
	//快速排序
	public static int  oneTurn(Integer[] array,int low,int high){
		int key=array[low];
		while (low<high){
			while (key<=array[high]&&low<high)high--;
			if(low<high)array[low]=array[high];
			while (key>=array[low]&&low<high)low++;
			if(low<high)array[high]=array[low];
		}
		array[low]=key;
		return low;
	}
	public static void quickSort(Integer[] array,int low,int high){
        if (low>=high)return;
        int index=oneTurn(array,low,high);
		quickSort(array,low,index-1);
		quickSort(array,index+1,high);
	}
    public static void bubbleSort(Integer[] array){
		for (int i = 0; i < array.length-1; i++) {

			for (int j = 0; j <array.length-1-i ; j++) {
				if (array[j]>array[j+1]){
					int key=array[j];
					array[j]=array[j+1];
					array[j+1]=key;
				}
			}
		}
	}
	public static void selectSort(Integer[] array){
		for (int i = 0; i <array.length-1 ; i++) {
			int key=i;
			for (int j = i+1; j <array.length; j++) {
				if (array[key]>array[j])key=j;
			}
			int temp=array[i];
			array[i]=array[key];
			array[key]=temp;
		}
	}
	public static void insertSort(Integer[] array){
		int j=0;
		for (int i = 0; i <array.length ; i++) {
			int temp=array[i];
			for ( j = i; j >0&&temp<array[j-1] ; j--) {
					array[j]=array[j-1];
			}
			array[j]=temp;
		}
	}
	public int say(){
		System.out.println("say");
		return 1;
	}
	//1000 3留1
	public static void changeList(){
		List<Integer> list=new LinkedList<Integer>();
		for (int i = 0; i <1000 ; i++) {
			list.add(i+1);
		}
		int fo=0,tag=2;
		while (list.size()>1){
			if (tag>0){
				tag--;
				if (fo==12){
					System.out.println(fo);
				}
				if (fo==list.size())fo=0;
				list.remove(fo);
				if (fo==list.size())fo=0;
			}else if (tag==0){
				fo++;
				tag=2;
			}
		}
		System.out.println(list.get(0));
	}
	public static void main(String[] args) {
//		 Integer[] array=new Integer[]{1,2,3,4,9,7,5,4,6};
//		quickSort(array,0,array.length-1);
////		bubbleSort(array);
////		selectSort(array);
////		insertSort(array);
//		System.out.println(Arrays.toString(array));


//		Service1 service1 = new Service1();
//		Thread1 thread1 = new Thread1(service1);
//		Thread1 thread2 = new Thread1(service1);
//		Thread1 thread3 = new Thread1(service1);
//		thread1.start();
//		thread2.start();
//		thread3.start();
		List<Integer> list=new LinkedList<Integer>();
		for (int i = 0; i <1000 ; i++) {
			list.add(i+1);
		}
		int fo=0,tag=2,saveNum=1;
		while (list.size()>1){
			if (fo==list.size())fo=0;
			if (saveNum==1){
				fo++;
				saveNum--;
			}else if (tag>0){
				tag--;
				if (fo==12){
					System.out.println(fo);
				}
				list.remove(fo);
			}else if (tag==0){
				tag=2;
				saveNum=1;
			}
		}
		System.out.println(list.get(0));
	}
}
class Thread1 extends Thread{
	private Service1 service1;
	public Thread1(Service1 service1) {
		super();
		this.service1 = service1;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		service1.task();
	}
}
class Service1 {
	private Lock lock = new ReentrantLock();
	public void task(){
		//lock()方法获得锁
		lock.lock();
		for(int i=0;i<5;i++){
			System.out.println("当前线程为： "+Thread.currentThread().getName());
		}
		//unlock()方法释放锁
		lock.unlock();
	}
}