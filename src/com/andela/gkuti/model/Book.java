package com.andela.gkuti.model;

/**
 * Book class
 *
 */

public class Book {
	private String title;
	private String isbn;
	private String nameOfAuthor;
	private int numberOfCopies;

	/**Create a new instance of Book.
	 *
	 * @param title title of the book
	 * @param isbn isbn of the book
	 * @param nameOfAuthor book author name
	 * @param numberOfCopies number of available copies
	 */

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
