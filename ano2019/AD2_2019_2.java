package br.cederj.comp.ano2019;

import java.util.*;

abstract class Elemento {
	private String nome;

	public Elemento(String nome) {
		this.nome = nome;
	}

	public abstract int getTamanho();
	
	public abstract String imprime(int nivel);

	public String getNome() { return this.nome; }
	
	public String indenta (int nivel) {
		return new String(new char[nivel]).replace("\0", "\t");
	}
}

class Arquivo extends Elemento {
	private int tamanho;

	public Arquivo(String nome, int tamanho) {
		super(nome);
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public String toString() {
		return this.getNome();
	}
	
	public String imprime(int nivel) {
		return this.indenta(nivel) + this.toString();
	}
}

class Pasta extends Elemento {
	private List<Elemento> elementos = new ArrayList<Elemento>();

	public Pasta(String nome) {
		super(nome);
	}

	public void adiciona(Elemento elemento) {
		elementos.add(elemento);
	}

	public Elemento remove(String elemento) {
		Elemento alvo = null;
		String subelementos[] = elemento.split("/");
		
		for (Elemento e : this.elementos)
			if (subelementos[0].equals(e.getNome()))
				if (subelementos.length == 1) {
					alvo = e;
					this.elementos.remove(e);
					break;
				}
				else
					alvo = ((Pasta) e).remove(elemento.substring(elemento.indexOf('/')+1));
		
		return alvo;
	}

	public int getTamanho() {
		int tamanho = 0;
		for (Elemento elemento : elementos)
			tamanho += elemento.getTamanho();
		return tamanho;
	}
	
	public String imprime(int nivel) {
		String saida = indenta(nivel) + this.getNome() + "\n";
		for (Elemento e : this.elementos)
			saida += e.imprime(nivel+1) + "\n";
		return saida;
	}
	
	public String toString() {
		return this.imprime(0);
	}
}

public class AD2_2019_2 {
	public static void main(String[] args) {
		Pasta p1 = new Pasta("dir1");
		p1.adiciona(new Arquivo("arquivo1.txt", 150));
		p1.adiciona(new Arquivo("arquivo2.txt", 200));
		Pasta p2 = new Pasta("dir2");
		p2.adiciona(new Arquivo("arquivo3.txt", 500));
		Pasta p3 = new Pasta("dir3");
		p3.adiciona(new Arquivo("arquivo4.txt", 350));
		p3.adiciona(p2);
		Pasta raiz = new Pasta("c:/");
		raiz.adiciona(p1);
		raiz.adiciona(p3);
		raiz.remove("dir1/arquivo1.txt");
		System.out.println(raiz.getTamanho());
		System.out.println(raiz);
	}
}
