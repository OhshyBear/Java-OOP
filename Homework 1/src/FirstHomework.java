/*
 * File name: FirstHomework.java
 * Author: Trevor Huddleston
 * Brief: This file contains 2 separate versions of random number generations.
 */

import java.util.concurrent.ThreadLocalRandom;  //import for random numbers
import java.util.Random; //import for random numbers

public class FirstHomework {

	public static void main(String[] args) {
		//variables
		Random randGen = new Random(); //New Random Number Generator
		int times = 20;
		int min = 1;
		int max = 50;
		int result;
		
		// will generate a random int in [min, max) i.e. [min, max-1]. 
		//int randomNum = ThreadLocalRandom.current().nextInt(min, max);

		   
		/* Loop times times // loop #1
		   Create a random int in [min, max] using Random class
		   Print out the number 
		   End loop*/
		for (int i = 0; i < times; ++i) {// loop #1 Random Class
			result = randGen.nextInt(min, max +1);
			System.out.print(result + " ");
		}
		System.out.println("");
		   
		/* Loop times times // loop #2
   		Create a random int in [min, max] using ThreadLocalRandom class
 	    Print out the number 
	    End loop */
		for (int i = 0; i < times; ++i) {// loop #2
			result = ThreadLocalRandom.current().nextInt(min, max +1);
			System.out.print(result + " ");
		}


	}

}
