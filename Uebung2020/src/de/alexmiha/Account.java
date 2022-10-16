package de.alexmiha;

import java.awt.Color;

public class Account {

	private String name;
	private State state;
	private Color color;
	
	public Account(String name) {
		this.name = name;
		this.color = getRandomColor();
		this.state = State.AVAILABLE;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	private Color getRandomColor() {
		return new Color(
				getRandomNumber(201),
				getRandomNumber(201),
				getRandomNumber(201));
	}
	
	private int getRandomNumber(int max) {
		return (int)(Math.random() * max);
	}
}
