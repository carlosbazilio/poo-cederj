package br.cederj.comp.ano2014;

import java.util.ArrayList;
import java.util.List;

abstract class Reprodutivel {
	private int reproducoes;

	public Reprodutivel() {
		this.reproducoes = 0;
	}

	public void play() {
		this.reproducoes++;
	}
	
	public float direitos () { return ((float)(this.reproducoes)) * this.ecad(); }
	
	public abstract float ecad();
}

abstract class Media extends Reprodutivel {
	String nome;
	int ano;
	
	public Media(String nome, int ano) {
		super();
		this.nome = nome;
		this.ano = ano;
	}
}

class Musica extends Media {
	List<String> compositores;
	static float vecad = 0.01f;
	
	public Musica(String nome, List<String> compositores, int ano) {
		super(nome, ano);
		this.nome = nome;
		this.compositores = compositores;
		this.ano = ano;
	}

	public float ecad() {
		return Musica.vecad;
	}
}

class Filme extends Media {
	String diretor;
	List<Musica> trilha;
	
	public Filme(String nome, int ano, String d, List<Musica> musicas) {
		super(nome, ano);
		diretor = d;
		trilha = musicas;
	}

	public float ecad() {
		return trilha.size() * Musica.vecad;
	}
}

public class AP3_2014_1_Q2 {
	public static void main(String[] args) {
		List<String> comp1 = new ArrayList<String>();
		comp1.add("Pharrel Williams");
		Musica m = new Musica ("Happy", comp1, 2014);
		
		List<String> comp2 = new ArrayList<String>();
		comp2.add("Carlinhos Brown");
		Musica m2 = new Musica ("Dia de Festa, Salve a Floresta", comp2, 2011);
		List<Musica> trilha = new ArrayList<Musica>();
		trilha.add(m2);
		Filme f = new Filme ("Rio", 2011, "Carlos Saldanha", trilha);
	}
}

