package com.jinxun.test;

import java.util.Random;
import java.util.Scanner;

import org.junit.Test;



public class Test1 {
	public static void main(String[] args) {
		System.out.println(getMaxNumRem(11,1000));;
//		test04();
		 
	}
	
	
	/*
	 * 编写：一个方法，带有两个参数int getMaxNumRem(int n1,int n2)
	 * 找出0~n2范围内，除以n1余7的最大的数，找到了返回该数，找不到返回-1；
	 */
	public static int getMaxNumRem(int n1,int n2) {
		//这个是从小向大找的，所以最大值会变；
		//直接从大向小找，输出的第一个就是 最大数；
		int max = 0;
		for(int i=0;i<=n2;i++) {
			if(i%n1==7&&max<=i) {
				max = i;
			}
		}
		if(max!=0) return max;
		return -1;
	}
	//for循环
	//计算0~100之间的奇数的个数
	@Test
	public  void test04() {
		int count = 0;
		for(int i=0;i<=100;i++) {
			if(i%2 != 0) {
				count++;
				System.out.print(i+"\t");
				if(i%5==0) {
					System.out.println();
				}
			}
		}
		System.out.println("奇数的个数："+count);
	}
	//switch可以使用string类型数据，JDK1.7以上的都可以；
	public static void test03(String str) {
		switch(str) {
		case "i":
			System.out.println("我");
			break;
		case "love":
			System.out.println("爱");
			break;
		case "you":
			System.out.println("爱");
			break;
		default:
			System.out.println("I Love You!");
		}
	}
	public static void test02(){
		for(int i=0;i<10;i++) {
//			System.out.println(new Random().nextInt(3)+1);
			System.out.println((int)(Math.random()*3)+1);
		}
	}
	public static void test01() {
		while(true) {
//			int num = (int)(Math.random()*1000); 
			int num = new Random().nextInt(1000);
			if(num%30 == 0) {
				System.out.println(num+"可以被整除");
				break;
			}else {
				System.out.println(num);
			}
		}
	}

}
