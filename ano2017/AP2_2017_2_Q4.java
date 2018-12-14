package br.cederj.comp.ano2017;

interface Controlado {
	void commit();
	void checkout();
}

class Arquivo {
	String nome;
	String caminho;
	String conteudo;
	
	public Arquivo(String nome, String caminho, String conteudo) {
		this.nome = nome;
		this.caminho = caminho;
		this.conteudo = conteudo;
	}
	
	public void adicionaConteudo (String texto) {
		this.conteudo += texto;
	}
}

class ArquivoControlado extends Arquivo implements Controlado {
	boolean editado;
	String log;

	public ArquivoControlado(String nome, String caminho, String conteudo) {
		super(nome, caminho, conteudo);
		this.editado = false;
	}

	public void commit() {
		this.editado = false;
	}
	
	public void checkout() {
		this.editado = true;
	}
	
	public void adicionaConteudo (String texto) {
		if (this.editado) {
			this.log += this.conteudo + " -> " + this.conteudo + texto + "\n";
			super.adicionaConteudo(texto);
			System.out.println("Não esqueça de fazer o commit!");
		}
		else
			System.out.println("É necessário fazer checkout do arquivo " + this.nome + "!");
	}
}

public class AP2_2017_2_Q4 {
	public static void main(String[] args) {
		Arquivo a1 = new Arquivo("inicial.txt", "/", "Texto inicial");
		ArquivoControlado a2 = new ArquivoControlado("inicial-versionado.txt", "/", "Texto inicial");
		a1.adicionaConteudo("Novo texto");
		a2.checkout();
		a2.adicionaConteudo("Novo texto");
		a2.commit();
	}
}

