package de.alexmiha.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareExample {
	
	public static void main(String[] args) {
		List<BookModel> list = new ArrayList<BookModel>();
		for(int i = 0; i < 5; ++i) {
			list.add(new BookModel(RandomExample.RandomLetter() + "kekw", RandomExample.RandomLetter() + "kekw", i, RandomExample.RandomLetter() + "kekw"));
		}
		
		System.out.println("Sort by Title");
		sortAction(list, Comparator.comparing(BookModel::getTitle));
		System.out.println("Sort by Author");
		sortAction(list, Comparator.comparing(BookModel::getAuthor));
		System.out.println("Sort by Year");
		sortAction(list, Comparator.comparing(BookModel::getYear));
		System.out.println("Sort by Publisher");
		sortAction(list, Comparator.comparing(BookModel::getPublisher));
	}
	
	public static void sortAction(List<BookModel> list, final Comparator<BookModel> comp) {
		Collections.sort(list, comp);
		list.forEach(System.out::println);
		/*
		 * list.forEach(e -> System.out.println(e));
		 */
	}

}
