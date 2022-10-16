package de.alexmiha;

public enum State {

	AVAILABLE("Available"),
	AWAY("Away"),
	DND("Do not disturb");
	
	
	public String label;
	
	State(String text) {
		label = text;
	}
}
