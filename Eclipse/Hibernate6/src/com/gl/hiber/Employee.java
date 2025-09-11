package com.gl.hiber;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pancard_id")
	private PanCard panCard;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Bank> banks;

    // Default constructor
    public Employee() {}

    // Parameterized constructor
    public Employee(String name, PanCard panCard) {
        this.name = name;
        this.panCard = panCard;
    }


}
