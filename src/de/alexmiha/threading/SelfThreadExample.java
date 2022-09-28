package de.alexmiha.threading;

public class SelfThreadExample implements Runnable {

	private Thread runner;
	
	public SelfThreadExample() {
		runner = new Thread(this);
		runner.start();
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Helloooo from " + Thread.currentThread().getName());
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
