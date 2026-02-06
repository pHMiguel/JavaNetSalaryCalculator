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
	
	public Double getSalarioBruto() {
		return salarioBruto;
	}
}
