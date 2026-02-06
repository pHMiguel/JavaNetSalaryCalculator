package facades;

public class IRRFCalculadora {
	public Double getIRRF(Double salarioBruto, Double inss) {
		Double baseCalculo;
		Double reducao;
		Double resultado = null;	
		
		if(inss < 607.20) {
			baseCalculo = salarioBruto - 607.20;
		} else {
			baseCalculo = salarioBruto - inss;
		}
		

		if(baseCalculo >= 5000.01 && baseCalculo <= 7350.00){
			reducao = 978.62 - (0.133145 * salarioBruto);
		}else {
			reducao = 0.0;
		}
		
		if(salarioBruto > 5000.00) {
				resultado = (((baseCalculo - 4664.68)* 0.275) + 374.05) - reducao;
		} else {
			resultado = 0.0;
		}
		
		return resultado;
	}
}