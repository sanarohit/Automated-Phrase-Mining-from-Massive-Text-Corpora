package com.automated.dbutill;

import java.util.HashMap;

public class KValues {

	public void getAllValues() {
		
		HashMap<Integer, String> k=new HashMap<Integer, String>();
		k.put(1,"NOT (!=)");
		k.put(2,"x < a");
		k.put(3,"x > a");
		k.put(4,"x <= a");
		k.put(5,"x>=a");
		k.put(6,"a <= x <= b");
		k.put(7,"a < x < b");
		k.put(8,"a < x <= b");
		k.put(9,"a <= x < b");
		k.put(10,"role = r");
		System.out.println(k);
		
		
	}
	
	public static void main(String[] args) {

		HashMap<Integer, String> k=new HashMap<Integer, String>();
		k.put(1,"NOT (!=)");
		k.put(2,"x < a");
		k.put(3,"x > a");
		k.put(4,"x <= a");
		k.put(5,"x>=a");
		k.put(6,"a <= x <= b");
		k.put(7,"a < x < b");
		k.put(8,"a < x <= b");
		k.put(9,"a <= x < b");
		k.put(10,"role = r");
		System.out.println(k);
	}
}
