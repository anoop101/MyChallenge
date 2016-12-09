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

import com.centurylink.challenge.model.Department;
import com.centurylink.challenge.model.Developer;
import com.centurylink.challenge.model.Employee;
import com.centurylink.challenge.model.Manager;
import com.centurylink.challenge.model.Tester;
import com.centurylink.challenge.service.DeptAllocCalcService;
import com.centurylink.challenge.util.CenturyLinkChallengeException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test.xml" })
public class DepartmentAllocationJunitTest {
	@Autowired
	DeptAllocCalcService deptAllocCalcService;
	
	Department treasuryDept;
	Manager manager1;
	Manager manager2;
	Manager manager3;
	Manager manager4;

	@Before
	public void initialize() throws CenturyLinkChallengeException{
		treasuryDept = new Department(1111, "Treasury");
		manager1 = new Manager(1, "Manager 1");
		manager2 = new Manager(2, "Manager 2", manager1);
		manager3 = new Manager(3, "Manager 3");
		manager4 = new Manager(4, "Manager 4");
	}
	
	@Test
	public void noEmployeeDepartmentTest() throws CenturyLinkChallengeException{
		System.out.println("Executing test for Department with no employee ");
		//Monthly allocation output by department
		double outValue = deptAllocCalcService.getMonthlyExpenseAllocationOfDepartment(treasuryDept);
		System.out.println("Monthly Allocation - " + outValue);
		assertTrue(0.0 == outValue);
	}
	
	@Test
	public void developer1Tester1Manager1DeptTest() throws CenturyLinkChallengeException{
		System.out.println("Executing test for Department with 1 Developer, 1 Tester and 2 Manager ");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Developer(11, "Developer 1", manager1));
		employeeList.add(new Tester(21, "Tester 1", manager1));
		//one developer and one Tester reporting to a manager
		manager1.getEmployeeList().addAll(employeeList);

		//department contains only one manager
		treasuryDept.getEmployees().add(manager1);
		//Monthly allocation output
		double outValue = deptAllocCalcService.getMonthlyExpenseAllocationOfDepartment(treasuryDept);
		System.out.println("Monthly Allocation - " + outValue);
		assertTrue(1800.0 == outValue);
	}
	
	
	@Test
	public void developer4Tester2Manager4DeptTest() throws CenturyLinkChallengeException{
		System.out.println("Executing test for Department with 4 Developer, 2 Tester and 4 Manager");
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
		treasuryDept.getEmployees().addAll(employeeList4TopManager);
		
		//Monthly allocation output by department
		double outValue = deptAllocCalcService.getMonthlyExpenseAllocationOfDepartment(treasuryDept);
		System.out.println("Monthly Allocation - " + outValue);
		assertTrue(5900.0 == outValue);
		
	}
}
