package com.cloudwick.java.colections;

import java.util.Comparator;

public class UserComparator implements Comparator<UserCollection>{

	@Override
	public int compare(UserCollection arg0, UserCollection arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}
	

}
