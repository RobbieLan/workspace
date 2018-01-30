package com.test.entity;

public class Main {
	public static void main(String[] args) {
//		People people=new GoodPeople("leilei", 43);
		People people=new GoodPeople();
		people.setAge(12);
		people.setName("leilei");
		GoodPeople gPeople=(GoodPeople) people;
		System.out.println(gPeople.getName());
	}
}
