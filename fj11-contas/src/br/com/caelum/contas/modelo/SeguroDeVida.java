package br.com.caelum.contas.modelo;

public class SeguroDeVida implements Tributavel {
	private double valor;
	private String titular;
	private int numeroApolice;

	/**
	 * Calcula o valor de imposto de um seguro de vida.
	 * 
	 * @return o valor do imposto 42 reais mais 2% do valor do seguro.
	 */
	@Override
	public double getValorImposto() {
		return 42 + (this.valor * 0.02);
	}

	/**
	 * Define o tipo do seguro.
	 * 
	 * @return O texto informativo Seguro de Vida.
	 */
	public String getTipo() {
		return "Seguro de Vida";
	}

	// Getters e Setters
	public void setNumeroApolice(int numeroApolice) {
		this.numeroApolice = numeroApolice;
	}

	public int getNumeroApolice() {
		return numeroApolice;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getTitular() {
		return titular;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

}
