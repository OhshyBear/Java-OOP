/*
 * File name: HT54Manager.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 03/29/2025
 * The HT54Staff class extends HT54Employee to represent a staff member in the organization.
 * It includes a reference to a manager, allows for setting and retrieving the manager,
 * and calculates an annual bonus based on a percentage of the salary.
 */

package huddleston;

import java.time.LocalDate;

public class HT54Staff extends HT54Employee{
	private HT54Manager manager; // Manager overseeing this staff member
	//default constructor
	public HT54Staff() {}
	//initializes staff members with employee details
	public HT54Staff(String id, String firstName, String lastName, String position, LocalDate hiringDate, int annualSalary) {
		super(id, firstName, lastName,position, hiringDate, annualSalary); 
	}
	//calculates an annual bonus for the staff member
	public int getAnnualBonus() {
		return (int)(super.getAnnualSalary() * 0.075);
	}
	//gets the manager for the staff member
	public HT54Manager getManager() {
		return manager;
	}
	//sets the manager of the staff member
	protected void setManager(HT54Manager manager) {
		this.manager = manager;
	}
	
	//gets manager and appends it to the end of the employee string
	@Override
	public String toString() {
		String managerInfo = (manager != null) ? "Manager: " + manager.getFirstName() + " " + manager.getLastName() :"Manager: none";
		return super.toString() + " " + managerInfo;
	}

}
