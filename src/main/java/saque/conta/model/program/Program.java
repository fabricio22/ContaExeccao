package saque.conta.model.program;

import java.util.Locale;
import java.util.Scanner;

import saque.conta.model.entities.Conta;
import saque.conta.model.exceptions.SaqueContaExceptions;

public class Program {

	public static void main(String[] args) {
		try {
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);

			System.out.println("Seja Bem-Vindo ao Melhor Banco do Brasil, vamos criar a sua conta!");
			System.out.print("Por favor, digite o seu nome: ");
			String nomeTitular = sc.nextLine();
			System.out.println("Muito bem, " + nomeTitular + "!");
			System.out.print("Digite o numero da sua conta:");
			Integer numeroConta = sc.nextInt();
			System.out.println("Show estamos quase lá!");
			System.out.println("Difina um limite para saque da conta:");
			Double limiteSaque = sc.nextDouble();

			Conta conta = new Conta(numeroConta, nomeTitular, limiteSaque);

			System.out.println("Deseja fazer um depósito em conta? (S/N) ");
			char escolhaDeposito = sc.next().charAt(0);

			while (escolhaDeposito == 'S' || escolhaDeposito == 's') {

				System.out.println("Digite o valor do deposito:");
				conta.deposito(sc.nextDouble());
				System.out.println("Valor depositado com sucesso!");

				System.out.println("Deseja fazer um novo deposito? (S/N)");
				escolhaDeposito = sc.next().charAt(0);
			}

			System.out.println("Saldo da conta: R$ " + conta.getSaldo());
			System.out.println("Limite da conta: R$ " + conta.getLimiteSaque());

			System.out.println("Deseja fazer um Saque? (S/N)");
			escolhaDeposito = sc.next().charAt(0);

			while (escolhaDeposito == 'S' || escolhaDeposito == 's') {

				System.out.println("Digite o valor do saque:");
				conta.saque(sc.nextDouble());

				System.out.println("Valor sacado com sucesso!");

				System.out.println("Deseja fazer um novo saque? (S/N)");
				escolhaDeposito = sc.next().charAt(0);
			}
			
			System.out.println("Saldo da Conta: R$" + conta.getSaldo());
			sc.close();

		} catch (SaqueContaExceptions e) {
			System.out.println("[Alerta!] " + e.getMessage());
		}
	}

}
