package br.cederj.comp.ano2019;

import java.util.ArrayList;
import java.util.List;

class Produto {
	int codigo;
	String nome;
	private double preco;
	public Produto(int c, String n, double p) {
		this.codigo = c; this.nome = n; this.preco = p;
	}
	public double getPreco() {
		return preco;
	}
}

class ProdutoImportado extends Produto {
	String paisOrigem;
	public ProdutoImportado(int c, String n, double p, String pais) {
		super(c,n,p);
		this.paisOrigem = pais;
	}
	public double getPreco() {
		return super.getPreco() * 1.2;
	}
}

class CarrinhoDeCompras {
	List<Produto> produtos;

	public CarrinhoDeCompras() {
		produtos = new ArrayList<Produto>();
	}

	public void adiciona(Produto p) {
		produtos.add(p);
	}

	public double soma() {
		double s = 0;
		for (Produto p : produtos)
			s = s + p.getPreco();
		return s;
	}

	public boolean retira(int cod) {
		for (Produto p : produtos) {
			if (p.codigo == cod) {
				produtos.remove(p);
				return true;
			}
		}
		return false;
	}
}

public class AP3_2019_2_Q2 {
	public static void main(String[] args) {
		Produto tv = new Produto(1, "TV Plasma", 1500);
		Produto geladeira = new Produto(2, "Geladeira Frost Free", 1000);
		Produto sofa = new Produto(3, "Sofa 3 lugares", 500);
		Produto celular = new ProdutoImportado(4, "Celular", 3000, "China");
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adiciona(tv);
		carrinho.adiciona(geladeira);
		carrinho.adiciona(sofa);
		carrinho.adiciona(celular);
		System.out.println("Valor do carrinho: " + carrinho.soma());
	}
}
