package com.java_concepts.serialization;

import java.io.*;

public class DeserializeDemo {

    public static void main(String[] args) {
        Employee employee = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            employee = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + employee.name);
        System.out.println("Address: " + employee.address);
        System.out.println("SSN: " + employee.SSN);
        System.out.println("Number: " + employee.number);
    }
}
