package com.andela.gkuti.test;

import com.andela.gkuti.library.Library;
import com.andela.gkuti.model.Book;
import com.andela.gkuti.model.Member;
import com.andela.gkuti.model.Staff;
import com.andela.gkuti.model.Student;
import com.andela.gkuti.util.BookQueueComparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.PriorityQueue;
import static org.junit.Assert.*;

public class LibraryTest {
    Book book1, book2, book4;
    Member member1, member2, member3;
    Library library;
    PriorityQueue<Member> bookQueue;
    BookQueueComparator bookQueueComparator;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        member1 = new Student("Kuti Gbolahan", "21 onabola street, somolu", 1, "Laspotech", "Computer Science", "Science");
        member2 = new Staff("Kayode Olowu", "1 boyega street, sogunle", 2, 45000, 9, "Accounting");
        member3 = new Student("Samuel Okonkwo", "37 calabar street, masha", 3, "Laspotech", "History", "Art");
        book1 = new Book("Harry Porter", "978-0439139601", "JK Rolins", 2);
        book2 = new Book("The 3 Musketeers", "978-1853260407", "Alexandre Dumas", 1);
        book4 = new Book("The Trials of Brother Jero and The Strong Breed", "978-0822210900", "Wole Soyinka", 4);
        bookQueueComparator = new BookQueueComparator();
        bookQueue = new PriorityQueue<Member>(bookQueueComparator);
    }

    @After
    public void tearDown() throws Exception {
        library = null;
    }

    @Test
    public void testBorrowBook() throws Exception {
        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book4);
        assertEquals("expect to return 2", 2, library.borrowBook(book1, member1, member2, member3));
        assertEquals("expect to return 1", 1, library.borrowBook(book2, member1, member2, member3));
        assertEquals("expect to return 2", 2, library.borrowBook(book4, member2, member3));
        Book book5 = new Book("The Trials of Brother Jero and The Strong Breed", "978-0822210900", "Wole Soyinka", 4);
        assertEquals("expect to return 0", 0, library.borrowBook(book5, member2, member3));
    }

    @Test
    public void testRequest() throws Exception {
        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);
        library.addBook(book1);
        library.addBook(book2);
        assertEquals("expect to return 2", 2, library.request(book1, member1, member2, member3));
        assertEquals("expect to return 1", 1, library.request(book2, member1, member2, member3));
        book2 = new Book("The 3 Musketeers", "978-1853260407", "Alexandre Dumas", 1);
        assertEquals("expect to return 1", 1, library.request(book2, member2, member3));
    }

    @Test
    public void testAcceptedRequest() throws Exception {
        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);
        library.addBook(book1);
        library.addBook(book2);
        bookQueue.add(member1);
        bookQueue.add(member2);
        bookQueue.add(member3);
        assertEquals("expect to return 2", 2, library.acceptedRequest(book1, bookQueue, member1, member2, member3));
        assertEquals("expect to return 1", 1, library.acceptedRequest(book2, bookQueue, member1, member2, member3));
        book2 = new Book("The 3 Musketeers", "978-1853260407", "Alexandre Dumas", 1);
        bookQueue.add(member1);
        bookQueue.add(member2);
        bookQueue.add(member3);
        assertEquals("expect to return 1", 1, library.acceptedRequest(book2, bookQueue, member1));
        bookQueue = new PriorityQueue<Member>(bookQueueComparator);
        bookQueue.add(member1);
        bookQueue.add(member2);
        bookQueue.add(member3);
        assertEquals("expect to return 3", 3, library.acceptedRequest(book4, bookQueue, member1, member2, member3));
    }

    @Test
    public void testBorrower() throws Exception {
        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);
        book1 = new Book("Harry Porter", "978-0439139601", "JK Rolins", 2);
        library.addBook(book1);
        library.borrowBook(book1, member1, member2, member3);
        assertEquals("expect borrower to be student object", member1, library.borrower(0));
        book1 = new Book("Harry Porter", "978-0439139601", "JK Rolins", 2);
        library.addBook(book1);
        library.borrowBook(book1, member1, member2, member3);
        assertEquals("expect borrower to be staff object", member2, library.borrower(1));
    }

    @Test
    public void testGetBorrowersList() throws Exception {
        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);
        library.addBook(book1);
        library.borrowBook(book1, member1, member2, member3);
        ArrayList<Member> bookList = library.getBorrowerList();
        assertEquals("expect borrower to be member1", member1, bookList.get(0));
        assertEquals("expect borrower to be member2", member2, bookList.get(1));
        assertEquals("expect to return", 2, bookList.size());
    }

    @Test
    public void testGetbookAndBorrowers() throws Exception {
        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);
        library.addBook(book1);
        library.borrowBook(book1, member1, member2, member3);
        ArrayList<Member> borrowerList = library.getbookAndBorrowers(book1);
        assertNotNull(library.getbookAndBorrowers(book1));
        assertEquals("expect borrower to be member1", member1, borrowerList.get(0));
        assertEquals("expect borrower to be member2", member2, borrowerList.get(1));
        assertEquals("expect to return", 2, borrowerList.size());
        library.addBook(book2);
        library.borrowBook(book2, member1, member2, member3);
        ArrayList<Member> borrowerList2 = library.getbookAndBorrowers(book2);
        assertNotNull(library.getbookAndBorrowers(book2));
        assertEquals("expect borrower to be member2", member2, borrowerList2.get(0));
        assertEquals("expect to return", 1, borrowerList2.size());
    }

    @Test
    public void testSetbookAndBorrowers() throws Exception {
        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);
        library.addBook(book4);
        library.borrowBook(book4, member1, member2, member3);
        ArrayList<Member> borrowerList = library.getbookAndBorrowers(book4);
        assertNotNull(borrowerList);
        assertEquals("expect borrower to be member3", member2, borrowerList.get(2));
    }

    @Test
    public void isBookInLibrary() throws Exception {
        library.addBook(book2);
        Book book5 = new Book("The Trials of Brother Jero and The Strong Breed", "978-0822210900", "Wole Soyinka", 4);
        assertFalse("expect to return false", library.isBookInLibrary(book5));
        assertTrue("expect to return true", library.isBookInLibrary(book2));
    }

    @Test
    public void testReturnLibrary() throws Exception {
        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);
        library.addBook(book1);
        library.borrowBook(book1, member1, member2, member3);
        assertEquals("expect to return 2", 2, library.returnBook(book1, member1, member2));
        library.borrowBook(book1, member1, member2, member3);
        assertEquals("expect to return 1", 1, library.returnBook(book1, member2));
    }

    @Test
    public void testUpdateLibrary() throws Exception {
        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);
        library.addBook(book1);
        library.borrowBook(book1, member1, member2, member3);
        library.returnBook(book1, member1);
        assertEquals("expect to return 1", 1, book1.getNumberOfCopies());
        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);
        library.addBook(book4);
        library.borrowBook(book4, member1, member2, member3);
        library.returnBook(book4, member1, member3);
        assertEquals("expect to return 3", 3, book4.getNumberOfCopies());
    }

}