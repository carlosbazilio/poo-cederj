package br.cederj.comp.ano2013;

import java.util.ArrayList;
import java.util.List;


// item c)
interface FiguraGeom {
	double perimetro();
	double area();
}

abstract class Quadrilatero implements FiguraGeom {
	double lado1, lado2, lado3, lado4;
	public Quadrilatero(double l1, double l2, double l3, double l4) {
		lado1 = l1; lado2 = l2; lado3 = l3; lado4 = l4; 
	}
	// item b)
	public double perimetro() {
		return lado1 + lado2 + lado3 + lado4;
	}
}

class Retangulo extends Quadrilatero {	
	public Retangulo(double b, double h) {
		super(b, h, b, h);
	}
	// item b)
	public double area() {
		return lado1 * lado2;
	}
}

// item a)
class Quadrado extends Retangulo {
	public Quadrado(double l) {
		super(l, l);
	}	
}

// item a)
class Circulo implements FiguraGeom {
	double raio;
	public Circulo(double r) {
		raio = r;
	}
	// item b)
	public double area() {
		return Math.PI * Math.pow(raio, 2);
	}
	// item b)
	public double perimetro() {
		return 2 * Math.PI * raio;
	}	
}

interface FiguraGeom3D {
	double volume();
}

class Cubo extends Retangulo implements FiguraGeom3D {
	double altura;
	
	public Cubo(double b, double h, double alt) {
		super(b, h);
		altura = alt;
	}
	
	public double volume() {
		return this.area() * altura;
	}
}

class Cilindro extends Circulo implements FiguraGeom3D {
	double altura;
	
	public Cilindro(double r, double alt) {
		super(r);
		altura = alt;
	}
	
	public double volume() {
		return this.area() * altura;
	}	
}

public class AP3_2013_1_Q2 {
	public static void main(String[] args) {
		double soma = 0;
		List<FiguraGeom> objetos = new ArrayList();
		objetos.add(new Quadrado(5));
		objetos.add(new Retangulo(2,3));
		objetos.add(new Circulo(7));
		for (FiguraGeom fig : objetos) {
			soma = soma + fig.perimetro();
		}
		System.out.println("A soma dos perimetros e: " + soma);
	}
}
