package com.lambda.stream;

import java.util.Set;

public class Person {
	private String firstName, lastName, job, gender;  
	private int salary, age; 
	private Set<Phone> phones;
	  
	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public Person(String firstName, String lastName, String job, String gender, int salary, int age,
			Set<Phone> phones) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.gender = gender;
		this.salary = salary;
		this.age = age;
		this.phones = phones;
	}

	public Person(String firstName, String lastName, String job,  
	                String gender, int age, int salary)       {  
	          this.firstName = firstName;  
	          this.lastName = lastName;  
	          this.gender = gender;  
	          this.age = age;  
	          this.job = job;  
	          this.salary = salary;  
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	} 
	
}
