/*
 * File name: Homework5Main.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 03/02/2025
 * This program creates and manipulates MyPoint and Shape objects.  
 * It generates a list of random points, finds the closest point to the origin,  
 * and calculates distances between points and shapes.  
 */

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Homework5Main {

	public static void main(String[] args) {
		// create two Point objects
	    MyPoint p1 = new MyPoint();
	    p1.setX(5);
	    p1.setY(10);

	    MyPoint p2 = new MyPoint(3, 2); 
	    
	// print each point 
	    System.out.println("p1 is " + p1); 
	                      // will call toString() and return (x=5,y=10)
	                      // should print: p1 is (x=5,y=10)
	    System.out.println("p2 is " + p2); 
	                      // should print: p2 is (x=3,y=2) 

	    System.out.println("Distance between p1 and p2: " + p1.distanceBetween(p2) );                           
	                      // result should be: 8.246211…
	
	    ArrayList<MyPoint> list = createPointList();
	    System.out.println(list);
	    
	    int closest = findClosestToOrigin(list);	    
	    System.out.println("The point closest to (0,0) is: "+list.get(closest));
	    
	    Shape s1 = new Shape(p1, "red");
	    Shape s2 = new Shape(p2, "blue");	    
	    System.out.println("Shape 1: " + s1 + " | Shape 2:"+ s2);
	    System.out.println("Distance between s1 and s2: " +s1.distanceBetweenCenters(s2));
	    

	}
	
	// Creates and returns a list of MyPoint objects
	private static ArrayList<MyPoint> createPointList() {
	    ArrayList<MyPoint> list = new ArrayList<>();
	    int count = 10;
	    int min = -20, max = 20;

	// create points out of (-20~20, -20~20) range
	    for (int i=0; i<count; i++) {
	      int x = ThreadLocalRandom.current().nextInt(min, max+1);
	      int y = ThreadLocalRandom.current().nextInt(min, max+1);
	      list.add(new MyPoint(x, y));
	    }
	    return list;
	  }  
	
	public static int findClosestToOrigin(ArrayList<MyPoint> list) {
		MyPoint origin = new MyPoint(0,0);
		double minDistance = list.get(0).distanceBetween(origin);
		int closest = 0;
		
		for (int i = 1; i < list.size(); ++i) {
			if (list.get(i).distanceBetween(origin) < minDistance) {
				closest = i;
			}
		}
		return closest;
	}


}
