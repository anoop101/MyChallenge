package com.centurylink.challenge.model;

import java.util.ArrayList;
import java.util.List;

import com.centurylink.challenge.util.CenturyLinkChallengeException;
import com.centurylink.challenge.util.Constant;

/**
 * @author Anoop
 * Manager model class
 */
public class Manager extends Employee {

	List<Employee> employeeList = new ArrayList<Employee>();

	public Manager(int id, String name) {
		super(id, name);
	}
	
	public Manager(int id, String name, Employee manager) throws CenturyLinkChallengeException {
		super(id, name);
		reportsToManager(manager);
	}	
	
	//getters and setters
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	

	/* (non-Javadoc)
	 * @see com.centurylink.challenge.model.Employee#reportsToManager(Employee)
	 */
	@Override
	public void reportsToManager(Employee emp) throws CenturyLinkChallengeException{
		if(emp instanceof Manager){
			if(!((Manager) emp).getEmployeeList().contains(this) || this.equals(emp)){
				super.setManager(emp);
			}else{
				throw new CenturyLinkChallengeException("A reporting manager cannot be subordinate of same manager");
			}
		}else{
			throw new CenturyLinkChallengeException("An employee can only report to a Manager");
		}
		
	}


	/* (non-Javadoc)
	 * @see com.centurylink.challenge.model.Allocation#getMonthlyAllocation()
	 */
	public double getMonthlyAllocation() {
		double totalAllocation = Constant.MANAGER_ALLOCATION_PER_MONTH;
		if(employeeList != null && !employeeList.isEmpty()){
			for(Employee employee : employeeList){
				if(employee != null){
					totalAllocation += employee.getMonthlyAllocation();
				}
			}
		}
		return totalAllocation;
	}
	
	@Override
	public int hashCode() {
		int hash = 123;
		hash = hash * this.getId() + this.getEmployeeName().hashCode();
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		} else {
			Manager manager = (Manager) obj;
			if (manager.getId() == this.getId() && manager.getEmployeeName().equals(this.getEmployeeName())) {
				return true;
			} else {
				return false;
			}
		}
	}
	
}
