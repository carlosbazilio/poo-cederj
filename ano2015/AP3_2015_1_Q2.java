package br.cederj.comp.ano2015;

import java.util.ArrayList;
import java.util.List;

// item a)
// Poderia ser uma classe abstrata ou até uma classe
//concreta. Entretanto, como não havia restrição no 
//código, uma interface seria o recurso recomendado
//neste caso
interface Produto {
	double getValor();
}

// item b)
// Como nada além era exigido, além de ser um tipo de
//produto, nada além era necessário. Entretanto, poderia
//se colocar mais detalhes, desde que estes fossem
//corretamente manipulados
class Mouse implements Produto {
	public double getValor() {
		return 10;
	}
}

// item c)
// Idem ao item acima
class Teclado implements Produto {
	public double getValor() {
		return 30;
	}
}

// item d)
// Além deste possuir uma lista de produtos, computadores
//completos também podem ser inseridos no carrinho. Ou seja,
//ambos devem se comportar como produtos
class Computador implements Produto {
	List<Produto> pecas;
	public Computador(List<Produto> p) {
		this.pecas = p;
	}
	public double getValor() {
		double aux = 0;
		for (Produto p : pecas)
			aux = aux + p.getValor();
		return aux;
	}
}

// Classe fornecida no enunciado
class Carrinho {
	List <Produto> produtos;
	public Carrinho() {
		produtos = new ArrayList<Produto>();
	}
	public void adicionaProduto (Produto p) {
		produtos.add(p);
	}
	public double somaTotal() {
		double aux = 0;
		for (Produto p : produtos) {
			aux = aux + p.getValor();
		}
		return aux;
	}
}

// Item e)
// Era necessário que se criasse, ao menos, um objeto
//de cada classe manipulada
public class AP3_2015_1_Q2 { 
	public static void main(String[] args) {
		Produto m = new Mouse();
		Produto t = new Teclado();
		List<Produto> pecas = new ArrayList<Produto>();
		pecas.add(m);
		pecas.add(t);
		Produto c = new Computador(pecas);
		Produto m2 = new Mouse();
		Produto t2 = new Teclado();
		Carrinho carrinho = new Carrinho();
		carrinho.adicionaProduto(c);
		carrinho.adicionaProduto(m2);
		carrinho.adicionaProduto(t2);
		System.out.println("A soma dos produtos no carrinho é: " + carrinho.somaTotal());
    }
}
