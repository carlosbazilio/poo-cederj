package br.cederj.comp.ano2014;

// Classe utilitárias necessárias para podermos
//trabalhar com listas
import java.util.ArrayList;
import java.util.List;

// Interface deduzida pelo fato de termos a definição
//class IPTU implements Imposto. Ou seja, Imposto
//precisa ser uma interface
// Solução de parte do item a)
interface Imposto {
	double calculaValor(Imovel b);
}

// Classe fornecida na questão
class IPTU implements Imposto {
	double taxa;
	
	public IPTU (double tx) {
		this.taxa = tx;
	}
	
	public double calculaValor(Imovel b) {	
		return b.getValor() * this.taxa;
	}
}

// Classe pedida pelo item b) da questão. 
class Bombeiro implements Imposto {
	public double calculaValor(Imovel b) {
		return 200;
	}
}

// Classe requerida na questão.
//Apesar da questão só informar explicitamente que imóvel
//possui uma lista impostos, o campo valor também é necessário
//uma vez que o método getValor() da classe dada na questão
//precisa funcionar. Ou seja, a classe Imovel precisar
//armazenar o valor de alguma maneira.
class Imovel {
	private double valor;
	private List<Imposto> impostos;
	
	public Imovel (double valor) {
		this.valor = valor;
		impostos = new ArrayList<Imposto>();
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public void adicionaImposto(Imposto i) {
		impostos.add(i);
	}
	
	// Neste método, a chamada a calculaValor é polimórfica,
	//uma vez que qualquer objeto do subtipo de Imposto pode
	//ser adicionado à lista
	public double calculaImposto() {
		double temp = 0;
		for (Imposto i : impostos) {
			temp = temp + i.calculaValor(this);
		}
		return temp;
	}
}

// Manipulações objetos pedidos no item c) desta questão
public class AP2_2014_1_Q3 {
	public static void main(String[] args) {
		Imovel apto = new Imovel(100000);
		apto.adicionaImposto(new IPTU(0.03));
		apto.adicionaImposto(new Bombeiro());
		System.out.println(apto.calculaImposto());
	}
}
