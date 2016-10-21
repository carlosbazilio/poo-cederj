package br.cederj.comp.ano2010;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

// Implementa a interface necess��ria para qualquer publica�㍋o
interface IPublicacao {
	float retornaPreco();
}

// Classe abstrata que modela a estrutura b�sica de uma publica����o
abstract class Publicacao implements IPublicacao {
	int cod;
	String titulo;
	float preco_compra;
	
	public Publicacao (int c, String t, float p) {
		cod = c; titulo = t; preco_compra = p;
	}

	public float retornaPreco() {
		return preco_compra;
	}
}

// Os campos isbn (cod), titulo e pre�o de compra passam a ser
//herdados da classe abstrata 'Publicacao'
class Livro extends Publicacao {
	String autor;
	String editora;
	GregorianCalendar datapublicacao;
	
	public Livro (int i, String t, String a, String e, GregorianCalendar d, float p) {
		super(i, t, p);
		autor = a; editora = e; datapublicacao = d;
	}
}

class Revista extends Publicacao {
	int mes, ano;
	
	public Revista (int i, String t, float p, int m, int a) {
		super(i, t, p);
		mes = m;
		ano = a;
	}
}

class Gibi extends Publicacao {
	String edicao;
	
	public Gibi (int i, String t, float p, String e) {
		super(i, t, p);
		edicao = e;
	}
}

class CdDvd extends Publicacao {
	int tamanho;
	
	public CdDvd (int i, String t, float p, int tam) {
		super(i, t, p);
		tamanho = tam;
	}
}

// Classe principal que exemplifica o uso das classes declaradas
// N��o� necess�ria na solu�㍋o da quest�o !!
public class AP1_2010_1_Q3 {
	public static void main(String[] args) {
		List<Publicacao> publicacoes;
		publicacoes = new ArrayList<Publicacao> ();
		// Neste ponto ocorre a adi����o de livros, gibis, cds e dvds
		// Observe que para este trecho de c�digo sempre funcionar,
		//os objetos dentro da cole�㍋o 'publicacoes' precisam
		//saber responder ao m��todo 'retornaPreco()'
		float total = 0;
		for (Publicacao p : publicacoes) {
			total = total + p.retornaPreco();
		}
		System.out.println("Soma total de publica��es: " + total);
	}
}
