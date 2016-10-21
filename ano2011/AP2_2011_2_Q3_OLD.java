package br.cederj.comp.ano2011;

interface Objeto2D {
	double area();
}

interface Objeto3D {
	double volume();
}

class Retangulo implements Objeto2D {
	double lado1, lado2;
	public Retangulo(double l1, double l2) {
		lado1 = l1; lado2 = l2;
	}
	public double perimetro () {
		return 2*lado1 + 2*lado2;
	}
	public double area() {
		return lado1 * lado2;
	}
	public boolean comparaArea (Objeto2D o) {
		return this.area() >= o.area();
	}
}

class Circulo implements Objeto2D {
	double raio;
	public Circulo(double r) {
		raio = r;
	}
	public double perimetro () {
		return 2 * 3.14 * raio;
	}
	public double area() {
		return 3.14 * raio * raio;
	}
	public boolean comparaArea (Objeto2D o) {
		return this.area() >= o.area();
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
	public boolean comparaVolume (Objeto3D o) {
		return this.volume() >= o.volume();
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
	public double area() {
		return 2*(lado1*lado2 + altura*lado1 + altura*lado2);
	}
	public boolean comparaVolume (Objeto3D o) {
		return this.volume() >= o.volume();
	}
}

public class AP2_2011_2_Q3_OLD {
	public static void main(String[] args) {
	}
}
