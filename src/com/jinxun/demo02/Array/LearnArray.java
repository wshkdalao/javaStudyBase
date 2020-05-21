package com.jinxun.demo02.Array;

import java.util.Arrays;

import org.junit.Test;

public class LearnArray {
	
	public  static void main(String[] args) {
		
	}
	
	//数组遍历：
	@Test
	public void testTraverseArray() {
		Integer[] arr = {1,2,3,4,5,6};
		//方式1：for循环，数组下标遍历；
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		//方式2：增强for循环
		for(Integer i:arr) {
			System.out.print(i+"\t");
		}
		//方式3：lambda表达式
		
	}
	
	//数组的创建，初始化
	@Test
	public void testCreateArray() {
		//基本数据类型不允许传null，引用类型可以；
		int[] arr1;//建议使用
		int arr2[];
		int[] arr3 = new int[] {1,2,3,4};//[]内不能定义容量，否则报错
		String[] strs = {"hello",",","world","!"};//建议使用
		System.out.println(Arrays.toString(strs));
	}

}
