package com.andela.gkuti.library;

import java.util.ArrayList;
import java.util.Date;

public class LibraryOperations {
	private ArrayList <Book> bookList = new ArrayList<Book>();
	private ArrayList<Member> memberList = new ArrayList<Member>();
	private Date registrationDate;
	public boolean addBook(Book book) {
		if (book.getNumberOfCopies()>0) {
		bookList.add(book);
		return true;
		}
		else {
		return false;
		}
	}
	public int addBookList(ArrayList <Book> bookList) {
		int bookAdded = 0;
		for (Book book : bookList) {
			if (addBook(book) == true) {
				bookAdded++;
			}	
			}
		return bookAdded;
	}
	public boolean removeBook(Book book) {
		return bookList.remove(book);
	}
	public int removeBookList(ArrayList<Book> bookList) {
		int removed = 0;
		for (Book book : bookList) {
			if (removeBook(book) == true ) {
				removed++;
			}
		}
		return removed;
	}
	public boolean registerMember(Member member) throws Exception  {
		registrationDate = new Date();
		member.setRegistrationDate(registrationDate);
		Thread.sleep(5);
		return memberList.add(member);
	}
	public int registerMemberList(ArrayList<Member> memberList) throws Exception {
		for (Member member : memberList) {
			registerMember(member);
		}
		return memberList.size();
	}
	public ArrayList<Member> getMemberList(){
		return memberList;
	}
	public boolean removeMember(Member member) {
		return memberList.remove(member);
	}
	public int removeMemberList(ArrayList<Member> memberList) {
		int removed = 0;
		for (Member member : memberList) {
			if (removeMember(member) == true ) {
				removed++;
			}
		}
		return removed;
	}
	public int totalMember() {
		return memberList.size();
	}	
	
	public ArrayList<Book> getBookList() {
		return bookList;
	}
}
