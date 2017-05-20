package br.cederj.comp.ano2016;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

class ContaCorrente {
	int numConta;
	String nome;
	private float saldo;
	List<Transacao> transacoes;
	
	public ContaCorrente(int i, String n, float s) {
		this.numConta = numConta;
		this.nome = n;
		this.saldo = s;
		transacoes = new ArrayList<Transacao>();
	}
}

class Transacao {
	ContaCorrente conta;
	float valor;
	GregorianCalendar hora;
}

public class LP_2016_2_P2 {
	public static void main(String[] args) {
		ContaCorrente c1 = new ContaCorrente(1, "Fulano", 1000);
		ContaCorrente c2 = new ContaCorrente(1, "Ciclano", 100);
		c1.saque(100);
		c1.deposito(50);
		c1.transfere(200, c2);
		c1.exibeExtrato();
	}
}
