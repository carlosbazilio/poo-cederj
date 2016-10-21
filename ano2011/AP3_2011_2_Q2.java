package br.cederj.comp.ano2011;

import java.util.ArrayList;
import java.util.List;

class Tel {
	int pais;
	int cidade;
	int numero;
	
	public Tel(int pais, int cidade, int numero) {
		this.pais = pais;
		this.cidade = cidade;
		this.numero = numero;
	}
	
	public boolean igual (Tel t) {
		return (this.pais == t.pais && this.cidade == t.cidade && this.numero == t.numero);
	}
	
	public String toString() {
		return "+" + pais + " " + cidade + " " + numero;
	}
}

class Ramal extends Tel {
	int ramal;

	public Ramal(int pais, int cidade, int numero, int ramal) {
		super(pais, cidade, numero);
		this.ramal = ramal;
	}

	public boolean igual (Ramal r) {
		return (super.igual(r) && this.ramal == r.ramal);
	}
	
	public String toString() {
		return super.toString() + " #" + this.ramal;
	}
}

class Contato {
	String nome;
	String endereco;
	List<Tel> telefones;

	public Contato(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefones = new ArrayList<Tel>();
	}

	public void adicionaTelefone (Tel tel) {
		boolean pertence = false;
		for (Tel t : this.telefones)
			if (t.igual(tel)) {
				pertence = true;
				break;
			}
		if (!pertence)
			this.telefones.add(tel);
	}
	
	public String toString () {
		String tels = "";
		for (Tel t : this.telefones)
			tels = tels + t.toString() + " ";
		return this.nome + "\n" + this.endereco + "\n" + tels + "\n";
	}
}

class Agenda {
	List<Contato> contatos;
	public Agenda() {
		contatos = new ArrayList<Contato>();
	}
	
	public void adicionaContato (Contato c) {
		contatos.add(c);
	}

	public void imprimeContatos() {
		for (Contato c: contatos) {
			System.out.println(c);
		}
	}
}

public class AP3_2011_2_Q2 {
	public static void main(String[] args) {
		Agenda ag = new Agenda();
		Contato c = new Contato("Fulano", "Petrópolis");
		c.adicionaTelefone(new Tel(55, 24, 99999999));
		c.adicionaTelefone(new Ramal(55, 24, 22222222, 3500));
		ag.adicionaContato(c);
		Contato c2 = new Contato("Ciclano", "Rio das Ostras");
		c2.adicionaTelefone(new Tel(55, 22, 99999999));
		ag.adicionaContato(c2);
		ag.imprimeContatos();
	}
}
