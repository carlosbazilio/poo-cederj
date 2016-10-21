package br.cederj.comp.ano2013;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

abstract class VeiculoAutomotivo {
	GregorianCalendar dataFabricacao;
	String cor;
	String numeroChassi;
	String combustivel;
	double valor;
	
	abstract double aliquota();
	
	public double ipva() {
		return this.aliquota() * valor;
	}
	
	public int getIdade() {
		return new GregorianCalendar().get(GregorianCalendar.YEAR) - dataFabricacao.get(GregorianCalendar.YEAR);
	}

	public VeiculoAutomotivo(GregorianCalendar dataFabricacao, String cor,
			String numeroChassi, String combustivel, double valor) {
		this.dataFabricacao = dataFabricacao;
		this.cor = cor;
		this.numeroChassi = numeroChassi;
		this.combustivel = combustivel;
		this.valor = valor;
	}
}

class CarroPasseio extends VeiculoAutomotivo {
	public CarroPasseio(GregorianCalendar dataFabricacao, String cor,
			String numeroChassi, String combustivel, double valor) {
		super(dataFabricacao, cor, numeroChassi, combustivel, valor);
	}

	public double aliquota() {
		double aliquota = 0;
		if (this.getIdade() < 15) {
			if (combustivel.equalsIgnoreCase("flex"))
				aliquota = 0.03;
			else
				if (combustivel.equalsIgnoreCase("gasolina"))
					aliquota = 0.04;
				else
					if (combustivel.equalsIgnoreCase("etanol"))
						aliquota = 0.02;
					else // gnv
						aliquota = 0.01;
		}
		return aliquota;
	}
}

class Moto extends VeiculoAutomotivo {
	public Moto(GregorianCalendar dataFabricacao, String cor,
			String numeroChassi, String combustivel, double valor) {
		super(dataFabricacao, cor, numeroChassi, combustivel, valor);
	}

	double aliquota() {
		double aliquota = 0;
		if (this.getIdade() < 15) {
			aliquota = 0.02;
		}
		return aliquota;
	}
}

//class CarroUtilitario extends VeiculoAutomotivo {
//	public CarroUtilitario(GregorianCalendar dataFabricacao, String cor,
//			String numeroChassi, String combustivel, double valor) {
//		super(dataFabricacao, cor, numeroChassi, combustivel, valor);
//	}
//
//	double aliquota() {
//		double aliquota = 0;
//		if (this.getIdade() < 15) {
//			aliquota = 0.03;
//		}
//		return aliquota;
//	}
//}

// Classe de teste para a classe Telefone acima
public class AP2_2013_2_Q1 {
	public static void main(String[] args) {
		double totalIPVA = 0;
		List <VeiculoAutomotivo> veiculos = new ArrayList<VeiculoAutomotivo>();
		veiculos.add(new CarroPasseio(new GregorianCalendar(2011, 3, 1), "prata", "111", "gnv", 15000.00));
		veiculos.add(new Moto(new GregorianCalendar(2007, 3, 1), "vermelha", "222", "gasolina", 8000.00));
		veiculos.add(new CarroPasseio(new GregorianCalendar(1995, 3, 1), "preta", "333", "alcool", 10000.00));
		for (VeiculoAutomotivo v : veiculos)
			totalIPVA += v.ipva();
		System.out.println("Total de ipva's: " + totalIPVA);
	}
}
