package com.gl.hiber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Mobile {
	@Id //Primary Key

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String model;
    private double price;
    private int ram;
    private int hdd;
	private String color;
    private String company;
    
    public Mobile() {
    }
   
	public int getId() {
		return id;
	}
	public Mobile(int id, String company, String model, double price, int ram, int hdd, String color) {
	    this.id = id;
	    this.company = company;
	    this.model = model;
	    this.price = price;
	    this.ram = ram;
	    this.hdd = hdd;
	    this.color = color;
	}
	public Mobile(int id) {
	    this.id = id;
	}
	public Mobile(String company, String model, double price, int ram, int hdd, String color) {
	    this.company = company;
	    this.model = model;
	    this.price = price;
	    this.ram = ram;
	    this.hdd = hdd;
	    this.color = color;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getHdd() {
		return hdd;
	}
	public void setHdd(int hdd) {
		this.hdd = hdd;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
    

}
