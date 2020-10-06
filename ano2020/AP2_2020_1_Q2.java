package br.cederj.comp.ano2020;

import java.util.ArrayList;
import java.util.List;

interface IRecurso { // Opcional
	boolean valido();
}

abstract class Recurso implements IRecurso {
	String nome;
	
	public Recurso (String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return "Nome: " + nome;
	}
	
	// abstract boolean valido(); Alternativa a interface
}

class Link extends Recurso {
	String url;
	public Link (String nome, String url) {
		super(nome);
		this.url = url;
	}

	public boolean valido() {
		return this.url.contains("www");
	}
	
	public String toString() {
		return super.toString() + " Url: " + this.url;
	}
}

class Imagem extends Link {
	int tamanho;
	public Imagem (String nome, String url, int tamanho) {
		super(nome, url);
		this.tamanho = tamanho;
	}
	
	public boolean valido() {
		return this.url.endsWith("jpg") || this.url.endsWith("png");
	}
	
	public String toString() {
		return super.toString() + " Tamanho: " + this.tamanho;
	}
}

class Pagina {
	List <Recurso> recursos;

	public Pagina() {
		recursos = new ArrayList<Recurso>();
	}
	
	public void adicionaRecurso(Recurso r) {
		if (r.valido())
			recursos.add(r);
	}
	
	public String toString() {
		String retorno = "";
		for (Recurso r : recursos)
			retorno += r.toString() + "\n";
		return retorno;
	}
}

public class AP2_2020_1_Q2 {
	public static void main(String[] args) {
		//Nome e url
		Recurso link1 = new Link("Página Principal", "https://www.cecierj.edu.br/");
		Recurso link2 = new Link("GNU", "ftp://gnu.mirror.iweb.com/");
		//Nome, url e tamanho da imagem
		Imagem logo = new Imagem("Logo da Página", "https://www.cecierj.edu.br/wp-content/uploads/2019/08/logo-cecierj-1.png", 50);
		Pagina pagina = new Pagina();
		pagina.adicionaRecurso(link1);
		pagina.adicionaRecurso(link2);
		pagina.adicionaRecurso(logo);
		System.out.println(pagina);
	}
}