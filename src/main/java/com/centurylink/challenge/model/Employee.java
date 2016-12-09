package com.centurylink.challenge.model;

import com.centurylink.challenge.util.CenturyLinkChallengeException;

/**
 * @author Anoop
 * Employee abstract class
 * implements Allocation interface
 *
 */
public abstract class Employee implements Allocation{
	private int id;
	private String employeeName;
	private Employee manager;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.employeeName = name;
	}

	public Employee getManager() {
		return manager;
	}

	//Getters and setters
	protected void setManager(Employee manager) {
		this.manager = manager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	
	/**
	 * This method needs to be implemented to set reporting manager
	 * for this employee.
	 * @param Employee type - as per this challenge it can only be 
	 * Manager type
	 * @throws CenturyLinkChallengeException if Employee is not 
	 * Manager type
	 */
	public abstract void reportsToManager(Employee emp) throws CenturyLinkChallengeException;
	
}
