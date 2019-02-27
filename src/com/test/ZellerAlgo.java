package com.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class ZellerAlgo {

	public static void main(String[] args) {

		String dates = "2017 10 30\n" + 
		"2016 2 29\n" + 
		"2015 2 28\n" + 
		"29 4 12\n" + 
		"570 11 30\n" + 
		"1066 9 25\n" + 
		"1776 7 4\n" + 
		"1933 1 30\n" + 
		"1953 3 6\n" + 
		"2100 1 9\n" + 
		"2202 12 15\n" + 
		"7032 3 26";
		
		/*
		 * Cheating solution =P
		 */
		
		Arrays.stream(dates.split("\n")).forEach(date -> {
			
			String[] dateArray = date.split(" ");
			int year = Integer.parseInt(dateArray[0]);
			int month = Integer.parseInt(dateArray[1]);
			int dayOfMonth = Integer.parseInt(dateArray[2]);
			
			LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
			System.out.println("LocalDate impl : " + localDate.getDayOfWeek() + " Self impl : " + getDayOfWeek(date));
		});
		
		
	}
	
	public static DayOfWeek getDayOfWeek(String date) {
		
		int day;
		
		String[] dateArray = date.split(" ");
		int year = Integer.parseInt(dateArray[0]);
		int month = Integer.parseInt(dateArray[1]);
		int dayOfMonth = Integer.parseInt(dateArray[2]);
		
		if(month == 1 || month == 2) {
			year = year - 1;
			month = month + 12;
		}
		
		day = (int)(
				dayOfMonth 
				+ Math.floor((13*(month+1)) / 5) 
				+ (year % 100) 
				+ Math.floor((year % 100)/4) 
				+ Math.floor( (year / 100) / 4) 
				+5 * (Math.floor(year / 100))
				) % 7;
		
		if(day <= 1 ) {
			day = day + 6;
		}
		else {
			day = day - 1;
		}
		
		return DayOfWeek.of(day);
		
	}

}
