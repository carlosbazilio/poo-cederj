package br.cederj.comp.ano2014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Caminhao extends Transporte {
	boolean bau;
	boolean cama;
	int numEixos;
	
	public Caminhao(int capacidade, double peso, int numEixos, List<Carga> carregamento, boolean bau, boolean cama) {
		super(capacidade, peso, carregamento);
		this.numEixos = numEixos;
		this.bau = bau;
		this.cama = cama;
	}
	
	public double razao() {
		return (this.cargaTotal() + peso) / this.numEixos;
	}
}

class Picape extends Transporte {
	boolean cabineDupla;
	
	public Picape(int capacidade, double peso, List<Carga> carregamento, boolean cabineDupla) {
		super(capacidade, peso, carregamento);
		this.cabineDupla = cabineDupla;
	}

	public double razao() {
		return (this.cargaTotal() + peso) / 2;
	}
}

class Carga {
	double altura, largura, profundidade;

	public Carga(double altura, double largura, double profundidade) {
		this.altura = altura;
		this.largura = largura;
		this.profundidade = profundidade;
	}
	
	public double volume () {
		return altura * largura * profundidade;
	}
}

abstract class Transporte {
	int capacidade;
	double peso;
	List <Carga> carregamento;
	
	public Transporte(int capacidade, double peso, List<Carga> carregamento) {
		this.capacidade = capacidade;
		this.peso = peso;
		this.carregamento = carregamento;
	}
	
	public double cargaTotal() {
		int carga = 0;
		for (Carga c : this.carregamento)
			carga += c.volume();
		return carga;
	}
	
	public abstract double razao();
}

// Apenas a título de ilustração (NÃO ERA REQUERIDO NA QUESTÃO)

public class AP3_2014_2_Q1 {
	public static void main(String[] args) {
		List <Transporte> frota = new ArrayList<Transporte>();
		List <Carga> cargasCaminhao = Arrays.asList(new Carga(10, 10, 10), new Carga(15, 15, 15));
		frota.add(new Caminhao (100, 300, 3, cargasCaminhao, true, false));
		List <Carga> cargasPicape = Arrays.asList(new Carga(5, 5, 5));
		frota.add(new Picape (100, 100, cargasPicape, true));
		double somaCargas = 0;
		for (Transporte t : frota)
			if (t.razao() > 500)
				somaCargas += t.cargaTotal();
		System.out.println("Volume total: " + somaCargas);
	}
}

