package br.cederj.comp.ano2011;

class Telefone {
	int codInternacional;
	int codArea;
	int numero;
	
	public Telefone(int codInternacional, int codArea, int numero) {
		this.codInternacional = codInternacional;
		this.codArea = codArea;
		this.numero = numero;
	}
	
	public Telefone(int codArea, int numero) {
		this(55, codArea, numero);
	}
	
	public Telefone(int numero) {
		this(55, 21, numero);
	}
	
	public String toString() {
		return "+" + codInternacional + " " + codArea + " " + numero;
	}
	
	public boolean igual (Telefone t) {
		return ((this.codInternacional == t.codInternacional) && (this.codArea == t.codArea) && (this.numero == t.numero));
	}
}

// Classe de teste para a classe Telefone acima
public class AP1_2011_1_Q3 {
	public static void main(String[] args) {
		System.out.println(new Telefone(78684527));
	}
}
