package com.andela.gkuti.library;

import java.util.Comparator;

public class BookQueueComparator implements Comparator<Member>{
	@Override
	public int compare(Member member1, Member member2) {
		if (member1 instanceof Student && member2 instanceof Staff) {
			return -1;
		}
		else if (member1 instanceof Staff && member2 instanceof Student) {
			return 1;
		}
		else
			return compareTime(member1, member2);
		}
	public int compareTime(Member member1, Member member2) {
		int priority = 0;
		if (member1 instanceof Staff && member2 instanceof Staff && member1.getRegistrationDate().compareTo(member2.getRegistrationDate())>0) {
			priority = -1;
		}
		if (member1 instanceof Staff && member2 instanceof Staff && member1.getRegistrationDate().compareTo(member2.getRegistrationDate())<0) {
			priority = 1;
		}
		if (member1 instanceof Student && member2 instanceof Student && member1.getRegistrationDate().compareTo(member2.getRegistrationDate())>0) {
			priority = -1;
		}
		if (member1 instanceof Student && member2 instanceof Student && member1.getRegistrationDate().compareTo(member2.getRegistrationDate())<0) {
			priority = 1;
		}
		return priority;
	}

}
