package strategies.INSS;

public class INSSFaixa1 implements INSSStrategy {
	@Override
	public Double calcular(Double salarioBruto) {
		return salarioBruto * 0.075;
	}

}
