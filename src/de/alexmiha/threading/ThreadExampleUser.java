package de.alexmiha.threading;

public class ThreadExampleUser {

	public static final Buffer buffer = new Buffer();
	
	public static void main(String[] args) {
		ThreadRunnable();
		ThreadExtend();
	}
	
	public static void ThreadRunnable() {
		ThreadWithRunnable[] threadList = new ThreadWithRunnable[5];
		for(ThreadWithRunnable thread : threadList) {
			thread = new ThreadWithRunnable(buffer);
			new Thread(thread).start();
		}
	}
	
	public static void ThreadExtend() {
		ThreadWithExtend[] threadList = new ThreadWithExtend[5];
		for(ThreadWithExtend thread : threadList) {
			thread = new ThreadWithExtend(buffer);
			thread.start();
		}
	}
}
