package br.com.caelum.contas.modelo;

/**
 * Interface com os métodos que devem existir se uma classe possuir regras de
 * tributação.
 * 
 * @author Gabriel Hideki Miyoshi
 * @since 20/09/2018
 *
 */
public interface Tributavel {

	/**
	 * Calcula o valor do imposto que será de acordo com a implementação.
	 * 
	 * @return O valor do imposto
	 */
	double getValorImposto();

}
