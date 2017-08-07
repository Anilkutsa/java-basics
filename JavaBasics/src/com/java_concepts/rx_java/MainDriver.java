package com.java_concepts.rx_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainDriver {
    
    public static void main(String[] args) throws IOException{
        
        List<AVariable> variables = Collections.synchronizedList(new ArrayList<AVariable>());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        AVariable ar = null;
        String varName = null;
        Double varValue = null;
        System.out.println("-----------Non Reactive Example------------");
        while(true){
            System.out.println("Enter variable name - ");
                varName = br.readLine();
            
            if(varName.equalsIgnoreCase("exit"))
                break;
            else if (varName.isEmpty())
                continue;
            
            System.out.println("Please enter var value - ");
            try {
                varValue = Double.valueOf(br.readLine());
            } catch (NumberFormatException ex) {
                continue;
            }
            
            ar = new AVariable(varName, varValue);
            if(!variables.contains(ar))
                variables.add(ar);
            
            System.out.println("Added Variable " + variables.stream().mapToDouble(x -> x.getVarValue()).sum());
            System.out.println("------------------------------------------");
            
        }
    
    }
}
