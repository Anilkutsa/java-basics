package com.java_concepts.datastructures;

import java.util.*;
import java.util.Map.Entry;

public class Collections {
	
	public static void main(String[] args){
		Collections c = new Collections();
		System.out.println("Printing ArrayList - ");
		c.arraylistTest();
		System.out.println("\nPrinting Vector - ");
		c.vectorTest();
		System.out.println("\nPrinting LinkedSet - ");
		c.linkedSetTest();
		System.out.println("\nPrinting HashMap - ");
		c.hashmapTest();
		
	}
	
	void hashmapTest(){
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Anil");
		map.put(2, "Sow");
		map.put(3, "Koi");
		
		for(Entry<Integer, String> entry : map.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
	}
	
	void linkedSetTest(){
		Set<String> set = new LinkedHashSet<>();
		set.add("Anil");
		set.add("Sow");
		set.add("Mash");
		set.add("Togue");
		set.add("Ambes");
		set.add("Lop");
		
		for(String s : set){
			System.out.print(s + " ");
		}
	}
	
	void arraylistTest(){
		List<String> list = new ArrayList<>();
		list.add("Anil");
		list.add("Sow");
		list.add("Mash");
		list.add("Togue");
		list.add("Ambes");
		list.add("Lop");
		
		for(String s : list){
			System.out.print(s + " ");
		}
	}
	
	void vectorTest(){
		List<String> list = new Vector<>(10, 5);
		list.add("Anil");
		list.add("Sow");
		list.add("Mash");
		list.add("Togue");
		list.add("Ambes");
		list.add("Lop");
		
		for(String s : list){
			System.out.print(s + " ");
		}
	}
	
	

}
