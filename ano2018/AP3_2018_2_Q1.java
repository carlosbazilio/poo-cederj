package br.cederj.comp.ano2018;

import java.util.ArrayList;
import java.util.List;

class Candidato {
	String nome;
	String sigla;
	int numero;
	private int votos_recebidos;
	
	public Candidato(String nome, String sigla, int numero) {
		this.nome = nome;
		this.sigla = sigla;
		this.numero = numero;
		this.votos_recebidos = 0;
	}

	public void creditaVoto() {
		this.votos_recebidos++;
	}
}

class Eleitor {
	String nome;
	int numero;
	private boolean votou;
	
	public Eleitor(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
		this.votou = false;
	}

	public void votou() {
		this.votou = true;
	}
}

class Voto {
	Eleitor votante;
	Candidato votado;
	
	public Voto(Eleitor votante, Candidato votado) {
		this.votante = votante;
		this.votado = votado;
	}
}

class Urna {
	List<Voto> votos;
	Candidato nulo;

	public Urna() {
		this.votos = new ArrayList();
		nulo = new Candidato("Nulo", "Nenhuma", 0);
	}
	
	public void somaVotos () {
		for (Voto v : votos) {
			v.votante.votou();
			if (v.votado != null)
				v.votado.creditaVoto();
			else
				nulo.creditaVoto();
		}
	}
}

public class AP3_2018_2_Q1 {
	public static void main(String[] args) {
		
	}
}



