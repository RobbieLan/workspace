package com.optional;

import java.util.Optional;

public class Main {
	public static void main(String[] args) {
		
		Person p1=new Person("Pinkman", "Jessie", "MethMaker", "male", 25, 3222);
		Person p2=null;
		Person bakPerson=new Person("Walter","White","MethMaster","male", 47, 7000);
		Person defPerson=p1;
		
		//If the object is null and not handled then causes NPE
//		System.out.println(p2.getFirstName());
		//Old way to handle null
//		if(p1!=null) {
//			p1.getFirstName();
//		}
		//Construct Person with Optional, even if the person object is null, nothing happens instead of NPE
		//If value exists in Optional, then call consumer.accept to the value,otherwise nothing happens
		Optional<Person> person1=Optional.ofNullable(defPerson);
		person1.ifPresent(p->System.out.println(p.getFirstName()));
		
		//Use orElse of Optional,if the object is null,assign it with another one
		Person person2=Optional.ofNullable(defPerson).orElse(bakPerson);
		System.out.println(person2.getFirstName());
		
		//orElseGet(supplier)
		Person person3 = Optional
		        .ofNullable(defPerson)
		        .orElseGet(() -> new Person("Walter","White","MethMaster","male", 47, 7000));	        
		System.out.println("Username is: " + person3.getFirstName());
		
		//orElseThrow
//		Person person4 = Optional
//		        .ofNullable(defPerson)
//		        .orElseThrow(()->new EntityNotFoundException("用户未找到"));
		
		//map
		//If defPerson is not null, firstName=defPerson.getFirstName, otherwise firstName=Optional.empty
		//But if firstName.orElse is used, firstName="unknown" 
//		Optional<String> firstName = Optional
//		        .ofNullable(defPerson)
//		        .map(person -> person.getFirstName());		        
		Optional<String> firstName = Optional
				.ofNullable(defPerson)
				.map(person -> person.getFirstName())
				.map(str -> str.toLowerCase())
				.map(str -> str.replace("a", "A"));
		System.out.println("<<map>> firstname is: " + firstName.orElse("unknow"));
		
		//flatMap
		Optional<String> f1rstName = Optional
		        .ofNullable(defPerson)
		        .flatMap(person -> Optional.of(person.getFirstName()))
		        .flatMap(name -> Optional.of(name.toLowerCase()));	        
		System.out.println("<<flatMap>> firstname is: " + f1rstName.orElse("Unknown"));
		
		//filter
		Optional<String> f1rstNAme= Optional
				.ofNullable(defPerson)
				.filter(person->person.getAge()>26)
				.map(person->person.getFirstName());
		System.out.println("<<filter>> firstname is: " + f1rstNAme.orElse("Unknown"));
	}
}
//https://segmentfault.com/a/1190000008692522