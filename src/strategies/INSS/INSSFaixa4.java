package strategies.INSS;

public class INSSFaixa4 implements INSSStrategy {
	@Override
	public Double calcular(Double salarioBruto) {
		return ((salarioBruto - 4354.27)  * 0.14) + 411.11;
	}
}
