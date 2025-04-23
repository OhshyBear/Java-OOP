/*
 * File name: HT54TestHr.java
 * Author: Trevor Huddleston, 1717354, CS252
 * Date: 03/29/2025
 * This class serves as a test driver for the HT54Employee, HT54Staff, and HT54Manager classes.
 * It demonstrates the creation of staff and manager objects, assigning team members,
 * calculating bonuses, and managing reporting relationships within the organization.
 * The program prints out the details of each employee, including their managers and subordinates,
 * and tests the removal of a team member from a manager.
 */

package huddleston;

import java.time.LocalDate;

public class HT54TestHr {

	public static void main(String[] args) {
		//Staff Objects
		HT54Staff s1 = new HT54Staff("101", "S1Trevor", "Huddleston", "Software Engineer", LocalDate.now().minusYears(2), 80000);
		HT54Staff s2 = new HT54Staff("102", "S2Lilly", "Huddleston", "Baby Helper", LocalDate.now().minusYears(1), 180000);
		//Manager Objects
		HT54Manager m1 = new HT54Manager("201", "M1Crystal", "Peng", "CEO", LocalDate.now().minusYears(5), 200000);
		HT54Manager m2 = new HT54Manager("202", "M2Alexandra", "Huddleston", "Project Manager", LocalDate.now().minusYears(8), 150000);
		//Calls to add team members to Managers
		m1.addTeamMember(s1);
		m1.addTeamMember(m2);
		m2.addTeamMember(s2);
		//Print Employees with Managers and anyone they manage
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(m1);
		System.out.println(m2);
		//Call to remove manager2 from manager1 then print both again
		m1.removeTeamMember(m2);
		System.out.println(m1);
		System.out.println(m2);
	}

}
