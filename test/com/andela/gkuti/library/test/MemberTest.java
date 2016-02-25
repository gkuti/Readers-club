package com.andela.gkuti.library.test;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class MemberTest {
	static String name = "Kuti Gbolahan";
	static String address = "21 onabola street, somolu";
	static Date registrationDate;
	static int memberId = 1;
	static Member member;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		member = new Member(name, address, memberId);
		member.setRegistrationDate( new Date());
		registrationDate = member.getRegistrationDate();
	}

	@Test
	public void testMember() {
		assertNotNull(member);
	}

	@Test
	public void testSetRegistrationDate() {
		assertEquals("expect setDate to set date", registrationDate, member.getRegistrationDate());
	}

	@Test
	public void testGetName() {
		assertEquals("expect to return Kuti Gbolahan", name, member.getName());
	}

	@Test
	public void testGetAddress() {
		assertEquals("expect to return 21 onabola street, somolu", address, member.getAddress());
	}

	@Test
	public void testGetRegistrationDate() {
		assertEquals("expect to return "+registrationDate, registrationDate, member.getRegistrationDate());
	}

	@Test
	public void testGetMemberid() {
		assertEquals("expect to return 1", memberId, member.getMemberid());
	}

}
