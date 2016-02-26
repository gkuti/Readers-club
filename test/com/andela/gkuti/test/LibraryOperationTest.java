package com.andela.gkuti.test;

import com.andela.gkuti.library.Library;
import com.andela.gkuti.library.LibraryOperations;
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

public class LibraryOperationTest {
    Book book1,book2,book3,book4;
    Member member1,member2,member3;
    ArrayList<Book> bookList;
    LibraryOperations libraryOperations;
    PriorityQueue<Member> bookQueue;
    BookQueueComparator bookQueueComparator;
    @Before
    public void setUp() throws Exception {
        libraryOperations = new Library();
        bookList = new ArrayList<Book>();
        member1 = new Student("Kuti Gbolahan", "21 onabola street, somolu", 1, "Laspotech", "Computer Science", "Science");
        member2 = new Staff("Kayode Olowu", "1 boyega street, sogunle", 2, 45000, 9, "Accounting");
        member3 = new Student("Samuel Okonkwo", "37 calabar street, masha", 3, "Laspotech", "History", "Art");
        book1 = new Book("Harry Porter", "978-0439139601", "JK Rolins", 2);
        book2 = new Book("The 3 Musketeers", "978-1853260407", "Alexandre Dumas", 1);
        book3 = new Book("Spatial Mathematics", "978-1466505322", "Sandra Lach A.", 0);
        book4 = new Book("The Trials of Brother Jero and The Strong Breed", "978-0822210900", "Wole Soyinka", 4);
        bookQueueComparator = new BookQueueComparator();
        bookQueue = new PriorityQueue<Member>(bookQueueComparator);
    }

    @After
    public void tearDown() throws Exception {
        libraryOperations = null;
    }
    @Test
    public void testAddBook() throws Exception {
        assertTrue("expect to return true", libraryOperations.addBook(book1));
    }

    @Test
    public void testAddBookList() throws Exception {
        ArrayList<Book> addBookList = new ArrayList<Book>();
        addBookList.add(book1);
        addBookList.add(book2);
        assertEquals("expect to return 2", 2, libraryOperations.addBookList(addBookList));
        addBookList.add(book3);
        addBookList.add(book4);
        assertEquals("expect to return 3", 3, libraryOperations.addBookList(addBookList));
    }

    @Test
    public void testRemoveBook() throws Exception {
        libraryOperations.addBook(book1);
        assertTrue("expect to return true", libraryOperations.removeBook(book1));
    }

    @Test
    public void testRemoveBookList() throws Exception {
        libraryOperations.addBook(book1);
        libraryOperations.addBook(book2);
        ArrayList<Book> bookDeleteList = new ArrayList<Book>();
        Book book5 = new Book("Things Fall Apart", "978-0385474542", "Chinua Achebe", 3);
        bookDeleteList.add(book1);
        bookDeleteList.add(book2);
        bookDeleteList.add(book5);
        assertEquals("expect to return 2", 2, libraryOperations.removeBookList(bookDeleteList));
    }

    @Test
    public void testRegisterMember() throws Exception {
        assertTrue("expect to return true", libraryOperations.registerMember(member1));
    }

    @Test
    public void testRegisterMemberList() throws Exception {
        ArrayList<Member> addMemberList = new ArrayList<Member>();
        addMemberList.add(member1);
        addMemberList.add(member2);
        assertEquals("expect to return true", 2, libraryOperations.registerMemberList(addMemberList));
    }

    @Test
    public void testGetMemberList() throws Exception {
        libraryOperations.registerMember(member1);
        libraryOperations.registerMember(member2);
        libraryOperations.registerMember(member3);
        ArrayList<Member> memberList = libraryOperations.getMemberList();
        assertNotNull("List shouldn't be null", memberList);
        assertEquals("expect to return 3", 3, memberList.size());
        assertEquals("expect to return to member1", member1, memberList.get(0));
        assertEquals("expect to return to member2", member2, memberList.get(1));
        assertEquals("expect to return to member3", member3, memberList.get(2));
    }

    @Test
    public void testRemoveMember() throws Exception {
        libraryOperations.registerMember(member1);
        libraryOperations.registerMember(member2);
        libraryOperations.registerMember(member3);
        assertTrue("expect to return true", libraryOperations.removeMember(member1));
        assertEquals("expect to return 2", 2, libraryOperations.totalMember());
    }

    @Test
    public void testRemoveMemberList() throws Exception {
        libraryOperations.registerMember(member1);
        libraryOperations.registerMember(member2);
        libraryOperations.registerMember(member3);
        ArrayList<Member> memberDeleteList = new ArrayList<Member>();
        memberDeleteList.add(member1);
        memberDeleteList.add(member2);
        assertEquals("expect to return 2", 2, libraryOperations.removeMemberList(memberDeleteList));
        assertEquals("expect to return 1", 1, libraryOperations.totalMember());
    }

    @Test
    public void testTotalMember() throws Exception {
        libraryOperations.registerMember(member1);
        libraryOperations.registerMember(member2);
        libraryOperations.registerMember(member3);
        assertEquals("expect to return 3", 3, libraryOperations.totalMember());
    }

    @Test
    public void testGetBookList() throws Exception {
        libraryOperations.addBook(book1);
        libraryOperations.addBook(book2);
        libraryOperations.addBook(book4);
        ArrayList<Book> bookList = libraryOperations.getBookList();
        assertNotNull("List shouldn't be null", bookList);
        assertEquals("expect to return 3", 3, bookList.size());
        assertEquals("expect to return to book1", book1, bookList.get(0));
        assertEquals("expect to return to book2", book2, bookList.get(1));
        assertEquals("expect to return to book4", book4, bookList.get(2));
    }
}