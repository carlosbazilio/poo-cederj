package br.cederj.comp.ano2019;

import java.util.ArrayList;
import java.util.List;

interface Nota {
	String exibe ();
}

class NotaTexto implements Nota {
	String conteudo;
	public NotaTexto (String c) {
		this.conteudo = c;
	}
	public String exibe() {
		return ">> " + this.conteudo + "\n";
	}
}

class Cartao implements Nota {
	String nome;
	String empresa;
	String telefone;
	public Cartao (String n, String e, String tel) {
		this.nome = n; this.empresa = e; this.telefone = tel;
	}
	public String exibe() {
		return ">> " + this.empresa + "\n" + this.telefone + "\n";
	}
}

class BlocoNotas {
	List<Nota> notas;
	public BlocoNotas () {
		notas = new ArrayList<Nota>();
	}
	public void adiciona(Nota n) {
		notas.add(n);
	}
	public void imprimeNotas() {
		for (Nota n : notas) {
			System.out.println(n.exibe());
		}
	}
	public BlocoNotas buscaNotas (String termo) {
		BlocoNotas resultado = new BlocoNotas();
		for (Nota n : notas) {
			if (n.exibe().contains(termo))
				resultado.adiciona(n);
		}
		return resultado;
	}
}

public class AP2_2019_2_Q3 {
	public static void main(String[] args) {
		NotaTexto nota = new NotaTexto("Estudar Classes, Herança, Polimorfismo, ...");
		Cartao cartao = new Cartao("Ouvidoria", "Cederj", "21-2334-1583");
		BlocoNotas anotacoes = new BlocoNotas();
		anotacoes.adiciona(nota);
		anotacoes.adiciona(cartao);
		anotacoes.buscaNotas("Herança").imprimeNotas();
	}
}
