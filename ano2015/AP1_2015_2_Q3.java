package br.cederj.comp.ano2015;

class Veiculo {
	String motorista;
	String fabricante;
	
	public Veiculo(String motorista, String fabricante) {
		this.motorista = motorista;
		this.fabricante = fabricante;
	}
}

class Carro extends Veiculo {
	String cor;
	boolean quatro_portas;
	
	public Carro(String motorista, String fabricante, String cor, boolean quatro_portas) {
		super(motorista, fabricante);
		this.cor = cor;
		this.quatro_portas = quatro_portas;
	}
}

class Caminhao extends Veiculo {
	String ajudante;
	boolean bau;
	boolean cama_pernoite;
	
	
	public Caminhao(String motorista, String ajudante, String fabricante, boolean bau, boolean cama_pernoite) {
		super(motorista, fabricante);
		this.ajudante = ajudante;
		this.bau = bau;
		this.cama_pernoite = cama_pernoite;
	}
}

public class AP1_2015_2_Q3 {
	public static void main(String[] args) {
	}
}
