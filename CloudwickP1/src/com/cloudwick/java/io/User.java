package com.cloudwick.java.io;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private transient int age;// the transient keyword lets the JVM know that this variable is not to be sent via serializable
	// usefull when we requiesecurity like hide SSN,BAnk Acc Numbers ,etc
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
