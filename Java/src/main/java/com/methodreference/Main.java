package com.methodreference;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.methodreference.Person.Gender;

/**
 * New features in javaa8: Method Reference
 * 
 * Basic format of Method Reference: ClassName::MethodName 
 * All forms of Method Reference:
 * 	1)static method with class name
 * 	2)instance method with a specific class instance
 * 	3)instance method with an arbitrary class instance
 * 	4)construction method with class name
 * 	
 */
public class Main {
	public static void main(String[] args) {
		
		Person[] persons = new Person[10];		
		persons[0]=new Person("Jarrod", "Pace", LocalDate.of(2017, 1, 2), Gender.female);
		persons[1]=new Person("Clarette", "Cicely", LocalDate.of(1978, 1, 2), Gender.male);
		persons[2]=new Person("Victor", "Channing", LocalDate.of(1990, 5, 2), Gender.female);
		persons[3]=new Person("Tori", "Sheryl", LocalDate.of(2008, 1, 2), Gender.female);
		persons[4]=new Person("Osborne", "Shad", LocalDate.of(1986, 6, 2), Gender.female);
		persons[5]=new Person("Rosalind", "Layla", LocalDate.of(1966, 3, 2), Gender.male);
		persons[6]=new Person("Fraser", "Hewie",LocalDate.of(1976, 2, 2), Gender.female);
		persons[7]=new Person("Quinn", "Tamara", LocalDate.of(1993, 1, 2), Gender.male);
		persons[8]=new Person("Alvin", "Lance", LocalDate.of(2001, 1, 2), Gender.male);
		persons[9]=new Person("Evonne", "Shari", LocalDate.of(2012, 6, 2), Gender.female);

		
		// 1 Call static method with class name
		// Use anonymous class
//		Arrays.sort(persons, new Comparator<Person>() {
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.birthday.compareTo(o2.birthday);
//			}
//		});
		// Use lambda expression
//		Arrays.sort(persons, (o1, o2) -> o1.birthday.compareTo(o2.birthday));
		// Use lambda expression and static method
//		Arrays.sort(persons, (o1, o2) -> Person.compareByAge(o1, o2));
		// Use lambda expression and static method in form of Method Reference
		Arrays.sort(persons, Person::compareByAge);
		
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i].getName());
		}
		System.out.println("--------------------------------------");
		
		// 2 Call instance method with class instance
		ComparisonProvider provider=new ComparisonProvider();
		// Use lambda expression without Method Referecnce
		Arrays.sort(persons,(p1,p2)->provider.compareByName(p1, p2));
		// Use Method Reference
		Arrays.sort(persons,provider::compareByName);
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i]);
		}
		System.out.println("--------------------------------------");
		
		
		// 3 instance method with an arbitrary class instance
		String[] players = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
				"Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet", "John Isner" };

		// Arrays.sort(players, (s1, s2) -> s1.compareToIgnoreCase(s2));
		Arrays.sort(players, String::compareToIgnoreCase);

		// Output for test
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i]);
		}
		
		// 4 Construction method
		// .......(No practical use? so omit here....))
	}
	
}
//https://www.cnblogs.com/xiaoxi/p/7099667.html