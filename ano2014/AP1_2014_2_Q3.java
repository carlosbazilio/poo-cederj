package br.cederj.comp.ano2014;

import java.util.GregorianCalendar;

// Como há vários atributos comuns entre as publicações
//existentes, foram declaradas superclasses para conter o
//que é comum entre as subclasses.
// Supondo que preco é um campo chave, foi definifido como
//privado. Entretanto, isso não era exigido na questão.
class Publicacao {
	String titulo;
	private float preco;
	
	public Publicacao(String titulo, float preco) {
		this.titulo = titulo;
		this.preco = preco;
	}
	
	public float retornaPreco() {
		return preco;
	}
}

// Superclasse comum a Livro, Revista e Gibis
class PubLivro extends Publicacao {
	String isbn;

	public PubLivro(String titulo, float preco, String isbn) {
		super(titulo, preco);
		this.isbn = isbn;
	}
}

class Livro2 extends PubLivro {
	String autor;
	String editora;
	java.util.GregorianCalendar datapublicacao;

	public Livro2(String titulo, float preco, String isbn, String autor,
			String editora, GregorianCalendar datapublicacao) {
		super(titulo, preco, isbn);
		this.autor = autor;
		this.editora = editora;
		this.datapublicacao = datapublicacao;
	}
}

class Revista extends PubLivro {
	int mes, ano;

	public Revista(String titulo, float preco, String isbn, int mes, int ano) {
		super(titulo, preco, isbn);
		this.mes = mes;
		this.ano = ano;
	}
}

class Gibi extends PubLivro {
	String edicao;

	public Gibi(String titulo, float preco, String isbn, String edicao) {
		super(titulo, preco, isbn);
		this.edicao = edicao;
	}
}

class CdDvd extends Publicacao {
	String issn;
	int tamanho;

	public CdDvd(String titulo, float preco, String issn, int tamanho) {
		super(titulo, preco);
		this.issn = issn;
		this.tamanho = tamanho;
	}
}

// Classe principal que exemplifica o uso das classes declaradas
public class AP1_2014_2_Q3 {
	public static void main(String[] args) {
		Revista revista = new Revista("Auto Esporte", 10.0f, "0001", 9, 2014);
		System.out.println("Preço da revista: " + revista.retornaPreco());
	}
}
