package br.cederj.comp.ano2012;

class ArCond {
	int numSerie;
	int capacidade;
	boolean possuiArQuente;
	
	public ArCond(int numSerie, int capacidade, boolean possuiArQuente) {
		this.numSerie = numSerie;
		this.capacidade = capacidade;
		this.possuiArQuente = possuiArQuente;
	}
}

class Residencial extends ArCond {
	String cor;
	int voltagem;
	boolean possuiControleRemoto;
	
	public Residencial(int numSerie, int capacidade, boolean possuiArQuente,
			String cor, int voltagem, boolean possuiControleRemoto) {
		super(numSerie, capacidade, possuiArQuente);
		this.cor = cor;
		this.voltagem = voltagem;
		this.possuiControleRemoto = possuiControleRemoto;
	}
}

// Classe de teste para a classe Telefone acima
public class AP1_2012_1_Q2 {
	public static void main(String[] args) {
		ArCond ar1 = new ArCond(1, 7500, false);
		ArCond ar2 = new ArCond(2, 15000, true);
		Residencial ar3 = new Residencial(3, 5000, false, "branca", 110, false);
		Residencial ar4 = new Residencial(4, 10000, false, "preta", 220, false);
	}
}
