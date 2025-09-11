package com.gl.microservice.client;

public class Course {
	
    private int id;
	private String name;
	private double fees;
	
    private Category category;
	
	public Course() {
    }

    public Course(String name, double fees, Category category) {
        this.name = name;
        this.fees = fees;
        this.category = category;
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

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
    

}
