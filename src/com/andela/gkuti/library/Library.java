package com.andela.gkuti.library;

import com.andela.gkuti.model.Book;
import com.andela.gkuti.util.BookQueueComparator;
import com.andela.gkuti.model.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Library class extends LibraryOperations
 */

public class Library extends LibraryOperations {
    private ArrayList<Member> borrowerList;
    private BookQueueComparator bookQueueComparator = new BookQueueComparator();
    private PriorityQueue<Member> borrowerQueue;
    private HashMap<Book, ArrayList<Member>> bookAndBorrower = new HashMap<>();

    /**
     * Receives a book and the member(s) that want to borrow.
     *
     * @param book    the book to be borrowed
     * @param members the member(s) that want to borrow the book
     * @return the number of copy borrowed
     */

    public int borrowBook(Book book, Member... members) {
        if (isBookInLibrary(book)) {
            int copies = book.getNumberOfCopies();
            if (copies > 0) {
                return request(book, members);
            }
        }
        return 0;
    }

    /**
     * Receives a book, the member(s) that want to borrow and add them to a queue.
     *
     * @param book    the book to be borrowed
     * @param members the member(s) that want to borrow the book
     * @return the number of copy borrowed
     */

    public int request(Book book, Member... members) {
        borrowerQueue = new PriorityQueue<Member>(bookQueueComparator);
        for (Member member : members) {
            borrowerQueue.add(member);
        }
        return acceptedRequest(book, borrowerQueue, members);
    }

    /**
     * Return the number of copies borrowed.
     *
     * @param book          the book to be borrowed
     * @param borrowerQueue the queue of member(s) that want to borrow the specified book
     * @param members       the member(s) that want to borrow
     * @return the size of the queue after removing ineligible member(s)
     */

    public int acceptedRequest(Book book, PriorityQueue<Member> borrowerQueue, Member... members) {
        int copies = book.getNumberOfCopies();
        while (borrowerQueue.size() > copies) {
            borrowerQueue.poll();
        }
        book.setNumberOfCopies(copies - borrowerQueue.size());
        return borrowerQueue.size();
    }

    /**
     * Set the borrowerList from the borrowerQueue.
     */

    public void setBorrowerList() {
        borrowerList = new ArrayList<Member>();
        while (!borrowerQueue.isEmpty()) {
            borrowerList.add(borrowerQueue.poll());
        }
    }

    /**
     * Return the borrower at the specified index.
     *
     * @param position the index of the member
     * @return the Member at the specified index
     */

    public Member borrower(int position) {
        setBorrowerList();
        return borrowerList.get(position);
    }

    /**
     * Return the borrowerList.
     *
     * @return ArrayList of borrower
     */

    public ArrayList<Member> getBorrowerList() {
        setBorrowerList();
        return borrowerList;
    }

    /**
     * Return the borrowers of the specified book.
     *
     * @param book
     * @return HashMap of borrowers
     */

    public ArrayList<Member> getbookAndBorrowers(Book book) {
        setbookAndBorrowers(book);
        return bookAndBorrower.get(book);
    }

    /**
     * Set the book key to map the borrowerList
     *
     * @param book the book to be specified as key
     */

    public void setbookAndBorrowers(Book book) {
        bookAndBorrower.put(book, getBorrowerList());
    }

    /**
     * Check if the specified book is the Library
     *
     * @param book the book to check
     * @return true if book is in Library
     */

    public boolean isBookInLibrary(Book book) {
        ArrayList<Book> bookList = getBookList();
        for (Book availableBook : bookList) {
            if (book == availableBook) {
                return true;
            }
        }
        return false;
    }
}

