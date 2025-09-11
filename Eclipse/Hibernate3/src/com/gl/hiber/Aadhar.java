package com.gl.hiber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Aadhar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String aadharNumber;
    public Aadhar() {
    	
    }
	
	
	@OneToOne
	@JoinColumn(name="teacher_id")
	private Teacher teacher;


	public Aadhar(String aadharNumber, Teacher teacher) {
	    this.aadharNumber = aadharNumber;
	    this.teacher = teacher;
	}


	public String getAadharNumber() {
		return aadharNumber;
	}


	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	
	
	

}
