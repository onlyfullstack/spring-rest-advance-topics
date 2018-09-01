package com.onlyfullstack.springrestadvance.datatransferobject;

public class StudentV1 {
	
	private String fullName;

	public StudentV1(String fullName) {
		super();
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
