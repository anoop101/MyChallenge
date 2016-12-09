package com.centurylink.challenge.model;

import com.centurylink.challenge.util.CenturyLinkChallengeException;
import com.centurylink.challenge.util.Constant;

/**
 * @author Anoop
 * Developer Model class
 */
public class Developer extends Employee {

	public Developer(int id, String name) {
		super(id, name);
	}
	
	public Developer(int id, String name, Employee emp) throws CenturyLinkChallengeException {
		super(id, name);
		reportsToManager(emp);
	}



	@Override
	public void reportsToManager(Employee emp) throws CenturyLinkChallengeException {
		if(emp instanceof Manager){
			super.setManager(emp);
		}else{
			throw new CenturyLinkChallengeException("An employee can only report to a Manager");
		}
		
	}

	public double getMonthlyAllocation() {
		return Constant.DEVELOPER_ALLOCATION_PER_MONTH;
	}
	
	@Override
	public int hashCode() {
		int hash = 124;
		hash = hash * this.getId() + this.getEmployeeName().hashCode();
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass() != getClass()){
			return false;
		}else{
			Developer developer = (Developer) obj;
			if(developer.getId() == this.getId() && developer.getEmployeeName().equals(this.getEmployeeName())){
				return true;
			}else{
				return false;
			}
		}
	}

}
