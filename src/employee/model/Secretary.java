package employee.model;

import java.time.LocalDate;

public class Secretary extends Employee {

	public Secretary() {
		super();
	}

	public Secretary(String name, LocalDate hireDate) {
		this.name=name;
		this.hireDate = hireDate;
		this.setBaseSalary(7000.00);
		this.setValuePerYear(1000.00);
		this.setTaxBonus(20.0);
		
	}

	@Override
	public Double getSalaryWithBonus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSalaryWithBonus(Double salaryWithBonus) {
		// TODO Auto-generated method stub
		
	}





}
