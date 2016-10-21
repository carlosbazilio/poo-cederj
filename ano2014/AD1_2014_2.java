package br.cederj.comp.ano2014;

import java.util.Calendar;
import java.util.GregorianCalendar;

class Cliente {
	String nome;
	String telefone;
	String endereco;
	
	public Cliente(String nome, String telefone, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}
}

class Pedido {
	int numero;
	Cliente cliente;
	GregorianCalendar data;
	private double preco;
	
	public Pedido(int numero, Cliente cliente, double preco, GregorianCalendar data) {
		this.numero = numero;
		this.cliente = cliente;
		this.preco = preco;
		this.data = data;
	}
	
	public double getPreco () {
		return preco;
	}
	
	public String toString() {
		return "Num: " + numero + ", Cliente: " + cliente.nome + ", Preco: " + this.getPreco();
	}
}

class PedidoExpresso extends Pedido {
	GregorianCalendar dataEntrega;
	
	public PedidoExpresso(int numero, Cliente cliente, double preco,
			GregorianCalendar data) {
		super(numero, cliente, preco, data);
		dataEntrega = null;
	}

	public double getPreco () {
		return super.getPreco() * 1.2;
	}
	
	public void setDataEntrega (GregorianCalendar data) {
		this.dataEntrega = data;
	}
	
	public boolean noPrazo () {
		if (dataEntrega != null)
			return (this.data.get(Calendar.DATE) == dataEntrega.get(Calendar.DATE)) &&
			       (this.data.get(Calendar.MONTH) == dataEntrega.get(Calendar.MONTH)) &&
			       (this.data.get(Calendar.YEAR) == dataEntrega.get(Calendar.YEAR));
		return true;
	}
	
	public String toString() {
		String inicial = super.toString() + ", No prazo: ";
		if (this.noPrazo())
			inicial = inicial + "SIM";
		else
			inicial = inicial + "NAO";
		return inicial;
	}
}

public class AD1_2014_2 {
	public static void main(String[] args) {
		Cliente c1 = new Cliente ("Fulano", "Rua A", "9999");
		Cliente c2 = new Cliente ("Beltrano", "Rua B", "8888");
		
		Pedido p1 = new Pedido(1, c1, 500, new GregorianCalendar());
		PedidoExpresso p2 = new PedidoExpresso(2, c2, 500, new GregorianCalendar());
		p2.setDataEntrega(new GregorianCalendar());
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}
}
