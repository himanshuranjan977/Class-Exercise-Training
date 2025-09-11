package com.gl.hiber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique =true)
	private String acNumber;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public Bank() {
		
	}

	
     public Bank(String acNumber, Student student) {
	        this.acNumber = acNumber;
	        this.student = student;
	 }


	 public String getAcNumber() {
		 return acNumber;
	 }


	 public void setAcNumber(String acNumber) {
		 this.acNumber = acNumber;
	 }


	 public Student getStudent() {
		 return student;
	 }


	 public void setStudent(Student student) {
		 this.student = student;
	 }
     

	    
}
	


