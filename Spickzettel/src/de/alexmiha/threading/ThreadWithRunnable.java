package de.alexmiha.threading;

public class ThreadWithRunnable implements Runnable {
	
	private final Buffer buffer;

	public ThreadWithRunnable(final Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while(true) {
			//System.out.println("Helloooo from " + Thread.currentThread().getName());
			
			this.buffer.get();
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
