package com.stringdemo;

public class MainClass
{
	public static void main(String[] args) {
		
		//With lambda expression
		FunctionDemoInterface intdemo= (a,b)->(a+b);
		System.out.println("lambda Answer is"+intdemo.add(3, 4));
		
		//With method Reference (You need to create a impl class and create an object of that to call the method)
		Interfaceimpl intImpl = new Interfaceimpl();
		FunctionDemoInterface demoint= intImpl::add;
		System.out.println("Method Reference"+demoint.add(4, 8));
		
		//can use anonymous object to call(Using New)
		FunctionDemoInterface demointref= new Interfaceimpl()::add;
		System.out.println("Method Reference using anonymous object  "+demointref.add(4, 8));
		
		//with default method reference
		FunctionDemoInterface intDemo = Integer::sum;
		System.out.println("Default Method Reference "+intDemo.add(3, 4));
		
		
	}
}
//INTERFACE
 interface FunctionDemoInterface {
	
	public int add(int a,int b);

}
 //IMPLEMENTATION CLASS
 class Interfaceimpl implements FunctionDemoInterface
 {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	 
 }