package strategies.INSS;

public class INSSFaixa2 implements INSSStrategy {
	@Override
	public Double calcular(Double salarioBruto) {
		return ((salarioBruto - 1621.00) * 0.09) + 121.58;
	}
}
