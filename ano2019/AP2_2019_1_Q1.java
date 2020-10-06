package br.cederj.comp.ano2019;

class Entrada {
	private String fonte;
	private String traducao;
	private String idioma_fonte;
	private String idioma_traducao;
	
	public Entrada(String fonte, String traducao, String idioma_fonte, String idioma_traducao) {
		this.fonte = fonte;
		this.traducao = traducao;
		this.idioma_fonte = idioma_fonte;
		this.idioma_traducao = idioma_traducao;
	}
	
	public String getFonte () {
		return this.fonte;
	}
	
	public String getTraducao () {
		return this.traducao;
	}

	public String getIdioma_fonte() {
		return idioma_fonte;
	}

	public String getIdioma_traducao() {
		return idioma_traducao;
	}
}

class Dicionario {
	private Entrada entradas[];
	private int tam;
	private static int MAX = 1000;

	public Dicionario() {
		entradas = new Entrada [MAX];
		tam = 0;
	}
	
	public void adiciona (Entrada e) {
		if (tam < MAX-1) {
			entradas[tam] = e;
			tam++;
		}
	}
	
	public String traduz (String termo) {
		String saida = "";
		for (int i=0; i<tam; i++)
			if (entradas[i].getFonte() == termo) {
				saida += entradas[i].getIdioma_fonte() + " -> " + entradas[i].getIdioma_traducao() + "\n" + termo + " -> " + entradas[i].getTraducao() + "\n";
			}
			else
				if (entradas[i].getTraducao() == termo) {
					saida += entradas[i].getIdioma_traducao() + " -> " + entradas[i].getIdioma_fonte() + "\n" + termo + " -> " + entradas[i].getFonte() + "\n";
				}
		return saida;
	}
	
	public String geraEntradas(String origem, String destino) {
		String saida = origem + " -> " + destino + "\n";
		for (int i=0; i<tam; i++)
			if ((entradas[i].getIdioma_fonte() == origem) && (entradas[i].getIdioma_traducao() == destino))
				saida += entradas[i].getFonte() + " -> " + entradas[i].getTraducao() + "\n";
			else
				if ((entradas[i].getIdioma_fonte() == destino) && (entradas[i].getIdioma_traducao() == origem))
					saida += entradas[i].getTraducao() + " -> " + entradas[i].getFonte() + "\n";
		return saida;
	}
}

public class AP2_2019_1_Q1 {
	public static void main(String[] args) {
		Dicionario dic = new Dicionario();
		dic.adiciona(new Entrada("carro", "car", "pt", "en"));
		dic.adiciona(new Entrada("table", "mesa", "en", "pt"));
		dic.adiciona(new Entrada("voiture", "carro", "fr", "pt"));
		dic.adiciona(new Entrada("dog", "cachorro", "en", "pt"));
		dic.adiciona(new Entrada("pao", "pane", "pt", "it"));
		
		System.out.println(dic.traduz("carro"));
		
		System.out.println(dic.geraEntradas("pt", "en"));
	}
}
