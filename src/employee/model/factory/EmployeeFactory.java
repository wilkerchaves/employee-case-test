package employee.model.factory;

import java.time.LocalDate;

import employee.model.Manager;
import employee.model.Secretary;
import employee.model.Seller;

public class EmployeeFactory {

	public static Seller createSeller(String name, LocalDate hireDate) {

		return new Seller(name, hireDate);
	}

	public static Secretary createSecretary(String name, LocalDate hireDate) {
		return new Secretary(name, hireDate);
	}

	public static Manager createManager(String name, LocalDate hireDate) {
		return new Manager(name, hireDate);
	}

}
