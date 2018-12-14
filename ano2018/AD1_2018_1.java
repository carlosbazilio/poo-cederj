package br.cederj.comp.ano2018;

import java.time.LocalDate;
import java.time.Period;

class Midia {
	String autor;
	String url;
	String titulo;
	LocalDate dataPublicacao;
	
	public Midia(String autor, String url, String titulo, LocalDate dataPublicacao) {
		this.autor = autor;
		this.url = url;
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
	}
	
	public String toString() {
		return autor + " " + titulo + " " + dataPublicacao;
	}
}

class Video extends Midia {
	int duracao;
	String descricao;
	int curtidas;
	
	public Video(String autor, String url, String titulo, LocalDate dataPublicacao, int duracao, String descricao,
			int curtidas) {
		super(autor, url, titulo, dataPublicacao);
		this.titulo = titulo;
		this.duracao = duracao;
		this.descricao = descricao;
		this.curtidas = curtidas;
	}
	
	public String retornaIdade () {
		LocalDate hoje = java.time.LocalDate.now();
		Period idade = java.time.Period.between(this.dataPublicacao, hoje);
		String sIdade = "";
		if (idade.getYears() > 0)
			sIdade += idade.getYears() + " anos ";
		if (idade.getMonths() > 0)
			sIdade += idade.getMonths() + " meses ";
		if (idade.getDays() > 0)
			sIdade += idade.getDays() + " dias";
		return sIdade;
	}
	
	public String toString() {
		return autor + " " + titulo + " " + retornaIdade();
	}
}

class Ebook extends Midia {
	int numPaginas;

	public Ebook(String autor, String url, String titulo, LocalDate dataPublicacao, int numPaginas) {
		super(autor, url, titulo, dataPublicacao);
		this.numPaginas = numPaginas;
	}
}

public class AD1_2018_1 {
	public static void main(String[] args) {
		Video video1 = new Video("Carlos Bazilio", 
				                 "https://www.youtube.com/watch?v=bdpSqjTZJcg", 
				                 "Por quê ainda estudar Java?", 
				                 LocalDate.of (2017,8,22), 
				                 998, 
				                 "Razões para ainda se estudar a linguagem Java",
				                 11);
		Ebook ebook1 = new Ebook("Carlos Bazilio",
				                 "https://carlosbazilio.gitbooks.io/programando-na-cozinha/content/pt-br/",
				                 "Programando na Cozinha",
				                 LocalDate.of (2017,9,23), 
				                 57);
		Ebook ebook2 = new Ebook("Marijn Haverbeke",
					             "http://eloquentjavascript.net/3rd_edition/",
					             "Eloquent JavaScript",
					             LocalDate.of (2017,3,6), 
					             472);
		Midia midias[] = {video1, ebook1, ebook2};
		
		for (Midia m : midias) {
			System.out.println(m);
		}
	}
}



