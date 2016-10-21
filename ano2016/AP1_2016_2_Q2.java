package br.cederj.comp.ano2016;

class CarrinhoDeCompras {
	Produto produtos[];
	int ultimo = 0;

	public CarrinhoDeCompras() {
		produtos = new Produto[1000];
	}
	
	public void adiciona (Produto p) {
		produtos[ultimo] = p;
		ultimo++;
	}
	
	public double soma () {
		double s = 0;
		for (int i=0; i<ultimo; i++)
			s = s + produtos[i].getPreco();
		return s;
	}
}

public class AP1_2016_2_Q2 {
	public static void main(String[] args) {
		Produto tv = new Produto(1, "TV Plasma", 1500);
		Produto geladeira = new Produto(2, "Geladeira Frost Free", 1000);
		Produto sofa = new Produto(3, "Sofa 3 lugares", 500);
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adiciona(tv);
		carrinho.adiciona(geladeira);
		carrinho.adiciona(sofa);
		System.out.println("Valor do carrinho: " + carrinho.soma());
	}
}
