/*
 * File name: ArrayListSort.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 03/02/2025
 * Brief: This file contains a method to method to insert ArrayListItems in order from least to greatest
 */

import java.util.Arrays;
import java.util.ArrayList;

public class ArrayListSort {
	
	//method to insert ArrayListItems in order from least to greatest
	public static void arrayListInsertionSort(ArrayList<Double> list) {
		if(list.isEmpty() || list.size() == 1) {
			return;
		}
		
		Double key; // array item to be inserted
		for(int i = 1; i < list.size(); ++i) {
			key = list.get(i);
			//inner loop checks if array element at j > array element at i
			for(int j = i - 1; j >= 0; --j) {
				if(list.get(j) > key) {
					list.set(j + 1, list.get(j)); //shift elements to the right
				}else {
					break;
				}
				list.set(j, key);
			}
		}
		
	}

	public static void main(String[] args) {
		Double[] numArr;
		ArrayList<Double> objects;
		ArrayList<Double> expected;
		
		//Case 1
		numArr = new Double[]{6.0, -7.0, 0.0, 10.0, 5.0};
		objects = new ArrayList<>(Arrays.asList(numArr));
		expected = new ArrayList<>(Arrays.asList(new Double[] {-7.0, 0.0, 5.0, 6.0, 10.0}));
		
		System.out.println(objects);
		arrayListInsertionSort(objects);
		System.out.println("-->" + objects);
		System.out.println(objects.equals(expected)?"Passed":"Failed");
	
		// Case 2: Empty ArrayList
		numArr = new Double[]{};  
		objects = new ArrayList<>(Arrays.asList(numArr));  
		expected = new ArrayList<>(Arrays.asList(new Double[]{}));  
		
		System.out.println(objects);
		arrayListInsertionSort(objects);
		System.out.println("-->" + objects);
		System.out.println(objects.equals(expected)?"Passed":"Failed");

		// Case 3: Single element (0.0)
		numArr = new Double[]{0.0};  
		objects = new ArrayList<>(Arrays.asList(numArr));  
		expected = new ArrayList<>(Arrays.asList(new Double[]{0.0}));
		
		System.out.println(objects);
		arrayListInsertionSort(objects);
		System.out.println("-->" + objects);
		System.out.println(objects.equals(expected)?"Passed":"Failed");

		// Case 4: Already Sorted List
		numArr = new Double[]{-7.0, 0.0, 5.0, 6.0, 10.0};  
		objects = new ArrayList<>(Arrays.asList(numArr));  
		expected = new ArrayList<>(Arrays.asList(new Double[]{-7.0, 0.0, 5.0, 6.0, 10.0}));
		
		System.out.println(objects);
		arrayListInsertionSort(objects);
		System.out.println("-->" + objects);
		System.out.println(objects.equals(expected)?"Passed":"Failed");
		
		// Case 5: List with Duplicate Values
		numArr = new Double[]{6.0, 0.0, 5.0, 0.0, 6.0};  
		objects = new ArrayList<>(Arrays.asList(numArr));  
		expected = new ArrayList<>(Arrays.asList(new Double[]{0.0, 0.0, 5.0, 6.0, 6.0}));
		
		System.out.println(objects);
		arrayListInsertionSort(objects);
		System.out.println("-->" + objects);
		System.out.println(objects.equals(expected)?"Passed":"Failed");	
	}

}
