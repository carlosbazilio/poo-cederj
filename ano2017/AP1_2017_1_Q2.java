package br.cederj.comp.ano2017;

// item b)
interface Bem {
	double retornaValor();
}

class Apto /* item b) */ implements Bem {
	int codigo, numQuartos;
	double metragem, preco;
	
	public Apto(int codigo, int numQuartos, double metragem, double preco) {
		this.codigo = codigo;
		this.numQuartos = numQuartos;
		this.metragem = metragem;
		this.preco = preco;
	}

	// item b)
	public double retornaValor() {
		return preco;
	}
}

class Carro /* item b) */ implements Bem {
	int codigo;
	String nome;
	int ano;
	double valor;
	
	public Carro(int codigo, String nome, int ano, double valor) {
		this.codigo = codigo;
		this.nome = nome;
		this.ano = ano;
		this.valor = valor;
	}

	// item b)
	public double retornaValor() {
		return valor;
	}
}

public class AP1_2017_1_Q2 {
	public static void main(String[] args) {
		//item a)
		Apto apto = new Apto(1, 3, 100, 500);
		Carro carro = new Carro(2, "Lamborghini", 2016, 1000);
		
		//item b)
        Bem[] shapes = new Bem[2];
        shapes[0] = apto; 
        shapes[1] = carro;
        double soma = 0;
        for (int i=0; i<shapes.length; i++)
        	soma = soma + shapes[i].retornaValor();
        System.out.println("O valor da soma é: " + soma);
	}
}
