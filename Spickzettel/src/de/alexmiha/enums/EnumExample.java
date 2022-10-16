package de.alexmiha.enums;

public enum EnumExample {
	JANUAR(31, "Hartung, Eismond"),
	FERUAR(28, "Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester"),
	MAERZ(31, "Lenzing, Lenzmond"),
	APRIL(30, "Launing, Ostermond"),
	MAI(31, "Winnemond*, Blumenmond"),
	JUNI(30, "Brachet, Brachmond"),
	JULI(31, "Heuert, Heumond"),
	AUGUST(31, "Ernting, Erntemond, Bisemond"),
	SEPTEMBER(30, "Scheiding, Herbstmond"),
	OKTOBER(31, "Gilbhart, Gilbhard, Weinmond"),
	NOVEMBER(30, "Nebelung, Windmond, Wintermond"),
	DEZEMBER(31, "Julmond, Heilmond, Christmond, Dustermond");
	
	public int days;
	public String oldName; 
	
	EnumExample(int days, String oldName) {
		this.days = days;
		this.oldName = oldName;
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		return s.charAt(0) + s.substring(1).toLowerCase();
	}
}
