package employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import employee.controller.EmployeeController;
import employee.exceptions.InvalidDate;
import employee.exceptions.StandartError;
import employee.model.Employee;
import employee.model.Manager;
import employee.model.SalesSummary;
import employee.model.Secretary;
import employee.model.Seller;
import employee.model.factory.EmployeeFactory;
import employee.service.EmployeeeService;

public class Program {

	public static void main(String[] args) {
		
		EmployeeController controller = new EmployeeController();		
		controller.setSellerService(new EmployeeeService());	
		

		Secretary sctry1 = EmployeeFactory.createSecretary("Jorge Carvalho", LocalDate.of(2018, 01, 01));
		Secretary sctry2 = EmployeeFactory.createSecretary("Maria Souza", LocalDate.of(2015, 12, 01));
		
		Seller seller1 = EmployeeFactory.createSeller("Ana Silva", LocalDate.of(2021, 12, 01));
		seller1.getSellerResumes().add(new SalesSummary(5200.00, LocalDate.of(2021, 12, 01)));
		seller1.getSellerResumes().add(new SalesSummary(4000.00, LocalDate.of(2022, 1, 01)));
		seller1.getSellerResumes().add(new SalesSummary(4200.00, LocalDate.of(2022, 2, 01)));
		seller1.getSellerResumes().add(new SalesSummary(5850.00, LocalDate.of(2022, 3, 01)));
		seller1.getSellerResumes().add(new SalesSummary(7000.00, LocalDate.of(2022, 4, 01)));
		
		
		
		
		Seller seller2 = EmployeeFactory.createSeller("João Mendes", LocalDate.of(2021, 12, 01));
		seller2.getSellerResumes().add(new SalesSummary(7700.00, LocalDate.of(2021, 12, 01)));
		seller2.getSellerResumes().add(new SalesSummary(5000.00, LocalDate.of(2022, 1, 01)));
		seller2.getSellerResumes().add(new SalesSummary(5900.00, LocalDate.of(2022, 2, 01)));
		seller2.getSellerResumes().add(new SalesSummary(16550.00, LocalDate.of(2022, 3, 01)));
		seller2.getSellerResumes().add(new SalesSummary(7000.00, LocalDate.of(2022, 4, 01)));
		
		Manager mngr1 = EmployeeFactory.createManager("Juliana Alves", LocalDate.of(2017, 07, 01));
		Manager mngr2 = EmployeeFactory.createManager("Bento Albino", LocalDate.of(2014, 03, 01));	
		
		List<Employee> employees = new ArrayList<>(Arrays.asList(sctry1, sctry2, seller1,seller2, mngr1, mngr2));
		List<Seller> sellers = new ArrayList<>(Arrays.asList(seller1,seller2));

		
		try {
			System.out.println("------------");
			controller.getTotalPaidAtMonth(employees, 22, 2022);
			System.out.println();
			System.out.println();
			System.out.println("------------");
			controller.getOnlySalaryPaidAtMonth(employees, 2, 2022);
			System.out.println();
			System.out.println();
			System.out.println("------------");
			controller.getOnlyBonusPaidAtMonth(employees, 2, 2022);
			System.out.println();
			System.out.println();
			System.out.println("------------");
			controller.getEmployeeBetterPaidAtMonth(employees, 2, 2022);
			System.out.println();
			System.out.println();
			System.out.println("------------");
			controller.getEmployeeWithBetterBonusAtMonth(employees, 2, 2022);
			System.out.println();
			System.out.println();
			System.out.println("------------");
			controller.getBestSellerAtMonth(sellers ,2, 2022);
			
		} catch (InvalidDate e) {
			StandartError error = new StandartError(System.currentTimeMillis(), e.getMessage(), e.getMonth(), e.getYear());
			error.showError();
		}
		
	
		
		
		
		
		
		
		
		

	}

}
