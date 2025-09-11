package com.gl.hiber;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // Auto-increment in MySQL
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)   // Insert/Delete cascades to PanCard
    @JoinColumn(name = "pancard_id")       // Foreign key column
    private PanCard panCard;

    // Constructors
    public Employee() {}
    public Employee(String name, PanCard panCard) {
        this.name = name;
        this.panCard = panCard;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public PanCard getPanCard() {
        return panCard;
    }
    public void setPanCard(PanCard panCard) {
        this.panCard = panCard;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", panCard=" + panCard + "]";
    }
}
