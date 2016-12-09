package com.centurylink.challenge.model;

import com.centurylink.challenge.util.CenturyLinkChallengeException;
import com.centurylink.challenge.util.Constant;

/**
 * @author Anoop
 * Tester model class
 */
public class Tester extends Employee {

	public Tester(int id, String name) {
		super(id, name);
	}
	
	public Tester(int id, String name, Employee manager) throws CenturyLinkChallengeException {
		super(id, name);
		reportsToManager(manager);
	}

	
	/* (non-Javadoc)
	 * @see com.centurylink.challenge.model.Employee#reportsToManager(Employee)
	 */
	@Override
	public void reportsToManager(Employee emp) throws CenturyLinkChallengeException {
		if(emp instanceof Manager){
			super.setManager(emp);
		}else{
			throw new CenturyLinkChallengeException("An employee can only report to a Manager");
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.centurylink.challenge.model.Allocation#getMonthlyAllocation()
	 */
	public double getMonthlyAllocation() {
		return Constant.TESTER_ALLOCATION_PER_MONTH;
	}
	
	@Override
	public int hashCode() {
		int hash = 125;
		hash = hash * this.getId() + this.getEmployeeName().hashCode();
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass() != getClass()){
			return false;
		}else{
			Tester tester = (Tester) obj;
			if(tester.getId() == this.getId() && tester.getEmployeeName().equals(this.getEmployeeName())){
				return true;
			}else{
				return false;
			}
		}
	}

}
