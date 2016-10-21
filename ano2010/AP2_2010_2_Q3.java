package br.cederj.comp.ano2010;

import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

abstract class Peca {
	static enum Cor {preta, branca};
	Cor tipo;
	Image imagem;
	
	public Peca(Cor c) {
		tipo = c;
		imagem = null;
	}
	
	public Image getImagem() { return imagem; };
}

class Peao extends Peca {
	public Peao(Cor c) {
		super(c);
	}
}

class Torre extends Peca {
	public Torre(Cor c) {
		super(c);
	}
}

class Cavalo extends Peca {
	public Cavalo(Cor c) {
		super(c);
		try { 
			// A imagem pode ser carregada de qualquer local. 
			// Neste caso, apenas como exemplo, é uma URL
			URL url = new URL("http://xadrez.com//cavalo.gif"); 
			imagem = ImageIO.read(url); 
		} catch (IOException e) { }
	}

	public boolean movimentoValido (int x, int y, int x2, int y2) {
		if ((((x+1 == x2) && (y-2 == y2)) ||
			 ((x+2 == x2) && (y-1 == y2)) ||
			 ((x+2 == x2) && (y+1 == y2)) ||
			 ((x+1 == x2) && (y+2 == y2)) ||
			 ((x-1 == x2) && (y+2 == y2)) ||
			 ((x-2 == x2) && (y+1 == y2)) ||
			 ((x-2 == x2) && (y-1 == y2)) ||
			 ((x-1 == x2) && (y-2 == y2)))
			 && Tabuleiro.posicaoValida(x2, y2))
			return true;
		return false;
	}
}

class Bispo extends Peca {
	public Bispo(Cor c) {
		super(c);
	}
}

class Dama extends Peca {
	public Dama(Cor c) {
		super(c);
	}
}

class Rei extends Peca {
	public Rei(Cor c) {
		super(c);
	}
}

class Tabuleiro {
	Peca tabuleiro [][];
	
	public Tabuleiro() {
		tabuleiro = new Peca[8][8];
	}
	
	public static boolean posicaoValida(int x, int y) {
		return (x >= 1 && x <= 8 && y >= 1 && y <= 8) ? true : false;
	}

	public static boolean posicaoValida(Point p) {
		return Tabuleiro.posicaoValida(p.x, p.y);
	}

	public void atribui(int i, int j, Peca peca) {
		tabuleiro[i][j] = peca;
	}
}

class JogoXadrez {
	Tabuleiro tabuleiro;
	List<Peca> pecasCapturadasJogadorPreto;
	List<Peca> pecasCapturadasJogadorBranco;
	
	public JogoXadrez() {
		pecasCapturadasJogadorBranco = new ArrayList<Peca>();
		pecasCapturadasJogadorPreto = new ArrayList<Peca>();
		tabuleiro = new Tabuleiro();
		
		// Pe›ões
		for (int j=0;j<8;j++) {
			tabuleiro.atribui(1, j, new Bispo(Peca.Cor.preta));
			tabuleiro.atribui(6, j, new Bispo(Peca.Cor.branca));
		}
		
		// Torres
		tabuleiro.atribui(0, 0, new Torre(Peca.Cor.preta));
		tabuleiro.atribui(0, 7, new Torre(Peca.Cor.preta));
		tabuleiro.atribui(7, 0, new Torre(Peca.Cor.branca));
		tabuleiro.atribui(7, 7, new Torre(Peca.Cor.branca));
	
		// Cavalos
		tabuleiro.atribui(0, 1, new Cavalo(Peca.Cor.preta));
		tabuleiro.atribui(0, 6, new Cavalo(Peca.Cor.preta));
		tabuleiro.atribui(7, 1, new Cavalo(Peca.Cor.branca));
		tabuleiro.atribui(7, 6, new Cavalo(Peca.Cor.branca));

		// Bispos
		tabuleiro.atribui(0, 2, new Bispo(Peca.Cor.preta));
		tabuleiro.atribui(0, 5, new Bispo(Peca.Cor.preta));
		tabuleiro.atribui(7, 2, new Bispo(Peca.Cor.branca));
		tabuleiro.atribui(7, 5, new Bispo(Peca.Cor.branca));

		// Reis
		tabuleiro.atribui(0, 3, new Rei(Peca.Cor.preta));
		tabuleiro.atribui(7, 3, new Rei(Peca.Cor.branca));

		// Bispos
		tabuleiro.atribui(0, 4, new Dama(Peca.Cor.preta));
		tabuleiro.atribui(7, 4, new Dama(Peca.Cor.branca));
	}
}

/*
 Classe principal que inicia a janela da aplica‹o
 */
public class AP2_2010_2_Q3 {
	public static void main(String[] args) {
		
	}
}
