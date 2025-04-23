/* TestInsert.java
 * CS252 HW Exercise, Trevor Huddleston, 1717354
 * Last updated: 2/9/2025
 *
 * Insertion practice
 * 1. Load initial data from a text file
 * 2. Create a partially filled array
 * 3. Sort this partially filled array
 * 4. Read additional items from keyboard and insert them into the array.
 *    The sorted order should be maintained
 */

// classes used for file i/o and i/o exception
import java.io.IOException;
import java.nio.file.Path; // requires at least JDK11
import java.util.Scanner;  // I/O methods

public class TestInsert {

  public static void main(String[] args) {

    // 1. Load initial data from the text file
    String fileName = "data/words.txt";
    // This "words.txt" file should already exist in a folder "data".
    // If using an IDE and the source code file is put in a default "src" folder, folder "data" should be at the same location as the "src" folder;
    // otherwise, the "data" folder should be at the same location as your .java file

   
    // 2. Create a partially filled array
    String[] list = new String[100];
    int size;
    size = loadFromFile(fileName, list);

    System.out.print("Just loaded (" + size + " items): ");
    printArr(list, size);

    // 3. Sort this partially filled array
    sortPartialArr(list, size);
    System.out.print("After sorting: ");
    printArr(list, size);

    // 4. Now insert items into the sorted array
    // array should maintain sorted order and "size" should increment by 1 after each successful insert
    Scanner stdIn = new Scanner(System.in);
    int times = 2;
    for (int i=0; i<times; i++) {
      System.out.print("Enter a string: ");
      String inputStr = stdIn.nextLine(); // read one string from keyboard

      if ( insert(list, size, inputStr) ) { // insert succeeded?
        size++;
        System.out.print("After inserting \"" + inputStr + "\": ");
      } else {
        System.out.print("Insertion failed. The array should remain the same: ");
      }
      printArr(list, size); 

    }
    stdIn.close();  // close the scanner object for keyboard input. Required by IDE

  } // end main


  /**
   * print a partially filled array. If size > arr.length, print the whole array
   *
   * @param arr    String array arr is filled with "size" # of elements
   * @param size   number of elements currently in the array. "size" >=0
   */
  private static void printArr(String[] arr, int size) {
    int validatedSize = size;
    if (validatedSize > arr.length) { // make sure we got a valid size
      validatedSize = arr.length;
    }

    System.out.print("[");
    for (int i=0; i<validatedSize; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.print("]\n");
  } // end printArr


  // ADD CODE #2: sortPartialArr(xxx)
  public static void sortPartialArr(String[] arr, int size) {
	  if (size > arr.length) {
		  size = arr.length;
	  }
		
	// If size is 0 or 1, no sorting is needed
	    if (size <= 1) {
	        return;
	    }//test edge cases
	    
	  String temp;
	  boolean swap;
	  
	  for(int i = 0; i < size; ++i) {
		  for(int j = 0; j < size -1; ++j) {
			  swap = false;
			  //uses the compareTo API to do what my other code in StringSort.java does which is sort the string in base of ascii values
			  if (arr[j].compareTo(arr[j + 1]) > 0 ) {
				  swap = true;
			  }
			  // performs the swap for the values that need to be swapped
			  if (swap) {
				  temp = arr[j];
				  arr[j] = arr[j + 1];
				  arr[j + 1] = temp;
			  }
		  }
	  }
  }

  // ADD CODE #3
  public static boolean insert(String[] arr, int size, String newItem) {
	  //checks for valid size or if the array is full
	  if(size < 0 || size >= arr.length) {
		  return false;
	  }
	  
	  int insertPosition = size;//initializes to the end unless a better position is identified by the following for loop
	  //find the spot in the array that the input is to be inserted at
	  for (int i = 0; i < size; ++i) {
		  if(newItem.compareTo(arr[i]) < 0) {
			  insertPosition = i;
			  break;
		  }
	  }
	  
	  //shift the elements to the right to make room for the input if not at the end
	  for (int i = size; i > insertPosition; --i) {
		  arr[i] = arr[i-1];
	  }
	  //actually inserts the input into the array
	  arr[insertPosition] = newItem;
	  
	  return true;
  }

  // load data from text files
  /**
     * Fills String array arr with data from text file.
     *
     * @param fileName  name of input text file
     * @param arr       String array to hold data
     * @return          # of records loaded from file
     * @throws IOException: any exception during file opening, reading, and closing
     */
    private static int loadFromFile(String fileName, String[] arr) {
      Scanner fileIn = null;     // scanner object to connect to file
      int count = 0;  // track # of records loaded
  
      try {
        // open input file
        fileIn = new Scanner( Path.of(fileName) );
  
        // loop through multiple records when arr is not already full
        while (fileIn.hasNext() && count < arr.length) { 
          // 1. read one record: one line of words
          String word = fileIn.next(); // only one word in each record
  
          // 2. add to array
          arr[count++] = word; // same as:
                               // arr[count] = word;
                               // count++;
  
          // end one record
        }// end while: reading all records
  
      } catch (IOException ioe) {
        System.out.println("Error reading \"" + fileName + "\" file: " + ioe);
      } finally { // close file
        if ( fileIn != null) {
          // close the scanner object if it was connected to a file
          fileIn.close();
        }
      }
      // end file input
  
      return count;
    }// end loadFromFile

} // end class TestInsert