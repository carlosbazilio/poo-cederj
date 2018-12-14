package br.cederj.comp.ano2018;

class Conta {
	private int numero;
	private double saldo;
	String nome;
	
	public Conta(int numero, double saldo, String nome) {
		this.numero = numero;
		this.saldo = saldo;
		this.nome = nome;
	}
	
	public void debito(double v) {
		if (this.saldo >= v) {
			this.saldo -= v;
		}
	}
	
	public void credito(double v) {
		this.saldo += v;
	}
	
	public double saldo() {
		return this.saldo;
	}
}

class Especial extends Conta {
	private double valor;
	public Especial(int numero, double saldo, String nome, double valor) {
		super(numero, saldo + valor, nome);
		this.valor = valor;
	}
}

class TesteConta {
	public void test() {
		Conta c = new Conta(1, 100, "Fulano");
		assert(c.saldo() == 100);
		c.credito(150);
		assert(c.saldo() == 250);
		c.debito(300);
		assert(c.saldo() == 150);
		
		Conta ce = new Especial(2, 100, "Ciclano", 50);
		assert(ce.saldo() >= 100);
		ce.credito(150);
		assert(ce.saldo() >= 250);
		ce.debito(200);
		assert(ce.saldo() >= 0);
	}
}

public class AP2_2018_1_Q3 {
	public static void main(String[] args) {
		TesteConta t = new TesteConta();
		t.test();
	}
}



