package br.cederj.comp.ano2007;

import java.util.ArrayList;
import java.util.List;

/* Classe abstrata que define quais m�todos um objeto precisa implementar.
 * 
 * Problema da amarra��o tardia: http://wiki.c2.com/?SmalltalkLateBinding
 */		
abstract class Coisa {
	abstract int vence (Papel adv);
	abstract int vence (Pedra adv);
	abstract int vence (Tesoura adv);
	
	void vence () {
		System.out.println("Da superclasse !!");};
//	
//	public int disputa (Coisa c) {return this.vence(c);}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}

/* Implementa��o das classes dos objetos que ser�o confrontados.
 * Nesta implementa��o, o m�todo vence() retorna os seguintes valores:
 * 0: Objetos da mesma classe
 * 1: Objeto this ganha do objeto passado por par�metro
 * -1: Objeto this perde para o objeto passado por par�metro
 */		
class Papel extends Coisa {
	public int vence (Papel adv) {
		return 0;
	}
	
	public int vence (Pedra adv) {
		return 1;
	}
	
	public int vence (Tesoura adv) {
		return -1;
	}

	@Override
	void vence() {
		System.out.println("Da subclasse !! " + this);
		
	}
}

class Pedra extends Coisa {
	public int vence (Papel adv) {
		return -1;
	}
	
	public int vence (Pedra adv) {
		return 0;
	}
	
	public int vence (Tesoura adv) {
		return 1;
	}

	@Override
	void vence() {
		System.out.println("Da subclasse !! " + this);
		
	}
}

class Tesoura extends Coisa {
	public int vence (Papel adv) {
		return 1;
	}
	
	public int vence (Pedra adv) {
		return -1;
	}
	
	public int vence (Tesoura adv) {
		return 0;
	}

	@Override
	void vence() {
		System.out.println("Da subclasse !! " + this);
		
	}
}

/* Esta classe cont�m o m�todo main, respons�vel por iniciar o jogo.
 * No in�cio, criamos uma lista com 3 objetos, cada um de uma classe diferente.
 * Ap�s, selecionamos 2 destes, aleatoriamente, os quais ser�o confrontados (observe
 * que a escolha aleat�ria pode selecionar um mesmo objeto 2 vezes, o que resultar� num empate).
 */		
public class AD2_2007_1 {

	public static void main(String[] args) {
		List <Coisa>objetos = new ArrayList<Coisa>();
		objetos.add(new Papel());
		objetos.add(new Pedra());
		objetos.add(new Tesoura());
		
		/* Obt�m �ndices entre 0 e 10 e pega o resto da divis�o para obter
		 * �ndices entre 0 e 2, neste caso.
		 */		
		int i = (int) (Math.random() * 10) % 3;
		int j = (int) (Math.random() * 10) % 3;
		
		Coisa c1 = objetos.get(i);
		Coisa c2 = objetos.get(j);
		
		/* Confronta os objetos */
		//int resultado = c1.vence(c2);
		int resultado = 0;
		c1.vence();
		//int resultado = objetos.get(i).vence(objetos.get(j));
		
		/* Imprime o resultado listando a classe dos objetos envolvidos */
		switch (resultado) {
			case 0: {
				System.out.println("Objetos do mesmo tipo: " + c1);
			} break;
			case 1: {
				System.out.println("Objeto " + c1 + " vence objeto " + c2);
			} break;
			case -1: {
				System.out.println("Objeto " + c1 + " perde para objeto " + c2);
			} break;
		}

	}

}
