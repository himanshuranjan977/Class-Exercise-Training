package com.gl.spring;

public class Product {
    private int id;
    private String name;
    private double price;
    private int discount;
    private int units;

    // Default constructor
    public Product() {}

    // Parameterized constructor
    public Product(int id, String name, double price, int discount, int units) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.units = units;
    }

    // Getters and Setters
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

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getUnits() {
        return units;
    }
    public void setUnits(int units) {
        this.units = units;
    }

    
    
}


