package br.cederj.comp.ano2012;

import java.util.ArrayList;
import java.util.List;

interface IRecurso { // Opcional
	boolean valido();
}

abstract class Recurso implements IRecurso {
	String nome;
	String url;
	
	public Recurso (String nome, String url) {
		this.nome = nome;
		this.url = url;
	}
	
	public String toString() {
		return url;
	}
}

class EnderecoWWW extends Recurso {
	public EnderecoWWW (String nome, String url) {
		super(nome, url);
	}

	public boolean valido() {
		return this.url.startsWith("www");
	}
}

class Imagem extends Recurso {
	int tamanho;
	public Imagem (String nome, String url, int tamanho) {
		super(nome, url);
		this.tamanho = tamanho;
	}
	
	public boolean valido() {
		return this.url.endsWith("jpg") || this.url.endsWith("png");
	}
}

public class AP3_2012_2_Q4 {
	public static void main(String[] args) {
		//Nome e url
		EnderecoWWW e = new EnderecoWWW("Cederj", "www.cederj.edu.br");
		//Nome, url e tamanho da imagem
		Imagem i = new Imagem("Cederj", "http://www.cederj.edu.br/fundacao/imagenssuperior_arquivos/menu_logo.jpg", 50);
		List<Recurso> pagina = new ArrayList<Recurso>();
		pagina.add(e);
		pagina.add(i);
		for (Recurso r : pagina)
			System.out.println("O recurso " + r.toString() + " eh " + r.valido());
	}
}