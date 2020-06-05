package com.jinxun.demo02.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import org.junit.Test;

public class ArrayUtils {
	private final  int a;
	private static Integer b;
	
	public ArrayUtils() {
		a =2;
	}
	
	public final void test1111() {};
	public final void test1111(int i) {};
	
	@Test
	public void test() {
////		System.out.println(a+"\t"+b);
//		ArrayUtils a1=new ArrayUtils(1);
		System.out.println(a);
	}
	
	//字符串匹配：只有三种字符：(*) ，* 可以表示  (  /  )  /  空格
	@Test
	public void machTwo() {
		long time = System.currentTimeMillis();
		String s = "((*)*)(*)*()()()()()*******()()()()(((*)))(((***((*)*)(*)*()()()()()*******()()()()(((*)))(((***((*)*)(*)*()()()()()*******()()()()(((*)))(((***((*)*)(*)*()()()()()*******()()()()(((*)))(((***((*)*)(*)*()()()()()*******()()()()(((*)))(((***((*)*)(*)*()()()()()*******()()()()(((*)))(((***((*)*)(*)*()()()()()*******()()()()(((*)))(((***((*)*)(*)*()()()()()*******()()()()(((*)))(((***";
		String s1 = "()(";
		boolean flag = 
//				machDFS(s1,0,0);
//		machTanXin(s);
		machSuangXiangBianLi(s);
//		machTwoStack(s);
		System.out.println(flag+"\n"+(System.currentTimeMillis() - time));
	} 
	public static boolean machDFS(String s,int start,int count) {
		if(count < 0) return false;
		for(int i=start;i<s.length();i++) {
			if(s.charAt(i) == '(') count++;
			else if(s.charAt(i) == ')') {
				if(count-- == 0) return false;
			}else {
				return machDFS(s,i+1,count + 1) ||  //将*当作 （
						machDFS(s,i+1,count - 1) || //将*当作 ）
						machDFS(s,i+1,count);  //将*当作  空格
			}
		}
		return count == 0;
	}
	public static boolean machTanXin(String s) {
		//此方法，计算左括号的数量，左括号数量必须 >=0 ,小于0时则说明 左括号不够，也就是匹配错误；
		int min = 0,max = 0; //记录左括号最多/最少的个数
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if( c == '(') {
				min++;
				max++;
			}else if(c == ')') {
				if(min > 0)min--;
				if(max-- == 0)return false;
			}else {
				if(min > 0)min--; //将*当作 ）
				max++;//将*当作  （
			}
		}
		return min == 0;
	}
	public static boolean machSuangXiangBianLi(String s) {
		int left = 0; //将*都做为 (
		//从左向右遍历,用(和*匹配 )
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c != ')') left++;
			else {
				if(left-- == 0) return false;
			}
		}
		if(left == 0)return true;//如果*全作为(，刚刚可以匹配，则可以匹配成功，直接结束；
		//代码执行到这行，则说明 ( + *  > ) 的数量的；
		int right = 0; //将*都做为 )
		//从右向左遍历,用)和*匹配 (
		for(int i=s.length()-1;i>=0;i--) {
			char c = s.charAt(i);
			if(c != '(')right++;
			else {
				if(right-- ==0)return false;
			}
		}
		//代码执行到这行，则说明 ) + *  > ( 的数量的；
		return true;
	}
	public static  boolean machTwoStack(String s) {
		//定义两个栈，用于存(和*的下标
		Stack<Integer> left = new Stack<>(),star = new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c == '(')left.push(i);
			else if(c == '*')star.push(i);
			else {
				if(!left.isEmpty())left.pop();
				else if(!star.isEmpty())star.pop();
				else return false;
			}
		}
		while(!left.isEmpty()&&!star.isEmpty()) {
			if(left.pop() > star.pop())return false;
		}
		return left.isEmpty();
	}
	//字符串做左反转，如：abcdef  -->fedcba
	@Test
	public void reverseString() {
		String str = "abcdef";
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	//字符串做左反转，如：abcdef 2 -->cdefab
	@Test
	public void reversr() {
		String str = "abcdef";
		int n = 2;
		StringBuilder sb = new StringBuilder();
		for(int i=n;i<str.length();i++) {
			sb.append(str.charAt(i));
		}
		for(int i=0;i<n;i++) {
			sb.append(str.charAt(i));
		}
		System.out.println(sb.toString());
		//清空sb
		sb.setLength(0);
		System.out.println(sb.toString());
		sb.delete(0,sb.length());
		System.out.println(sb.toString());
		//优化
		sb.reverse();
		for(int i=n;i<n+str.length();i++) {
			sb.append(str.charAt(i%str.length()));
		}
		System.out.println(sb.toString());
	}
	
	// 对传入的数组从小到大排序
	@Test
	public void testSort() {
		int[] arr = {11,4,2,66,123,2,23,9,10};
		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(bubbleSort(arr)));
		System.out.println(Arrays.toString(selectionSort(arr)));
	}
	// 排序算法1：冒泡排序：相邻间比较，每一个循环把一个剩下未排序中的最大元素放在最后；
	public static int[] bubbleSort(int[] arr) {
		if (arr.length == 0)
			return arr;
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {// 外层循环只是控制内层循环的次数；
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
		return arr;
	}

	// 排序算法2：选择排序；不相邻间比较，每一次循环都把一个剩下未排序中的最大元素放在最后；
	public static int[] selectionSort(int[] arr) {
		if (arr.length == 0)
			return arr;
		int minIndex,tmp=0;
		for (int i = 0; i < arr.length; i++) {
			minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
//				if(arr[i]>arr[j]) {//这个地方不能写arr[i]，因为最小值是在一直变化的；
				if(arr[minIndex]>arr[j]) {//arr[minIndex]一直是最小值；
					minIndex = j;  //这里只是找出最小的数组下标，不交换值；
				}
			}
			tmp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = tmp;
		}
		return arr;
	}

}
