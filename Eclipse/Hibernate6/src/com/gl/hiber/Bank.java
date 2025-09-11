package com.gl.hiber;

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

    private String acNumber;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Default constructor
    public Bank() {}

    // Parameterized constructor
    public Bank(String acNumber, Employee employee) {
        this.acNumber = acNumber;
        this.employee = employee;
    }

	
	
	

}
