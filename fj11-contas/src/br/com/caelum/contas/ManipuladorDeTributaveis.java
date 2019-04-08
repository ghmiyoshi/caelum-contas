package br.com.caelum.contas;

import br.com.caelum.contas.modelo.Tributavel;
import br.com.caelum.javafx.api.util.Evento;

/**
 * Classe exigida pela biblioteca de interface gr�fica para manipular os
 * tribut�veis.
 * 
 * @author Gabriel Hideki Miyoshi
 * @since 20/09/2018
 *
 */
public class ManipuladorDeTributaveis {

	private double total;

	/**
	 * Calcula os impostos gerados de tudo que for tribut�vel no sistema.
	 * 
	 * @param evento Evento do JavaFX executado na interface e seus par�metros.
	 */
	public void calculaImpostos(Evento evento) {
		int tamanho = evento.getTamanhoDaLista("listaTributaveis");
		for (int i = 0; i < tamanho; i++) {
			Tributavel tributavel = evento.getTributavel("listaTributaveis", i);
			this.total += tributavel.getValorImposto();
		}
	}

	// Getters e Setters
	public double getTotal() {
		return total;
	}

}
