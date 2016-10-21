package br.cederj.comp.ano2012;

/*
 * Critérios gerais de correção:
 * 
 * - Questão vale 3 pontos
 * - Falta de chamada de super(): -0.5 ponto
 * - Erro na definição da herança: -1 ponto
 * - Erro na implementação do limite de velocidade: -0.5 ponto
 */

class Veiculo {
	private int numRodas;
	protected String marca;
	protected int velocidade;
	
	protected void aumentarVelocidade(int vel) { velocidade = velocidade + vel; };
	protected void diminuirVelocidade(int vel) { velocidade = velocidade - vel; };
	public String getMarca() { return marca; };
	public int getVelocidade() { return velocidade; };
	public void acelerar() { aumentarVelocidade(5); };
	public void frear() { diminuirVelocidade(5); };
	
	public Veiculo(String m, int n) { 
		marca = m;
		numRodas = n;
		velocidade = 0;
	}
}

class Carro extends Veiculo {
	int qtdLugares;
	
	public Carro(String m, int qtd) {
		super(m, 4);
		qtdLugares = qtd;
	}

	protected void aumentarVelocidade(int vel) { 
		if ((velocidade + vel) < 150)
			super.aumentarVelocidade(vel);
	}
}

/**
 * Classe de teste da classe intervalo 
 * @author Carlos Bazilio
 */
public class AP1_2012_2_Q3 {
	public static void main(String[] args) {
		Veiculo fiat = new Veiculo("FIAT", 6); 
		Veiculo ford = new Carro("Ford", 5);
	}
}
