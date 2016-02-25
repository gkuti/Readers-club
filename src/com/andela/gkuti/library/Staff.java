package com.andela.gkuti.library;

public class Staff extends Member {
	private int salary;
	private int workingHours;
	private String position;
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
