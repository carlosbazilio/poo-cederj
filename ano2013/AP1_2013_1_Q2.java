package br.cederj.comp.ano2013;

class Embarcacao {
	int capacidade;
	double velocMax;
	double comprimento;
	double largura;
	
	public Embarcacao(int capacidade, double velocMax, double comprimento,
			double largura) {
		this.capacidade = capacidade;
		this.velocMax = velocMax;
		this.comprimento = comprimento;
		this.largura = largura;
	}
}

class Esporte extends Embarcacao {
	boolean vela;
	public Esporte(int capacidade, double velocMax, double comprimento,
			double largura, boolean vela) {
		super(capacidade, velocMax, comprimento, largura);
		this.vela = vela;
	}
}

class Transporte extends Embarcacao {
	double potencia;
	double carga;
	public Transporte(int capacidade, double velocMax, double comprimento,
			double largura, double potencia, double carga) {
		super(capacidade, velocMax, comprimento, largura);
		if (potencia < carga)
			potencia = carga;
		this.potencia = potencia;
		this.carga = carga;
	}
}

// Classe de teste para as classes de Embarcacao acima
public class AP1_2013_1_Q2 {
	public static void main(String[] args) {
		Embarcacao caiaque = new Esporte(1, 10, 2, 0.3, false);
		Embarcacao barca = new Transporte(2000, 100, 40, 20, 500, 1000);
	}
}