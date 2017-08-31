package br.cederj.comp.ano2015;

import java.util.ArrayList;
import java.util.List;

class Questao {
	private String enunciado;
	
	public Questao(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public String getEnunciado() {
		return this.enunciado;
	}
}

class Discursiva extends Questao {
	private String gabarito;
	
	public Discursiva(String enunciado, String gabarito) {
		super(enunciado);
		this.gabarito = gabarito;
	}
	
	public String getGabarito() {
		return this.gabarito;
	}
	
	public String toString() {
		return this.getEnunciado() + "\n";
	}
}

class ItemVerdadeiroFalso extends Questao {
	private boolean gabarito;

	public ItemVerdadeiroFalso(String enunciado, boolean gabarito) {
		super(enunciado);
		this.gabarito = gabarito;
	}
	
	public boolean getGabarito() {
		return this.gabarito;
	}
	
	public String toString() {
		return "( ) " + this.getEnunciado();
	}
}

class VerdadeiroFalso extends Questao {
	List<ItemVerdadeiroFalso> itens;

	public VerdadeiroFalso(List<ItemVerdadeiroFalso> itens) {
		super("Assinale verdadeiro ou falso para os itens:");
		this.itens = itens;
	}
	
	public String toString() {
		String texto = "";
		for (ItemVerdadeiroFalso item : itens)
			texto = texto + item.toString() + "\n";
		return this.getEnunciado() + "\n" + texto;
	}
}

public class AP2_2015_2_Q1 {
	public static void main(String[] args) {
		List<Questao> prova = new ArrayList<Questao>();
		prova.add(new Discursiva("Qual é a capital do Maranhão?", "Sao Luis"));
		List<ItemVerdadeiroFalso> itens = new ArrayList<ItemVerdadeiroFalso>();
		itens.add(new ItemVerdadeiroFalso("A linguagem de programação Java foi lançada há mais de 20 anos atrás", true));
		itens.add(new ItemVerdadeiroFalso("Palmas não é a capital de Tocantins", false));
		itens.add(new ItemVerdadeiroFalso("Eclipse é um editor de texto multilinguagem", true));
		Questao VouF = new VerdadeiroFalso(itens);
		prova.add(VouF);
		
		int num = 1;
		for (Questao q : prova) {
			System.out.print(num + ") ");
			System.out.println(q); // Chamada do método toString()
			num++;
		}
	}
}
