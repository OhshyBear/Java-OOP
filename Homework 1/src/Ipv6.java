/*
 * File name: Ipv6.java
 * Author: Trevor Huddleston
 * Brief: This file contains an IPv6 parser that determines if an IPv6 address is of the correct lenght,
 * has valid characters and the appropriately spaced colons. 
 * Returns True if IPv6 address is valid.
 */
public class Ipv6 {

	
	  // Returns true if the string parameter contains a valid IPv6 
	  // address in the preferred format. Otherwise returns false.
	public static boolean isValidPreferFormatIpv6(String address) {
		//method variables
		boolean isValidFormat = false;
		char currentChar;
		int segmentCount = 0;
		int segmentLength = 0;
		
		if(address.length() != 39) { //check if length is appropriate
			isValidFormat = false;
		}
		for (int i = 0; i < address.length();++i) { // loop through characters in the address
			currentChar = address.charAt(i);
			segmentLength ++;
			// segments the IPv6 address and verifies characters are hexadecimal 
			if(segmentLength <= 4) {
				if (Character.isDigit(currentChar)) {
					isValidFormat = true;
				}else if (currentChar >= 'a' && currentChar <= 'f') {
					isValidFormat = true;
				}else if (currentChar >= 'A' && currentChar <= 'F') {
					isValidFormat = true;
				}else {
					isValidFormat = false;
					break; //if an invalid format is found breaks the loop after setting it to false
				}
			}
			/*Ensures every : is at the 5th segment ensuring none are out of place 
			  if correct then increase the segmentCount and reset the length  */
			if (currentChar == ':') {
				if(segmentLength != 5) {
					isValidFormat = false;
					break;
				}
				segmentCount ++;
				segmentLength = 0;
			}
			//ensures proper amount of 8 segments 
			if (segmentCount != 7) {
				isValidFormat = false;
			}
			//ensures proper length at the end
			if(segmentLength != 4) {
				isValidFormat = false;
			}	
				
			}
	    return isValidFormat; 
	}

	public static void main(String[] args) {
		//variables for main
		String str; // store test strings
		
		System.out.println("Testing started ...");
		
	    // testing case #1
		str = "";
		System.out.print("isValidPreferFormatIpv6(" + str + ") == false: ");
		if ( isValidPreferFormatIpv6(str) ) // should be false 
		  System.out.println("pass");
		else
		  System.out.println("fail"); 
		    
		    // testing case #2
		str = "0123:4567:89ab:cdef:0123:4567:89ab:cdef";
		System.out.print("isValidPreferFormatIpv6(" + str + ") == true: ");
		if ( isValidPreferFormatIpv6(str) ) // should be true
		  System.out.println("pass");
		else
		  System.out.println("fail");
			
			//test case #3
		str = "0123:4567:89ab:cdef:0123:4567:89Ab:cDEf" ;
		System.out.print("isValidPreferFormatIpv6(" + str + ") == true: ");
		if ( isValidPreferFormatIpv6(str) ) // should be False
		  System.out.println("pass");
		else
		  System.out.println("fail");
		
			//test case #4
		str = "1234:5678:abcd:ez01:2345:6789:abcd:efad" ;
		System.out.print("isValidPreferFormatIpv6(" + str + ") == false: ");
		if ( isValidPreferFormatIpv6(str) ) // should be False
		  System.out.println("pass");
		else
		  System.out.println("fail");
		
			//test case #5
		str = "1234:5678:abcd:ef01:2345:6789:abcd:ef011" ;
		System.out.print("isValidPreferFormatIpv6(" + str + ") == false: ");
		if ( isValidPreferFormatIpv6(str) ) // should be False
		  System.out.println("pass");
		else
		  System.out.println("fail");
		
		System.out.println("Testing completed.");
	}

}
