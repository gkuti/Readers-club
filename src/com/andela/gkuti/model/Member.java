package com.andela.gkuti.model;
	import java.util.Date;
public class Member {
    private String name;
    private String address;
    private Date registrationDate;
    private int memberId;

    public Member(String name, String address,int memberId) {
        this.name = name;
        this.address = address;
        this.memberId = memberId;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public int getMemberid() {
        return memberId;
    }

    }
