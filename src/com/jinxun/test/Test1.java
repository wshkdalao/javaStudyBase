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
	 * ��д��һ��������������������int getMaxNumRem(int n1,int n2)
	 * �ҳ�0~n2��Χ�ڣ�����n1��7�����������ҵ��˷��ظ������Ҳ�������-1��
	 */
	public static int getMaxNumRem(int n1,int n2) {
		//����Ǵ�С����ҵģ��������ֵ��䣻
		//ֱ�ӴӴ���С�ң�����ĵ�һ������ �������
		int max = 0;
		for(int i=0;i<=n2;i++) {
			if(i%n1==7&&max<=i) {
				max = i;
			}
		}
		if(max!=0) return max;
		return -1;
	}
	//forѭ��
	//����0~100֮��������ĸ���
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
		System.out.println("�����ĸ�����"+count);
	}
	//switch����ʹ��string�������ݣ�JDK1.7���ϵĶ����ԣ�
	public static void test03(String str) {
		switch(str) {
		case "i":
			System.out.println("��");
			break;
		case "love":
			System.out.println("��");
			break;
		case "you":
			System.out.println("��");
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
				System.out.println(num+"���Ա�����");
				break;
			}else {
				System.out.println(num);
			}
		}
	}

}
