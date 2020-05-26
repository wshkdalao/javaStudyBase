package com.jinxun.demo02.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
	
	//�������
	@Test
	public void testFillArray() {
		Integer[] arr1 = {1,2,23,4,5};
		//��arr1ȫ���Ϊ0
		Arrays.fill(arr1, 0);
		System.out.println(Arrays.toString(arr1));
		//��Χ���:����2/3���Ǵ�1��ʼ������
		//��arr1���������������Ϊ52
		Arrays.fill(arr1, arr1.length-3, arr1.length, 52);
		System.out.println(Arrays.toString(arr1));
	}
	
	//��������
	@Test
	public void testSort() {
		long time = System.currentTimeMillis();
		//��һ������Ϊ100�����飬�����ÿһλ��0~100��ֵ��Ȼ�����������
		Integer[] arr = new Integer[100];
		for(int i=0;i<arr.length;i++) {
			arr[i] = new Random().nextInt(100)+1;
		}
		//�Ӵ�С����
		int tmp = 0 ;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("��ʱ��"+(System.currentTimeMillis()-time));
		//ʹ�ù���������Ĭ�ϴ�С��������
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	//Arrays.equals()����:����boolean���Ƚ�ÿһ��ֵ����һ��ֵ���Ⱦͷ���false;
	@Test
	public void testEquals() {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {1,2,3,4};
		int[] arr3 = {1,2,3};
		int[] arr4 = {1,2,5,6};
		int[] arr5 = {5,6,7,8};
		System.out.println(Arrays.equals(arr1, arr2));
		System.out.println(Arrays.equals(arr1, arr3));
		System.out.println(Arrays.equals(arr1, arr4));
		System.out.println(Arrays.equals(arr1, arr5));
	}
	//Arrays.testBinarySearch()����:���������±꣬�ڲ���1�������ҵ�ֵΪkey��Ԫ�أ��ײ�ʹ�ö��ֲ��ң�
	@Test
	public void testBinarySearch() {
		int[] arr1 = {1,2,3,4};
		int a = Arrays.binarySearch(arr1, 4);
		System.out.println(a);
	}
	
	//��ά����Ͳ���������
	@Test
	public void testDouWeiArray() {
		//����һ����λ���飬��һά��ʾ�û����ڶ�ά��ʾ�û��ľ�����Ϣ(1.��ţ�2.������3.�Ա�)
		//��һ����ά���飺��һά����ָ���������ڶ�ά���Բ�ָ����
		//һ��һά�����ֵ������Ӧһ���µ�����(���ڵڶ�ά��)��
		String[][] users = new String[3][];
		//��һ��user
		//ָ����һ���ڶ�ά�����������ÿ���ڶ�ά������������Բ��ȣ�
		users[0] = new String[3];
		users[0][0] = "001";
		users[0][1] = "С��";
		users[0][2] = "��";
		//�ڶ���user
		users[1] = new String[3];
		users[1][0] = "002";
		users[1][1] = "С��";
		users[1][2] = "Ů";
		//������user
		users[2] = new String[2];
		users[2][0] = "003";
		users[2][1] = "С��";
		for(String[] user:users) {
			System.out.println(Arrays.toString(user));
		}
		//ʹ��lambda���ʽ���������������һ��һ��ֵ�������
		Arrays.asList(users).forEach(user -> Arrays.asList(user).
				forEach(val -> System.out.println(val)));
		//ʹ��lambda���ʽ���������������ֱ������ڶ�ά���飻
		Arrays.asList(users).forEach(user -> 
				System.out.println(Arrays.toString(user)));
	}
	
	//��ϰ1��
	//1.����һ����������nums �� һ��Ŀ��ֵtarget���������� �ҳ�����Ԫ�� ��Ϊ target,�����������Ԫ�ص��±ꣻ
	//������ظ�Ԫ�أ�
	@Test
	public void testTwoSum() {
		int[] arr = {1,2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(arr));
		
	}
	//�ⷨ1��
	public int[] testPractice011(int[] nums,int target) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				//��i�ĺ���һ����ʼ�������Ϳ��Ա���[i=1,j=5] �� [j=1��i=5]������ˣ�
				if((nums[i]+nums[j])==target) {
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
	//�ⷨ2��
		public int[] testPractice012(int[] nums,int target) {
			//�ȶ������������
			Arrays.sort(nums);
			for(int i=0;i<nums.length;i++) {
				if(nums[i]>=target) break;//��һ��������target����ڶ�����һ��>=target
				for(int j=i+1;j<nums.length;j++) {
					if(nums[j]>target) break;
					//��i�ĺ���һ����ʼ�������Ϳ��Ա���[i=1,j=5] �� [j=1��i=5]������ˣ�
					if((nums[i]+nums[j])==target) {
						return new int[] {i,j};
					}
				}
			}
			return null;
		}
	//�ⷨ3��
	public int[] testPractice01(int[] nums ,int target) {
		//�ȶ������������
		Arrays.sort(nums);
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			if(nums[i] > target) return null;
			//ֱ�ӿ��������Ƿ�������ֵ��������˵��������ֵ��Ϊtarget��
			if(map.containsKey(target-nums[i])) {
				return new int[] {map.get(target-nums[i]),i};
			}
			//����Ž���ֵ���±����map�У����Ҹ�ֵֻ���һ�Σ�
			map.put(nums[i],i);
		}
		return null;
	}
	
	//��ϰ2��
	//�鿴ִ�н��
	@Test
	public void test01() {
		int[] arr = {1,2,7,11,15};
		testPractice02(arr);
		System.out.println(Arrays.toString(arr));
	}
	public void testPractice02(int[] arr) {
//		arr = new int[] {1,1,1,1,1}; //�޸����ã�����ı�test01�е�arr�����ã�
		Arrays.fill(arr, 0); //�޸�����ָ���ֵ����ı�test01�е�arr����ָ���ֵ��
	}
	//��ϰ3��
	//�鿴ִ�н��
	@Test
	public void test02() {
		int[] arr1;
		int[] arr2 = new int[3];
		String[] arr3 = new String[3];
//		System.out.println(Arrays.toString(arr1)); //���뱨��δ��ʼ��
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
	}
}
