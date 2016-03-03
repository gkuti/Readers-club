package com.andela.gkuti.test;

import com.andela.gkuti.library.Library;
import com.andela.gkuti.model.Member;
import com.andela.gkuti.model.Staff;
import com.andela.gkuti.model.Student;
import com.andela.gkuti.util.BookQueueComparator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookQueueComparatorTest {
    Member member1, member2, member3, member4;
    Library library;
    BookQueueComparator bookQueueComparator;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        bookQueueComparator = new BookQueueComparator();
        member1 = new Student("Kuti Gbolahan", "21 onabola street, somolu", 1, "Laspotech", "Computer Science", "Science");
        member2 = new Staff("Kayode Olowu", "1 boyega street, sogunle", 2, 45000, 9, "Accounting");
        member3 = new Staff("Uche Johnson", "73 aina street, sogunle", 4, 30000, 8, "Office Asssistant");
        member4 = new Student("Samuel Okonkwo", "37 calabar street, masha", 3, "Laspotech", "History", "Art");
        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);
        library.registerMember(member4);
    }

    @Test
    public void testCompare() {
        assertEquals("expect to return -1", -1, bookQueueComparator.compare(member1, member2));
        assertEquals("expect to return -1", 1, bookQueueComparator.compare(member3, member1));
        assertEquals("expect to return -1", -1, bookQueueComparator.compare(member4, member3));
    }

    @Test
    public void testCompareTime() {
        assertEquals("expect to return 1", 1, bookQueueComparator.compareTime(member1, member4));
        assertEquals("expect to return 1", 1, bookQueueComparator.compareTime(member2, member3));
        assertEquals("expect to return -1", -1, bookQueueComparator.compareTime(member3, member2));
        assertEquals("expect to return -1", -1, bookQueueComparator.compareTime(member4, member1));
    }

}
