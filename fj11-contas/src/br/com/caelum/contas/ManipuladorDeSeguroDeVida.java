package br.com.caelum.contas;

import br.com.caelum.contas.modelo.SeguroDeVida;
import br.com.caelum.javafx.api.util.Evento;

/**
 * Classe exigida pela biblioteca de interface gráfica para manipular os seguros
 * de vida.
 * 
 * @author Gabriel Hideki Miyoshi
 * @since 20/09/2018
 *
 */
public class ManipuladorDeSeguroDeVida {

	private SeguroDeVida seguroDeVida;

	/**
	 * Cria um novo seguro de vida.
	 * 
	 * @param evento Evento do JavaFX executado na interface e seus parâmetros.
	 */
	public void criaSeguro(Evento evento) {
		this.seguroDeVida = new SeguroDeVida();
		this.seguroDeVida.setNumeroApolice(evento.getInt("numeroApolice"));
		this.seguroDeVida.setTitular(evento.getString("titular"));
		this.seguroDeVida.setValor(evento.getDouble("valor"));

	}

}
