package br.cederj.comp.ano2016;

import java.util.ArrayList;
import java.util.List;

class Dado {
	private Object chave;
	private Object valor;
	
	public Dado(Object chave, Object valor) {
		this.chave = chave;
		this.valor = valor;
	}

	public Object getChave() {
		return chave;
	}

	public void setChave(Object chave) {
		this.chave = chave;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return (String) valor;
	}
}

class Dicionario {
	List<Dado> valores;

	public Dicionario() {
		this.valores = new ArrayList<Dado>();
	}
	
	public void adiciona (Dado d) {
		valores.add(d);
	}
	
	public void retira (Object chave) {
		for (Dado d : valores) {
			if (d.getChave() == chave)
				valores.remove(d);
		}
	}
	
	public void exibe () {
		for (Dado d : valores) {
			System.out.println(d);
		}
	}
}

public class AP3_2016_2_Q2 {
	public static void main(String[] args) {
		Dicionario d = new Dicionario();
		d.adiciona(new Dado("Joao", "9999-8888"));
		d.adiciona(new Dado("Paulo", "77777-5555"));
		//d.adiciona(new Dado("Maria", 100));
		//d.adiciona(new Dado("Paulo", new Produto(1, "abc", 100)));
		d.exibe();
	}
}
