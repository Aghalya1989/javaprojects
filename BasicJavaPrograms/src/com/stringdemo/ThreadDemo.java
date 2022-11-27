package com.stringdemo;

public class ThreadDemo {

	//main is also a thread
	public static void main(String[] args) throws InterruptedException {

		
		
		Runnable obj1 = ()-> {
				for(int i=0;i<=5;i++)
				{
					System.out.println("Hi"+Thread.currentThread().getPriority());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		};
		
Runnable obj2 = ()-> {
				for(int i=0;i<=5;i++)
				{
					System.out.println("Hello");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		};

		
		Thread t1 = new Thread(obj1,"HiThread");
		Thread t2= new Thread(obj2,"HelloThread");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		t1.start();
		Thread.sleep(10);
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println("BYE");
	}

}

class Hi extends Thread
{
	
	public void run()
	{
		for(int i=0;i<=5;i++)
		{
			System.out.println("Hi");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Hello extends Thread
{
	public void run()
	{
		for(int i=0;i<=5;i++)
		{
			System.out.println("Hello");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}