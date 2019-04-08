package br.com.caelum.contas.modelo;

import br.com.caelum.contas.exception.SaldoInsuficienteException;

/**
 * Especificação de uma conta corrente do banco.
 * 
 * @author Gabriel Hideki Miyoshi
 * @since 20/09/2018
 *
 */
public class ContaCorrente extends Conta implements Tributavel {

	// Construtor com parâmetros
	public ContaCorrente(int numero, String agencia, String titular, double saldo) {
		super(numero, agencia, titular, saldo);
	}

	// Construtor vazio
	public ContaCorrente() {

	}

	// Métodos

	@Override
	public void saque(double valor) {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException(valor);
		} else {
			super.saque(valor + 0.10);
		}
	}

	/**
	 * Define o tipo da conta.
	 * 
	 * @return O texto informativo do método getTipo() da superclasse e corrente.
	 */
	@Override
	public String getTipo() {
		return super.getTipo() + " Corrente";
	}

	/**
	 * Calcula o valor de imposto de uma conta corrente.
	 * 
	 * @return o valor do imposto 1% do saldo da conta.
	 */
	@Override
	public double getValorImposto() {
		return this.getSaldo() * 0.01;
	}

}
