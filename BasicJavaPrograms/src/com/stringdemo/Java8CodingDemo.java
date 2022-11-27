package com.stringdemo;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

//Given a list of integers, find out all the even numbers exist in the list using Stream functions?
public class Java8CodingDemo {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		List<Alien> alilist = Arrays.asList(new Alien(3, "Avin", "XXX"), new Alien(2, "Ravi", "IOS"),
				new Alien(1, "vennailla", "Dotnet"), new Alien(4, "SaiVetri", "Excel"), new Alien(5, "Ganga", "Java"));

		List<Integer> myList = Arrays.asList(21, 13, 44, 27, 16, 18, 29);
		List<Integer> evenList = myList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(evenList);

		// Given a list of integers, find out all the numbers starting with 1 using
		// Stream functions?
		myList.stream().map(s -> s + "").filter(s -> s.startsWith("4")).forEach(System.out::println);

		// How to find duplicate elements in a given integers list in java using Stream
		// functions?

		// Convert list to map and
		Map<Integer, String> resmap = alilist.stream().collect(Collectors.toMap(Alien::getAid, Alien::getAname));
		alilist.stream().collect(Collectors.toMap(Alien::getAid, Alien::getAname))
				.forEach((k, v) -> System.out.println(k + "=" + v));
		// duplicate keys removal--->use merger function
		System.out.println(alilist.stream().collect(Collectors.toMap(Alien::getAid, Alien::getAname, (o, n) -> o)));

		// sort the map by key ascending order -> can apply stream only on entryset
		// Comparingbykey and foreachordered should be used

		Map<Integer, String> resMapObj = new LinkedHashMap<Integer, String>();
		resmap.entrySet().stream().sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
				.forEachOrdered((e) -> resMapObj.put(e.getKey(), e.getValue()));

		System.out.println(resMapObj);

		// using grouping by

		Map<String, List<Alien>> empMap = alilist.stream().collect(Collectors.groupingBy(Alien::getTech));
		empMap.forEach((k, v) -> System.out.println("grouping by****" + k + "   " + v));

		//Multiple the elements within array  o/p 120
		Integer[] arr = {};
		List<Integer> intlist = Arrays.asList(arr);
		Optional<Integer> output = intlist.stream().reduce((a, b) -> a * b);
		if (output.isPresent()) {
			System.out.println(output.get());
		} else {
			System.out.println("Array is empty");
		}
		//find first repetitive and nonrepetitive character
		String input="Hel Word";
	LinkedHashMap<Character, Long> resMap=	input.chars().mapToObj(e->(char)e)
		.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		
	Optional<Entry<Character, Long>> resentrynonrep =resMap.entrySet().stream().filter(x->x.getValue()==1).findFirst();
	Optional<Character> resentryrep =resMap.entrySet().stream().filter(x->x.getValue()>1).map(e->e.getKey()).findFirst();
	if(resentrynonrep.isPresent())
	System.out.println(resentrynonrep.get().getKey());
	System.out.println(resentryrep.orElse('k'));
	//System.out.println(resentryrep.orElseThrow(NoSuchFieldException::new));
	Java8CodingDemo Demo = new Java8CodingDemo();
	//System.out.println(resentryrep.orElseGet(()->newMessage()));
	//Ifthe optional value is empty,the orElse will return the value inside it
	//or call tge method and return the value.
	//differnece between orElse and orElseGet(orElseget is performance wise good)
	System.out.println(resentryrep.orElse(newMessage()));
	
	}
	public static Character newMessage()
	{
		System.out.println("Iam inside this method");
		return'T';
		
	}
	
	
	
}



