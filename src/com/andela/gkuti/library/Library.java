package com.andela.gkuti.library;
import com.andela.gkuti.model.Book;
import com.andela.gkuti.util.BookQueueComparator;
import com.andela.gkuti.model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Library extends LibraryOperations{
	private ArrayList<Member> borrowerList;
	private BookQueueComparator bookQueueComparator = new BookQueueComparator();
	private PriorityQueue<Member> borrowerQueue;
	private HashMap<Book, ArrayList<Member>> bookAndBorrower = new HashMap<>();;
	public int borrowBook(Book book, Member...members) {
		int copies = book.getNumberOfCopies();
		if (copies > 0) {
			return request(book, members);
		}
		else {
			return 0;
		}
	}
	public int request(Book book, Member...members) {
		borrowerQueue = new PriorityQueue<Member>(bookQueueComparator);
		for (Member member : members) {
			borrowerQueue.add(member);
		}
		return acceptedRequest(book, borrowerQueue, members);
	}
	public int acceptedRequest(Book book, PriorityQueue<Member> borrowerQueue, Member...members) {
		int copies = book.getNumberOfCopies();
		while (borrowerQueue.size()>copies) {
			borrowerQueue.poll();
		}
		book.setNumberOfCopies(copies-borrowerQueue.size());
		return borrowerQueue.size();
	}
	public void setBorrowerList() {
		borrowerList = new ArrayList<Member>();
		while (!borrowerQueue.isEmpty()) {
			borrowerList.add(borrowerQueue.poll());
		}
	}
	public Member borrower(int position) {
		setBorrowerList();
		return borrowerList.get(position);
	}
	public ArrayList<Member> getBorrowerList() {
		setBorrowerList();
		return borrowerList;
	}
	public ArrayList<Member> getbookAndBorrowers(Book book){
		setbookAndBorrowers(book);
		return bookAndBorrower.get(book);

	}
	public void setbookAndBorrowers(Book book){
		bookAndBorrower.put(book, getBorrowerList());
	}

}
