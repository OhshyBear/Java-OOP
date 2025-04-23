/*
 * File name: OddEven.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 02/02/2025
 * Brief: This file checks an array parameter and ensures that all 
 * odd numbers come first before any even numbers, the method returns 
 * true or false based on the comparison. 
 */


public class OddEven {
	
	// This method loops through an array and checks that all odd numbers come before any even numbers
	public static boolean isOddEven(int[] arrayPar) {
		int count = 0;
		//loop for the array
		for(int i = 0; i < arrayPar.length; ++i) {
			if(arrayPar[i] % 2 == 0) {
				count++; // Identifies an even number in the array
			}
			// checks the count to any additional numbers if they are not even will return false
			if(count > 0 && arrayPar[i] % 2 != 0) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		int[] arr;
		
		//test cases calling isOddEven method and printing out expected result
		arr = new int[] {7, 3, 6, 6, 7};
		System.out.println(isOddEven(arr) + " Expected: false");		
		arr = new int[] {7, 3, 6, 6,};
		System.out.println(isOddEven(arr) + "  Expected: true");
		arr = new int[] {1, 2, -3};
		System.out.println(isOddEven(arr) + " Expected: false");		
		arr = new int[] {-4};
		System.out.println(isOddEven(arr) + "  Expected: true");
		arr = new int[] {};
		System.out.println(isOddEven(arr) + "  Expected: true");
		arr = new int[] {1};
		System.out.println(isOddEven(arr) + "  Expected: true");
	}

}
