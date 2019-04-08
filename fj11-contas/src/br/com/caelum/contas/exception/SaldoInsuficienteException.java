package br.com.caelum.contas.exception;

/**
 * Exception para causar um erro caso o usu�rio tente realizar uma opera��o de valor
 * maior do que o saldo atual na conta.
 * 
 * @author Gabriel Hideki Miyoshi
 * @since 20/09/2018
 *
 */
public class SaldoInsuficienteException extends RuntimeException {

	public SaldoInsuficienteException(double valor) {
		super("Saldo insuficiente para realizar a opera��o no valor de : R$ " + valor);
	}

}
