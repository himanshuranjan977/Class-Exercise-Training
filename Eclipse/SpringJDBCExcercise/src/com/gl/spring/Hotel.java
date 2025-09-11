package com.gl.spring;

public class Hotel {
    private int id;
    private String name;
    private String address;

    public Hotel() {}

    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    /*@Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", address=" + address + "]";
    }*/
}
