package br.cederj.comp.ano2010;

interface ObjetoManipulavel {
	double perimetro();
	double area();
}

interface Objeto3D extends ObjetoManipulavel {
	double altura();
	double volume();
}

abstract class Objeto3DImpl implements Objeto3D {
	public double volume() {
		return this.area() * this.altura();
	}
}

class Quadrilatero implements ObjetoManipulavel {
	double lado1, lado2, lado3, lado4;
	public Quadrilatero(double l1, double l2, double l3, double l4) {
		lado1 = l1; lado2 = l2; lado3 = l3; lado4 = l4; 
	}
	public double perimetro () {
		return lado1 + lado2 + lado3 + lado4;
	}
	public double area() {
		return ((lado1 + lado2) / 2) * ((lado3 + lado4) / 2); // Cálculo aproxima do quadrilátero
	}
}

class Retangulo extends Quadrilatero {	
	public Retangulo(double b, double h) {
		super(b, h, b, h);
	}
	public void exibe() {
		System.out.println("Retangulo com lados " + lado1 + " e " + lado2);
	}
	public double area() {
		return lado1 * lado2;
	}
}

class Circulo implements ObjetoManipulavel {
	double raio;
	public Circulo(double r) {
		raio = r;
	}
	public void exibe() {
		System.out.println("Circulo com raio " + raio);
	}
	public double perimetro () {
		return 2 * 3.14 * raio;
	}
	public double area() {
		return 3.14 * raio * raio;
	}
}

class Quadrado extends Retangulo {
	public Quadrado(double l) {
		super(l, l);
	}	
}

class Cilindro extends Circulo implements Objeto3D {
	private double altura;
	public Cilindro(double a, double r) {
		super(r);
		altura = a;
	}

	public double volume() {
		return this.area() * altura;
	}

	public double altura() {
		return 0;
	}
}

class Caixa extends Retangulo implements Objeto3D {
	private double altura;
	public Caixa(double l1, double l2, double a) {
		super(l1, l2);
		altura = a;
	}

	public double volume() {
		return this.area() * altura;
	}

	public double altura() {
		return altura;
	}
}

public class AP2_2010_1_Q1 {
	public static void main(String[] args) {
	}
}
