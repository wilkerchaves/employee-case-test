package employee.exceptions;

public class InvalidDate extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer month;
	private Integer year;

	public InvalidDate(String msg, Integer month, Integer year) {
		super(msg);
		this.month = month;
		this.year = year;
	}

	public InvalidDate(String msg, Integer month, Integer year, Throwable cause) {
		super(msg, cause);
		this.month = month;
		this.year = year;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

}
