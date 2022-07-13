package employee.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import employee.model.Employee;
import employee.model.Manager;
import employee.model.SalesSummary;
import employee.model.Secretary;
import employee.model.Seller;
import employee.utils.CalcBonus;

public class EmployeeeService {

	public Double getTotalPaidAtMonth(List<Employee> employees, Integer month, Integer year) {
		Double total = 0.0;
		for (Employee employee : employees) {
			if (employee instanceof Seller) {
				var seller = (Seller) employee;
				var sellerBonus = CalcBonus.calcBonusSeller(seller, month, year);
				var salary = CalcBonus.calcSalaryByYears(seller, month, year);
				total += sellerBonus + salary;
			} else if (employee instanceof Secretary) {
				var secretrary = (Secretary) employee;
				var secretaryBonus = CalcBonus.calcBonusSecretary(secretrary, month, year);
				var salary = CalcBonus.calcSalaryByYears(secretrary, month, year);
				total += secretaryBonus + salary;
			} else {
				var manager = (Manager) employee;
				var salary = CalcBonus.calcSalaryByYears(manager, month, year);
				total += salary;
			}
		}
		System.out.println("Salary and bonus total: " + total);
		return total;
	}

	public Double getOnlySalaryPaidAtMonth(List<Employee> employees, Integer month, Integer year) {
		Double total = 0.0;
		for (Employee employee : employees) {
			if (employee instanceof Seller) {
				var seller = (Seller) employee;
				var salary = CalcBonus.calcSalaryByYears(seller, month, year);
				total += salary;
			} else if (employee instanceof Secretary) {
				var secretrary = (Secretary) employee;
				var salary = CalcBonus.calcSalaryByYears(secretrary, month, year);
				total += salary;
			} else {
				var manager = (Manager) employee;
				var salary = CalcBonus.calcSalaryByYears(manager, month, year);
				total += salary;
			}
		}
		System.out.println("Only salaary total: "+total);
		return total;
	}
	
	public Double getOnlyBonusPaidAtMonth(List<Employee> employees, Integer month, Integer year) {
		Double total = 0.0;
		for (Employee employee : employees) {
			if (employee instanceof Seller) {
				var seller = (Seller) employee;
				var sellerBonus = CalcBonus.calcBonusSeller(seller, month, year);
				total += sellerBonus;
			} else if (employee instanceof Secretary) {
				var secretrary = (Secretary) employee;
				var secretaryBonus = CalcBonus.calcBonusSecretary(secretrary, month, year);
				total += secretaryBonus;
			}
			
		}
		System.out.println("Only bonus total: "+total);
		return total;
	}
	
	public Employee getEmployeeBetterPaidAtMonth(List<Employee> employees, Integer month, Integer year) {
		Map<Employee, Double> map = new HashMap<>();
		for (Employee employee : employees) {
			if (employee instanceof Seller) {
				var seller = (Seller) employee;
				var sellerBonus = CalcBonus.calcBonusSeller(seller, month, year);
				var salary = CalcBonus.calcSalaryByYears(seller, month, year);
				Double total = sellerBonus + salary;
				System.out.println("emp: " +seller.getName() + " total: "+total);
				map.put(seller, total);
			} else if (employee instanceof Secretary) {
				var secretrary = (Secretary) employee;
				var secretaryBonus = CalcBonus.calcBonusSecretary(secretrary, month, year);
				var salary = CalcBonus.calcSalaryByYears(secretrary, month, year);
				Double total = secretaryBonus + salary;

				System.out.println("emp: " +secretrary.getName() + " total: "+total);
				map.put(secretrary, total);
			} else {
				var manager = (Manager) employee;
				var salary = CalcBonus.calcSalaryByYears(manager, month, year);

				System.out.println("emp: " +manager.getName() + " total: "+salary);
				map.put(manager, salary);
			}
		}
		
		Employee emp = map.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get()
				.getKey();
		
		System.out.println(emp);
		return emp;
	}

	public String getEmployeeWithBetterBonusAtMonth(List<Employee> empsWithBonus, Integer month, Integer year) {
		Map<Employee, Double> map = new HashMap<>();
		for (Employee employee : empsWithBonus) {
			if (employee instanceof Seller) {
				var seller = (Seller) employee;
				var sellerBonus = CalcBonus.calcBonusSeller(seller, month, year);
				Double total = sellerBonus;
				System.out.println("emp: " +seller.getName() + " total: "+total);
				map.put(seller, total);
			} else if (employee instanceof Secretary) {
				var secretrary = (Secretary) employee;
				var secretaryBonus = CalcBonus.calcBonusSecretary(secretrary, month, year);
				Double total = secretaryBonus;

				System.out.println("emp: " +secretrary.getName() + " total: "+total);
				map.put(secretrary, total);
			} 
		}
		
		Employee emp = map.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get()
				.getKey();
		
		System.out.println(emp);
		return emp.getName();
	}	

	
	

	public Seller getBestSellerAtMonth(List<Seller> sellers, Integer month, Integer year) {
		Map<Seller, Double> map = new HashMap<>();
		for (Seller s : sellers) {
			SalesSummary sale = s.getSellerResumes().stream().filter(r -> r.getDateSummary().getYear() == year)
					.filter(r -> r.getDateSummary().getMonthValue() == month)
					.max(Comparator.comparing(SalesSummary::getTotalValueSales)).get();
			map.put(s, sale.getTotalValueSales());
		}
		Seller seller =  map.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get()
				.getKey();
		System.out.println(seller);
		return seller;

	}

	

}
