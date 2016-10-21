package br.cederj.comp.ano2009;

abstract class ObjetoVisual {
	float vida; // Varia entre 0, .25, .5, 1
	int pontuacao; // + 1 para cada acerto
	int pos_x; // Posicao no eixo x
	int pos_y; // Posicao no eixo y
	float largura; // Largura do objeto
	float altura; // Altura do objeto
	
	abstract void desenha();
	
	public ObjetoVisual(float v,
						int pont,
						int x,
						int y,
						float l,
						float a) {
		vida = v;
		pontuacao = pont;
		pos_x = x;
		pos_y = y;
		largura = l;
		altura = a;
	}
}

class Aviao extends ObjetoVisual {
	public Aviao(float v, int pont, int x, int y, float l, float a) {
		super(v, pont, x, y, l, a);
	}
	void movimenta (int x, int y) {
		pos_x = x;
		pos_y = y;
	}
	void desenha() {
	}
}

class Canhao extends ObjetoVisual {
	double inclinacao;
	public Canhao(float v, int pont, int x, int y, float l, float a, double incl) {
		super(v, pont, x, y, l, a);
		inclinacao = incl;
	}
	void desenha() {		
	}
}

public class AP1_2009_1_Q3 {

}
