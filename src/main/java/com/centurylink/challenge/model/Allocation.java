package com.centurylink.challenge.model;
/**
 * @author Anoop
 * interface Allocation can be implemented 
 * to get various allocations
 */
public interface Allocation {
	
	/**
	 * Concrete class needs to implement this method
	 * to calculate and get monthly allocation
	 * @return double value of monthly allocation
	 */
	public double getMonthlyAllocation(); 
}
