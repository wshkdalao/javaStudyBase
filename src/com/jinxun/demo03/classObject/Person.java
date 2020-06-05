package com.jinxun.demo03.classObject;

public class Person {
	private int age;
	private String name;
	private int sex;
	
	//静态变量
	private static Integer count = 10;
	
	//构造器
	public Person() {}
	public Person(int age) {}
	
	public void run() {}
	public void eat() {}
	public void work() {}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	

}
