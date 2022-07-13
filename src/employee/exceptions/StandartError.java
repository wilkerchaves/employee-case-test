package employee.exceptions;

import java.io.Serializable;

public class StandartError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long timestamp;
	private String error;
	private Integer month;
	private Integer year;
	
	public StandartError() {
		
	}
	public StandartError(Long timestamp, String error,Integer month, Integer year) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.month=month;
		this.year=year;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public void showError() {
		System.out.println("Erro durante execução do programa: "+this.getError()+". Mes: "+this.getMonth()+" - Ano: "+this.getYear());
	}
	
	
	
	 

}
