package strategies.INSS;

public class INSSFaixa3 implements INSSStrategy {
	@Override
	public Double calcular(Double salarioBruto) {
		return ((salarioBruto - 2902.84) * 0.12) + 236.94;
	}
}
