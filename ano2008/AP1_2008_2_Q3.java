package br.cederj.comp.ano2008;

// Classe que será usada por todos os objetos que forem desenhados
class Posicao {
	int x, y;
	
	public Posicao(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}	
}

// Classe abstrata que contém o atributo Posicao, um construtor
//padrão e métodos de acesso ao atributo, os quais serão herdados
//pelas classes especializadas de Objeto
abstract class Objeto {
	Posicao pos;
	
	public Objeto(Posicao pos) {
		this.setPos(pos);
	}

	public Posicao getPos() {
		return pos;
	}

	public void setPos(Posicao pos) {
		this.pos = pos;
	}
}

// Classe que modela um jogador do jogo 
class Jogador extends Objeto {
	int pontuacao = 0;
	
	public Jogador(Posicao p) {
		super(p);
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
}

// Classe que modela um fantasma no jogo 
class Fantasma extends Objeto {
	public Fantasma(Posicao p) {
		super(p);
	}
}

// Classe que modela um ponto no jogo
class Ponto extends Objeto {
	int valor = 1;
	
	public Ponto(Posicao p) {
		super(p);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}	
}

//Classe que modela um ponto especial no jogo
class PontoEspecial extends Ponto {
	public PontoEspecial(Posicao p) {
		super(p);
		this.setValor(5);
	}
}

class Obstaculo extends Objeto {
	public Obstaculo(Posicao pos) {
		super(pos);
	}
	
}

// Suponha uma matriz de tamanho 40x40 que modele o jogo
// Suponha também que a posição 0x0 é o canto esquerdo superior
class Pacman {
	Jogador j;
	Fantasma f1, f2, f3, f4;
	PontoEspecial p1, p2, p3, p4;
	int imortalidade = 10; // 10 segundos
	int estado = 0; // 0: jogador mortal, 1: jogador imortal
	
	public Pacman() {
		f1 = new Fantasma(new Posicao(20,20));
		f2 = new Fantasma(new Posicao(20,20));
		f3 = new Fantasma(new Posicao(20,20));
		f4 = new Fantasma(new Posicao(20,20));
		j = new Jogador(new Posicao(20,30));
		
		// Criação dos pontos
		p1 = new PontoEspecial(new Posicao(0,0));
		p2 = new PontoEspecial(new Posicao(0,40));
		p3 = new PontoEspecial(new Posicao(40,0));
		p4 = new PontoEspecial(new Posicao(40,40));
		
		// Criação dos obstáculos
	}
}

public class AP1_2008_2_Q3 {
	public static void main(String[] args) {
		Pacman jogo = new Pacman();
	}
}
