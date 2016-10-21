package br.cederj.comp.ano2008;

abstract class Objeto2D {
	int pos_x; // Posicao no eixo x
	int pos_y; // Posicao no eixo y
	float largura; // Largura do objeto
	float altura; // Altura do objeto
	
	public abstract void desenha();
	
	public Objeto2D (int px, int py, float l, float a) {
		pos_x = px;
		pos_y = py;
		largura = l;
		altura = a;
	}
	
}

abstract class ObjetoVisual extends Objeto2D {
	float vida; // Varia entre 0, .25, .5, 1
	int pontuacao; // + 1 para cada acerto
	
	ObjetoVisual(float v, int p, int x, int y, int l, int a) {
		super(x, y, l, a);
		vida = v;
		pontuacao = p;
	}

	public boolean intercepta(ObjetoVisual o) {
		// Implementar método de interceptação
		return false;
	}
}

class Aviao extends ObjetoVisual {
	public Aviao(float v, int p, int x, int y, int l, int a) {
		super(v, p, x, y, l, a);
	}
	
	void movimenta (int x, int y) {
		pos_x = x;
		pos_y = y;
	}
	
	public void desenha() {
		// Comandos para o desenho de um aviao
	}
}

class Canhao extends ObjetoVisual {
	float angulo; // 0 a 180	
	
	public Canhao(float v, int p, int x, int y, int l, int a, int al) {
		super(v, p, x, y, l, a);
		angulo = al;
	}
	
	public void desenha() {
		// Comandos para o desenho de um canhao
	}
	
	public void movimenta (float x) {
		angulo = angulo + x;
	}
}

class Bomba extends Objeto2D {
	int pos_x; // Posicao no eixo x
	int pos_y; // Posicao no eixo y
	float alcance;
	
	public Bomba(int x, int y, float a) {
		super(x, y, 1, 1);
		alcance = a;
	}
	
	void movimenta (int x, int y) {
		pos_x = x;
		pos_y = y;
	}

	public void desenha() {
		// Comandos para o desenho de uma bomba
	}
}

public class AP1_2008_1_Q4 {
	ObjetoVisual [] objetos; // Conjunto de objetos a ser manipulado pelo jogo

}
