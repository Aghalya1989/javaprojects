package com.stringdemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingJava8Demo {
	public static void main(String[] args) {
		
		List<Alien> alilist =Arrays.asList(new Alien(1,"Avin","Java"),new Alien(2, "Ganga", "IOS"),
				new Alien(3, "vennailla", "Dotnet"),new Alien(4,"SaiVetri","Excel"),new Alien(5,"Ravi","Java"));
		alilist.stream().sorted(Comparator.comparing(Alien :: getAname).reversed()).forEach(x->System.out.println(x.getAname()+"  "+x.getAid()));
		
		
		alilist.stream().sorted((a,b)->b.getAname().compareTo(a.getAname())).forEach(x->System.out.println(x.getAname()+"  "+x.getAid()));
	
		//create your own compapartor
		
		Comparator<Alien> myComparator = Comparator.comparing(Alien :: getTech).thenComparing(Alien :: getAname);
		
		alilist.stream().sorted(myComparator).forEach(x->System.out.println(x.getAname()+"  "+x.getTech()));
	}
	
	

}
