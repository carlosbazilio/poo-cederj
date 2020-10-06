package br.cederj.comp.ano2020;

import java.time.LocalDate;

interface INota {
	String obtemMensagem();
}

class Nota implements INota {
	String mensagem;
	String labels[];
	LocalDate horaCriacao;
	
	public Nota(String mensagem, String[] labels) {
		this.mensagem = mensagem;
		this.labels = labels;
		this.horaCriacao = LocalDate.now();
	}
	
	public String obtemMensagem() {
		return this.mensagem;
	}
	
	public String toStringLabels() {
		String resultado = "";
		for (int i=0; i<this.labels.length; i++)
			resultado = resultado + labels[i] + " ";
		return resultado;
	}
	
	public String toString() {
		return this.mensagem + "\n" + this.toStringLabels() + "\n" + horaCriacao + "\n";
	}
}

class Tarefa extends Nota {
	LocalDate dataLimite;
	public Tarefa(String mensagem, String[] labels) {
		super(mensagem, labels);
		this.dataLimite = LocalDate.now().plusDays(2);
	}
	public Tarefa(String mensagem, String[] labels, LocalDate limite) {
		super(mensagem, labels);
		this.dataLimite = limite;
	}
	public String obtemMensagem() {
		return super.obtemMensagem() + dataLimite;
	}
}

class Bloco {
	INota notas[];
	private int qtdNotas;
	
	public Bloco() {
		notas = new INota[1000];
		this.qtdNotas = 0;
	}
	
	public void adicionarNota (INota n) {
		notas[qtdNotas] = n;
		qtdNotas++;
	}
	
	public Bloco buscaNotas (String palavra) {
		Bloco resultado = new Bloco();
		for (int i=0; i<qtdNotas; i++)
			if (notas[i].obtemMensagem().contains(palavra))
				resultado.adicionarNota(notas[i]);
		return resultado;
	}
	
	public String toString() {
		String resultado = "";
		for (int i=0; i<qtdNotas; i++)
			resultado = resultado + notas[i];
		return resultado;
	}
}

public class AP1_2020_1_Q1 {
	public static void main(String[] args) {
		Nota n1 = new Nota("CPF: 999999999-99", new String[] {"documento", "identifica��o"});
		Nota n2 = new Nota("Matricula UFF: 99999999-9", new String[] {"documento", "universidade"});
		Tarefa t1 = new Tarefa("Estudar para a AP2 - POO/UFF/Cederj", new String[] {"cederj", "poo"});
		Bloco anotacoes = new Bloco();
		anotacoes.adicionarNota(n1);
		anotacoes.adicionarNota(n2);
		anotacoes.adicionarNota(t1);
		System.out.println(anotacoes); // Imprime todas as notas
		Bloco faculdade = anotacoes.buscaNotas("UFF");
		System.out.println(faculdade); // Imprime apenas notas com a palavra UFF inclu�da
	}
}
