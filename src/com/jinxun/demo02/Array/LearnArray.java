package com.jinxun.demo02.Array;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class LearnArray {
	
	public  static void main(String[] args) {
		
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
	
	//数组遍历：
	@Test
	public void testTraverseArray() {
		Integer[] arr = {1,2,3,4,5,6};
		//方式1：for循环，数组下标遍历；
		for(int i=0;i<arr.length;i++) {
			System.out.print(String.format("下标：%d , 值为：%d%n",i,arr[i]));
		}
		System.out.println();
		//方式2：增强for循环
		for(Integer i:arr) {
			System.out.print(String.format("存放：%d%n", i));
		}
		//方式3：lambda表达式
		Arrays.asList(arr).forEach(val->System.out.println(val));
		
	}
	
	//数组拷贝：
	@Test
	public void testCopy() {
		Integer[] arr1 = {1,2,3,4,5};
		Integer[] arr2 = {6,7,8,9,0};
		//拷贝arr1的前三个元素，生成一个新的数组；
		//copyOf(参数1，参数2)：参数1：指定从参数1中拷贝；参数2：指定拷贝的元素个数；
		//从前向后拷贝；
		Integer[] arr11 = Arrays.copyOf(arr1, 3);
		System.out.println(Arrays.toString(arr11));
		System.out.println("==========");
		//拷贝arr1的 后三个元素，生成一个新的数组；
		//copyOfRange(参数1，参数2，参数3)：
		//参数1：指定从参数1中拷贝；参数2：指定拷贝的开始位置(从1开始计算)；
		//参数3：指定拷贝的结束的位置(从1开始计算)；
		//下面的意思是：拷贝arr1数组，从倒数第三个拷贝到最后一个；
		Integer[] arr12 = Arrays.copyOfRange(arr1, arr1.length - 3, arr1.length);
		System.out.println(Arrays.toString(arr12));
		//拷贝arr2的后三个元素，到arr1的后三个元素；也就是替换掉arr1的最后三个元素；
		//arraycopy(参数1,参数2,参数3,参数4,参数5)
		//参数1：指定从参数1拷贝；
		//参数2：指定从参数2开始拷贝；
		//参数3：指定拷贝到参数3；
		//参数4：指定从参数4开始拷贝(覆盖)；
		//参数5：指定拷贝的长度；
		//这个方法拷贝结束，则arr1数组就发生了变化；
		System.arraycopy(arr2,arr2.length-3,arr1,arr1.length-3,3);
		System.out.println("arr1 = "+Arrays.toString(arr1));
	}
	
	//数组填充
	@Test
	public void testFillArray() {
		Integer[] arr1 = {1,2,23,4,5};
		//将arr1全填充为0
		Arrays.fill(arr1, 0);
		System.out.println(Arrays.toString(arr1));
		//范围填充:参数2/3都是从1开始计数；
		//将arr1数组的最后三个填充为52
		Arrays.fill(arr1, arr1.length-3, arr1.length, 52);
		System.out.println(Arrays.toString(arr1));
	}
	
	//数组排序
	@Test
	public void testSort() {
		long time = System.currentTimeMillis();
		//第一个容量为100的数组，随机给每一位赋0~100的值，然后给数组排序；
		Integer[] arr = new Integer[100];
		for(int i=0;i<arr.length;i++) {
			arr[i] = new Random().nextInt(100)+1;
		}
		//从大到小排序
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
		System.out.println("用时："+(System.currentTimeMillis()-time));
		//使用工具类排序：默认从小到大排序
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	//多维数组和不规则数组
	@Test
	public void testDouWeiArray() {
		//定义一个二位数组，第一维表示用户，第二维表示用户的具体信息(1.编号；2.姓名；3.性别；)
		//第一个二维数组：第一维必须指定容量；第二维可以不指定；
		//一个一维数组的值，都对应一个新的数组(存在第二维中)；
		String[][] users = new String[3][];
		//第一个user
		//指定第一个第二维数组的容量；每个第二维数组的容量可以不等；
		users[0] = new String[3];
		users[0][0] = "001";
		users[0][1] = "小明";
		users[0][2] = "男";
		//第二个user
		users[1] = new String[3];
		users[1][0] = "002";
		users[1][1] = "小芳";
		users[1][2] = "女";
		//第三个user
		users[2] = new String[2];
		users[2][0] = "003";
		users[2][1] = "小黑";
		for(String[] user:users) {
			System.out.println(Arrays.toString(user));
		}
		//使用lambda表达式，遍历；下面的是一个一个值的输出；
		Arrays.asList(users).forEach(user -> Arrays.asList(user).
				forEach(val -> System.out.println(val)));
		//使用lambda表达式，遍历；下面的是直接输出第二维数组；
		Arrays.asList(users).forEach(user -> 
				System.out.println(Arrays.toString(user)));
	}
}
