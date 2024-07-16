package com.automated.dto;

import java.util.Random;

public class Test {

	public void simple(int i){
		System.out.println("hii");
	}
	public void simple(int i,int j){
		this.simple(i);
		System.out.println("hello");
	}
	 public void simple(int i,int j,int k){
	this.simple(i,j);
	System.out.println("bye");
	 }
	
	
	
	public static void main(String[] args) {
		
		
		Test t=new Test();
			t.simple(10, 20, 30);	
		
				        
		/* double n = Math.random();
	        long n3 = Math.round(Math.random()*1000);
	        System.out.println (n3);
		
		int n1 = 12345;
		int n2 = 67890;

		String concat = Integer.toString(n1) + Integer.toString(n2);

		int combined = Integer.parseInt(concat);
		System.out.println(combined);*/
	}
	}
