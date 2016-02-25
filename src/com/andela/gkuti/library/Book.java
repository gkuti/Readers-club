package com.andela.gkuti.library;

public class Book {
	private String title;
	private String isbn;
	private String nameOfAuthor;
	private int numberOfCopies;
	public Book(String title, String isbn, String nameOfAuthor, int numberOfCopies) {
		this.title = title;
		this.isbn = isbn;
		this.nameOfAuthor = nameOfAuthor;
		this.numberOfCopies = numberOfCopies;
	}
	public String getTitle() {
		return title;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getNameOfAuthor() {
		return nameOfAuthor;
	}
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	
	
}
