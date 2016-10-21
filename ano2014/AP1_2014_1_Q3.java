package br.cederj.comp.ano2014;

class Telefone {
	String pais;
	String ddd;
	String numero;

	public Telefone(String pais, String ddd, String numero) {
		this.pais = pais;
		this.ddd = ddd;
		this.numero = numero;
	}
	
	public boolean ehCelular() {
		if (numero.startsWith("9") || 
			numero.startsWith("8") || 
			numero.startsWith("7") || 
			numero.startsWith("6"))
			return true;
		return false;
	}
	
	public String ligacao(String modo) {
		if (modo.contentEquals("local")) 
			return this.numero;
		else
			if (modo.contentEquals("interurbano"))
				return "0" + this.ddd + numero;
			else
				return "0" + this.pais + this.ddd + numero;
	}
}

public class AP1_2014_1_Q3 {
	public static void main(String[] args) {

	}
}
