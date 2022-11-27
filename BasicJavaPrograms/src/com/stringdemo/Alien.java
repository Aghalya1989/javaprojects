package com.stringdemo;


public class Alien {

	private int aid;
	private String aname;
	private String tech;
	
	public Alien(int aid, String aname, String tech) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.tech = tech;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]";
	}
	public void setAname(String aname) {
		this.aname = aname;
	}

}
