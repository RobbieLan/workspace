package com.lambda.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
/**
 * User lambda to sort
 * */
public class SortLambda {
	public static void main(String[] args) {
		String[] players = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
				"Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet", "John Isner" };

		/*Use lambda to sort collection*/
		// 1.1 User anonymous inner class to sort players according to name
//		Arrays.sort(players, new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				return (s1.compareTo(s2));
//			}
//		});
		// 1.2 Use lambda expression to sort players
//		Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
//		Arrays.sort(players, sortByName);

		// 1.3 May also use this
//		Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
		
		
		// 2.1 User anonymous inner class to sort players according to name length
		Arrays.sort(players, new Comparator<String>() {  
		    @Override  
		    public int compare(String s1, String s2) {  
		        return (s1.length() - s2.length());  
		    }  
		});  
		  
		// 2.2 Use lambda expression 
//		Comparator<String> sortByNameLenght = (String s1, String s2) -> (s1.length() - s2.length());  
//		Arrays.sort(players, sortByNameLenght);  
		  
		// 2.3 Or this  
//		Arrays.sort(players, (String s1, String s2) -> (s1.length() - s2.length()));  
		
		//Output for test
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i]);
		}
	}
}
