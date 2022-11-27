package com.stringdemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CodingInterviewDemo {
	public static void main(String[] args) {
		
		//reverse a String 
		String s="Aghalya";
		char[] chararray=s.toCharArray();
		String r="";
		for(int i= chararray.length-1;i>=0;i--)
		{
			r= r+chararray[i];
		}
		for(int i= 0;i<=chararray.length-1;i++)
		{
			r= chararray[i]+r;
		}
		System.out.println(r);
		
		
		// to check if string contains unique characters
		String se= "Aghly";
		
		Set myset = new HashSet(); 
		boolean result = true;
		for(int i=0;i<se.length();i++)
		if(!myset.add(se.charAt(i)))
		{
			result=false;
		}
		System.out.println(result);
		
		//to find duplicate characters in String
		
		String dup="Aghalyaiygh";
		
		Map<Character,Integer> imap= new HashMap<Character,Integer>();
		
		for(int i=0;i<dup.length();i++)
		{
			if((imap.containsKey(dup.charAt(i))))
			{
				imap.put(dup.charAt(i), imap.get(dup.charAt(i))+1);
			}
			else
			{
				imap.put(dup.charAt(i), 1);
			}
		}
		
	Iterator<Entry<Character, Integer>> entryset = imap.entrySet().iterator();
	while(entryset.hasNext())
	{
		Entry<Character, Integer> entry = entryset.next();
		
		System.out.println(entry.getKey()+""+ entry.getValue());
	}
		
	
	 Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
	 
     // enhanced for-loop also uses an iterator behind the scenes
     for (Integer item: set) {
         System.out.println(item);
     }
	}

	
	
	
	
	
	
}
