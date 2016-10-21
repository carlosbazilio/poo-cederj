package br.cederj.comp.ano2011;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

class MinhaLista<E> extends ArrayList<E> {
	public MinhaLista map (Method m) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		MinhaLista aux =  new MinhaLista();
		for (E e : this) {
			aux.add(m.invoke(e));
		}
		return aux;
	}
}

public class AP3_2011_2_Q2_Tentativa {
	public static void main(String[] args) {
		MinhaLista<Integer> ml = new MinhaLista<Integer>();
		ml.add(10);
		ml.add(20);
		ml.add(30);
		ml.map(Integer.class.);
	}
}
