package com.stringdemo;

public class SynchronizedDemo {

	public static void main(String[] args) throws InterruptedException {
		Counter c = new Counter();
		Thread t1 = new Thread(()->{
			for(int i=1;i<=1000;i++)
			{
				c.increment();
			}
		});
		Thread t2 = new Thread(()->{
			for(int i=1;i<=1000;i++)
			{
				c.increment();
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(c.count);
	}
}

class Counter
{
	int count;
	
	public synchronized 
	void increment()
	{//both threads are accessing the thread at both times so count is not reachig
		//2000 both increment to 1 value .
		count++;
	}
}