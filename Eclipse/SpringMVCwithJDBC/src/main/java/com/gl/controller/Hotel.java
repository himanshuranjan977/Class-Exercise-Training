package com.gl.controller;



public class Hotel {

    private int id;
    private String name;
    private String address;

    // Default constructor
    public Hotel() {}

    // Parameterized constructor
    public Hotel(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    // Optional: toString() for debugging
    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
}
