package com.java_concepts.custom_exceptions;

import java.util.HashMap;
import java.util.Map.Entry;

public class MainClass {
	
	HashMap<Integer, Person> personsList = new HashMap<>();
	
	public static void main(String[] args){
		MainClass main = new MainClass();
		main.init();
	}
	
	void init(){
		try {
			personsList.put(1, new Person(1, "Anil"));
			personsList.put(2, new Person(2, "Sow"));
			personsList.put(3, new Person(3, "Tom"));
			personsList.put(4, new Person(4, "Dick"));
			personsList.put(5, new Person(5, ""));
			personsList.put(6, new Person(6, "Rick"));
		} catch (InvalidProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Entry<Integer, Person> map : personsList.entrySet()){
			System.out.println(map.getKey() + " " + map.getValue().getName());
		}
	}
}
