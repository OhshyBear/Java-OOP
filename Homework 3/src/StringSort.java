/*
 * File name: StringSort.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 02/09/2025
 * Brief: This file contains a method to sort and array of stings into
 * ascending order for Strings. It is self written code 
 * mimicing a call to Array.sort().
 */
import java.util.Arrays;

public class StringSort {
	
	  // for unit testing
	  public static void main(String[] args) {
	/* ADD CODE 1: set up your testing cases like exercise 1 of HW2 */
		/* do this for each testing case
		  Set up an array
		  Print original
		  Call your method to sort this array
		  Now print the array after sorting */
		  String[] testArr;
		  
		  
		  testArr = new String[] {"four", "FOUR", "eight", "EIGHT"};
		  System.out.println("Original Array: " + Arrays.toString(testArr));
		  asendingStringSort(testArr);
		  System.out.println(Arrays.toString(testArr)); 
		  
		  testArr = new String[] {"5", "two", "three"};
		  System.out.println("Original Array: " + Arrays.toString(testArr));
		  asendingStringSort(testArr);
		  System.out.println(Arrays.toString(testArr));
		  
		  testArr = new String[] {"s", "si", "sit", "sippy", "situation"};
		  System.out.println("Original Array: " + Arrays.toString(testArr));
		  asendingStringSort(testArr);
		  System.out.println(Arrays.toString(testArr));

	  } // end main

	  // Your method prolog comment
	  public static void asendingStringSort(String[] list) {
		  String temp;
		  String str1;
		  String str2;
		  int minLength;
		  int i;
		  int j;
		  int k;
		  boolean swap = false;
		  
		  //Checks that array given is longer than 1 element otherwise no comparison needed. 
		  if (list.length <= 1) {
			  return;
		  }
		  	    
		  for (i = 0; i < list.length - 1; ++i) {
	    	for(j = 0; j < list.length - 1; ++j) {
	    		str1 = list[j];
	    		str2 = list [j + 1];
	    		
	    		//sets the smaller string for comparison
	    		if(str1.length() < str2.length()) {
	    			minLength = str1.length();
	    		} else {
	    			minLength = str2.length();
	    		}
	    		
	    		//compares each letter in the two strings 
	    		for(k = 0; k < minLength; ++k) {
	    			//if the characters at the same position are in the correct order nothing needs to be done and it breaks the loop
	    			if (str1.charAt(k) < str2.charAt(k)) {
	    				break;
	    			//if the character at k in string 1 is greater than string 2 then a swap is needed.
	    			} else if (str1.charAt(k) > str2.charAt(k)) {
	    				swap = true;
	    				break;
	    			}//continues the for loop until a difference is found
	    		}
	    		
	            // Swap the strings items if they are in the wrong order
	            if(swap) {
	            	temp = list[j];
	                list[j] = list[j + 1];
	                list[j + 1] = temp;
	                swap = false;
	                }
	            
	    	
    		}
		  }
	    return;
	  } // end asendingStringSort

} // end class

	

