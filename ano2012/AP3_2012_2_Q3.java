package br.cederj.comp.ano2012;

import java.util.ArrayList;
import java.util.List;

interface IObjetoGeom {
	double perimetro();
}

class Quadrilater implements IObjetoGeom {
	protected double lado1, lado2, lado3, lado4;
	public Quadrilater(double l1, double l2, double l3, double l4) {
		lado1 = l1; lado2 = l2; lado3 = l3; lado4 = l4; 
	}
	public double perimetro() {
		return lado1 + lado2 + lado3 + lado4;
	}
}

class Retangul extends Quadrilater {	
	public Retangul(double b, double h) {
		super(b, h, b, h);
	}
	public void exibe() {
		System.out.println("Retangulo com lados " + lado1 + " e " + lado2);
	}
}

class Quadrad extends Retangul {
	public Quadrad(double l) {
		super(l, l);
	}
}

class Circul implements IObjetoGeom {
	protected double raio;
	public Circul(double raio) {
		this.raio = raio;
	}
	public double perimetro() {
		return 2*raio*Math.PI;
	}
}

public class AP3_2012_2_Q3 {
	public static void main(String[] args) {
		List<IObjetoGeom> figuras = new ArrayList<IObjetoGeom>();
		figuras.add(new Quadrilater(2, 2, 4, 4));
		figuras.add(new Retangul(3, 5));
		figuras.add(new Quadrad(7));
		figuras.add(new Circul(6));
		double soma = 0;
		for (IObjetoGeom f : figuras) {
			soma = soma + f.perimetro();
		}
		System.out.println("A soma dos perimetros dos objetos e: " + soma);
	}
}
