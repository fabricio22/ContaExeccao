package saque.conta.model.entities;

import saque.conta.model.exceptions.SaqueContaExceptions;

public class Conta {

	private Integer numero;
	private String titular;
	private Double saldo = 0.0;
	private double limiteSaque;

	public Conta(Integer numero, String titular, double limiteSaque) {

		this.numero = numero;
		this.titular = titular;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public void deposito(Double valorDeposito) {
		
		this.saldo += valorDeposito;
	}

	public void saque(Double valorSaque) throws SaqueContaExceptions {

		if (valorSaque > this.limiteSaque) {
			throw new SaqueContaExceptions("Valor de Saque Acima do permitido!");
		}

		if (valorSaque > this.saldo) {
			throw new SaqueContaExceptions("Valor de Saque execede o valor que esta em conta!");
		}

		this.saldo -= valorSaque;
	}
}
