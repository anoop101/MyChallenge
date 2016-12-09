package com.centurylink.challenge.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.centurylink.challenge.model.Department;
import com.centurylink.challenge.service.DeptAllocCalcService;
import com.centurylink.challenge.util.CenturyLinkChallengeException;

public class DeptAllocCalcServiceImpl implements DeptAllocCalcService{

	private static final Logger log = LogManager.getLogger(DeptAllocCalcServiceImpl.class);

	public double getMonthlyExpenseAllocationOfDepartment(Department dept) throws CenturyLinkChallengeException {
		log.info("executing getMonthlyExpenseAllocationOfDepartment() method");
		if(dept != null){
			return dept.getMonthlyAllocation();
		}else{
			log.error("Input cannot be null.");
			throw new CenturyLinkChallengeException("Input cannot be null.");
		}
	}
	
	
}
