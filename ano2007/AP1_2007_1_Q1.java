package br.cederj.comp.ano2007;

abstract class ObjetoVisual {
	float vida; // Varia entre 0, .25, .5, 1
	int pontuacao; // + 1 para cada acerto
	int pos_x; // Posicao no eixo x
	int pos_y; // Posicao no eixo y
	float largura; // Largura do objeto
	float altura; // Altura do objeto
	
	abstract void desenha();
}

class Aviao extends ObjetoVisual {
	void movimenta (int x, int y) {
		pos_x = x;
		pos_y = y;
	}	
	void desenha() {
		// Comandos para o desenho de um aviao
	}
}

class Canhao extends ObjetoVisual {
	float angulo; // 0 a 180	
	void desenha() {
		// Comandos para o desenho de um canhao
	}
}

public class AP1_2007_1_Q1 {
	ObjetoVisual [] objetos; // Conjunto de objetos a ser manipulado pelo jogo

}
