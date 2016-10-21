package br.cederj.comp.ano2012;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos Bazilio
 */

interface Figura {
	void moveCima ();
	void moveBaixo ();
	void moveEsq ();
	void moveDir ();
	void desloca (Point pos);
	void desenha ();
}

class Retangulo implements Figura {
	Point lados[];
	
	public Retangulo(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		lados = new Point[4];
		lados[0] = new Point(x1, y1);
		lados[1] = new Point(x2, y2);
		lados[2] = new Point(x3, y3);
		lados[3] = new Point(x4, y4);
	}
	
	public void moveCima() {
		for (Point p : lados) {
			p.y = p.y - 1;
		}
	}

	public void moveBaixo() {
		for (Point p : lados) {
			p.y = p.y + 1;
		}
	}

	public void moveEsq() {
		for (Point p : lados) {
			p.x = p.x - 1;
		}
	}

	public void moveDir() {
		for (Point p : lados) {
			p.x = p.x + 1;
		}
	}

	public void desloca (Point pos) {
		for (Point p : lados) {
			p.x = p.x + pos.x;
			p.y = p.y + pos.y;
		}
	}

	public void desenha() {
		System.out.println("Retangulo: ");
		for (Point p : lados) {
			System.out.println("(" + p.x + "," + p.y + ")");
		}
	}
}

class Circulo implements Figura {
	double raio;
	Point centro;
	
	public Circulo(double raio, int x, int y) {
		this.raio = raio;
		this.centro = new Point(x, y);
	}

	public void moveCima() {
		centro.y = centro.y - 1;
	}

	public void moveBaixo() {
		centro.y = centro.y + 1;
	}

	public void moveEsq() {
		centro.x = centro.x - 1;
	}

	public void moveDir() {
		centro.x = centro.x + 1;
	}

	public void desloca(Point pos) {
		centro.x = centro.x + pos.x;
		centro.y = centro.y + pos.y;
	}

	public void desenha() {
		System.out.println("Circulo:");
		System.out.println("(" + centro.x + "," + centro.y + ")" + " Raio: " + raio);
	}
}

/**
 * Classe de teste da classe intervalo 
 * @author Carlos Bazilio
 */
public class AP2_2012_1_Q3 {
	public static void main(String[] args) {
		List<Figura> objetos = new ArrayList<Figura>();
		Retangulo r = new Retangulo(1, 1, 1, 2, 3, 1, 3, 2);
		Circulo c = new Circulo(2.5, 4, 4);
		objetos.add(r);
		objetos.add(c);
		r.moveBaixo();
		Point pos10 = new Point(10,10);
		for (Figura f : objetos) {
			f.desloca(pos10);
			f.desenha();
		}
	}
}
