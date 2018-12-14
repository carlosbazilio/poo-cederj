package br.cederj.comp.ano2017;

import java.util.ArrayList;
import java.util.List;

abstract class Comodo {
	double lado1, lado2, pe_direito;
	
	public Comodo (double l1, double l2, double a) {
		this.lado1 = l1; this.lado2 = l2; this.pe_direito = a;
	}
	
	public double perimetro() {
		return lado1 + lado2;
	}
	
	public double area() {
		return lado1 * lado2;
	}
	
	public double area_ceramica() {
		return this.area();
	}
}

class Quarto extends Comodo {
	public Quarto(double l1, double l2, double a) {
		super(l1, l2, a);
	}
}

class Cozinha extends Comodo {
	public Cozinha(double l1, double l2, double a) {
		super(l1, l2, a);
	}
	
	public double area_ceramica() {
		return 2 * this.pe_direito * (this.lado1 + this.lado2) + super.area_ceramica();
	}
}

public class AP2_2017_2_Q1 {
	public static void main(String[] args) {
		List<Comodo> apto = new ArrayList();
		apto.add(new Quarto(3, 4, 3));
		apto.add(new Cozinha(2, 3, 3));
		double quantidade_piso = 0;
		for (Comodo c : apto) {
			quantidade_piso += c.area_ceramica();
		}
		System.out.println("Área de piso necessária: " + quantidade_piso);
	}
}

