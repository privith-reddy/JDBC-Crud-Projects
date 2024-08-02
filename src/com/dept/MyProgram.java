package com.dept;

import java.util.ArrayList;

public class MyProgram {

	public static void main(String[] args) 
	{
		A a = new A();
		
		ArrayList<Department> ald = a.f1();
		  
		for(Department item : ald) 
		{ 
			 System.out.println(item.getDno());
			 System.out.println(item.getDname()); 
			 System.out.println(item.getDloc());
			 System.out.println(item.getDstrength());
		}
		 
	
		
		a.f2(2);
		
		a.f3(3, "Sales");

	}

}
