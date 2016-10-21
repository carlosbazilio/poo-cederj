package br.cederj.comp.ano2009;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Interface para um Produto que permite definirmos
 * que m�todos s�o necess�rios no nosso sistema
 * (esta interface n�o foi pedida na quest�o)
 */
interface IProduto {
	float obtemValor();
	String obtemNome();
}

/*
 * Classe produto contendo o valor e o nome do produto
 */
class Produto implements IProduto {
	private float valor;
	private String nome;
	public Produto(String n, float v) {
		nome = n;
		valor = v;
	}
	public float obtemValor() {
		return valor;
	}
	public void alteraValor (float v) {
		valor = v;
	}
	public String obtemNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}

/*
 * Classe que modela um item a ser inserido no carrinho.
 * Esta n�o foi explicitamente pedida, mas facilita a
 * cria��o da classe CarrinhoCompra
 * Al�m dos campos da classe Produto, declaramos um campo
 * quantidade, o qual define a quantidade de itens do
 * produto no carrinho
 */
class ItemCompra extends Produto {
	private int quantidade;
	public ItemCompra(String n, float v, int quant) {
		super(n, v);
		quantidade = quant;
	}
	public int obtemQuantidade () {
		return quantidade;
	}
}

/*
 * Classe que representa o estoque. Cont�m uma lista
 * de produtos e m�todos para adi��o e obten��o de um
 * produto.
 * Naturalmente, para uma modelagem mais realista, dever�amos
 * criar outros m�todos, como a remo��o de produtos
 */
class Estoque {
	private List<IProduto> produtos;
	public Estoque() {
		produtos = new ArrayList<IProduto>();
	}
	public void adicionaProduto (IProduto prod) {
		produtos.add(prod);
	}
	public IProduto obtemProduto (String nome) {
		// Forma simplificada de percorrermos uma cole��o
		// Alternativamente, poder�amos usar a interface Iterator
		for(IProduto prod : produtos) {
			if (prod.obtemNome() == nome)
				return prod;			
		}		
		return null;
	}
}

/*
 * Classe que modela um carrinho de compras.
 * Esta possui uma refer�ncia para o estoque sobre o qual
 * o carrinho se basear� e uma lista de itens
 */
class CarrinhoCompra {
	private List<ItemCompra> produtos;
	private Estoque estoque;
	public CarrinhoCompra(Estoque e) {
		produtos = new ArrayList<ItemCompra>();
		estoque = e;
	}
	public void adicionaItem (String nome, int quant) {
		IProduto prod = estoque.obtemProduto(nome);
		produtos.add(new ItemCompra(prod.obtemNome(), prod.obtemValor(), quant));
	}
	public float calculaTotal () {
		float soma = 0;
		for (ItemCompra item : produtos) {
			soma = soma + (item.obtemValor() * item.obtemQuantidade());
		}
		return soma;
	}
}

public class AP2_2009_2_Q3 {
	public static void main(String[] args) {
		Estoque produtos = new Estoque();
		produtos.adicionaProduto(new Produto ("monitor", 500));
		produtos.adicionaProduto(new Produto ("telefone", 150));
		produtos.adicionaProduto(new Produto ("teclado", 70));
		produtos.adicionaProduto(new Produto ("mouse", 50));
		
		CarrinhoCompra carrinho = new CarrinhoCompra(produtos);		
		carrinho.adicionaItem("monitor", 2);
		carrinho.adicionaItem("telefone", 5);
		carrinho.adicionaItem("teclado", 2);
		
		System.out.println("A soma dos produtos �: " + carrinho.calculaTotal());
	}
}
