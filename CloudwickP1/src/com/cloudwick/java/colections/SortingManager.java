package com.cloudwick.java.colections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List userList = new ArrayList<>();
		UserCollection user1 = new UserCollection();
		user1.setName("Vaibahv");
		user1.setSSN(123456789);
		UserCollection user2 = new UserCollection();
		user2.setName("Hemant");
		user2.setSSN(45697321);
		UserCollection user3 = new UserCollection();
		user3.setName("Ajay");
		user3.setSSN(98764321);

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);

	//	Collections.sort(userList); //for the compareTo method
		Collections.sort(userList,new UserComparator());
		for(Object iter : userList){
			UserCollection us = (UserCollection)iter;
			System.out.println("name: "+us.getName());
			System.out.println("SSN: "+us.getSSN());
		}
	}

}
