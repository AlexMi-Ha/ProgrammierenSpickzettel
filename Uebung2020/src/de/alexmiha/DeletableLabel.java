package de.alexmiha;

import javax.swing.JLabel;

public class DeletableLabel extends JLabel implements Runnable {

	private Thread runner;
	
	private ChatMessagesComponent msgs;
	private int timeToDel;
	private String text;
	
	public DeletableLabel(String text, ChatMessagesComponent msgs, int timeToDel) {
		super(text + " [ " + timeToDel + " ]");
		this.text = text;
		this.msgs = msgs;
		this.timeToDel = timeToDel;
		
		this.runner = new Thread(this);
		runner.start();
	}
	
	public void run() {
		while(timeToDel > 0) {
			--timeToDel;
			setText(text + " [ " + timeToDel + " ]");
			if(timeToDel <= 0) {
				msgs.remove(this);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
