package de.alexmiha.threading;

public class ThreadWithExtend extends Thread {
	
	private final Buffer buffer;

	public ThreadWithExtend(final Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		while(true) {
			//System.out.println("Hellooooo from " + Thread.currentThread().getName());
			
			this.buffer.put((int)(Math.random() * 100));
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
