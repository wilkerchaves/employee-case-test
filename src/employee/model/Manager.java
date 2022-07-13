package employee.model;

import java.time.LocalDate;

public class Manager extends Employee {
	
	

	public Manager() {
		super();
	}

	public Manager(String name, LocalDate hireDate) {
		this.name = name;
		this.hireDate = hireDate;
		this.setBaseSalary(20000.00);
		this.setValuePerYear(3000.00);
		this.setTaxBonus(null);
		
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
