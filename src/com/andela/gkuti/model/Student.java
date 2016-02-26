package com.andela.gkuti.model;

public class Student extends Member {
	private String subjectOfInterest;
	private String institution;
	private String department;

	public Student(String name, String address, int memberId, String institution, String subjectOfInterest, String department) {
		super(name, address, memberId);
		this.institution = institution;
		this.subjectOfInterest = subjectOfInterest;
		this.department = department;
		
	}

	public String getSubjectOfInterest() {
		return subjectOfInterest;
	}

	public String getInstitution() {
		return institution;
	}

	public String getDepartment() {
		return department;
	}

}
