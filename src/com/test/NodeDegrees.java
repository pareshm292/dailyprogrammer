package com.test;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NodeDegrees {

	public static void main(String[] args) {



		String nodes = "16\r\n" + 
				"1 2\r\n" + 
				"1 3\r\n" + 
				"2 3\r\n" + 
				"1 4\r\n" + 
				"3 4\r\n" + 
				"1 5\r\n" + 
				"2 5\r\n" + 
				"1 6\r\n" + 
				"2 6\r\n" + 
				"3 6\r\n" + 
				"3 7\r\n" + 
				"5 7\r\n" + 
				"6 7\r\n" + 
				"3 8\r\n" + 
				"4 8\r\n" + 
				"6 8\r\n" + 
				"7 8\r\n" + 
				"2 9\r\n" + 
				"5 9\r\n" + 
				"6 9\r\n" + 
				"2 10\r\n" + 
				"9 10\r\n" + 
				"6 11\r\n" + 
				"7 11\r\n" + 
				"8 11\r\n" + 
				"9 11\r\n" + 
				"10 11\r\n" + 
				"1 12\r\n" + 
				"6 12\r\n" + 
				"7 12\r\n" + 
				"8 12\r\n" + 
				"11 12\r\n" + 
				"6 13\r\n" + 
				"7 13\r\n" + 
				"9 13\r\n" + 
				"10 13\r\n" + 
				"11 13\r\n" + 
				"5 14\r\n" + 
				"8 14\r\n" + 
				"12 14\r\n" + 
				"13 14\r\n" + 
				"1 15\r\n" + 
				"2 15\r\n" + 
				"5 15\r\n" + 
				"9 15\r\n" + 
				"10 15\r\n" + 
				"11 15\r\n" + 
				"12 15\r\n" + 
				"13 15\r\n" + 
				"1 16\r\n" + 
				"2 16\r\n" + 
				"5 16\r\n" + 
				"6 16\r\n" + 
				"11 16\r\n" + 
				"12 16\r\n" + 
				"13 16\r\n" + 
				"14 16\r\n" + 
				"15 16";
		
			Arrays.stream(nodes.replace("\n", "").split("\\r"))
				.skip(1)
				.filter(s -> !s.isEmpty())
				.flatMap(line -> Arrays.stream(line.split(" ")))
				.collect(Collectors.groupingBy(Function.identity()	, Collectors.counting()))
				.entrySet()
				.stream()
				.sorted(Entry.comparingByKey((e1,e2) -> {
					return Integer.parseInt(e1) - Integer.parseInt(e2);
				}))
				.forEach(e -> System.out.println("Node " + e.getKey() + " has a degree of " + e.getValue()));
		
	}
}
