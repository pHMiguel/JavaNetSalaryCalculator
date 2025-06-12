package application;

import java.util.Locale;
import java.util.Scanner;

import entities.User;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Digite seu Nome: ");
		String name = sc.nextLine();
		System.out.printf("Digite a Quantidade de Dias trabalhadas: ");
		Integer days = sc.nextInt();
		System.out.printf("Digite a Quantidade de Horas trabalhadas: ");
		Integer hours = sc.nextInt();
		System.out.printf("Digite o Salário em Carteira: ");
		Double grossSalary = sc.nextDouble();
		
		User user = new User(name, days, hours, grossSalary);
		
		System.out.println(user);
		
		sc.close();
	}
}
