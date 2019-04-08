package br.com.caelum.contas.modelo;

import br.com.caelum.contas.exception.SaldoInsuficienteException;

/**
 * Especificação de uma conta de banco.
 * 
 * @author Gabriel Hideki Miyoshi
 * @since 20/09/2018
 *
 */
public class ContaPoupanca extends Conta {

	// Construtor com parâmtros
	public ContaPoupanca(int numero, String agencia, String titular, double saldo) {
		super(numero, agencia, titular, saldo);
	}

	// Construtor vazio
	public ContaPoupanca() {

	}

	// Métodos

	/**
	 * Realiza uma retirada da conta.
	 * 
	 * @param valor O valor a ser retirado.
	 */
	@Override
	public void saque(double valor) {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException(valor);
		} else {
			super.saque(valor);
		}

	}

	/**
	 * Define o tipo da conta.
	 * 
	 * @return O texto informativo do método getTipo() da superclasse e poupança.
	 */
	@Override
	public String getTipo() {
		return super.getTipo() + " Poupança";
	}

}
