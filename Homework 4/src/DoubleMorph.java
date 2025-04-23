/*
 * File name: DoubleMorph.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 03/02/2025
 * Brief: This file contains a method to morph a given ArrayList to be twice as large.
 * If the given integer is odd it will put the larger number first in the new list
 */

import java.util.Arrays;
import java.util.ArrayList;

public class DoubleMorph {
	
	
	// Modify the given ArrayList to be twice as large, replacing every integer 
	// with a pair of integers, each half the original. If the original is odd, 
	// then the first number in the pair should be 1 higher than the 2nd.
	public static void doubleMorph (ArrayList<Integer> list) {
		//Check for empty list to avoid errors in program
		if (list.isEmpty()) {
			return;
		}
		//iterate through list backwards to avoid errors in shifting elements
		for (int i = list.size() - 1; i >= 0; --i) {
			Integer original = list.get(i); 
			Integer result;
			if(original % 2 == 1) {    //if odd then add one to the leading number
				result = list.get(i) / 2 + 1;
				list.set(i, result);
				result = original - result; //avoids having to set a second integer for the second number
				list.add(i+1,result);
			}else if (original % 2 == -1){
				result = list.get(i) / 2;
				list.set(i, result);
				result = original - result; //avoids having to set a second integer for the second number
				list.add(i + 1,result);
			}else {
				result = list.get(i) / 2;
				list.set(i, result);
				list.add(i + 1,result);
			}
		}
	}

	public static void main(String[] args) {
		Integer[] numArr; // a temp arr to convert a list of values to ArrayList
		ArrayList<Integer> numList; 
		ArrayList<Integer> expected;

		// case #1
		numArr = new Integer[]{6, 7, 0, 10, 5};
		numList = new ArrayList<>(Arrays.asList(numArr));
		expected = new ArrayList<>(Arrays.asList(new Integer[] {3, 3, 4, 3, 0, 0, 5, 5, 3, 2}));

		System.out.println(numList); // print original
		doubleMorph(numList);
		System.out.println("--> " + numList);
		System.out.println(numList.equals(expected)?"Passed":"Failed");

		      // reuse the variables to add additional testing cases
		//case #2
		numArr = new Integer[]{-2, -5};
		numList = new ArrayList<>(Arrays.asList(numArr));
		expected = new ArrayList<>(Arrays.asList(new Integer[] {-1, -1, -2, -3}));

		System.out.println(numList); // print original
		doubleMorph(numList);
		System.out.println("--> " + numList);
		System.out.println(numList.equals(expected)?"Passed":"Failed");
		
		//case #3
		numArr = new Integer[]{0};
		numList = new ArrayList<>(Arrays.asList(numArr));
		expected = new ArrayList<>(Arrays.asList(new Integer[] {0, 0}));

		System.out.println(numList); // print original
		doubleMorph(numList);
		System.out.println("--> " + numList);
		System.out.println(numList.equals(expected)?"Passed":"Failed");
		
		//case #4
		numArr = new Integer[]{};
		numList = new ArrayList<>(Arrays.asList(numArr));
		expected = new ArrayList<>(Arrays.asList(new Integer[] {}));

		System.out.println(numList); // print original
		doubleMorph(numList);
		System.out.println("--> " + numList);
		System.out.println(numList.equals(expected)?"Passed":"Failed");


	}

}
