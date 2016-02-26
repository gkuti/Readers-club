package com.andela.gkuti.test;

import com.andela.gkuti.model.Book;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
	static String title="Harry porter";
	static String nameOfAuthor = "JK ROLINS";
	static String isbn = "978-0439139601";
	static int numberOfCopies = 3;
	static Book book;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		book = new Book(title, isbn, nameOfAuthor, numberOfCopies);
	}

	@Test
	public void testBook() {
		assertNotNull(book);
	}

	@Test
	public void testGetTitle() {
		assertEquals("expect to return JK Rolins", title, book.getTitle());
	}

	@Test
	public void testGetIsbn() {
		assertEquals("expect to return 978-0439139601", isbn, book.getIsbn());
	}

	@Test
	public void testGetNameOfAuthor() {
		assertEquals("expect to return 978-0439139601", nameOfAuthor, book.getNameOfAuthor());
	}

	@Test
	public void testGetNumberOfCopies() {
		assertEquals("expect to return 3", numberOfCopies, book.getNumberOfCopies());
	}

}
