package br.cederj.comp.ano2010;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

class Favorito {
	private String nome;
	private String url;
	private GregorianCalendar ultimoAcesso;
	
	public Favorito(String n, String u) {
		nome = n;
		url = u;
		ultimoAcesso = new GregorianCalendar();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public GregorianCalendar getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(GregorianCalendar ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
	
	public String toString() {
		// A classe java.text.SimpleDateFormat é útil para a formatação 
		// da classe GregorianCalendar
	    String DATE_FORMAT = "dd/MM/yyyy hh:mm:ss";
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return "\nNome: " + nome + "\nUrl: " + url + "\nUltimo Acesso: " 
		+ sdf.format(ultimoAcesso.getTime());
	}
}

class Imagem extends Favorito {
	private int tamanho;
	
	public Imagem(String n, String u, int t) {
		super(n, u);
		tamanho = t;
	}
	
	public String toString() {
		return super.toString() + " Tamanho: " + tamanho + " kbytes";
	}
}

class Favoritos {
	List<Favorito> lista = new ArrayList<Favorito>();
	
	public void add (Favorito f) {
		boolean achou = false;
		for (Favorito fav: lista) {
			if (fav.getNome().compareTo(f.getNome()) == 0) {
				if (fav.getUrl().compareTo(f.getUrl()) == 0) {
					fav.setUltimoAcesso(new GregorianCalendar());
					achou = true;
				}
				else {
					fav.setUrl(fav.getUrl());
					achou = true;
				}
			}
			else
				if (fav.getUrl().compareTo(f.getUrl()) == 0) {
					fav.setUltimoAcesso(new GregorianCalendar());
					achou = true;
				}
		}
		if (! achou)
			lista.add(f);
	}
}

// Nesta soluçãÁ„o, optamos por criar uma especialização da classe ArrayList
// Uma maneira alternativa, e talvez mais simples, seria uma classe isolada
//e declararmos um campo que seria a lista. Dentro desta classe definiríamos
//os métodos de acesso a esta lista. A vantagem da implementaÁ„ção como
//uma especializaçãÁ„o é termos uma classe que se comportará como qualquer
//outra classe do tipo ArrayList
class MinhaLista extends ArrayList {
	public boolean add(Object e) {
		for (Object obj: this) {
			Favorito efav = (Favorito)e;
			Favorito objfav = (Favorito)obj;
			if (efav.getNome().compareTo(objfav.getNome()) == 0) {
				if (efav.getUrl().compareTo(objfav.getUrl()) == 0) {
					objfav.setUltimoAcesso(new GregorianCalendar());
				}
				else {
					objfav.setUrl(efav.getUrl());
				}
				return true;
			}
			else
				if (efav.getUrl().compareTo(objfav.getUrl()) == 0) {
					objfav.setUltimoAcesso(new GregorianCalendar());
					return true;
				}
		}
		return super.add(e);
	}
}

public class AD2_2010_1 {
	public static void main(String[] args) {
		List<Favorito> favoritos = new MinhaLista ();
		favoritos.add(new Favorito("Cederj", "www.cederj.edu.br"));
		favoritos.add(new Imagem("LogoCederj", "www.coseac.uff.br/cederj/cederj_logo.gif", 4));
		favoritos.add(new Favorito("Pessoal", "www.ic.uff.br/~bazilio"));
		favoritos.add(new Imagem("LogoUFF", "http://www.uff.br/logouff/logopuroazul.gif", 2));
		favoritos.add(new Imagem("BandeiraBrasil", "http://gilgiardelli.files.wordpress.com/2008/07/brasil.jpg", 27));
		
		for (Favorito img: favoritos) { // Percorre o conjunto de imagens
			System.out.println(img);
		}
		
		favoritos.add(new Favorito("Cederj2", "www.cederj.edu.br"));

		for (Favorito img: favoritos) { // Percorre o conjunto de imagens
			System.out.println(img);
		}
	}
}
