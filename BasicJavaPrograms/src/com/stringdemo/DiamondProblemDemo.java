package com.stringdemo;


//A class implements two interfaces having two default methods with same name,this is diamond problem
public class DiamondProblemDemo {
	
	public static void main(String[] args) {
		
		FirstClass fc= new secondclass();
		
		//secondclass sec= new secondclass();
		fc.show();
	}

}

interface FirstClass
{
	default void show() {
		
		System.out.println("Im in FirstClass");
	}
	
}

interface ThirdClass
{
default void show() {
		
		System.out.println("Im in Thirdclass");
	}
	
}

class secondclass implements FirstClass,ThirdClass
{

	@Override
	public void show() {
	
		ThirdClass.super.show();
	}
	
}

