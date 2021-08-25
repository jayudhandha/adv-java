package com.svlt.basics.model;


// Java Bean
public class Student {
	
	private String name;
	private String email;
	private int rollNo;

	
	public Student(String name, String email, int rollNo) {
		super();
		this.name = name;
		this.email = email;
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", rollNo=" + rollNo + "]";
	}
	
}
