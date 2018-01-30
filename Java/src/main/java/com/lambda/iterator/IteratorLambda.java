package com.lambda.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/**
 * User lambda to iterate
 * */
public class IteratorLambda {
	public static void main(String[] args) {
		List<String> list=Arrays.asList("pingan","chengtai","pacific");
		for (String string : list) {
			System.out.println(string);
		}
		
		List<String> newList=Arrays.asList("Tencent","Amazon","JingDong");
		newList.forEach(n->System.out.println(n));
//		newList.forEach(System.out::println); // method reference
		
	}
}
