package com.revature;

public class WordNumber {

	public static void main(String[] args) {
		int number = 5;
		int otherNum = -10;
		
		System.out.println(printNumberInWord(number));
		System.out.println(printNumberInWord(otherNum));

	}
	
	public static String printNumberInWord(int number) {
		String name = "OTHER";
		
		switch(number) {
		case 1: name = "ONE";
			break;
		case 2: name = "TWO";
			break;
		case 3: name = "THREE";
			break;
		case 4: name = "FOUR";
			break;
		case 5: name = "FIVE";
			break;
		case 6: name = "SIX";
			break;
		case 7: name = "SEVEN";
			break;
		case 8: name = "EIGHT";
			break;
		case 9: name = "NINE";
			break;
		default: 
			break;
		
		}
		
		return name;
	}

}
