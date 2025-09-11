package com.gl.spring;

public class Counter {
	int age =0;
	public void addAge() {
		System.out.println("I am adding my age");
		age++;
	}
	public void lessAge() {
		age--;
	}
	public void printAge() {
		System.out.println("Age : " +age);
	}
	public int getAge() {
		return age;
	}
	public void div(int a,int b)
	{
		System.out.println("div:"+(a/b));
	}



}
