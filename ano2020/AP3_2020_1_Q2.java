package br.cederj.comp.ano2020;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um ponto
 * @author carlosbazilio
 */

class Ponto {
	protected double x, y;

	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// Método que calcula a distância entre 2 pontos
	public double getDistancia (Ponto p) {
		return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
	}
}

/**
 * Classe que representa um poligono, ou seja, uma lista de pontos
 */

class Poligono {
	private List<Ponto> pontos;
	
	public Poligono() {
		this.pontos = new ArrayList<Ponto>();
	}

	public Poligono(List<Ponto> pontos) {
		this.pontos = pontos;
	}
	
	public int getNumPontos() {
		return pontos.size();
	}
	
	// Obtém o perímetro do polígono
	public double getPerimetro() {
		double perimetro = 0;
		int pos = 0;
		while (pos < pontos.size() - 1) {
			Ponto p = pontos.get(pos);
			Ponto p2 = pontos.get(pos + 1);
			perimetro += p.getDistancia(p2);
			pos++;
		}
		Ponto p = pontos.get(0);
		return perimetro + p.getDistancia(pontos.get(pontos.size() - 1));
	}
	
	public boolean ehRegular() {
		double distancia = pontos.get(0).getDistancia(pontos.get(pontos.size() - 1));
		int pos = 1;
		while (pos < pontos.size() - 1) {
			Ponto p = pontos.get(pos);
			Ponto p2 = pontos.get(pos + 1);
			if (p.getDistancia(p2) != distancia)
				return false;
			pos++;
		}
		return true;
	}
	
	// Obtém o centróide que é o ponto médio das coordenadas do polígono
	public Ponto getCentroide() { // 2D
		Ponto retorno = null;
		double x = 0, y = 0;
		// Percorre os pontos do polígono
		for (Ponto paux : pontos) {
			x += paux.x;
			y += paux.y;
		}
		// Calcula a média para cada dimensão do ponto
		retorno = new Ponto(x / this.getNumPontos(), y / this.getNumPontos());
		return retorno;
	}
	
	public void adicionaPonto (Ponto p) {
		pontos.add(p);
	}
}

/**
 * Classe de teste para a aplicação
 */

public class AP3_2020_1_Q2 {
	public static void main(String[] args) {
		Poligono figura = new Poligono();
		figura.adicionaPonto(new Ponto(0,0));
		figura.adicionaPonto(new Ponto(0,1));
		figura.adicionaPonto(new Ponto(1,1));
		figura.adicionaPonto(new Ponto(1,0));
		System.out.println("Perimetro da figura: " + figura.getPerimetro());
		System.out.println("Figura regular: " + figura.ehRegular());
		System.out.println("Centroide da figura: (" + figura.getCentroide().x + ", " + figura.getCentroide().y + ")");
		
		Poligono figura2 = new Poligono();
		figura2.adicionaPonto(new Ponto(0,0));
		figura2.adicionaPonto(new Ponto(1,0));
		figura2.adicionaPonto(new Ponto(2,5));
		System.out.println("Perimetro da figura: " + figura2.getPerimetro());
		System.out.println("Figura regular: " + figura2.ehRegular());
		System.out.println("Centroide da figura: (" + figura2.getCentroide().x + ", " + figura2.getCentroide().y + ")");
	}
}
