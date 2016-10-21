package br.cederj.comp.ano2008;

import java.util.*;

interface FiguraGeom {
	double perimetro();
	double area();
	void exibe();
}

abstract class Quadrilatero implements FiguraGeom {
	double lado1, lado2, lado3, lado4;
	public Quadrilatero(double l1, double l2, double l3, double l4) {
		lado1 = l1; lado2 = l2; lado3 = l3; lado4 = l4; 
	}
	public double perimetro() {
		return lado1 + lado2 + lado3 + lado4;
	}
}

class Retangulo extends Quadrilatero {	
	public Retangulo(double b, double h) {
		super(b, h, b, h);
	}
	public double area() {
		return lado1 * lado2;
	}
	public void exibe() {
		System.out.println("Retangulo com lados " + lado1 + " e " + lado2);
	}	
}

class Quadrado extends Retangulo {
	public Quadrado(double l) {
		super(l, l);
	}	
}

class Circulo implements FiguraGeom {
	double raio;
	public Circulo(double r) {
		raio = r;
	}
	public double area() {
		return Math.PI * Math.pow(raio, 2);
	}
	public double perimetro() {
		return 2 * Math.PI * raio;
	}
	public void exibe() {
		System.out.println("Circulo com raio " + raio);
	}	
}

/*
 Classe principal 
 */
public class AP3_2008_2_Q4_Reposicao {
	public static void main(String[] args) {
		List<FiguraGeom> figuras = new ArrayList<FiguraGeom>();
		FiguraGeom f1 = new Retangulo(10, 15);
		FiguraGeom f2 = new Quadrado(8);
		FiguraGeom f3 = new Retangulo(8, 15);
		FiguraGeom f4 = new Circulo(7);
		figuras.add(f1);
		figuras.add(f2);
		figuras.add(f3);
		figuras.add(f4);
		for (FiguraGeom f : figuras) {
			System.out.print("Perimetro: " + f.perimetro());
			System.out.println(" Area: " + f.area() + "\n");
		}
	}
}
