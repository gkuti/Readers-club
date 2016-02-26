package com.andela.gkuti.library;
import com.andela.gkuti.model.Book;
import com.andela.gkuti.model.Member;

import java.util.ArrayList;
import java.util.Date;

/**
 * LibraryOperations class
 *
 */

public class LibraryOperations {
	private ArrayList <Book> bookList = new ArrayList<Book>();
	private ArrayList<Member> memberList = new ArrayList<Member>();
	private Date registrationDate;

	/**Adds a book to the library.
	 *
	 * @param book to be add to library
	 * @return true if added
	 */

	public boolean addBook(Book book) {
		if (book.getNumberOfCopies()>0) {
		bookList.add(book);
		return true;
		}
		else {
		return false;
		}
	}

	/**Add books to the library from a list.
	 *
	 * @param bookList the ArrayList that contains books
	 * @return number of book added
	 */

	public int addBookList(ArrayList <Book> bookList) {
		int bookAdded = 0;
		for (Book book : bookList) {
			if (addBook(book) == true) {
				bookAdded++;
			}	
			}
		return bookAdded;
	}

	/**Remove the first occurrence of the specified book.
	 *
	 * @param book the book to be remove from the list
	 * @return true if this list contained the specified element
	 */

	public boolean removeBook(Book book) {
		return bookList.remove(book);
	}

	/**Remove books in the library from a list.
	 *
	 * @param bookList the List that contains books to be removed
	 * @return the number of books removed
	 */

	public int removeBookList(ArrayList<Book> bookList) {
		int removed = 0;
		for (Book book : bookList) {
			if (removeBook(book) == true ) {
				removed++;
			}
		}
		return removed;
	}

	/**Adds member to the Library.
	 *
	 * @param member to be added
	 * @return true if member was added
	 * @throws Exception if the Thread was interrupted
	 */

	public boolean registerMember(Member member) throws Exception  {
		registrationDate = new Date();
		member.setRegistrationDate(registrationDate);
		Thread.sleep(5);
		return memberList.add(member);
	}

	/**Adds member to the Library from a List
	 *
	 * @param memberList the list of members
	 * @return the total list of members
	 * @throws Exception if the Thread was interrupted
	 */

	public int registerMemberList(ArrayList<Member> memberList) throws Exception {
		for (Member member : memberList) {
			registerMember(member);
		}
		return memberList.size();
	}

	/**Return the list of members
	 *
	 * @return Arraylist of member
	 */

	public ArrayList<Member> getMemberList(){
		return memberList;
	}

	/**Remove the specified member from the list
	 *
	 * @param member to be removed
	 * @return
	 */

	public boolean removeMember(Member member) {
		return memberList.remove(member);
	}

	/**Remove member from library from the specified list
	 *
	 * @param memberList of members to be removed
	 * @return the number of members removed
	 */

	public int removeMemberList(ArrayList<Member> memberList) {
		int removed = 0;
		for (Member member : memberList) {
			if (removeMember(member) == true ) {
				removed++;
			}
		}
		return removed;
	}

	/**Return the total members in the list
	 *
	 * @return the size of the memberList
	 */

	public int totalMember() {
		return memberList.size();
	}

	/**Return the list of books
	 *
	 * @return ArrayList of books
	 */

	public ArrayList<Book> getBookList() {
		return bookList;
	}
}
