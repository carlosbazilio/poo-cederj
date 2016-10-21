package br.cederj.comp.ano2011;

import java.util.ArrayList;
import java.util.List;

class Pedido {
	int codPrato;
	double precoPrato;
	public Pedido(int codPrato, double precoPrato) {
		this.codPrato = codPrato;
		this.precoPrato = precoPrato;
	}
	
	public double getPrecoPrato() {
		return precoPrato;
	}
}

class PedidoViagem extends Pedido {
	String telefone;

	public PedidoViagem(int codPrato, double precoPrato, String tel) {
		super(codPrato, precoPrato);
		this.telefone = tel;
	}
	
	public double getPrecoPrato() {
		return super.getPrecoPrato()*1.1;
	}
}

class PedidoLocal extends Pedido {
	int mesa;

	public PedidoLocal(int codPrato, double precoPrato, int mesa) {
		super(codPrato, precoPrato);
		this.mesa = mesa;
	}	
}

public class AP2_2011_2_Q3 {
	public static void main(String[] args) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(new PedidoLocal(1, 50.0, 1));
		pedidos.add(new PedidoLocal(2, 20.0, 1));
		pedidos.add(new PedidoLocal(3, 100.0, 1));
		pedidos.add(new PedidoViagem(1, 50.0, "9999-9999"));
		pedidos.add(new PedidoViagem(2, 20.0, "8888-8888"));
		double soma = 0;
		for (Pedido p : pedidos) {
			soma = soma + p.getPrecoPrato();
		}
		System.out.println("A soma eh: " + soma);
	}
}
