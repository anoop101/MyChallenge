package com.centurylink.challenge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Anoop
 * Department model class
 *
 */
public class Department implements Allocation {
	private int departmentId;
	private String deptName;
	private List<Employee> employees = new ArrayList<Employee>();

	public Department(int id, String deptName) {
		this.departmentId = id;
		this.deptName = deptName;
	}

	public Department(String deptName, List<Employee> employees) {
		this.deptName = deptName;
		this.employees = employees;
	}

	//Getters and setters
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
	/* (non-Javadoc)
	 * @see com.centurylink.challenge.model.Allocation#getMonthlyAllocation()
	 */
	public double getMonthlyAllocation() {
		double totalAllocation = 0.0;
		if (employees != null && !employees.isEmpty()) {
			for (Employee employee : employees) {
				if (employee != null) {
					totalAllocation += employee.getMonthlyAllocation();
				}
			}
		}
		return totalAllocation;
	}
	
	@Override
	public int hashCode() {
		int hash = 120;
		hash = hash * this.getDepartmentId() + this.getDeptName().hashCode();
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass() != getClass()){
			return false;
		}else{
			Department dept = (Department) obj;
			if(dept.getDepartmentId() == this.getDepartmentId() && dept.getDeptName().equals(this.getDeptName())){
				return true;
			}else{
				return false;
			}
		}
	}

}
