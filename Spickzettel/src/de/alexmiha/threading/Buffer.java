package de.alexmiha.threading;

import java.util.Stack;

public class Buffer {
	
	private final int MAX_SIZE = 3;
	
	private Stack<Integer> buffer;
	
	public Buffer() {
		buffer = new Stack<Integer>();
	}
	
	public synchronized void put(final int val) {
		while(buffer.size() >= MAX_SIZE) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		buffer.push(val);
		System.out.println("Put: " + val);
		System.out.println("Current fill level: " + buffer.size() + "/" + MAX_SIZE);
		this.notify();
	}
	
	public synchronized int get() {
		while(buffer.empty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		final int val = buffer.pop();
		System.out.println("Get: " + val);
		System.out.println("Current fill level: " + buffer.size() + "/" + MAX_SIZE);
		this.notify();
		return val;
	}
}
