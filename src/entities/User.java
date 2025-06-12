package entities;

public class User {
	private String name;
	private Integer days;
	private Integer hours;
	private Double grossSalary;
	
	public User(String name, Integer days, Integer hours, Double grossSalary) {
		this.name = name;
		this.days = days;
		this.hours = hours;
		this.grossSalary = grossSalary;
	}

	public String getName() {
		return name;
	}
	
	public Integer getDays() {
		return days;
	}

	public Integer getHours() {
		return hours;
	}

	public Double getFGTS() {
		return grossSalary * 0.08;
	}
	
	public Double getINSSAliquota() {
		if(grossSalary <= 1518.00) {
			return 0.075;
		} else if(grossSalary >= 1518.01 && grossSalary <= 2793.88) {
			return 0.09;
		} else if(grossSalary >= 2793.89 && grossSalary <= 4190.83) {
			return 0.12;
		} else if(grossSalary >= 4190.84) {
			return 0.14;
		} else {
			return 0.14;
		}
	}
	
	public Double getINSS() {
			if(grossSalary * getINSSAliquota() >= 951.62) {
				return 951.62;
			} else {
				return grossSalary * getINSSAliquota();
			}
	}
	
	public Double getIRRF() {
		if(grossSalary >= 1903.99 && grossSalary <= 2826.65) {
			return ((grossSalary - getINSS()) * 0.075) - 142.80;
		} else if(grossSalary >= 2826.66 && grossSalary <= 3751.05) {
			return ((grossSalary - getINSS()) * 0.15) - 354.80;
		} else if(grossSalary >= 3751.06 && grossSalary <= 4664.68) {
			return ((grossSalary - getINSS()) * 0.225) - 636.13;
		} else if(grossSalary > 4664.68) {
			return ((grossSalary - getINSS()) * 0.275) - 869.36;
		} else {
			return 0.0;
		}
	}
	
	public Double getNetSalary() {
		if(grossSalary <= 1903.08) {
			return grossSalary - getINSS();
		} else {
			return grossSalary - (getINSS()+getIRRF());
		}
	}
	
	public Double getNetSalaryPerDays() {
		return getNetSalary() / days;
	}
	
	public Double getNetSalaryPerHours() {
		return getNetSalaryPerDays() / hours;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
			sb.append("-----------------------------------------------\n");
			sb.append("Nome: ").append(name);
			sb.append("\nSalário em Carteira: ").append(String.format("%.2f", grossSalary));
			sb.append("\nDesconto INSS: ").append(String.format("%.2f", getINSS()));
			sb.append("\nDesconto IRRF: ").append(String.format("%.2f", getIRRF()));
			sb.append("\nFGTS: ").append(String.format("%.2f", getFGTS()));
			sb.append("\nSalário Líquido: ").append(String.format("%.2f", getNetSalary()));
			sb.append("\nSalário por Dias Trabalhados: ").append(String.format("%.2f", getNetSalaryPerDays()));
			sb.append("\nSalario por Horas Trabalhadas: ").append(String.format("%.2f", getNetSalaryPerHours()));
			sb.append("\n-----------------------------------------------");
			return sb.toString();
				
	}
	
	
	
}
