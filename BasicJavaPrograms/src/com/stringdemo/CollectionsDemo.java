package com.stringdemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

 class CollectionsDemo {
	
	public static void main(String[] args) {
		
		List<Integer> myList = Arrays.asList(1,2,3,4,4,5,6,7,8);
		
		//to list
		
		List<Integer> resList =myList.stream().map(x->2*x).collect(Collectors.toList());
		System.out.println(resList);
		
		//to Set
		Set<Integer> resSet =myList.stream().map(x->2*x).collect(Collectors.toSet());
		System.out.println(resSet);
		
		//toSpecific Collection  toCollection Method to be used
		
		LinkedList<Integer> resLinkedList =myList.stream().map(x->2*x).
											collect(Collectors.toCollection(LinkedList::new));
		System.out.println(resLinkedList);
		
		//collectors.counting
		Long count =myList.stream().map(x->2*x).collect(Collectors.counting());
		System.out.println(count);
		
		//find minimum value
		
		Integer minValue =myList.stream().map(x->2*x).collect(Collectors.minBy(Comparator.naturalOrder())).get();		
		System.out.println("Minimum value in the list---->"+minValue);
		
		Integer maxValue =myList.stream().map(x->2*x).collect(Collectors.maxBy(Comparator.naturalOrder())).get();		
		System.out.println("Maximum value in the list---->"+maxValue);
		
		//partitioning the List based on the condition it will partition the list and return the map
		
		Map<Boolean, List<Integer>> resMap=myList.stream().collect(Collectors.partitioningBy(x->x%2==0));
		System.out.println(resMap);
		
		//creating unmodifiable list  ->throws unsupported operation Exception if u try to modify
		List<Integer> unmodifiableList=resList.stream().collect(Collectors.toUnmodifiableList());
		System.out.println(unmodifiableList);
		//unmodifiableList.add(10);
		
		//joining elements
		
		List<String> myStrList = Arrays.asList("Aghalya","went","outside","outside");
		String resString=myStrList.stream().collect(Collectors.joining(" ", "{", "}"));
		System.out.println("String joining--->"+resString+resString.length());
		
		//AveragingLong AveragingDuble Averaging int
		Double avgValue= myList.stream().collect(Collectors.averagingInt(x->x*2));
		System.out.println("Average Value-->"+avgValue);
		
		//List to Map
		Map<String, Integer> resultMap=myStrList.stream().collect(Collectors.toMap(Function.identity(),String::length,(o,n)->n));
		System.out.println("List to Map"+resultMap);
		
		//summing Int
		System.out.println("Summing Int---->"+myList.stream().collect(Collectors.summingInt(x->x)));
		//summarizing int
		IntSummaryStatistics statistics = myList.stream().collect(Collectors.summarizingInt(x->x));
		System.out.println("summarizing statistics---->"+statistics);
		
		//Grouping by -->List to Map<Integer,List<String>>  Note the return generics its a list
		
		Map<Integer, List<String>> grpmap =myStrList.stream().collect(Collectors.groupingBy(x->x.length()));
		System.out.println("Total Map printing"+grpmap);
		Iterator<Entry<Integer, List<String>>>  entry = grpmap.entrySet().iterator();
		while(entry.hasNext())
		{
			Entry<Integer, List<String>> entobj= entry.next();
			
			System.out.println(entobj.getKey());
			for(String s: entobj.getValue())
			{
				System.out.println(s);
			}
			
		}
		//if you want that to be Linked List Collectors.toCollection(LinkedList::new)
		Map<Integer, LinkedList<String>> grpmapLinkedList =myStrList.stream()
				.collect(Collectors.groupingBy (x->x.length(),Collectors.toCollection(LinkedList::new)));
	}

}

