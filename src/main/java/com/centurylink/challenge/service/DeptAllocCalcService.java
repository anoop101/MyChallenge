package com.centurylink.challenge.service;

import com.centurylink.challenge.model.Department;
import com.centurylink.challenge.util.CenturyLinkChallengeException;

public interface DeptAllocCalcService {
	/**
	 * @param Department for which monthly allocation needs to be calculated.
	 * @return double calculated value of monthly allocation
	 * @throws CenturyLinkChallengeException
	 */
	public double getMonthlyExpenseAllocationOfDepartment(Department dept) throws CenturyLinkChallengeException;
}
