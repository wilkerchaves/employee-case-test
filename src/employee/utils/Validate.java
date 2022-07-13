package employee.utils;

public class Validate {
	
	public static boolean isInvalidMonth(Integer month) {
		if(month < 1 || month >12 || month == null) {
			return true;
		}
		return false;
	}
	
	public static boolean isInvalidYear(Integer year) {
		if(year < 1 || year == null) {
			return true;
		}
		return false;
	}

}
