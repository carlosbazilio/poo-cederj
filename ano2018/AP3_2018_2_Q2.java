package br.cederj.comp.ano2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Elemento {
	int numero;
	int frequencia;
	
	public Elemento(int numero) {
		this.numero = numero;
		this.frequencia = 1;
	}
	
	public void novaOcorrencia() {
		this.frequencia++;
	}
	
	public String toString() {
		return "(" + numero + "," + frequencia + ")";
	}
}

class Elementos {
	List<Elemento> valores;
	
	public Elementos() {
		valores = new ArrayList<Elemento>();
	}
	
	public Elemento pertence (int val) {
		for (Elemento e: valores) {
			if (e.numero == val)
				return e;
		}
		return null;
	}

	public void adiciona(int val) {
		Elemento e = this.pertence(val);
		if (e != null)
			e.novaOcorrencia();
		else
			valores.add(new Elemento(val));
	}
	
	public void ordena() {
		Collections.sort(valores, new ComparaElementos());
	}
}

class ComparaElementos implements Comparator<Elemento> {
	public int compare(Elemento o1, Elemento o2) {
		if (o1.frequencia > o2.frequencia)
			return -1;
		else 
			if (o1.frequencia < o2.frequencia)
				return 1;
			else 
				if (o1.numero < o2.numero)
					return -1;
				else
					if (o1.numero > o2.numero)
						return 1;
					else
						return 0;
	}
}

public class AP3_2018_2_Q2 {
	public static void main(String[] args) {
		Integer nums[] = {1, 5, 3, 2, 4, 5, 7, 3};
		Elementos elementos = new Elementos();
		List<Integer>vals = Arrays.asList(nums);
		for (Integer x : vals) {
			elementos.adiciona(x);
		}
		elementos.ordena();
		//elementos.valores.forEach(System.out::println);
		for (Elemento e : elementos.valores)
			System.out.println(e);
	}
}



