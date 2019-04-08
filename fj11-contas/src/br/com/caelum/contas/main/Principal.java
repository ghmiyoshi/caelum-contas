package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

/**
 * Teste Principal
 * 
 * @author Gabriel Hideki Miyoshi
 * @since 20/09/2018
 *
 */
public class Principal {

	public static void main(String[] args) {
		Conta conta = new ContaCorrente();
		conta.deposita(100);

		System.out.println(conta.getSaldo());
	}

}