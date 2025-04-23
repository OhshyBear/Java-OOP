/*
 * File name: HT54Manager.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 03/29/2025
 * The HT54Manager class extends HT54Staff to represent a managerial role within the organization.
 * A manager oversees a team of HT54Employees and receives an annual bonus based on salary.
 */

package huddleston;

import java.time.LocalDate;
import java.util.ArrayList;

public class HT54Manager extends HT54Staff{
	private ArrayList<HT54Employee> teamMembers;// array list for managed team members

	//default constructor
	public HT54Manager() {
		this.teamMembers = new ArrayList<>();
	};
	//constructor for Manager
	public HT54Manager(String id, String firstName, String lastName, String position, LocalDate hiringDate, int annualSalary) {
		super(id, firstName, lastName,position, hiringDate, annualSalary);
		this.teamMembers = new ArrayList<>();
	};
	//bonus for managers is increased to 10% from staff
	public int getAnnualBonus() {
		return (int)(super.getAnnualSalary() * 0.1);
	}
	//adds team members to list of under manager 
	public boolean addTeamMember(HT54Staff member) {
		if (teamMembers.contains(member)) {
			return false;
		}
		
		member.setManager(this);
		teamMembers.add(member);
		return true;
	}
	//removes added team members from manager list
	public boolean removeTeamMember(HT54Staff member) {
		if(!teamMembers.contains(member)) {
			return false;
		}
		member.setManager(null);
		teamMembers.remove(member);
		return true;
	}
	@Override //overrides the toString for Staff allowing it to list the managed employees
	public String toString() {
		//loop through the teamMembers assigned and get the full name then add them to a list of managed employees
		ArrayList<String> managedEmployees = new ArrayList<>();
		for (HT54Employee employee: teamMembers) {
			managedEmployees.add(employee.getFullName());
		}
		
		return super.toString() +" " + "Manages: " + managedEmployees;
	}
	
}
