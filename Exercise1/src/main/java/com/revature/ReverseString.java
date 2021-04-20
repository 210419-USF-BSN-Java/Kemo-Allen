package com.revature;

public class ReverseString {

	public static void main(String[] args) {
		String string = "Hello";
		
		System.out.println(reverse(string));

	}

	public static String reverse(String string) {
		String newString = "";
		char temp;
		
		
		for(int i = string.length() - 1; i >= 0; i--) {
			temp = string.charAt(i);
			newString += temp;
		}
		
		return newString;
	}
}
