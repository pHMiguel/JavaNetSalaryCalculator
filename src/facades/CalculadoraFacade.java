package facades;

import entities.User;

public class CalculadoraFacade {
	public String calcular(User user) {
		StringBuilder sb = new StringBuilder();
		INSSCalculadora inssCalculadora = new INSSCalculadora();
		FGTSCalculadora fgtsCalculadora = new FGTSCalculadora();
		IRRFCalculadora irrfCalculadora = new IRRFCalculadora();
		SalarioLiquidoCalculadora salarioLiquidoCalculadora = new SalarioLiquidoCalculadora();
		
		Double salarioBruto = user.getSalarioBruto();
		Double inss = inssCalculadora.getINSS(salarioBruto);
		Double fgts = fgtsCalculadora.getFGTS(salarioBruto);
		Double irrf = irrfCalculadora.getIRRF(salarioBruto, inss);
		Double salarioLiquido = salarioLiquidoCalculadora.getNetSalary(salarioBruto, inss, irrf);
		Double salarioLiquidoPorDias = salarioLiquido / user.getDias();
		Double salarioLiquidoPorHoras = salarioLiquidoPorDias / user.getHoras();
		
		sb.append("-----------------------------------------------");
		sb.append("\nNome: ").append(user.getNome());
		sb.append("\nSalário em Carteira: ").append(String.format("%.2f", salarioBruto));
		sb.append("\nDesconto INSS: ").append(String.format("%.2f", inss));
		sb.append("\nDesconto IRRF: ").append(String.format("%.2f", irrf));
		sb.append("\nFGTS: ").append(String.format("%.2f", fgts));
		sb.append("\nSalário Líquido: ").append(String.format("%.2f", salarioLiquido));
		sb.append("\nSalário por Dias Trabalhados: ").append(String.format("%.2f", salarioLiquidoPorDias));
		sb.append("\nSalario por Horas Trabalhadas: ").append(String.format("%.2f", salarioLiquidoPorHoras));
		sb.append("\n-----------------------------------------------");
		return sb.toString();
	}
	
	
	
}
