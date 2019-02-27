package com.test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeating {

	public static boolean arrayContains(int[] array , int element) {
	
		for (int i : array) {
			if(i == element) {
				System.out.println("Checking for " + element  +" and returning true");
				return true;
			}
		}
		System.out.println("Checking for " + element + " and returning false");
		return false;
	}
	
	
	public static void main(String[] args) {

		/*String s = "asdbasdbasjbaslrdasdbjnrbabsdasdajdbasdasr";
		
		//int len = s.length();
		
		Arrays.stream(s.replaceAll(" ", "").split(""))
						.collect(Collectors.groupingBy(Function.identity() , Collectors.counting()))
						.entrySet()
						.stream()
						//.peek(entry -> System.out.println(entry))
						.filter(e -> e.getValue() == 1)
						.sorted((e1,e2) -> s.indexOf(e1.getKey()) - s.indexOf(e2.getKey()))
						.findFirst()
						.ifPresentOrElse(str -> System.out.println(str.getKey()), () -> System.out.println("no value"));
						*/

		
		int[] array = {1,2,3,4,5,3,2,7,8,9};
		
		int[] a = new int[array.length];
		
		int currentPos = 0 ;
		
		for(int i = 0 ; i < array.length ; i++) {
			if(!arrayContains(a, array[i])) {
				a[currentPos++] = array[i]; 
			}
		}
 		
		System.out.println(Arrays.toString(a));
		
	}

}
