package br.cederj.comp.ano2016;

class Entrada {
	private String fonte;
	private String traducao;
	
	public Entrada(String fonte, String traducao) {
		this.fonte = fonte;
		this.traducao = traducao;
	}
	
	public String getFonte () {
		return this.fonte;
	}
	
	public String getTraducao () {
		return this.traducao;
	}
}

class Dicionario2 {
	private Entrada entradas[];
	private int tam;
	private static int MAX = 1000;

	public Dicionario2() {
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
		for (int i=0; i<tam; i++)
			if (entradas[i].getFonte() == termo) {
				return entradas[i].getTraducao();
			}
		return "";
	}
}

public class AP1_2016_1_Q3 {
	public static void main(String[] args) {
		Dicionario2 dic = new Dicionario2();
		dic.adiciona(new Entrada("table", "mesa"));
		dic.adiciona(new Entrada("pen", "caneta"));
		dic.adiciona(new Entrada("car", "carro"));
		dic.adiciona(new Entrada("dog", "cachorro"));
		
		System.out.println(dic.traduz("pen"));
	}
}
