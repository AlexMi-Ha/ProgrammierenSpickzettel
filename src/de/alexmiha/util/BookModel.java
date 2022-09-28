package de.alexmiha.util;

public class BookModel {

	private String title, author, publisher;
	private int year;
	
	public BookModel(String title, String author, int year, String publisher) {
		setTitle(title);
		setAuthor(author);
		setYear(year);
		setPublisher(publisher);
	}
	
	public BookModel(String title, String author, String year, String publisher) {
		setTitle(title);
		setAuthor(author);
		setYear(year);
		setPublisher(publisher);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setYear(String year) throws NumberFormatException {
		this.year = Integer.parseInt(year);
	}

	@Override
	public String toString() {
		return title + " by " + author + ", " + publisher + " " + year;
	}
}
