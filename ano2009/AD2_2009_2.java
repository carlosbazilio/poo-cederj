package br.cederj.comp.ano2009;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AD2_2009_2 {
	public static void main(String[] args) {
		List <ObjetoManipulavel> objetos = new ArrayList<ObjetoManipulavel>();
		objetos.add(new Retangulo(2, 3));
		objetos.add(new Retangulo(7, 15));
		objetos.add(new Circulo(5));
		objetos.add(new Quadrilatero(2, 3, 8, 10));
		objetos.add(new Quadrado(3));
		objetos.add(new Quadrado(8));
		
		Iterator <ObjetoManipulavel> it = objetos.iterator();
		while (it.hasNext()) {
			ObjetoManipulavel figura = (ObjetoManipulavel) it.next();
			System.out.println("Tipo: " + figura.getClass().getSimpleName());
			System.out.println("Área figura: " + figura.area());
			System.out.println("Perímetro: " + figura.perimetro());
		}
	}
}
