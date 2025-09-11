package com.gl.hiber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PanCard {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String panNumber;

    @OneToOne(mappedBy = "panCard")
    private Employee employee;

    // Default constructor
    public PanCard() {}

    // Parameterized constructor
    public PanCard(String panNumber) {
        this.panNumber = panNumber;
    }



}
