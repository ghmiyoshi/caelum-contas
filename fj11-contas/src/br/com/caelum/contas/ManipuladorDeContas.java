package br.com.caelum.contas;

import java.util.Collections;
import java.util.List;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.javafx.api.util.Evento;

/**
 * Classe exigida pela biblioteca de interface gráfica para manipular as contas
 * do sistema.
 * 
 * @author Gabriel Hideki Miyoshi
 * @since 20/09/2018
 *
 */
public class ManipuladorDeContas {

	private Conta conta;

	/**
	 * Cria uma nova conta.
	 * 
	 * @param evento Evento do JavaFX executado na interface e seus parâmetros.
	 */
	public void criaConta(Evento evento) {
		String tipoConta = evento.getSelecionadoNoRadio("tipo");

		if (tipoConta.equals("Conta Corrente")) {
			this.conta = new ContaCorrente();
		} else {
			this.conta = new ContaPoupanca();
		}
		conta.setAgencia(evento.getString("agencia"));
		conta.setNumero(evento.getInt("numero"));
		conta.setTitular(evento.getString("titular"));
	}

	/**
	 * Realiza um depósito na conta
	 * 
	 * @param evento Evento do JavaFX executado na interface e seus parâmetros.
	 */
	public void deposita(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.deposita(valorDigitado);
	}

	/**
	 * Realiza um saque na conta
	 * 
	 * @param evento Evento do JavaFX executado na interface e seus parâmetros.
	 */
	public void saca(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		// Codigo comentado para mostrar que nao colocamos a taxa
		// aqui na manipulador de contas, isso fica na propria conta.

		// if (this.conta.getTipo().equals("Conta Corrente"))
		// this.conta.saca(valorDigitado - 0.10);
		// else
		// this.conta.saca(valorDigitado);
		this.conta.saque(valorDigitado);
	}

	/**
	 * Realiza uma transferência na conta.
	 * 
	 * @param evento Evento do JavaFX executado na interface e seus parâmetros.
	 */
	public void transfere(Evento evento) {
		double valorDigitado = evento.getDouble("valorTransferencia");
		Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");
		this.conta.transferePara(valorDigitado, destino);
	}

	/**
	 * Ordena a lista de contas na combo de destino.
	 * 
	 * @param evento Evento do JavaFX executado na interface e seus parâmetros.
	 */
	public void ordenaLista(Evento evento) {
		List<Conta> contas = evento.getLista("destino");
		Collections.sort(contas);
	}

	/**
	 * Salva a lista de contas em um txt.
	 * 
	 * @param evento Evento do JavaFX executado na interface e seus parâmetros.
	 */
	public void salvaDados(Evento evento) {
		List<Conta> contas = evento.getLista("listaContas");
		RepositorioDeContas repositorio = new RepositorioDeContas();
		repositorio.salva(contas);
	}

	/**
	 * Carrega as contas a partir de um arquivo.
	 * 
	 * @return A lista de contas carregada.
	 */
	public List<Conta> carregaDados() {
		RepositorioDeContas repositorio = new RepositorioDeContas();
		List<Conta> contas = repositorio.carrega();
		Collections.sort(contas);
		return contas;
	}
}
