package com.jinxun.demo02.Array;

import java.util.Arrays;

import org.junit.Test;

public class LearnArray {
	
	public  static void main(String[] args) {
		
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
	
	//���������
	@Test
	public void testTraverseArray() {
		Integer[] arr = {1,2,3,4,5,6};
		//��ʽ1��forѭ���������±������
		for(int i=0;i<arr.length;i++) {
			System.out.print(String.format("�±꣺%d , ֵΪ��%d%n",i,arr[i]));
		}
		System.out.println();
		//��ʽ2����ǿforѭ��
		for(Integer i:arr) {
			System.out.print(String.format("��ţ�%d%n", i));
		}
		//��ʽ3��lambda���ʽ
		Arrays.asList(arr).forEach(val->System.out.println(val));
		
	}
	
	//���鿽����
	@Test
	public void testCopy() {
		Integer[] arr1 = {1,2,3,4,5};
		Integer[] arr2 = {6,7,8,9,0};
		//����arr1��ǰ����Ԫ�أ�����һ���µ����飻
		//copyOf(����1������2)������1��ָ���Ӳ���1�п���������2��ָ��������Ԫ�ظ�����
		//��ǰ��󿽱���
		Integer[] arr11 = Arrays.copyOf(arr1, 3);
		System.out.println(Arrays.toString(arr11));
		System.out.println("==========");
		//����arr1�� ������Ԫ�أ�����һ���µ����飻
		//copyOfRange(����1������2������3)��
		//����1��ָ���Ӳ���1�п���������2��ָ�������Ŀ�ʼλ��(��1��ʼ����)��
		//����3��ָ�������Ľ�����λ��(��1��ʼ����)��
		//�������˼�ǣ�����arr1���飬�ӵ������������������һ����
		Integer[] arr12 = Arrays.copyOfRange(arr1, arr1.length - 3, arr1.length);
		System.out.println(Arrays.toString(arr12));
		//����arr2�ĺ�����Ԫ�أ���arr1�ĺ�����Ԫ�أ�Ҳ�����滻��arr1���������Ԫ�أ�
		//arraycopy(����1,����2,����3,����4,����5)
		//����1��ָ���Ӳ���1������
		//����2��ָ���Ӳ���2��ʼ������
		//����3��ָ������������3��
		//����4��ָ���Ӳ���4��ʼ����(����)��
		//����5��ָ�������ĳ��ȣ�
		//�������������������arr1����ͷ����˱仯��
		System.arraycopy(arr2,arr2.length-3,arr1,arr1.length-3,3);
		System.out.println("arr1 = "+Arrays.toString(arr1));
	}
	

}
