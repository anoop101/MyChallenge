package com.centurylink.challenge.service;

import com.centurylink.challenge.model.Manager;
import com.centurylink.challenge.util.CenturyLinkChallengeException;

public interface ManagerAllocCalcService {
	/**
	 * @param Manager for whose monthly allocation needs to be calculated.
	 * @return double calculated value of monthly allocation
	 * @throws CenturyLinkChallengeException
	 */
	public double getMonthlyExpenseAllocationOfManager(Manager mngr) throws CenturyLinkChallengeException;
}
