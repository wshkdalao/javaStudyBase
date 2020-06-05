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
	
	//�ַ���ƥ�䣺ֻ�������ַ���(*) ��* ���Ա�ʾ  (  /  )  /  �ո�
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
				return machDFS(s,i+1,count + 1) ||  //��*���� ��
						machDFS(s,i+1,count - 1) || //��*���� ��
						machDFS(s,i+1,count);  //��*����  �ո�
			}
		}
		return count == 0;
	}
	public static boolean machTanXin(String s) {
		//�˷��������������ŵ��������������������� >=0 ,С��0ʱ��˵�� �����Ų�����Ҳ����ƥ�����
		int min = 0,max = 0; //��¼���������/���ٵĸ���
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if( c == '(') {
				min++;
				max++;
			}else if(c == ')') {
				if(min > 0)min--;
				if(max-- == 0)return false;
			}else {
				if(min > 0)min--; //��*���� ��
				max++;//��*����  ��
			}
		}
		return min == 0;
	}
	public static boolean machSuangXiangBianLi(String s) {
		int left = 0; //��*����Ϊ (
		//�������ұ���,��(��*ƥ�� )
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c != ')') left++;
			else {
				if(left-- == 0) return false;
			}
		}
		if(left == 0)return true;//���*ȫ��Ϊ(���ոտ���ƥ�䣬�����ƥ��ɹ���ֱ�ӽ�����
		//����ִ�е����У���˵�� ( + *  > ) �������ģ�
		int right = 0; //��*����Ϊ )
		//�����������,��)��*ƥ�� (
		for(int i=s.length()-1;i>=0;i--) {
			char c = s.charAt(i);
			if(c != '(')right++;
			else {
				if(right-- ==0)return false;
			}
		}
		//����ִ�е����У���˵�� ) + *  > ( �������ģ�
		return true;
	}
	public static  boolean machTwoStack(String s) {
		//��������ջ�����ڴ�(��*���±�
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
	//�ַ�������ת���磺abcdef  -->fedcba
	@Test
	public void reverseString() {
		String str = "abcdef";
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		System.out.println(sb.toString());
	}
	
	//�ַ�������ת���磺abcdef 2 -->cdefab
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
		//���sb
		sb.setLength(0);
		System.out.println(sb.toString());
		sb.delete(0,sb.length());
		System.out.println(sb.toString());
		//�Ż�
		sb.reverse();
		for(int i=n;i<n+str.length();i++) {
			sb.append(str.charAt(i%str.length()));
		}
		System.out.println(sb.toString());
	}
	
	// �Դ���������С��������
	@Test
	public void testSort() {
		int[] arr = {11,4,2,66,123,2,23,9,10};
		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(bubbleSort(arr)));
		System.out.println(Arrays.toString(selectionSort(arr)));
	}
	// �����㷨1��ð���������ڼ�Ƚϣ�ÿһ��ѭ����һ��ʣ��δ�����е����Ԫ�ط������
	public static int[] bubbleSort(int[] arr) {
		if (arr.length == 0)
			return arr;
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {// ���ѭ��ֻ�ǿ����ڲ�ѭ���Ĵ�����
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

	// �����㷨2��ѡ�����򣻲����ڼ�Ƚϣ�ÿһ��ѭ������һ��ʣ��δ�����е����Ԫ�ط������
	public static int[] selectionSort(int[] arr) {
		if (arr.length == 0)
			return arr;
		int minIndex,tmp=0;
		for (int i = 0; i < arr.length; i++) {
			minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
//				if(arr[i]>arr[j]) {//����ط�����дarr[i]����Ϊ��Сֵ����һֱ�仯�ģ�
				if(arr[minIndex]>arr[j]) {//arr[minIndex]һֱ����Сֵ��
					minIndex = j;  //����ֻ���ҳ���С�������±꣬������ֵ��
				}
			}
			tmp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = tmp;
		}
		return arr;
	}

}
