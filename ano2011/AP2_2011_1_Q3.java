package br.cederj.comp.ano2011;

import java.util.ArrayList;
import java.util.List;

class Predio {
	List<Sala> salas; // Em metros
	
	public Predio() {
		salas = new ArrayList();
	}

	public double custoTotal () {
		double retorno = 0;
		for (Sala s: salas) {
			retorno = retorno + s.valor();
		}
		return retorno;
	}
}

class Sala {
	double lado1, lado2;
	boolean frente; // Frente ou fundos
	static double preco;
	
	public double metragem () {
		return lado1 * lado2;
	}
	
	public static void setPreco (double p) {
		preco = p;
	}
	
	public double valor() {
		return this.metragem() * preco * ((frente) ? 1.2 : 1);
	}
}

class Apartamento extends Sala {
	int comodos;
	
	public double valor() {
		return super.valor() * (1 + (0.1 * comodos));
	}
}

public class AP2_2011_1_Q3 {
	public static void main(String[] args) {
	}
	}
