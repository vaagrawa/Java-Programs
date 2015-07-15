package com.cloudwick.java.colections;

public class UserCollection implements Comparable<UserCollection> {

	private int SSN;
	private String name;
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int sSN) {
		SSN = sSN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(UserCollection o) {
		// TODO Auto-generated method stub
		return o.SSN-this.SSN;
	}
	
}
