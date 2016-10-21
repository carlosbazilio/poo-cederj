package br.cederj.comp.ano2014;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

interface IProduto {
	String getNome();
}

class Emprestimo {
	GregorianCalendar retirada;
	GregorianCalendar devolucao;
	GregorianCalendar devolucaoEfetiva;
	String emailContato;
	IProduto produto;

	public Emprestimo(GregorianCalendar retirada, GregorianCalendar devolucao, GregorianCalendar devolucao2,  
			String emailContato, IProduto p) {
		this.retirada = retirada;
		this.devolucao = devolucao;
		this.devolucaoEfetiva = devolucao2;
		this.emailContato = emailContato;
		this.produto = p;
	}	
}

class Livro implements IProduto {
	String titulo;
	String autor;
	String editora;
	int ano;
	
	public Livro(String titulo, String autor, String editora, int ano) {
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.ano = ano;
	}

	public String getNome() {
		return this.titulo;
	}
}

class Utensilio implements IProduto {
	String descricao;
	String materialConfeccionado;
	
	public Utensilio(String descricao, String materialConfeccionado) {
		this.descricao = descricao;
		this.materialConfeccionado = materialConfeccionado;
	}

	public String getNome() {
		return descricao;
	}	
}

public class AD2_2014_1 {
	public static void main(String[] args) {
		IProduto monge = new Livro("O monge e o Executivo", "James Hunter", "Sextante", 2004);
		IProduto frigideira = new Utensilio("Frigideira", "teflon");
		
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		emprestimos.add(new Emprestimo(new GregorianCalendar(), new GregorianCalendar(2014, 3, 1), null, "xxx@yyy.zzz", monge));
		emprestimos.add(new Emprestimo(new GregorianCalendar(2013, 12, 25), new GregorianCalendar(2014, 4, 1), null, "xxx@yyy.zzz", frigideira));
			
		for (Emprestimo e : emprestimos) {
			if (e.devolucao.compareTo(new GregorianCalendar()) < 0) {
				System.out.println("Emprestimo de \"" + e.produto.getNome() + "\" em atraso!");
			}
		}
	}
}
