package br.cederj.comp.ano2011;

import java.util.ArrayList;
import java.util.List;

class Ponto {
	protected double x, y;

	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getDistancia (Ponto p) {
		return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
	}
}

class Ponto3D extends Ponto {
	private double z;

	public Ponto3D(double x, double y, double z) {
		super(x, y);
		this.z = z;
	}
	
	public double getDistancia (Ponto ponto) {
		Ponto3D p = (Ponto3D) ponto;
		return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2) + Math.pow(p.z - this.z, 2));
	}
}

class Poligono<T extends Ponto> {
	private List<T> pontos;
	
	public Poligono() {
		this.pontos = new ArrayList<T>();
	}

	public Poligono(List<T> pontos) {
		this.pontos = pontos;
	}
	
	public int getNumPontos() {
		return pontos.size();
	}
	
	public double getPerimetro() {
		double perimetro = 0;
		int pos = 0;
		while (pos < pontos.size() - 1) {
			T p = pontos.get(pos);
			T p2 = pontos.get(pos + 1);
			perimetro += p.getDistancia(p2);
			pos++;
		}
		T p = pontos.get(0);
		return perimetro + p.getDistancia(pontos.get(pontos.size() - 1));
	}
	
	public Ponto getCentroide() { // 2D
		Ponto retorno = null;
		double x = 0, y = 0;
		for (Ponto paux : pontos) {
			x += paux.x;
			y += paux.y;
		}
		retorno = new Ponto(x / this.getNumPontos(), y / this.getNumPontos());
		return retorno;
	}
	
	public void adicionaPonto (T p) {
		pontos.add(p);
	}
}

public class CopyOfAP3_2011_1_Q2 {
	public static void main(String[] args) {
		Poligono<Ponto3D> figura = new Poligono<Ponto3D>();
		figura.adicionaPonto(new Ponto3D(0,0,0));
		figura.adicionaPonto(new Ponto3D(0,0,1));
		System.out.println("Perimentro da figura: " + figura.getPerimetro());
	}
}
