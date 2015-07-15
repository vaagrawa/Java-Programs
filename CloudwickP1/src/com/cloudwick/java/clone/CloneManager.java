package com.cloudwick.java.clone;

public class CloneManager {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub

		UserClone userObj = new UserClone();
		userObj.name= "Vaibhav";
		System.out.println("User name1: "+userObj.name);
		UserClone userObj2 = (UserClone) userObj.clone();
		
		System.out.println("User Name from clone: "+ userObj2.name);
		UserClone userObj3 = new UserClone();
		userObj3= userObj;
		if(userObj.equals(userObj3))
		{
			System.out.println("Check; hence same memory location");
		}
	}

}
