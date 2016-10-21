package br.cederj.comp.ano2008;

class Ponto3D {
	private double x, y, z;
	public Ponto3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public Ponto3D diferenca (Ponto3D ponto) {
		return new Ponto3D(this.getX() - ponto.getX(),
						   this.getY() - ponto.getY(),
						   this.getZ() - ponto.getZ());
	}
	public Ponto3D diferenca (double x, double y, double z) {
		return this.diferenca(new Ponto3D(x, y, z));
	}
	public boolean intercepta (Ponto3D ponto) {
		if ((this.getX() >= ponto.getX()-3 && this.getX() <= ponto.getX()+3) &&
			(this.getY() >= ponto.getY()-3 && this.getY() <= ponto.getY()+3) &&
			(this.getZ() >= ponto.getZ()-3 && this.getZ() <= ponto.getZ()+3))
			return true;
		return false;
	}
	public boolean intercepta (double x, double y, double z) {
		return this.intercepta(new Ponto3D(x, y, z));
	}
}

public class AP3_2008_2_Q4 {
	public static void main(String[] args) {
	}	
}
