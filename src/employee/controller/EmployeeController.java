package employee.controller;

import java.util.List;

import employee.exceptions.InvalidDate;
import employee.model.Employee;
import employee.model.Seller;
import employee.service.EmployeeeService;
import employee.utils.Validate;

public class EmployeeController {

	private EmployeeeService service;

	public void setSellerService(EmployeeeService service) {
		this.service = service;
	}

	public Double getTotalPaidAtMonth(List<Employee> employees, Integer month, Integer year) {
		if (Validate.isInvalidMonth(month)) {
			throw new InvalidDate("Valor de mes invalido!", month, year);
		}
		if (Validate.isInvalidYear(year)) {
			throw new InvalidDate("Valor de ano invalido!", month, year);
		}
		return service.getTotalPaidAtMonth(employees, month, year);
	}

	public Double getOnlySalaryPaidAtMonth(List<Employee> employees, Integer month, Integer year) {
		if (Validate.isInvalidMonth(month)) {
			throw new InvalidDate("Valor de mes invalido!", month, year);
		}
		if (Validate.isInvalidYear(year)) {
			throw new InvalidDate("Valor de ano invalido!", month, year);
		}
		return service.getOnlySalaryPaidAtMonth(employees, month, year);
	}

	public Double getOnlyBonusPaidAtMonth(List<Employee> employees, Integer month, Integer year) {
		if (Validate.isInvalidMonth(month)) {
			throw new InvalidDate("Valor de mes invalido!", month, year);
		}
		if (Validate.isInvalidYear(year)) {
			throw new InvalidDate("Valor de ano invalido!", month, year);
		}
		List<Employee> empsWithBonus = employees.stream().filter(emp -> emp.getTaxBonus() != null).toList();
		return service.getOnlyBonusPaidAtMonth(empsWithBonus, month, year);
	}

	public Employee getEmployeeBetterPaidAtMonth(List<Employee> employees, Integer month, Integer year) {
		if (Validate.isInvalidMonth(month)) {
			throw new InvalidDate("Valor de mes invalido!", month, year);
		}
		if (Validate.isInvalidYear(year)) {
			throw new InvalidDate("Valor de ano invalido!", month, year);
		}
		return service.getEmployeeBetterPaidAtMonth(employees, month, year);
	}

	public String getEmployeeWithBetterBonusAtMonth(List<Employee> employees, Integer month, Integer year) {
		if (Validate.isInvalidMonth(month)) {
			throw new InvalidDate("Valor de mes invalido!", month, year);
		}
		if (Validate.isInvalidYear(year)) {
			throw new InvalidDate("Valor de ano invalido!", month, year);
		}
		List<Employee> empsWithBonus = employees.stream().filter(emp -> emp.getTaxBonus() != null).toList();
		return service.getEmployeeWithBetterBonusAtMonth(empsWithBonus, month, year);
	}

	public Seller getBestSellerAtMonth(List<Seller> sellers, Integer month, Integer year) {
		if (Validate.isInvalidMonth(month)) {
			throw new InvalidDate("Valor de mes invalido!", month, year);
		}
		if (Validate.isInvalidYear(year)) {
			throw new InvalidDate("Valor de ano invalido!", month, year);
		}
		return service.getBestSellerAtMonth(sellers, month, year);

	}

}
