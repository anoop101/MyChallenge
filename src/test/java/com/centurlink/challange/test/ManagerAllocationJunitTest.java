package com.centurlink.challange.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.centurylink.challenge.model.Developer;
import com.centurylink.challenge.model.Employee;
import com.centurylink.challenge.model.Manager;
import com.centurylink.challenge.model.Tester;
import com.centurylink.challenge.service.ManagerAllocCalcService;
import com.centurylink.challenge.util.CenturyLinkChallengeException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test.xml" })
public class ManagerAllocationJunitTest {
	
	@Autowired
	ManagerAllocCalcService managerAllocCalcService;
	
	Manager manager1;
	Manager manager2;
	Manager manager3;
	Manager manager4;
	
	@Before
	public void prepareManagers(){
		manager1 = new Manager(1, "Manager 1");
		manager2 = new Manager(2, "Manager 2");
		manager3 = new Manager(3, "Manager 3");
		manager4 = new Manager(4, "Manager 4");
	}
	
	@Test(expected=CenturyLinkChallengeException.class)
	public void TesterToDeveloperTest() throws CenturyLinkChallengeException{
		System.out.println("Exception expected for 1 Tester reports to a Developer ");
		Employee developer1 = new Developer(11, "Developer 1");
		Employee tester1 = new Tester(21, "Tester 1");
		//tester1 report to developer1
		tester1.reportsToManager(developer1);
	}
	
	@Test(expected=CenturyLinkChallengeException.class)
	public void DeveloperToTesterTest() throws CenturyLinkChallengeException{
		System.out.println("Exception expected for 1 Developer reports to a Tester ");
		Employee developer1 = new Developer(11, "Developer 1");
		Employee tester1 = new Tester(21, "Tester 1");
		//tester1 report to developer1
		developer1.reportsToManager(tester1);
	}
	
	@Test
	public void Manager2Test() throws CenturyLinkChallengeException{
		System.out.println("Executing test for 2 Manager ");
		//manager2 reports to manager1
		manager2.reportsToManager(manager1);
		//manager2 is employee under manager1
		manager1.getEmployeeList().add(manager2);
		
		//Monthly allocation output by manager
		double output = managerAllocCalcService.getMonthlyExpenseAllocationOfManager(manager1);
		System.out.println("Monthly Allocation - " + output);
		assertTrue(600.0 == output);
	}
	
	@Test
	public void developer1Tester1Manager2Test() throws CenturyLinkChallengeException{
		System.out.println("Executing test for 1 Developer, 1 Tester and 2 Manager ");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Developer(11, "Developer 1", manager2));
		employeeList.add(new Tester(21, "Tester 1", manager2));
		//one developer and one Tester reporting to manager2
		manager2.getEmployeeList().addAll(employeeList);
		//manager2 reports to manager 1
		manager1.getEmployeeList().add(manager2);

		//Monthly allocation output by manager
		double output = managerAllocCalcService.getMonthlyExpenseAllocationOfManager(manager1);
		System.out.println("Monthly Allocation - " + output);
		assertTrue(2100.0 == output);
	}
	
	@Test
	public void developer4Tester3Manager2Test() throws CenturyLinkChallengeException{
		System.out.println("Executing test for 4 Developer, 3 Tester and 2 Manager");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Developer(11, "Developer 1", manager2));
		employeeList.add(new Developer(12, "Developer 2", manager2));
		employeeList.add(new Developer(13, "Developer 3", manager2));
		employeeList.add(new Developer(14, "Developer 4", manager2));
		employeeList.add(new Tester(21, "Tester 1", manager2));
		employeeList.add(new Tester(22, "Tester 2", manager2));
		employeeList.add(new Tester(23, "Tester 3", manager2));
		//4 developer and 3 Tester reporting to manager2
		manager2.getEmployeeList().addAll(employeeList);
		//manager 2 reports to manager 1
		manager1.getEmployeeList().add(manager2);
		//Monthly allocation output by manager
		double output = managerAllocCalcService.getMonthlyExpenseAllocationOfManager(manager1);
		System.out.println("Monthly Allocation - " + output);
		assertTrue(6100.0 == manager1.getMonthlyAllocation());
		
	}
	
	@Test
	public void developer4Tester2Manager4Test() throws CenturyLinkChallengeException{
		System.out.println("Executing test for 4 Developer, 2 Tester and 4 Manager");
		List<Employee> employeeList2 = new ArrayList<Employee>();
		
		//1Developer and 1 Tester for manager2
		employeeList2.add(new Developer(11, "Developer 1", manager2));
		employeeList2.add(new Tester(21, "Tester 1", manager2));
		manager2.getEmployeeList().addAll(employeeList2);
		
		List<Employee> employeeList3 = new ArrayList<Employee>();
		//2 Developer and a Tester for Manager3
		employeeList3.add(new Developer(12, "Developer 2", manager3));
		employeeList3.add(new Developer(13, "Developer 3", manager3));
		employeeList3.add(new Tester(22, "Tester 2", manager3));
		manager3.getEmployeeList().addAll(employeeList3);
		
		//1 developer for manager4
		manager4.getEmployeeList().add(new Developer(14, "Developer 4", manager4));
		
		List<Employee> employeeList4TopManager = new ArrayList<Employee>();
		employeeList4TopManager.add(manager2);
		employeeList4TopManager.add(manager3);
		employeeList4TopManager.add(manager4);		
		
		//manager 2 reports to manager 1
		manager1.getEmployeeList().addAll(employeeList4TopManager);
		
		//Monthly allocation output by manager
		double output = managerAllocCalcService.getMonthlyExpenseAllocationOfManager(manager1);
		System.out.println("Monthly Allocation - " + output);
		assertTrue(6200.0 == manager1.getMonthlyAllocation());
		
	}
	
	
	@Test
	public void developer4Tester3Manager4Test() throws CenturyLinkChallengeException{
		System.out.println("Executing test for 4 Developer, 2 Tester and 4 Manager");
		List<Employee> employeeList2 = new ArrayList<Employee>();
		
		//1Developer and 1 Tester for manager2
		employeeList2.add(new Developer(11, "Developer 1", manager2));
		employeeList2.add(new Tester(21, "Tester 1", manager2));
		manager2.getEmployeeList().addAll(employeeList2);
		
		List<Employee> employeeList3 = new ArrayList<Employee>();
		//2 Developer and a Tester for Manager3
		employeeList3.add(new Developer(12, "Developer 2", manager3));
		employeeList3.add(new Developer(13, "Developer 3", manager3));
		employeeList3.add(new Tester(22, "Tester 2", manager3));
		manager3.getEmployeeList().addAll(employeeList3);
		
		//1 developer for manager4
		manager4.getEmployeeList().add(new Developer(14, "Developer 4", manager4));
		
		//manager4 reports to manager3
		manager4.reportsToManager(manager3);
		manager3.getEmployeeList().add(manager4);
		
		//manager3 and a Principal tester reports to manager2
		manager3.reportsToManager(manager2);
		manager2.getEmployeeList().add(manager3);
		manager2.getEmployeeList().add(new Tester(23, "Principal QA", manager2));
		
		//manager 2 reports to manager 1
		manager1.getEmployeeList().add(manager2);
		
		//Monthly allocation output by manager
		double output = managerAllocCalcService.getMonthlyExpenseAllocationOfManager(manager1);
		System.out.println("Monthly Allocation - " + output);
		assertTrue(6700.0 == manager1.getMonthlyAllocation());
		
	}
}
