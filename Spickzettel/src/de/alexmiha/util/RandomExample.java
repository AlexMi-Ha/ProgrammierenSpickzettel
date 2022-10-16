package de.alexmiha.util;

import java.util.Random;

public class RandomExample {
	
	public static int RandomWithMath(final int minVal, final int maxVal) {
		return (int)(Math.random() * (maxVal-minVal) + minVal);
	}
	
	public static int RandomWithRandom(final int minVal, final int maxVal) {
		Random rng = new Random();
		return rng.nextInt(minVal, maxVal);
	}
	
	public static int RandomWithRandom(final int minVal, final int maxVal, final long seed) {
		Random rng = new Random(seed);
		return rng.nextInt(minVal, maxVal);
	}
	
	public static <T> T RandomElementInArray(final T[] arr) {
		final int index = RandomWithMath(0, arr.length);
		return arr[index];
	}
	
	public static char RandomLetter() {
		return (char)RandomWithMath('A', 'Z');
	}
}
