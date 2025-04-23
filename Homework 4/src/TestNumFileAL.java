/*
 * File name: TestNumFileAL.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 03/02/2025
 * Brief: This file Load data from text file into ArrayList
 */

// classes used for file i/o and i/o exception
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner; // I/O methods
import java.util.ArrayList;
import java.util.Random;

public class TestNumFileAL {
	
	public static void asciiAddFirstInitial(ArrayList<Integer> list, int initial) {
		list.add(initial);
		return;
	}
	
	public static void asciiAddLastInitial(ArrayList<Integer> list, int initial) {
		Random rand = new Random();
		int randomIndex = rand.nextInt(list.size() - 1);
		list.add(randomIndex, initial);
		return;
	}
	
	public static void deleteLastInitial(ArrayList<Integer> list, int initial) {
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i) == initial) {
				list.remove(i);
				return; //stops the loop from iterating to the end after the number is found
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> numList = null; // declare an ArrayList var and initialize to null
		char firstInitial = 'T';
	    char lastInitial = 'h';
	    int valueFirst;
	    int valueLast;
		firstInitial = Character.toUpperCase(firstInitial);
		lastInitial = Character.toUpperCase(lastInitial);
		valueFirst = (int) firstInitial;
		valueLast = (int) lastInitial;
		
		
	    // relative path and file name of data file
	    String fileName = "data/records.txt";
	    // This "records.txt" file should already exist in a folder named "data".
	    // If using an IDE and the source code file is put in a default "src" folder, folder "data" should be at the same location as the "src" folder;
	    // otherwise, the "data" folder should be at the same location as your .java file

	    numList = loadFromFile(fileName);  // load data
	    

		
	    //Call 1 : call a proper ArrayList method to add the ASCII value of your first name initial (i.e. first character of your first name in uppercase) to the end of the list
	    System.out.println("Records: " + numList); 
	    asciiAddFirstInitial(numList, valueFirst);
	    System.out.printf("List appended with First Initial: %c %d %s\n", firstInitial, valueFirst, numList);
	    //print out the list, the inserted letter (as a letter), and its ASCII value. 

	    //Call 2: call a proper ArrayList method to insert the ASCII value of your last name initial to somewhere among the existing elements. Use random number generation to generate a random yet valid index value for the insert. 
	    System.out.println("Records: " + numList); 
	    asciiAddLastInitial(numList, valueLast);
	    System.out.printf("List randomly appended with Last Initial: %c %d %s\n", lastInitial, valueLast, numList);
	    //Print out the list, the inserted letter (as a letter), and its ASCII value. 

	    //Call 3: call a proper ArrayList method to delete the ASCII value of your last name initial from the list. Pretend you don't know the index of the value in the ArrayList. 
	    System.out.println("Records: " + numList); 
	    deleteLastInitial(numList, valueLast);
	    System.out.printf("Value of Last Initial Deleted: %c %d %s\n", lastInitial, valueLast, numList);
	    //Print out the list after the deletion.

	    

	  } // end main


	  // read data from a specified file
	  // data will be saved in ArrayList and returned
	  private static ArrayList<Integer> loadFromFile(String fileName) {
	    Scanner fileIn = null; // scanner object to connect to file
	    ArrayList<Integer> list = new ArrayList<>(); // to store data from file

	    try { // try-catch-finally used for any exception during file open/read/close
	      // open input file
	      fileIn = new Scanner( Path.of(fileName) );

	      // loop through multiple records
	      while (fileIn.hasNextInt()) { // still have numbers to be read?
	        // 1. read one record (here each record is just one num)
	        int num = fileIn.nextInt();

	        // 2. add the record to ArrayList obj
	        list.add(num);

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

	    return list;
	  }// end loadFromFile

	} // end class TestNumFileAL