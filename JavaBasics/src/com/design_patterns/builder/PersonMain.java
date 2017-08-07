package com.design_patterns.builder;

import java.util.Scanner;

public class PersonMain {

    public static void main(String[] args) {

       Person p = new Person.PersonBuilder("Anil", "Suri").build();
       System.out.println("First Person - " + p.toString());
       
       Person p2 = new Person.PersonBuilder("Tom", "Hanks").age(28) .gender("Male").nationality("American").build();
       System.out.println("First Person - " + p2.toString());
    }

}
