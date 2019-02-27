package com.test;

public class UPCCheck {

	public static int upcLastDigit(String upc) {
	
		// for left padding
		if(upc.length() <= 11) {
			upc = "0" + upc;
			return upcLastDigit(upc);
		}
		
		int sumOdd = 0;
		int sumEven = 0;
		
		for(int i = 0 ; i < upc.length() ; i++) {
			
			int charValue = Integer.parseInt(String.valueOf(upc.charAt(i)));
			
			//multiply by 3
			if(i % 2 == 0) {
				sumEven += charValue;
			}
			else {
				sumOdd += charValue;
			}
		}
		
		int result = sumEven*3 + sumOdd;
		
		if(result % 10 != 0) {
			return 10 - (result % 10);
		}
		else {
			return 0;
		}
	}
	
	public static void main(String[] args) {

			System.out.println(upcLastDigit("4210000526"));
			System.out.println(upcLastDigit("3600029145"));
			System.out.println(upcLastDigit("12345678910"));
			System.out.println(upcLastDigit("1234567"));
	
	}

}
