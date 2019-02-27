package com.test;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PerfectlyBalanced {
	
	public static boolean balanced(String str) {
		
		int sum = 0 ;
		for (char c : str.toCharArray()) {
			if(c == 'x') {
				sum++;
			}
			if(c == 'y') {
				sum--;
			}
		}
		return sum == 0;
	}
	
	public static boolean balancedBonus(String str) {
		
	Set<Long> set =	str.chars()
			.boxed()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet()
			.stream()
			.map(entry -> entry.getValue())
			.collect(Collectors.toSet());
					
	return set.size()== 1L || set.size() == 0L;
	
	}

	public static void main(String[] args) {
		
		String[] strings = {
				"xxxyyy" ,
				"yyyxxx" ,
				"xxxyyyy" ,
				"yyxyxxyxxyyyyxxxyxyx" ,
				"xyxxxxyyyxyxxyxxyy" ,
				"" ,
				"x"};
		
		Arrays.stream(strings).forEach(str -> System.out.println("balanced (" + str +") -> " + balanced(str)) );
		
		System.out.println("\nBonus \n");
		
		String[] bonusStrings = {
				"xxxyyyzzz" ,
				"abccbaabccba",
				"xxxyyyzzzz" ,
				"abcdefghijklmnopqrstuvwxyz" ,
				"pqq" ,
				"fdedfdeffeddefeeeefddf" ,
				"www" ,
				"x" ,
				"" ,
		};
		
		Arrays.stream(bonusStrings).forEach(str -> System.out.println("balanced_bonus(" + str +") -> " + balancedBonus(str)) );
	}

}
