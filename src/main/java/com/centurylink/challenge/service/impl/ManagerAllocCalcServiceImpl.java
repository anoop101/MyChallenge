package com.centurylink.challenge.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.centurylink.challenge.model.Manager;
import com.centurylink.challenge.service.ManagerAllocCalcService;
import com.centurylink.challenge.util.CenturyLinkChallengeException;

public class ManagerAllocCalcServiceImpl implements ManagerAllocCalcService{

	private static final Logger log = LogManager.getLogger(ManagerAllocCalcServiceImpl.class);

	public double getMonthlyExpenseAllocationOfManager(Manager manager) throws CenturyLinkChallengeException{
		log.info("executing getMonthlyExpenseAllocationOfManager() method");
		if(manager != null){
			return manager.getMonthlyAllocation();
		}else{
			log.error("Input cannot be null.");
			throw new CenturyLinkChallengeException("Input cannot be null.");
		}
		
	}


	
}
