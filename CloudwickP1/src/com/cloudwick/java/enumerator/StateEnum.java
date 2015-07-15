package com.cloudwick.java.enumerator;

public enum StateEnum {
	
		
		CA("1",95054),
		TX("2",84527);
		private StateEnum(String id,int zip){
			this.stateid=id;
			this.postalcode=zip;
		};
		private String stateid;
		private int postalcode;
		public String getStateid() {
			return stateid;
		}
		public int getPostalcode() {
			return postalcode;
		}
		
		//If you want to add anymore enums, u need to add manually above. We do not use setters in enum is because enums are used for constants.
}
