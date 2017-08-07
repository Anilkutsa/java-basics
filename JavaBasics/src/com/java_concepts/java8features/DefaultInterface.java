package com.java_concepts.java8features;

public class DefaultInterface implements InterfaceA, InterfaceB {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
 
    @Override
    public void saySomething() {
        System.out.println("Hello World");
    }
    
    @Override
    public void sayHi(){
        InterfaceA.sayHi();
    }
 
}
 
interface InterfaceA {
    public void saySomething();
    static public void sayHi() {
        System.out.println("Hi from InterfaceA");
    }
}

interface InterfaceB {
    default public void sayHi() {
        System.out.println("Hi from InterfaceB");
    }
}
 