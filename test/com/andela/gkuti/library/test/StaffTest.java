package com.andela.gkuti.library.test;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StaffTest {
    static Staff staff;
    static String name = "Kuti Gbolahan";
    static String address = "21 onabola street, somolu";
    static int memberId = 1;
    static int salary = 5000;
    static int workingHours = 8;
    static String position = "Office Assistant";
    @BeforeClass
    public static void setUp() throws Exception {
        staff = new Staff(name, address, memberId, salary, workingHours, position);
    }

    @Test
    public void testStaff() {
        assertNotNull(staff);
    }

    @Test
    public void testGetSalary() {
        assertEquals("expect to return 5000", salary, staff.getSalary());
    }

    @Test
    public void testGetWorkingHours() {
        assertEquals("expect to return 8", workingHours, staff.getWorkingHours());
    }

    @Test
    public void testGetPosition() {
        assertEquals("expect to return Office Assistant", position, staff.getPosition());
    }

}
