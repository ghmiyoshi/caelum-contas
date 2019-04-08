package br.com.caelum.contas.modelo;

/**
 * Especificação de uma conta de banco.
 * 
 * @author Gabriel Hideki Miyoshi
 * @since 20/09/2018
 *
 */
public abstract class Conta implements Comparable<Conta> {

	// Atributos
	private int numero;
	private String agencia;
	private String titular;
	protected double saldo;

	// Construtor com parâmetros
	public Conta(int numero, String agencia, String titular, double saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.titular = titular;
		this.saldo = saldo;
	}

	// Construtor vazio
	public Conta() {

	}

	// Getters e Setters
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	// Métodos

	/**
	 * Adiciona um valor ao saldo da conta.
	 * 
	 * @param valor O valor a ser adicionado.
	 */
	public void deposita(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Valor menor do que 0");
		} else {
			this.saldo += valor;
		}
	}

	/**
	 * Realiza uma retirada da conta.
	 * 
	 * @param valor O valor a ser retirado.
	 */
	public void saque(double valor) {
		// Valida se o valor passado eh negativo
		// Caso seja, lança um erro. Nada abaixo da exception é executado por conta do
		// erro
		if (valor < 0) {
			throw new IllegalArgumentException("Valor menor do que 0");
		} else {
			// Essa linha só será executada se o valor for positivo
			this.saldo -= valor;
		}

	}

	/**
	 * Define o tipo da conta.
	 * 
	 * @return O texto informativo conta.
	 */
	public String getTipo() {
		return "Conta";
	}

	/**
	 * Realiza uma transferência de valor entre contas.
	 * 
	 * @param valor   O valor a ser transferido.
	 * @param destino A conta de destino a ser creditada.
	 */
	public void transferePara(double valor, Conta destino) {
		this.saque(valor);
		destino.deposita(valor);
	}

	/**
	 * Reescrita do método toString().
	 * 
	 * @return O titular da conta em maiúsculo.
	 */
	@Override
	public String toString() {
		return this.titular.toUpperCase();
	}

	/**
	 * Encontra objetos dentro da coleção pela agência e número da conta.
	 * 
	 * @return O grupo ao qual o objeto pertence.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + numero;
		return result;
	}

	/**
	 * Compara dois objetos pela referência, agência e número.
	 * 
	 * @return true ou false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	/**
	 * Compara dois objetos a partir do nome do titular da conta.
	 * 
	 * @param outraConta Outra conta a ser comparada
	 * @return -1 se essa conta deve vir anterior a outra conta; 0 se forem iguais;
	 *         1 se ela deve vir depois da outra conta.
	 */
	@Override
	public int compareTo(Conta outraConta) {
		return this.titular.compareTo(outraConta.titular);
	}

}
