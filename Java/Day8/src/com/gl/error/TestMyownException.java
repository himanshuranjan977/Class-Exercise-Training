package com.gl.error;

public class TestMyownException {
    public void checkAge(int age) throws MyOwnException{
        if(age <18){
            throw new MyOwnException("Age is under 18");
        }
    }

    public static void main(String[] args) {
        TestMyownException t= new TestMyownException();
        try {
            t.checkAge(15);
        } catch ( MyOwnException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }

}
