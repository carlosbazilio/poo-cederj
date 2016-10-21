package br.cederj.comp.ano2016;

import java.util.ArrayList;
import java.util.List;

class CarrinhoDeCompras2 {
	List<Produto> produtos;

	public CarrinhoDeCompras2() {
		produtos = new ArrayList<Produto>();
	}
	
	public void adiciona (Produto p) {
		produtos.add(p);
	}
	
	public double soma () {
		double s = 0;
		for (Produto p : produtos)
			s = s + p.getPreco();
		return s;
	}
	
	public boolean retira (int cod) {
		for (Produto p : produtos) {
			if (p.getCodigo() == cod) {
				produtos.remove(p);
				return true;
			}
		}
		return false;
	}
}

public class AP2_2016_2_Q1 {
	public static void main(String[] args) {
		Produto tv = new Produto(1, "TV Plasma", 1500);
		Produto geladeira = new Produto(2, "Geladeira Frost Free", 1000);
		Produto sofa = new Produto(3, "Sofa 3 lugares", 500);
		CarrinhoDeCompras2 carrinho = new CarrinhoDeCompras2();
		carrinho.adiciona(tv);
		carrinho.adiciona(geladeira);
		carrinho.adiciona(sofa);
		System.out.println("Valor do carrinho: " + carrinho.soma());
		carrinho.retira(2);
		System.out.println("Valor do carrinho: " + carrinho.soma());
		
	}
}
