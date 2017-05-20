package br.cederj.comp.ano2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Enunciado !!! 
class Manutencao {
	String peca;
	double custo;
	public Manutencao(String peca, double custo) {
		this.peca = peca;
		this.custo = custo;
	}
	public double getCusto() {
		return custo;
	}
}

class Abastecimento {
	float valor;
	String posto;
	public Abastecimento(float valor, String posto) {
		this.valor = valor;
		this.posto = posto;
	}
	public float getValor() {
		return valor;
	}
}
*/

// Gabarito !!!!

//interface Gasto {
//	double getCusto();
//}

abstract class Gasto {
	double custo;

	public Gasto(double custo) {
		this.custo = custo;
	}
	
	public double getCusto() {
		return custo;
	}
}

class Manutencao extends Gasto {
	String peca;
	public Manutencao(String peca, double custo) {
		super(custo);
		this.peca = peca;
	}
}

class Abastecimento extends Gasto {
	String posto;
	public Abastecimento(float valor, String posto) {
		super(valor);
		this.posto = posto;
	}
}

public class AP3_2016_2_Q1 {
	public static void main(String[] args) {
		/* Enunciado !!!
		double somaReparos = 0, somaManutencao = 0;

		List <Manutencao> reparos = Arrays.asList(new Manutencao("Freio", 150), new Manutencao("Oleo", 200));
		for (Manutencao m : reparos) {
			somaReparos = somaReparos + m.getCusto();
		}
		List <Abastecimento> abastecimentos = Arrays.asList(new Abastecimento(80, "BR"), new Abastecimento(50, "Shell"));
		for (Abastecimento a : abastecimentos) {
			somaManutencao = somaManutencao + a.getValor();
		}
		System.out.println("A soma dos valores gastos e': " + (somaManutencao + somaReparos));
		*/
		
		// Gabarito !!!
		double soma = 0;
		List <Manutencao> reparos = Arrays.asList(new Manutencao("Freio", 150), new Manutencao("Oleo", 200));
		List <Abastecimento> abastecimentos = Arrays.asList(new Abastecimento(80, "BR"), new Abastecimento(50, "Shell"));
		List <Gasto> gastos = new ArrayList<Gasto>();
		gastos.addAll(reparos);
		gastos.addAll(abastecimentos);
		for (Gasto g : gastos) {
			soma = soma + g.getCusto();
		}
		System.out.println("A soma dos valores gastos e': " + soma + " " + gastos.size());
	}
}

