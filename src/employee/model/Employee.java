package employee.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Employee {
	protected String name;
	protected Double baseSalary;
	protected Double taxBonus;
	protected LocalDate hireDate;
	protected Double valuePerYear;

	public Employee() {

	}

	public Employee(String name, Double baseSalary, Double taxBonus, Double valueBonus, Double salaryWithBonus,
			LocalDate hireDate, Double valuePerYear) {

		this.name = name;
		this.baseSalary = baseSalary;
		this.taxBonus = taxBonus;
		this.hireDate = hireDate;
		this.valuePerYear = valuePerYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Double getTaxBonus() {
		return taxBonus;
	}

	public void setTaxBonus(Double taxBonus) {
		this.taxBonus = taxBonus;
	}

	public abstract Double getSalaryWithBonus();

	public abstract void setSalaryWithBonus(Double salaryWithBonus);

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	

	public Double getValuePerYear() {
		return valuePerYear;
	}

	public void setValuePerYear(Double percentPerYear) {
		this.valuePerYear = percentPerYear;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", BaseSalary=" + baseSalary + ", taxBonus=" + taxBonus + "hireDate=" + hireDate + "]";
	}

}
