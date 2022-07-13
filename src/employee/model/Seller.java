package employee.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Seller extends Employee {
	
	private List<SalesSummary> sellerResumes = new ArrayList<>();

	public Seller() {
		super();
	}

	public Seller(String name, LocalDate hireDate) {
		this.name = name;
		this.hireDate = hireDate;
		this.setBaseSalary(12000.00);
		this.setTaxBonus(30.0);
		this.setValuePerYear(1800.00);		
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



	public List<SalesSummary> getSellerResumes() {
		return sellerResumes;
	}

	public void setSellerResumes(List<SalesSummary> sellerResumes) {
		this.sellerResumes = sellerResumes;
	}
	
	



}
