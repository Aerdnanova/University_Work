package comPay;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class CompanyPayrollTest {

	EmployeeM2P3 Emp;
	HourlyEmployeeM2P3 EmpH;
	SalariedEmployeeM2P3 EmpS;
	
	//Start
	@Before
	public void setUp() throws Exception {
		
		this.Emp = new EmployeeM2P3();
		this.EmpH = new HourlyEmployeeM2P3();
		this.EmpS = new SalariedEmployeeM2P3();
	
	}
	
	//For EmployeeM2P3
	@Test
	public void testgetName() {
		Emp.setName("Andrea");
		String name = Emp.getName();
		assertEquals("Andrea", name);
	}
	
	@Test
	public void testsetName() {
		Emp.setName("Andrea");
		assertEquals("Andrea", Emp.getName());
	}
	
	@Test
	public void testgetSIN() {
		Emp.setSIN("1111111111");
		String SIN = Emp.getSIN();
		assertEquals("1111111111", SIN);
	}
	
	@Test
	public void testsetSIN() {
		Emp.setSIN("1111111111");
		assertEquals("1111111111", Emp.getSIN());
	}
	
	//For HourlyEmployeeM2P3
	@Test
	public void testsetWage() {
		EmpH.setWage(100.00);
		assertEquals(100.00, EmpH.getWage(), 0.00);
	}
	
	@Test
	public void testgetWage() {
		EmpH.setWage(100.0);
		double wage = EmpH.getWage();
		assertEquals(100.0, wage, 0.00);
	}

	@Test
	public void testsetHours() {
		EmpH.setHours(10);
		assertEquals(10, EmpH.getHours(), 0.00);
	}
	
	@Test
	public void testgetHours() {
		EmpH.setHours(10);
		double hours = EmpH.getHours();
		assertEquals(10, hours, 0.00);
		
	}
	
	@Test
	public void testHourlyEmployeeEarnings() {
		EmpH.setHours(10);
		EmpH.setWage(4);
		double salary = EmpH.hourlyEmployeeEarnings();
		assertEquals(40.00, salary, 0.00);
	}
	
	//For SalariedEmployeeM2P3
	
	@Test
	public void testsetWeeklySalary() {
		EmpS.setWeeklySalary(1000);
		assertEquals(1000, EmpS.getWeeklySalary(), 0.00);
	}
	
	@Test
	public void testgetWeeklySalary() {
		EmpS.setWeeklySalary(1000);
		double salary = EmpS.getWeeklySalary();
		assertEquals(1000, salary, 0.00);
	}
	
	@Test
	public void testSalariedEmployeeEarnings() {
		EmpS.setWeeklySalary(1000);
		double salary = EmpS.salariedEmployeeEarnings();
		assertEquals(1000, salary, 0.00);
	}
	//Done all
	
	@After
	public void tearDown() throws Exception {}
}
