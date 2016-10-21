package br.cederj.comp.ano2008;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe que implementa os métodos solicitados na AD2 de Prog III / 2008-1
 * @author Carlos Bazilio
 *
 * @param <T> Parâmetro da classe genérica
 */

class MinhaLista<T> {
	private List<T> itens = new ArrayList<T>();
	public void add (T item) { itens.add(item); }
	public T primeiro() { return itens.get(0); }
	public T ultimo() {
		return itens.get(itens.size()-1);
	}
	public T aleatorio() {
		return itens.get((int)(Math.random()*(itens.size()-1)));
	}
	public boolean pertence(T object) {
		return itens.contains(object);
	}
	public boolean igual(MinhaLista<T> ml2) {
		Iterator<T> i = itens.iterator();
		Iterator<T> i2 = ml2.itens.iterator();
		while (i.hasNext() && i2.hasNext()) {
			if (i.next() != i2.next())
				return false;
		}
		if (!i.hasNext() && !i2.hasNext())
			return true;
		return false;
	}
	public boolean contida(MinhaLista<T> ml2) {
		Iterator<T> i = itens.iterator();
		List<T> l2 = ml2.itens;
		while (i.hasNext()) {
			if (!l2.contains(i.next()))
				return false;
		}
		return true;
	}
	public boolean contem(MinhaLista<T> ml2) {
		return ml2.contida(this);
	}
	public MinhaLista<T> intersecao(MinhaLista<T> ml2) {
		MinhaLista<T> mlNova = new MinhaLista<T>();
		Iterator<T> i = itens.iterator();
		while (i.hasNext()) {
			T obj = i.next();
			if (ml2.pertence(obj))
				mlNova.add(obj);
		}
		return mlNova;
	}
	public void exibe() {
		Iterator<T> i = itens.iterator();
		while (i.hasNext()) {
			System.out.print(i.next().toString());
		}
		System.out.println();
	}
	public MinhaLista<T> concatena(MinhaLista<T> ml2) {
		MinhaLista<T> mlNova = new MinhaLista<T>();
		for (T t : itens)
			mlNova.add(t);
		for (T t : ml2.itens)
			mlNova.add(t);
		return mlNova;
	}
	public int tamanho(){
		return itens.size();
	}
}

/**
 * Classe que testa os métodos definidos na classe MinhaLista<T>
 * @author bazilio
 */

public class AD2_2008_1 {
	public static void main(String[] args) {
		MinhaLista<String> ml = new MinhaLista<String>();
		MinhaLista<String> ml2 = new MinhaLista<String>();
		ml.add("primeiro");
		ml.add("segundo");
		ml2.add("segundo");
		System.out.println(ml.primeiro());
		System.out.println("Último elemento: " + ml.ultimo());
		System.out.println("Elemento qualquer: " +
		ml.aleatorio());
		System.out.println("Terceiro pertence a lista? " +
		ml.pertence("terceiro"));
		System.out.println("As listas são iguais? " +
		ml.igual(ml2));
		System.out.println("L1 está contida em L2? " +
		ml.contida(ml2));
		System.out.println("L1 contém L2? " +
		ml.contem(ml2));
		System.out.print("Calcula interseção: ");
		ml.intersecao(ml2).exibe();
		System.out.print("Concatenação: ");
		ml.concatena(ml2).exibe();
	}
}


