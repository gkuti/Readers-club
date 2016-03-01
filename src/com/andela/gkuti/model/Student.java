package com.andela.gkuti.model;

/**
 * Student class
 */

public class Student extends Member {
    private String subjectOfInterest;
    private String institution;
    private String department;

    /**
     * Create a new instance of Student.
     *
     * @param name              the name of member
     * @param address           address of member
     * @param memberId          the member id
     * @param institution       the institution of student
     * @param subjectOfInterest subject of interest
     * @param department        department of student
     */

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
