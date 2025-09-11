package com.gl.hiber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String designation;
	private String gender;
	
	
	public Employee(int id) {
		this.id=id;
	}
	public Employee() {
		
	}
	
	public Employee(int id, String name,int age,String designation,String gender) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.designation=designation;
		this.gender=gender;
		
	}
	
	public Employee(String name,int age, String designation,String gender) {
		this.name=name;
		this.age=age;
		this.designation=designation;
		this.gender=gender;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}

