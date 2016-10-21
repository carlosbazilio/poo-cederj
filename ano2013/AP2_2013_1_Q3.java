package br.cederj.comp.ano2013;

import java.util.ArrayList;
import java.util.List;

interface Gasto {
	double valor();
}

class Produto {
	String nome;
	String tipo;
	double valor;
	
	public Produto(String nome, String tipo, double valor) {
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
	}	
}

class Pessoa {
	String funcao;
	double valorHora;
	
	public Pessoa(String funcao, double valorHora) {
		this.funcao = funcao;
		this.valorHora = valorHora;
	}
}

class Item implements Gasto { 
	Produto p;
	int qtd;
	
	public Item(Produto p, int qtd) {
		this.p = p;
		this.qtd = qtd;
	}

	public double valor() {
		return p.valor * qtd * 1.05;
	}
}

class Colaborador implements Gasto { 
	Pessoa p;
	int qtd;
	
	public Colaborador(Pessoa p, int qtd) {
		this.p = p;
		this.qtd = qtd;
	}

	public double valor() {
		return p.valorHora * qtd;
	}
}

// Classe de teste para a classe Telefone acima
public class AP2_2013_1_Q3 {
	public static void main(String[] args) {
		Produto prod1 = new Produto("Cimento", "CPIII", 51.25); // Cimento do tipo CPIII com valor R$51,25
		Produto prod2 = new Produto("Tijolo", "Comum", 2.50);
		Pessoa p1 = new Pessoa("Pedreiro", 10.00); // Pedreiro que recebe R$10,00 / hora
		Pessoa p2 = new Pessoa("Arquiteto", 50.00);
		List<Gasto> obra = new ArrayList<Gasto>();
		obra.add(new Item(prod1, 50));
		obra.add(new Item(prod2, 1000));
		obra.add(new Colaborador(p1, 9));
		obra.add(new Colaborador(p2, 2));
		System.out.println("O total da obra é: ");
		double soma = 0;
		for (Gasto g : obra) {
			soma += g.valor();
		}
		System.out.println(soma);
	}
}
