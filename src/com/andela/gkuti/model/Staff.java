package com.andela.gkuti.model;

/**
 * Staff class
 */

public class Staff extends Member {
    private int salary;
    private int workingHours;
    private String position;

    /**
     * Create new instance of Staff.
     *
     * @param name         the name of member
     * @param address      address of member
     * @param memberId     the member id
     * @param salary       salary of staff
     * @param workingHours working hours
     * @param position     staff positions
     */

    public Staff(String name, String address, int memberId, int salary, int workingHours, String position) {
        super(name, address, memberId);
        this.salary = salary;
        this.workingHours = workingHours;
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public String getPosition() {
        return position;
    }
}
