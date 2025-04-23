/*
 * File name: ShiftRight.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 02/02/2025
 * Brief: Load data from text file into array. Then converts the 
 * array to a string omitting the trailing elements. After that the
 * array inserts  
 */

// classes used for file i/o and i/o exception
import java.io.IOException;
import java.nio.file.Path; // requires at least JDK11
import java.util.Scanner;  // I/O methods
import java.util.Random;

import java.util.Arrays;   // toString() method

public class TestNumFileArr {
	
	//call method to covert the array to an appended string that omits the trailing "0's" 
	public static String arrToString(int[] arr, int numOfItems) {
		String stringArr = "["; //begins the string
		for(int i = 0; i < numOfItems; ++i) {
			stringArr +=  arr[i] + " "; //adds array items to the size of the file length to the string 
		}
		stringArr += "]";//closes the string
		return stringArr; //returns the finished string
	}
	
	
	// Insert an element into a partially filled array at a specified index 
	  // while preserving the relative order of existing elements. 
	  // Return true on success. 
	  // Return false if the insertion can’t be completed, such as if the
	  // array is already full or the index is invalid a.k.a. 
	  // outside of [0, numOfElements] 
	  private static boolean insert(int[] arr, int numOfElements, int newValue, int index) {
	    if(arr.length < index) {
	    	return false;
	    }
	    if(numOfElements == index) {
	    	arr[index] = newValue;
	    	}else {
	    		for (int i = numOfElements; i > index; --i){
	    			arr[i]= arr[i-1]; 
	    			}
	    		arr[index] = newValue;	
	    	}
		return true;
	  }


  // call method to load data from file and process
  public static void main(String[] args) {
    // relative path and file name of the data file
    String fileName = "data/records.txt";
    // This "records.txt" file should already exist in a folder named "data".
    // If using an IDE and source code file is put in a default "src" folder (or similar),
    // folder "data" should be at the same location as the "src" folder;
    // otherwise, "data" folder should be at the same location as your .java file. 

    // You may even get rid of the "data" folder and directly use the "record.txt". 
    // In that case, put it where your .java file is. Be sure to modify the above fileName 
    // string to "records.txt". 


    final int MAX_SIZE = 50;
    int[] numArr = new int[MAX_SIZE];
    int size = 0; // track actual # of elements
    char firstInitial = 'T';
    char lastInitial = 'H';
    int value;
    Random rand = new Random();
    int randomIndex; 

    size = loadFromFile(fileName, numArr);  // load data
    System.out.println("Loaded " + size + " items: " + Arrays.toString(numArr));

    System.out.println("Print again: " + arrToString(numArr, size));
    
    value = (int) firstInitial;
    insert(numArr, size, value, size); //call to insert, if true will append the ascii value of my initial T to it
    if ( insert(numArr, size, value, size) ) { // success
    	size++;
    	System.out.println("After appending T 84: " + arrToString(numArr, size)); 
    }
    
    value = lastInitial;
    randomIndex = rand.nextInt(0,size - 1);
    if ( insert(numArr, size, value, randomIndex) ) { // success
    	size++;
    	System.out.printf("After Inserting H 72 to index %d:" + arrToString(numArr, size), randomIndex); 
    }


    
    
  } // end main


  // Load data from a specified file and save in the specified array param
  // Return # of records loaded
  // Precondition: arr is not null
  private static int loadFromFile(String fileName, int[] arr) {
    Scanner fileIn = null; // scanner object to connect to file
    int count = 0; // count # of items read from file

    try { // try-catch-finally used for any exception during file open/read/close
      // open input file
      fileIn = new Scanner( Path.of(fileName) );

      // loop through multiple records when arr is not already full
      while (fileIn.hasNextInt() && count < arr.length) {
        // 1. read one record (each record is just one num)
        int num = fileIn.nextInt();

        // 2. add the record to array
        arr[count++] = num; // same as:
                            // arr[count] = num;
                            // count = count + 1;

        // end one record
      }// end while: reading all records

    } catch (IOException ioe) {
      System.out.println("Error reading \"" + fileName + "\" file: " + ioe);
    } finally { // close file
      if ( fileIn != null) {  // close if was connected to a file
        fileIn.close();
      }
    }
    // end file input

    return count;
  }// end loadFromFile

} // end class TestNumFileArr
