package com.methodreference;

import java.time.LocalDate;

public class Person {
	public enum Gender{
		male,female	
	}
	String name,email;
	LocalDate birthday;
	Gender gender;
	
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
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Person(String name, String email, LocalDate birthday, Gender gender) {
		super();
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
	}
	public static int compareByAge(Person a,Person b){
        return a.birthday.compareTo(b.birthday);
    }
}
