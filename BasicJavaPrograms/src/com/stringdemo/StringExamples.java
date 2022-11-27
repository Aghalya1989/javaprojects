package com.stringdemo;

import java.util.Arrays;

public class StringExamples {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		String s1 ="Aghalya";
		String s2 = "Aghalya";
		System.out.println(s1==s2);
		
		String s3 = new String("Aghaya");
		
		System.out.println(s1.equals(s3));
		
		Employee e1 = new Employee();
		e1.id="3";
		e1.name="Aghalya";
		
		/*
		 * e2.id=e1.id; e2.name=e1.name;//Deep Copy System.out.println(e2);
		 * e1.name="Aghalya R"; System.out.println(e1);
		 */
		
		Employee  e2= (Employee) e1.clone();
		
		System.out.println(e2);
		
		
		//conversion String to Integer
		
		String id="2";
		System.out.println(Integer.parseInt(id));
		System.out.println(Integer.valueOf(id));
		
		//Conversion Integer to String
		int i =4;
		System.out.println(Integer.toString(i));
		System.out.println(String.valueOf(i));
		
		//conversion of String to charArray		
		String name="Aghalya";
		
		char[] mychar=name.toCharArray();
		for(int k=0;k<mychar.length;k++)
		{
			System.out.println(mychar[k]);
		}
		
		//Conversion of String to Array
		String myname= "What is mY name";
	    String[] strarr=myname.split(" ");
	    System.out.println(Arrays.toString(strarr));
	    
	}

}
//have to override the clone method of object class
class Employee implements Cloneable{
	String name;
	String id;
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	return super.clone();
	}
}