package br.cederj.comp.ano2008;

import java.util.Collection;

/**
 * Classe principal que inicia o programa
 * @author bazilio
 */
public class AP2_2008_2_Q1 {
	public static void main(String[] args) {
	}
}

abstract class Regiao {
	Collection<Regiao> vizinhos;
	double tamanho;
	public abstract double area();
	public Collection<Regiao> vizinhos() {
		return vizinhos;
	}
	public double tamanhoDaFronteira () {
		return tamanho;
	}
}

abstract class RegiaoPolitica extends Regiao {
	Cidade capital;
	public abstract double area();
	public Cidade capital() {
		return capital;
	}
	public double distancia (RegiaoPolitica e) {
		return this.capital().distancia(e.capital());
	}
}

class Pais extends RegiaoPolitica {
	Collection<Cidade> cidades;
	public Collection<Cidade> obtemCidades() {
		return cidades;
	}
	public double area() {
		return 0;
	}
}

class Estado extends RegiaoPolitica {
	Pais pais;
	public Pais obtemPais() {
		return pais;
	}
	public double area() {
		return 0;
	} 
}

class Cidade extends Regiao {
	Estado estado;
	public Pais obtemPais() {
		return estado.obtemPais();
	}
	public double distancia (Cidade destino) {
		return 0;
	}
	public double area() {
		return 0;
	}
}

class Rio {
	
}


