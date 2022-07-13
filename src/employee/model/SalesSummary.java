package employee.model;

import java.time.LocalDate;
import java.util.Objects;

public class SalesSummary {

	private Double totalValueSales;
	private LocalDate dateSummary;
	public SalesSummary() {
		super();
	}
	public SalesSummary(Double totalValueSales, LocalDate dateSummary) {
		super();
		this.totalValueSales = totalValueSales;
		this.dateSummary = dateSummary;
	}
	public Double getTotalValueSales() {
		return totalValueSales;
	}
	public void setTotalValueSales(Double totalValueSales) {
		this.totalValueSales = totalValueSales;
	}
	public LocalDate getDateSummary() {
		return dateSummary;
	}
	public void setDateSummary(LocalDate dateSummary) {
		this.dateSummary = dateSummary;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateSummary, totalValueSales);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesSummary other = (SalesSummary) obj;
		return Objects.equals(dateSummary, other.dateSummary) && Objects.equals(totalValueSales, other.totalValueSales);
	}
	@Override
	public String toString() {
		return "SalesSummary [totalValueSales=" + totalValueSales + ", dateSummary=" + dateSummary + "]";
	}
	
	
	
	
}
