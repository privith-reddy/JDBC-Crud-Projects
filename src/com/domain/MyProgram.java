package com.domain;

import java.util.ArrayList;

public class MyProgram 
{

	public static void main(String[] args) 
	{
		Student s = new Student();
		
		//s.creating();
		
//		s.inserting("Privith", "English","privith@gmail.com");
//		s.inserting("Shiva", "Physics","shiva@gmail.com");
//	    s.inserting("Sai", "Social","sai@gmail.com");
//		s.inserting("Sathya", "Maths","sathya@gmail.com");
		
		//s.updating(3,"Vinay", "Hindi","vinay@gmail.com");
		
		//s.deleting(3);
		
		ArrayList<Teacher> alt =  s.selecting();
		
		for(Teacher item : alt) 
		{
			System.out.println(item.getSno());
			System.out.println(item.getSname());
			System.out.println(item.getSub());
			System.out.println(item.getEmail());
			
		}

	}

}
