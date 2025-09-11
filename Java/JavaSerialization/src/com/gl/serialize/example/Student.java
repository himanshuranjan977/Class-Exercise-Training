package com.gl.serialize.example;

import java.io.Serializable;

public class Student implements Serializable {
    
    int id;
    
    int age;
    
    String name;
    transient String password;// any Sensitive information // this property will be avoided from the serialization

    public Student(int id ,String name,int age) {
        this.age=age;
        this.id =id;
        this.name =name;
        this.password=password;
    }

    
    


}
