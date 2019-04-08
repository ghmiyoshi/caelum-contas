package br.com.caelum.contas.modelo;

/**
 * Interface com os m�todos que devem existir se uma classe possuir regras de
 * tributa��o.
 * 
 * @author Gabriel Hideki Miyoshi
 * @since 20/09/2018
 *
 */
public interface Tributavel {

	/**
	 * Calcula o valor do imposto que ser� de acordo com a implementa��o.
	 * 
	 * @return O valor do imposto
	 */
	double getValorImposto();

}
