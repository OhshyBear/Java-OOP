/*
 * File name: ShiftRight.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 02/02/2025
 * Brief: This file explores the creation of a method that takes an
 * integer array parameter and shifts the right most element to the 
 * first index .
 */

import java.util.Arrays;

public class ShiftRight {
	
	//The method takes the int array and shifts the content to the right
	public static int[] shiftRight(int[] nums) {  
		if (nums.length <= 1) {
			return nums; // if no variable is assigned then return the empty array
		}
		
		int shift = nums[nums.length - 1];  // sets a variable to the number to be shifted
		int end = nums.length - 1;
		
		//for loop starts at the end and moves each array index to the right except for the last number
		for (int i = end; i > 0; --i){
			nums[i]= nums[i-1]; 
			}
		
		
		nums[0]= shift;
			
		
		return nums;
	} 

	public static void main(String[] args) {
		int[] arr; 
		int[] expected;
		int[] result;
		
		arr = new int[]{1, 2, 3, 4, 5};
		expected = new int[]{5, 1, 2, 3, 4};
		System.out.println("Original " + Arrays.toString(arr));
		result = shiftRight(arr);
		if ( !Arrays.equals(result, expected) )
		  System.out.println("Rightshift failed. Got " + Arrays.toString(result));

		arr = new int[]{1, 2};
		expected = new int[]{2, 1};
		System.out.println("Original " + Arrays.toString(arr));
		result = shiftRight(arr);
		if ( !Arrays.equals(result, expected) )
		  System.out.println("Rightshift failed. Got " + Arrays.toString(result));

		arr = new int[]{20};
		expected = new int[]{20};
		System.out.println("Original " + Arrays.toString(arr));
		result = shiftRight(arr);
		if ( !Arrays.equals(result, expected) )
		  System.out.println("Rightshift failed. Got " + Arrays.toString(result));

		arr = new int[]{};
		expected = new int[]{};
		System.out.println("Original " + Arrays.toString(arr));
		result = shiftRight(arr);
		if ( !Arrays.equals(result, expected) )
		  System.out.println("Rightshift failed. Got " + Arrays.toString(result));


	}

}
