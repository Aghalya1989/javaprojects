package com.stringdemo;

public class CorejavaDemo {
 
	static int i;
	static String name;
	int k=0;
	
	public static void main(String[] args) {
		
		Student s1 = new Student(1,"Aghalya",true);
		Student s2 = new Student(2,"Venbha");
		System.out.println(s1.id+"  "+s1.name+"  "+s1.exist+"  "+Student.collegename);
		System.out.println(s2.id+"  "+s2.name+s2.exist+Student.collegename);
		Child child= new Child();
		Parent parent= child;
		System.out.println("parent datamember value "+parent.i);
		parent.show();
		//create object of nested static class this way
		CorejavaDemo.Example staticclasobj = new CorejavaDemo.Example();
		staticclasobj.show();
        
	}
	//static block will be exceuted first
	//static block is used to initialize static variables
	static{
		i=6;
		name="Aghalya ramanujam";
		System.out.println("Instatic block"+i+name);
	}
	static class Example
	{
		public void show()
		{
			System.out.println("In nested static class"+i+name);
		}
	}

}


class Student
{
	static int i;//class variable belongs to all objects of the class
	int j;//instance i.e Object variable specific to each object
	public int id;
	public String name;
	public Boolean exist;
	static String collegename = "HHH";
	public Student(int id,String name) {
		i++;
		j++;
		this.id= id;
		this.name=name;
		System.out.println("i-->"+i+"j-->"+j);
	}
	//usage of this
	
	public Student(int id,String name,boolean val) {
		this(id,name);
		exist= val;
		
	}}
	//overriding concept
	
	 class Parent
		{
		 int i=15;
			public Parent() {
			System.out.println("I am in parent Constructor");
			}
			
			public Parent(int i) {
				System.out.println("I am in parent Constructorwith argument-->"+i);
				}
			void show()
			{
				System.out.println("I am in parent");
			}
		}
	 
	 //when we create object of child class,the default constructor of parent is also called.
		
	 class Child extends Parent
		{
		 int i=8;
		 int j=10;
			
		 
			/*
			 * Child(int i) { // super(i);
			 * System.out.println("In child constructor"+this.i+" "+j); }
			 */
			void show()
			{
				System.out.println("I am in Child");
			}
		}
			
	
	
