package br.cederj.comp.ano2009;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Favoritos {
	private Set<Favorito> favs;
	
	public Favoritos() {
		favs = new HashSet<Favorito>();
	}
	
	// item a) da questão
	public void adicionaFavorito (Favorito fav) {
		favs.add(fav);		
	}
	
	// item b) da questão
	public void removeFavorito (String nome) {
		Iterator<Favorito> it = favs.iterator();
		while (it.hasNext()) {
			Favorito fav = (Favorito)it.next();
			if (fav.getNome().equals(nome)) {
				favs.remove(fav);
				break;
			}
		}
	}
	
	// item c) da questão
	public Set<Favorito> buscaFavoritosPorAssunto (String assunto) {
		Set<Favorito> fav_assunto = new HashSet<Favorito>();
		Iterator<Favorito> it = favs.iterator();
		while (it.hasNext()) {
			Favorito fav = (Favorito)it.next();
			if (fav.getAssuntos().contains(assunto)) {
				fav_assunto.add(fav);
			}
		}
		return fav_assunto;
	}

	public void imprimeFavoritosPorAssunto (String assunto) {
		Set<Favorito> fav_assunto = this.buscaFavoritosPorAssunto(assunto);
		Iterator<Favorito> it = fav_assunto.iterator();
		while (it.hasNext()) {
			System.out.println("Nome favorito: " + ((Favorito)it.next()).getNome());
		}
	}
}

class Favorito {
	private String nome;
	private EnderecoWWW url;
	private Set<String> assuntos;
	
	public Favorito (String n, EnderecoWWW ender, Set<String> assuntos) {
		this.nome = n;
		this.url = ender;
		this.assuntos = assuntos;
	}

	public Favorito (String n, EnderecoWWW ender, String assunto) {
		this.nome = n;
		this.url = ender;
		this.assuntos = new HashSet<String>();
		this.assuntos.add(assunto);
	}

	public void adicionaAssunto (String assunto) {
		this.assuntos.add(assunto);
	}

	public void removeAssunto (String assunto) {
		this.assuntos.remove(assunto);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EnderecoWWW getUrl() {
		return url;
	}

	public void setUrl(EnderecoWWW url) {
		this.url = url;
	}

	public Set<String> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(Set<String> assuntos) {
		this.assuntos = assuntos;
	}	
}

public class AP2_2009_1_Q1 {
	public static void main(String[] args) {
		String www = "http://www.cederj.edu.br/vest";
		EnderecoWWW cederj = new EnderecoWWW(www);
		cederj.exibe();
		
		Favoritos bookmark = new Favoritos();
		Favorito fav = new Favorito("cederj", cederj, "ensino");
		fav.adicionaAssunto("ead");
		fav.adicionaAssunto("educação");
		bookmark.adicionaFavorito(fav);
		fav = new Favorito("sitepessoal", new EnderecoWWW("http://www.ic.uff.br/~bazilio"), "ensino");
		fav.adicionaAssunto("educação");
		bookmark.adicionaFavorito(fav);
		bookmark.imprimeFavoritosPorAssunto("ensino");
	}
}
