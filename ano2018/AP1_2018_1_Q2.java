package br.cederj.comp.ano2018;

class Corrida {
	int distancia;

	public Corrida (int distancia) {
		this.distancia = distancia;
	}

	public double calculaValor() {
		return this.distancia * 2.5;
	}
}

class TaxiComum extends Corrida {
	int bandeira; // 1 ou 2
	static double bandeirada = 5.5;

	public TaxiComum (int distancia, int bandeira) {
		super(distancia);
		this.bandeira = bandeira;
	}

	public double calculaValor() {
		if (this.bandeira == 1)
			return TaxiComum.bandeirada + super.calculaValor();
		return TaxiComum.bandeirada + (this.distancia * 3);
	}
}

class AplicativoTransporte extends Corrida {
	int motoristasDisponiveis;
	boolean compartilhado;
	boolean especial;
	String transito; // Bom, Razoável ou Ruim

	public AplicativoTransporte (int distancia, int motoristasDisponiveis, boolean compartilhado, boolean especial, String transito) {
		super(distancia);
		this.motoristasDisponiveis = motoristasDisponiveis;
		this.compartilhado = compartilhado;
		this.especial = especial;
		this.transito = transito;
	}

	public double calculaValor() {
		double percentual = 1;
		if (this.motoristasDisponiveis > 5)
			percentual-=0.2;
		if (this.compartilhado)
			percentual-=0.1;
		if (this.especial)
			percentual+=0.1;
		if (this.transito == "Bom")
			percentual-=0.1;
		else
			if (this.transito == "Ruim")
				percentual+=0.1;
		return super.calculaValor() * percentual;
	}
}


public class AP1_2018_1_Q2 {
	public static void main(String[] args) {
	    AplicativoTransporte c1 = new AplicativoTransporte(30, 40, false, false, "Bom");
	    System.out.println(c1.calculaValor());
	    Corrida c2 = new Corrida(30);
	    System.out.println(c2.calculaValor());
	    TaxiComum c3 = new TaxiComum(30, 1);
	    System.out.println(c3.calculaValor());
	}
}



