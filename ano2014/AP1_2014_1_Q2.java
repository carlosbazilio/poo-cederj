package br.cederj.comp.ano2014;

class Ponto {
	private double x, y;

	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
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
	
	public Ponto3D diferenca (Ponto3D p) {
		return new Ponto3D (p.getX() - this.getX(), p.getY() - this.getY(), p.getZ() - this.getZ());
	}
	
	public Ponto3D diferenca (double x, double y, double z) {
		return new Ponto3D (x - this.getX(), y - this.getY(), z - this.getZ());
	}
	
	public double distancia (Ponto3D p) {
		return Math.sqrt(Math.pow(p.getX() - this.getX(), 2) + 
				         Math.pow(p.getY() - this.getY(), 2) + 
				         Math.pow(p.getZ() - this.getZ(), 2));
	}
}

public class AP1_2014_1_Q2 {
	public static void main(String[] args) {

	}
}
