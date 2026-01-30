package facades;

public class SalarioLiquidoCalculadora {
	public Double getNetSalary(Double salarioBruto, Double inss, Double irrf) {
		if(salarioBruto <= 5000.00) {
			return salarioBruto - inss;
		}
		return salarioBruto - (inss + irrf);
	}
}