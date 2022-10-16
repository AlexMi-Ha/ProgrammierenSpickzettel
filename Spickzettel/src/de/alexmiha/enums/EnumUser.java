package de.alexmiha.enums;

public class EnumUser {

	public EnumUser() {
		EnumExample test = EnumExample.APRIL;
		System.out.println("Der " + test + " hat " 
				+ test.days + " Tage und hieß früher '" 
				+ test.oldName + "'");
		
		test = EnumExample.valueOf("APRIL");  // muss auch in caps sein
		test = EnumExample.values()[3];
		test.name(); // "APRIL"   meißtens gleich wie toString (außer overriden)
		test.ordinal(); // 3 -> index des monats im enum
		
		int i = test.compareTo(EnumExample.DEZEMBER); // < 0   (-8) -> (April(3) - Dezember(11))
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		new EnumUser();
	}
}
