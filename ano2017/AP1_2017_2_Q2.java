package br.cederj.comp.ano2017;

class Ingrediente {
	String nome;
	int quantidade;
	String unidade; // litro, gramas, colher de chá, etc 
	
	// a)
	public Ingrediente(String nome, int quantidade, String unidade) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidade = unidade;
	}
	
	public Ingrediente(String nome) {
		this(nome, (int)(Math.random()*100), "qualquer");
	}
}

class Receita {
	Ingrediente ingredientes[];
	int numIngredientes;
	
	// a)
	public Receita(int num) {
		ingredientes = new Ingrediente[num];
		numIngredientes = 0;
	}
	
	// b)
	public void adicionar (Ingrediente i) {
		if (numIngredientes < ingredientes.length) {
			ingredientes[numIngredientes] = i;
			numIngredientes++;
		}
	}
	
	public void aquecer () {}
	public void fritar () {}
	public void ferver () {}
	public void mexer () {}
	public void encerrar (boolean seco) {}
}

public class AP1_2017_2_Q2 {
	public static void main(String[] args) {
		Ingrediente oleo = new Ingrediente("Oleo", 50, "ml");
		
		// c)
		Ingrediente cebola = new Ingrediente("Cebola");
		Ingrediente alho = new Ingrediente("Alho");
		Ingrediente sal = new Ingrediente("Sal");
		Ingrediente arroz = new Ingrediente("Arroz", 2, "xícara");
		Ingrediente agua = new Ingrediente("Agua", 4, "xícara");
		
		Receita arrozSimples = new Receita (6);
		arrozSimples.adicionar(oleo);
		arrozSimples.aquecer();
		arrozSimples.adicionar(alho);
		arrozSimples.adicionar(cebola);
		arrozSimples.fritar();
		arrozSimples.adicionar(agua);
		arrozSimples.adicionar(sal);
		arrozSimples.ferver();
		arrozSimples.adicionar(arroz);
		arrozSimples.mexer();
		arrozSimples.encerrar(true);
	}
}
