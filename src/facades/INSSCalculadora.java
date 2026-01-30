package facades;

import strategies.INSS.INSSFaixa1;
import strategies.INSS.INSSFaixa2;
import strategies.INSS.INSSFaixa3;
import strategies.INSS.INSSFaixa4;
import strategies.INSS.INSSStrategy;

public class INSSCalculadora {
	private static INSSStrategy strategy;
	
	public Double getINSS(Double salarioBruto) {
		Double resultado;
	
		if(salarioBruto <= 1621.00) {
			strategy = new INSSFaixa1();
		}else if(salarioBruto >= 1621.01 && salarioBruto <= 2902.84){
			strategy = new INSSFaixa2();
		}else if(salarioBruto >= 2902.85 && salarioBruto <= 4354.27){
			strategy = new INSSFaixa3();
		}else if(salarioBruto >= 4354.28 && salarioBruto <= 8475.55){
			strategy = new INSSFaixa4();
		}
		return strategy.calcular(salarioBruto);
	}	
}
