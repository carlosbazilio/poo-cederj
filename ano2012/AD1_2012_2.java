package br.cederj.comp.ano2012;

import java.util.Calendar;
import java.util.GregorianCalendar;

abstract class MeioTransporte {
	int capacidadePassageiros;
	int capacidadeCarga;
	double consumo;
	double custoManutencao;
	int anoFabricacao;
	static enum tipoCombustivel {alcool, gasolina, diesel, gnv};
	tipoCombustivel combustivel;
	
	public MeioTransporte(int capacidadePassageiros, int capacidadeCarga,
			double consumo, double custoManutencao, int anoFabricacao,
			tipoCombustivel combustivel) {
		this.capacidadePassageiros = capacidadePassageiros;
		this.capacidadeCarga = capacidadeCarga;
		this.consumo = consumo;
		this.custoManutencao = custoManutencao;
		this.anoFabricacao = anoFabricacao;
		this.combustivel = combustivel;
	}

	abstract double eficiencia();
	
	int anosExistencia () {
		GregorianCalendar data = new GregorianCalendar();
		return data.get(Calendar.YEAR) - this.anoFabricacao;
	}
	
	boolean maisEficiente (MeioTransporte m) {
		return this.eficiencia() > m.eficiencia();
	}
}

class Carro extends MeioTransporte {
	public Carro(int capacidadePassageiros, int capacidadeCarga,
			double consumo, double custoManutencao, int anoFabricacao,
			tipoCombustivel combustivel) {
		super(capacidadePassageiros, capacidadeCarga, consumo, custoManutencao,
				anoFabricacao, combustivel);
	}

	double eficiencia() {
		return (capacidadePassageiros * (capacidadeCarga * 0.1) * (((combustivel == tipoCombustivel.gnv) ? 1.5 : 1) * consumo)) / (custoManutencao * this.anosExistencia());
	}
}

class Moto extends MeioTransporte {
	public Moto(int capacidadePassageiros, int capacidadeCarga, double consumo,
			double custoManutencao, int anoFabricacao,
			tipoCombustivel combustivel) {
		super(capacidadePassageiros, capacidadeCarga, consumo, custoManutencao,
				anoFabricacao, combustivel);
	}

	double eficiencia() {
		return (capacidadePassageiros * (capacidadeCarga * 0.1) * consumo) / (custoManutencao * this.anosExistencia());
	}
}

public class AD1_2012_2 {
	public static void main(String[] args) {
		MeioTransporte escort = new Carro(5, 300, 10, 1000, 2001, MeioTransporte.tipoCombustivel.gnv);
		MeioTransporte kawasaki = new Moto(2, 30, 20, 500, 2009, MeioTransporte.tipoCombustivel.gasolina);
		System.out.println("Eficiencia do Carro: " + escort.eficiencia());
		System.out.println("Eficiencia da Moto: " + kawasaki.eficiencia());
		System.out.println(escort.maisEficiente(kawasaki));
	}
}
