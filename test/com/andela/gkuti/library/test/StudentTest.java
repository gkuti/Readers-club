package com.andela.gkuti.library.test;

import com.andela.gkuti.library.Student;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
	static Student student;
	static String name = "Kuti Gbolahan";
	static String address = "21 onabola street, somolu";
	static int memberId = 3;
	static String subjectOfInterest = "Mathematics";
	static String institution = "Unilag";
	static String department = "Science";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		student = new Student(name, address, memberId, institution, subjectOfInterest, department);
	}

	@Test
	public void testStudent() {
		assertNotNull(student);
	}

	@Test
	public void testGetSubjectOfInterest() {
		assertEquals("expect to return Mathematics", subjectOfInterest, student.getSubjectOfInterest());
	}

	@Test
	public void testGetInstitution() {
		assertEquals("expect to return Unilag", institution, student.getInstitution());
	}

	@Test
	public void testGetDepartment() {
		assertEquals("expect to return Science", department, student.getDepartment());
	}

}