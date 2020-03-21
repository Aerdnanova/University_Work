package comPay;

public class SalariedEmployeeM2P3 extends EmployeeM2P3{
	
	private double weeklySalary;
	
	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}
	
	public double getWeeklySalary() {
		return weeklySalary;
	}

	public double salariedEmployeeEarnings() {
		return getWeeklySalary();
	}
}