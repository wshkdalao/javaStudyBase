package com.jinxun.demo01.String;

import org.junit.Test;

public class StringTest {
	public static void main(String[] args) {
//		test02();
		System.out.println(turnBack());
	}
	
	//���ַ�����ͷ���м䣬��β�Ŀո񣬲�����trim()
	@Test
	public void testDeleteSpace() {
		String str = "   hello , wo rld   ";
		StringBuilder sb = new StringBuilder(20);
		char[] chars =str.toCharArray();//�Ż�����
//		for(int i=0;i<str.length();i++) {
		for(int i=0;i<chars.length;i++) {//�Ż�����
//			char c=str.charAt(i);
//			if(c == ' ') {
			if(chars[i] == ' ') {//�Ż�����
				continue;
			}
//			sb.append(c);
			sb.append(chars[i]);//�Ż�����
		}
		str = sb.toString();
		System.out.println(str);
	}
	//��ת�ַ������磺123 ��תΪ321��
		public static String turnBack() {
			String str = "hello,world";
			StringBuilder sb = new StringBuilder(20);
			for(int i=str.length()-1;i>=0;i--) {
				char c=str.charAt(i);
				sb.append(c);
			}
			str = sb.toString();
			return str;
		}

	// ����
	public static void test02() {
		String str = "hello world!today is a sunny day!";
		System.out.println(str.indexOf("o", 5));
	}

	// ����
	public static void test01() {
		String str1 = "hello";
		String str2 = "hello" + "world";
		String str3 = "hello".intern();
		System.out.println(str1 == str3);
		System.out.println(str1.equals(str3));
		String str4 = str1 + "world";
		System.out.println(str2 == str4);
		System.out.println(str2.equals(str4));
		String str5 = new String("hello");
		System.out.println(str1 == str5);
		System.out.println(str1.equals(str5));
		String str6 = str1.intern();
		System.out.println(str1 == str6);
		System.out.println(str1.equals(str6));
		String str7 = str5.intern();
		System.out.println(str1 == str7);
		System.out.println(str1.equals(str7));
	}
}
