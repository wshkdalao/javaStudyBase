package com.jinxun.demo02.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
	
	//Arrays.equals()方法:返回boolean，比较每一个值，有一个值不等就返回false;
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
	//Arrays.testBinarySearch()方法:返回数组下标，在参数1数组中找到值为key的元素，底层使用二分查找；
	@Test
	public void testBinarySearch() {
		int[] arr1 = {1,2,3,4};
		int a = Arrays.binarySearch(arr1, 4);
		System.out.println(a);
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
	
	//练习1：
	//1.给定一个整数数组nums 和 一个目标值target，在数组中 找出两个元素 和为 target,并输出这两个元素的下标；
	//不输出重复元素；
	@Test
	public void testTwoSum() {
		int[] arr = {1,2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(arr));
		
	}
	//解法1：
	public int[] testPractice011(int[] nums,int target) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				//从i的后面一个开始，这样就可以避免[i=1,j=5] 和 [j=1，i=5]的情况了；
				if((nums[i]+nums[j])==target) {
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
	//解法2：
		public int[] testPractice012(int[] nums,int target) {
			//先对数组进行排序
			Arrays.sort(nums);
			for(int i=0;i<nums.length;i++) {
				if(nums[i]>=target) break;//第一个数大于target，则第二个数一定>=target
				for(int j=i+1;j<nums.length;j++) {
					if(nums[j]>target) break;
					//从i的后面一个开始，这样就可以避免[i=1,j=5] 和 [j=1，i=5]的情况了；
					if((nums[i]+nums[j])==target) {
						return new int[] {i,j};
					}
				}
			}
			return null;
		}
	//解法3：
	public int[] testPractice01(int[] nums ,int target) {
		//先对数组进行排序
		Arrays.sort(nums);
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			if(nums[i] > target) return null;
			//直接看集合中是否包含这个值，包含则说明存在两值和为target；
			if(map.containsKey(target-nums[i])) {
				return new int[] {map.get(target-nums[i]),i};
			}
			//不存才将该值及下标存在map中，并且该值只会存一次；
			map.put(nums[i],i);
		}
		return null;
	}
	
	//练习2：
	//查看执行结果
	@Test
	public void test01() {
		int[] arr = {1,2,7,11,15};
		testPractice02(arr);
		System.out.println(Arrays.toString(arr));
	}
	public void testPractice02(int[] arr) {
//		arr = new int[] {1,1,1,1,1}; //修改引用，不会改变test01中的arr的引用；
		Arrays.fill(arr, 0); //修改引用指向的值，会改变test01中的arr引用指向的值；
	}
	//练习3：
	//查看执行结果
	@Test
	public void test02() {
		int[] arr1;
		int[] arr2 = new int[3];
		String[] arr3 = new String[3];
//		System.out.println(Arrays.toString(arr1)); //编译报错，未初始化
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
	}
}
