package br.com.caelum.contas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;

/**
 * Classe que escreve as contas de um arquivo.
 * 
 * @author Gabriel Hideki Miyoshi
 * @since 20/09/2018
 *
 */
public class RepositorioDeContas {

	/**
	 * Salva as contas no arquivo.
	 * 
	 * @param contas A lista de contas a ser escrita no arquivo.
	 */
	public void salva(List<Conta> contas) {
		try {
			PrintStream stream = new PrintStream("contas.txt");
			for (Conta conta : contas) {
				stream.println(conta.getTipo() + "," + conta.getNumero() + "," + conta.getAgencia() + ","
						+ conta.getTitular() + "," + conta.getSaldo());
			}
			stream.close();
		} catch (FileNotFoundException erro) {
			throw new RuntimeException("Não foi encontrado o arquivo no diretório");
		}
	}

	/**
	 * Carrega a lista de contas salvas no arquivo.
	 * 
	 * @return A lista recuperada do arquivo.
	 */
	public List<Conta> carrega() {
		List<Conta> contas = new ArrayList<>();

		try (Scanner scanner = new Scanner(new File("contas.txt"))) {
			scanner.useDelimiter(",");

			while (scanner.hasNextLine()) {
				Conta conta;
				String linha = scanner.nextLine();
				String[] valores = linha.split(",");
				String tipo = valores[0];
				int numero = Integer.parseInt(valores[1]);
				String agencia = valores[2];
				String titular = valores[3];
				double saldo = Double.parseDouble(valores[4]);

				if (tipo.equals("Conta Corrente")) {
					conta = new ContaCorrente(numero, agencia, titular, saldo);
				} else {
					conta = new ContaPoupanca(numero, agencia, titular, saldo);
				}
				contas.add(conta);
			}
		} catch (FileNotFoundException erro) {
			System.out.println("Não tem arquivo ainda");
		}
		return contas;
	}

}
