package br.cederj.comp.ano2017;

class Ponto {
	private double x, y;
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// Necessário para acessar os campos na classe Ponto3D
	public double getX() { return x; };
	public double getY() { return y; };
}

class Ponto3D extends Ponto {
	private double z;

	public Ponto3D(double x, double y, double z) {
		super(x, y);
		this.z = z;
	}
	
	public double getZ() { return z; };
	
	// item a) OU ...
	public Ponto3D diferenca (Ponto3D p) {
		return new Ponto3D (p.getX() - this.getX(), p.getY() - this.getY(), p.getZ() - this.getZ());
	}
	// ... item a)
	public Ponto3D diferenca (double x, double y, double z) {
		return new Ponto3D (x - this.getX(), y - this.getY(), z - this.getZ());
	}
	// item b)
	public double distancia (Ponto3D p) {
		return Math.sqrt(Math.pow(p.getX() - this.getX(), 2) + 
				         Math.pow(p.getY() - this.getY(), 2) + 
				         Math.pow(p.getZ() - this.getZ(), 2));
	}
	
	public static double distancia (Ponto3D p, Ponto3D q) {
		return Math.sqrt(Math.pow(p.getX() - q.getX(), 2) + 
				         Math.pow(p.getY() - q.getY(), 2) + 
				         Math.pow(p.getZ() - q.getZ(), 2));
	}
}

public class AP1_2017_1_Q3 {
	public static void main(String[] args) {
	}
}
