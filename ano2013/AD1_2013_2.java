package br.cederj.comp.ano2013;

class Publicacao {
	String titulo;
	String assunto;
	String edicao;
	Editora editora;

	public Publicacao(String titulo, String assunto, String edicao,
			Editora editora) {
		this.titulo = titulo;
		this.assunto = assunto;
		this.edicao = edicao;
		editora.incNumPubs();
		this.editora = editora;
	}
}

class Editora {
	String nome;
	String website;
	int numPubs;
	
	public Editora(String nome, String website) {
		this.nome = nome;
		this.website = website;
		this.numPubs = 0;
	}
	
	public void incNumPubs() {
		this.numPubs++;
	}
	
	public int getNumPubs() {
		return this.numPubs;
	}
}

class Livro extends Publicacao {
	String [] autores;

	public Livro(String titulo, String assunto, String edicao, Editora editora, String [] auts) {
		super(titulo, assunto, edicao, editora);
		this.autores = auts;
	}
}

class Revista extends Publicacao {
	String periodicidade;
	
	public Revista(String titulo, String assunto, String edicao, Editora editora, String periodicidade) {
		super(titulo, assunto, edicao, editora);
		this.periodicidade = periodicidade;
	}
}

public class AD1_2013_2 {
	public static void main(String[] args) {
		Editora oreilly = new Editora("O'Reilly", "http://oreilly.com/");
		String [] autores = {"Eric Freeman", "Elisabeth Freeman"}; 
		Publicacao headfirst = new Livro("Padrões de Projeto", "Programação", "2a", oreilly, autores);
		Editora tres = new Editora("Editora Três", "http://editora3.terra.com.br/");
		Publicacao oracle = new Revista("Isto É", "Notícias", "2279", tres, "semanal");
		int pubs = oreilly.getNumPubs();
		System.out.println("O'Reilly: " + pubs);
		
		String [] autores2 = {"Jennifer Niederst Robbins"}; 
		Publicacao html5pocket = new Livro("HTML5 Pocket Reference", "Programação", "5a", oreilly, autores2);
		System.out.println("O'Reilly: " + oreilly.getNumPubs());
		System.out.println("Tres: " + tres.getNumPubs());
	}
}
