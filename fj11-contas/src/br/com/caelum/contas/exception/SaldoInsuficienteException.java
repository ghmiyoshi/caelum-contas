package br.com.caelum.contas.exception;

/**
 * Exception para causar um erro caso o usuário tente realizar uma operação de valor
 * maior do que o saldo atual na conta.
 * 
 * @author Gabriel Hideki Miyoshi
 * @since 20/09/2018
 *
 */
public class SaldoInsuficienteException extends RuntimeException {

	public SaldoInsuficienteException(double valor) {
		super("Saldo insuficiente para realizar a operação no valor de : R$ " + valor);
	}

}
