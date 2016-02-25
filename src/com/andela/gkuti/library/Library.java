package com.andela.gkuti.library;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Library extends LibraryOperations{
	private ArrayList<Member> borrowerList;
	private PriorityQueue<Member> borrowerQueue;
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
		BookQueueComparator bookQueueComparator = new BookQueueComparator();
		PriorityQueue<Member> bookQueue = new PriorityQueue<Member>(bookQueueComparator);
		for (Member member : members) {
			bookQueue.add(member);
		}
		borrowerQueue = bookQueue;
		return acceptedRequest(book, bookQueue, members);
	}
	public int acceptedRequest(Book book, PriorityQueue<Member> bookQueue, Member...members) {
		int copies = book.getNumberOfCopies();
		while (bookQueue.size()>copies) {
			bookQueue.poll();
		}
		book.setNumberOfCopies(copies-bookQueue.size());
		return bookQueue.size();
	}
	private void setBorrowerList() {
		borrowerList = new ArrayList<Member>();
		while (!borrowerQueue.isEmpty()) {
			borrowerList.add(borrowerQueue.poll());
		}
	}
	public Member borrower(int position) {
		setBorrowerList();
		return borrowerList.get(position);
	}
	public ArrayList<Member> getBorrowersList() {
		setBorrowerList();
		return borrowerList;
	}
	public ArrayList<Member> bookAndBorrowers(Book book){
		HashMap<Book, ArrayList> hm = new HashMap<>();
		hm.put(book, borrowerList);
		return borrowerList;
	}

}
