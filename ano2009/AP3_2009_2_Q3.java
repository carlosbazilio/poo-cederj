package br.cederj.comp.ano2009;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

abstract class ObjetoBasico {
	int pos_x, pos_y;
	public ObjetoBasico(int x, int y) {
		pos_x = x;
		pos_y = y;
	}
	abstract public void desenha (Graphics g, JFrame frame);
}

class Olimpiada extends ObjetoBasico {
	int raio;
	public Olimpiada(int x, int y, int r) {
		super(x, y);
		raio = r;
	}
	public void desenha (Graphics g, JFrame frame) {
		Graphics2D g2d = (Graphics2D)g;
		int x = pos_x;
		int x2 = pos_x + (raio/4);
		int y = pos_y;
        g2d.drawOval(x, y, raio, raio);
        g2d.drawOval(x = x + (raio/2), y, raio, raio);
        g2d.drawOval(x = x + (raio/2), y, raio, raio);
        g2d.drawOval(x2, y = y + (raio/2), raio, raio);
        g2d.drawOval(x2 = x2 + (raio/2), y, raio, raio);
	}
}

class Audi extends ObjetoBasico {
	int raio;
	public Audi(int x, int y, int r) {
		super(x, y);
		raio = r;
	}
	public void desenha (Graphics g, JFrame frame) {
		Graphics2D g2d = (Graphics2D)g;
		int x = pos_x;
		int y = pos_y;
        g2d.drawOval(x, y, raio, raio);
        g2d.drawOval(x = x + (raio/2), y, raio, raio);
        g2d.drawOval(x = x + (raio/2), y, raio, raio);
        g2d.drawOval(x = x + (raio/2), y, raio, raio);
	}
}

class Janela extends JFrame {
	List<ObjetoBasico> figuras;
	public Janela(List l) {
		// Atribui título da janela
		this.setTitle("Figuras Geométricas");
		// Define tamanho padrão da janela
		this.setBounds(0, 0, 800, 600);
		// Termina o processo no fechamando da janela
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		figuras = l;
	}
	public void paint(Graphics g) {
		super.paint(g);
        
        // Desenho dos objetos do jogo
        for (ObjetoBasico figura : figuras)
        	figura.desenha(g, this);
	}
}

public class AP3_2009_2_Q3 {
	public static void main(String[] args) {
		List<ObjetoBasico> figuras = new ArrayList<ObjetoBasico>();
		figuras.add(new Olimpiada(300, 150, 50));
		figuras.add(new Audi(200, 200, 30));
		figuras.add(new Audi(300, 300, 30));
		(new Janela(figuras)).setVisible(true);
	}
}
