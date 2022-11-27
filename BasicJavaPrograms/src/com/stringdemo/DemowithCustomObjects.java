package com.stringdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemowithCustomObjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Vendor> empList=	Stream.of(new Vendor(1, "Aghalya", Arrays.asList("Ama","BMA","CMA")),
					new Vendor(2, "Kar", Arrays.asList("Dma","HMA","FMA")),
					new Vendor(3, "KVen", Arrays.asList("Gma","HMA","IMA")),
					new Vendor(4, "KMaaran", Arrays.asList("Jma","KMA","LMA"))).collect(Collectors.toList());
	
	List<String> resList=	empList.stream().filter(s->s.getName().startsWith("K"))
			.map(v ->v.getName()).collect(Collectors.toList());
	System.out.println(resList);
	List<String> resMetList=	empList.stream().filter(s->s.getName().startsWith("K"))
			.map(Vendor::getName).collect(Collectors.toList());
	System.out.println(resMetList);
	//flatmap
	List<String> resflList=	empList.stream().filter(s->s.getName().startsWith("K")).
			flatMap(v->v.getAddress().stream()).distinct().collect(Collectors.toList());
	System.out.println(resflList);
	}

}

class Vendor
{
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	private int id;
	private String name;
	private List<String> address;
	public Vendor(int id, String name, List<String> address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
}