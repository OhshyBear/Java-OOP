/*
 * File name: HT54Employee.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 03/29/2025
 * The HT54Employee class serves as the base class for all employee types, encapsulating 
 * common attributes such as ID, name, position, hiring date, and salary. It also provides 
 * an abstract method for calculating the annual bonus, which must be implemented by subclasses.
 */

package huddleston;

import java.time.LocalDate;

public abstract class HT54Employee {

	private String id;
	private String firstName;
	private String lastName;
	private String position;
	private LocalDate hiringDate;
	private int annualSalary;

	  // Default constructor. Set member variables to null or 0 (default values of their types)
	public HT54Employee() {} 

	  // Constructor with parameters to set the private variables
	public HT54Employee(String id, String firstName, String lastName, String position,
	      LocalDate hiringDate, int annualSalary) {
	  this.id           = id;
	  this.firstName    = firstName;
	  this.lastName     = lastName;
	  this.position     = position;
	  this.hiringDate   = hiringDate;
	  this.annualSalary = annualSalary;
	  } 
	  
	  // Gets the id of this object
	public String getId() {
	    return id;
	}

	  // Sets the id of this object with the given value
	public void setId(String id) {
	    this.id = id;
	}

	  // Gets the first name of this object
	public String getFirstName() {
	    return firstName;
	}

	  // Sets the first name of this object with the given value
	public void setFirstName(String firstName) {
	    this.firstName = firstName;
	}

	  // Gets the last name of this object
	public String getLastName() {
	    return lastName;
	}

	  // Sets the last name of this object with the given value
	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }

	  // Gets the position of this object
	  public String getPosition() {
	    return position;
	  }

	  // Sets the position of this object with the given value
	  public void setPosition(String position) {
	    this.position = position;
	  }

	  // Gets the hiring date of this object
	  public LocalDate getHiringDate() {
	    return hiringDate;
	  }

	  // Sets the hiring date of this object with the given value
	  public void setHiringDate(LocalDate hiringDate) {
	    this.hiringDate = hiringDate;
	  }

	  // Gets the annual salary of this object
	  public int getAnnualSalary() {
	    return annualSalary;
	  }

	  // Sets the annual salary of this object with the given value
	  public void setAnnualSalary(int annualSalary) {
	    this.annualSalary = annualSalary;
	  }

	  // Returns the full name of this object
	  public String getFullName() {
	    return firstName + " " + lastName;
	  }

	  // Returns a string representation of this employee
	  @Override
	  public String toString() {
	    return String.format("ID: %s, Name: %s, Position: %s, HiringDate: %s, Salary: $%,d (Bonus: $%,d)", 
	        id, getFullName(), position, hiringDate, annualSalary, getAnnualBonus());
	  } 
	  
	  // Ensure each subclass has a getAnnualBonus() method
	  public abstract int getAnnualBonus();

	} // end class Employee
