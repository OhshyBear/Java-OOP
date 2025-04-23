/*
 * File name: Homework5Main.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 03/02/2025
 * Represents a point in 2D space with x and y coordinates.  
 * Supports setting/getting values, calculating distance, and string representation.
 */

public class MyPoint {
	private int x;
	private int y;

	public MyPoint() {
		//default constructor
	}
	
	public MyPoint(int x, int y) {
		this.x = x;
		this.y =y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public double distanceBetween(MyPoint other) {
		double distance = Math.sqrt(Math.pow((this.x - other.x),2) + Math.pow((this.y - other.y), 2));
		return distance;
	}
	
	public String toString() {
		return "(x=" + x +",y=" + y +")"; 
	}
}
