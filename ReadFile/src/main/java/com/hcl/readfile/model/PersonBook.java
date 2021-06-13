package com.hcl.readfile.model;

import java.time.LocalDate;

public class PersonBook implements Comparable<PersonBook> {

	private String name;
	private String gender;
	private LocalDate dob;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int compareTo(PersonBook personBook) {
		// TODO Auto-generated method stub
		return getDob().compareTo(personBook.getDob());
	}

}
