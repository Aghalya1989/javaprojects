package com.stringdemo;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfacesDemo {
	
	public static void main(String[] args) {
		
		//Function Interface
		Function<String, Integer> func = (a)->(Integer.parseInt(a));
		System.out.println("Function Example-->"+func.apply("3"));
		
		
		
		//BiFunction Interface
		BiFunction<Integer, Integer, Integer> bifun = (a,b)->(a+b);
		System.out.println("Bifunction Exmaple--->"+bifun.apply(3, 4));
		Function<Integer, Integer> funcobj1 = (a)->(a*a);
		
		//andThen
		System.out.println("andThenExample--->"+bifun.andThen(funcobj1).apply(3, 4));
		
		BiFunction<String, String, String> bifunstr = (a,b)->(a+b);
		System.out.println("Bifunction Example with String->"+bifunstr.apply("Aghalya", "Ramanujam"));
		
		//Consumer
		
		Consumer<String> consobj = a->System.out.println(a.toUpperCase());
		consobj.accept("Consumer Example-->"+"Aghalya");
		
		BiConsumer<String, String> biconobj =(a,b)->System.out.println("biconsumer example-->"+a.concat(b));
		biconobj.accept("Venbha", "Karthik");
		
		//Supplier
		
		Supplier<String> suppObj = ()->(Optional.of(new String("AGhalya")).get());
		System.out.println("supplier example-->"+suppObj.get());
		
	}
	

}


