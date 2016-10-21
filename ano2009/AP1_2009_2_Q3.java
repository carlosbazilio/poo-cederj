package br.cederj.comp.ano2009;

interface ObjetoManipulavel {
	double perimetro();
	double area(); // AD2
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

public class AP1_2009_2_Q3 {
	public static void main(String[] args) {
	}
}
