package employee.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import employee.model.Employee;
import employee.model.SalesSummary;
import employee.model.Secretary;
import employee.model.Seller;

public class CalcBonus {
	
	public static Double calcBonusSecretary(Secretary secretary, Integer month, Integer year) {	
		Double salary = calcSalaryByYears(secretary, month, year);
		Double bonus = (secretary.getTaxBonus() * salary)/100;
		return bonus;
	}
	
	public static Double calcBonusSeller(Seller seller, Integer month, Integer year) {
		Double bonus = 0.0;
		Optional<SalesSummary> sale = seller.getSellerResumes()
				.stream()
				.filter(r->r.getDateSummary().getMonthValue()==month)
				.filter(r->r.getDateSummary().getYear()==year)
				.findFirst();
				
		if(sale.isPresent()) {
			bonus += (seller.getTaxBonus() * sale.get().getTotalValueSales())/100;
		}
		return bonus;
		
	}
	
	public static Double calcSalaryByYears(Employee employee, Integer month, Integer year) {
		LocalDate currentDate = LocalDate.of(year, month, 1);
		Period period = Period.between(employee.getHireDate(), currentDate);
		int years = period.getYears();
		Double salaryByYears = employee.getBaseSalary() + (years * employee.getValuePerYear());
		return salaryByYears;
	}

}
