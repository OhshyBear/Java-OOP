/*
 * File name: Homework5Main.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 03/02/2025
 * Represents a shape with a center point and color.  
 * Supports calculating distance between centers and string representation.
 */

public class Shape {
	private MyPoint center;
	private String color;
	
	public Shape() {
		//default constructor
	}
	
	public Shape(MyPoint center, String color) {
		this.center = center;
		this.color = color;
	}
	
	public double distanceBetweenCenters(Shape other) {
		double distance = this.center.distanceBetween(other.center);
		return distance;
	}
	
	public String toString() {
		return "Center: " + center + ", Color: " + color;
	}

}
