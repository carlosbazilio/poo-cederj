package br.cederj.comp.ano2018;

import java.util.ArrayList;
import java.util.List;

interface Colecao {
	void adiciona (Object e);
	void remove (Object e);
	void altera (Object e, Object novo);
	boolean pertence (Object e);
	void lista();
}

class Lista implements Colecao {
	List<Object> objetos;
	
	public Lista() {
		objetos = new ArrayList();
	}
	
	public void adiciona(Object e) {
		objetos.add(e);
	}

	public void remove(Object e) {
		objetos.remove(e);
	}

	public void altera(Object e, Object novo) {
		objetos.remove(e); objetos.add(novo);
	}

	public boolean pertence(Object e) {
		return objetos.contains(e);
	}

	public void lista() {
		for (Object o : objetos)
			System.out.println(o);
	}
}

class Vetor implements Colecao {
	Object objetos[];
	int contador;

	public Vetor() {
		objetos = new Object[1000];
		contador = 0;
	}
	
	public void adiciona(Object e) {
		objetos[contador] = e;
		contador++;
	}

	public void remove(Object e) {
		boolean achou = false;
		for (int i=0; i<contador; i++)
			if (!achou && objetos[i] == e) {
				achou = true;
				objetos[i] = objetos[i+1];
			}
			else
				// Move objetos para eliminar buraco
				if (achou) 
					objetos[i] = objetos[i+1];
		if (achou)
			contador--;
	}

	public void altera(Object e, Object novo) {
		for (int i=0; i<contador; i++)
			if (objetos[i] == e) {
				objetos[i] = novo;
				break;
			}
	}

	public boolean pertence(Object e) {
		for (int i=0; i<contador; i++)
			if (objetos[i] == e)
				return true;
		return false;
	}

	public void lista() {
		for (int i=0; i<contador; i++)
			System.out.println(objetos[i]);
	}
}

public class AP2_2018_2_Q1 {
	public static void main(String[] args) {
		Colecao colecao;
		colecao = new Lista();
		String a = "A";
		String b = "B";
		colecao.adiciona(a);
		colecao.adiciona(b);
		String c = "C";
		colecao.altera(b, c);
		colecao.lista();
	}
}



