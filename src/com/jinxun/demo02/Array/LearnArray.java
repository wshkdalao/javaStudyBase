package com.jinxun.demo02.Array;

import java.util.Arrays;

import org.junit.Test;

public class LearnArray {
	
	public  static void main(String[] args) {
		
	}
	
	//���������
	@Test
	public void testTraverseArray() {
		Integer[] arr = {1,2,3,4,5,6};
		//��ʽ1��forѭ���������±������
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		//��ʽ2����ǿforѭ��
		for(Integer i:arr) {
			System.out.print(i+"\t");
		}
		//��ʽ3��lambda���ʽ
		
	}
	
	//����Ĵ�������ʼ��
	@Test
	public void testCreateArray() {
		//�����������Ͳ�����null���������Ϳ��ԣ�
		int[] arr1;//����ʹ��
		int arr2[];
		int[] arr3 = new int[] {1,2,3,4};//[]�ڲ��ܶ������������򱨴�
		String[] strs = {"hello",",","world","!"};//����ʹ��
		System.out.println(Arrays.toString(strs));
	}

}
