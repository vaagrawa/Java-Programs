package com.cloudwick.java.enumerator;

public class EnumManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(StateEnum.CA.getStateid());
		System.out.println(StateEnum.TX.getPostalcode());
		
		for(StateEnum e:StateEnum.values())
		{
			System.out.println(e.getPostalcode());
			
		}

	}

}
