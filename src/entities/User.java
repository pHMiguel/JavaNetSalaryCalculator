package entities;

public class User {
	private String nome;
	private Integer dias;
	private Integer horas;
	private Double salarioBruto;
	
	public User(String nome, Integer dias, Integer horas, Double salarioBruto) {
		this.nome = nome;
		this.dias = dias;
		this.horas = horas;
		this.salarioBruto = salarioBruto;
	}

	public String getNome() {
		return nome;
	}
	
	public Integer getDias() {
		return dias;
	}

	public Integer getHoras() {
		return horas;
	}
	
<<<<<<< HEAD
	public Double getSalarioBruto() {
		return salarioBruto;
	}
=======
	public Double getINSS() {
		Double netSalary;
		netSalary = grossSalary - calculateINSS();
		return netSalary;
	}
	
	// Método de Cálculo de INSS
	public Double calculateINSS() {
		double[][] faixas = {
	            {1412.00, 0.075},
	            {2666.68, 0.09},
	            {4000.03, 0.12},
	            {7786.02, 0.14}
	        };

	        double inss = 0.0;
	        double salarioRestante = grossSalary;
	        double limiteAnterior = 0.0;

	        for (int i = 0; i < faixas.length; i++) {
	            double limite = faixas[i][0];
	            double aliquota = faixas[i][1];

	            if (grossSalary > limite) {
	                double base = limite - limiteAnterior;
	                inss += base * aliquota;
	                salarioRestante -= base;
	                limiteAnterior = limite;
	            } else {
	                double base = salarioRestante;
	                inss += base * aliquota;
	                break;
	            }
	        }

	        double tetoMaximo = 908.86;
	        if (inss > tetoMaximo) {
	            inss = tetoMaximo;
	        }

	        return Math.round(inss * 100.0) / 100.0;
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
	
	
	
>>>>>>> 7969e08082b251e277e648889337b9d4e974f830
}
