package com.lambda.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
/**
 * Use lambda to filter(partly similar to demos in package stream)
 * */
public class PredicateLambda {
	public static void main(String[] args) {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		 
	    System.out.println("Languages which starts with J :");
	    filter(languages, (str)->((String) str).startsWith("J"));
//	    filter(languages, (str)->str.startsWith("J"));
	 
	    System.out.println("Languages which ends with a ");
	    filter(languages, (str)->((String) str).endsWith("a"));
	 
	    System.out.println("Print all languages :");
	    filter(languages, (str)->true);
	 
	    System.out.println("Print no language : ");
	    filter(languages, (str)->false);
//	 
//	    System.out.println("Print language whose length greater than 4:");
//	    filter(languages, (str)->str.length() > 4);
	}
	
	public static void filter(List<String> names, Predicate condition) {
		//Use Predicate without lambda
//	    for(String name: names)  {
//	        if(condition.test(name)) {
//	            System.out.println(name + " ");
//	        }
//	    }
	    
		//User Predicate without lambda
	    names.stream().filter(name->condition.test(name)).forEach(System.out::println);
	    
	    
//	    Predicate<String> startsWithJ = (n) -> n.startsWith("J");
//	    Predicate<String> fourLetterLong = (n) -> n.length() == 4;
//	    names.stream()
//	        .filter(startsWithJ.and(fourLetterLong))   //other options: or()  xor()
//	        .forEach((n) -> System.out.println("nName, which starts with 'J' and four letter long is : " + n));
	};
}