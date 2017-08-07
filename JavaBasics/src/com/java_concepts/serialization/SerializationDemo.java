package com.java_concepts.serialization;

import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.name = "Reyan Ali";
        employee.address = "Phokka Kuan, Ambehta Peer";
        employee.SSN = 11122333;
        employee.number = 101;

        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employee);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
