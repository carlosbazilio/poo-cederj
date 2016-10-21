package br.cederj.comp.ano2009;

import java.util.*;

import br.cederj.comp.ano2010.Circulo;
import br.cederj.comp.ano2010.ObjetoManipulavel;
import br.cederj.comp.ano2010.Retangulo;

interface I {
	
}

class ObjListMeu<T extends I> { // ObjetoManipulavel
	List<T> lista = new ArrayList<T>();

    public void add(T obj) {
        lista.add(obj);
    }

    public void imprimirLista() {
        Iterator it = lista.iterator();
        while(it.hasNext()) {
            ObjetoManipulavel obj = (ObjetoManipulavel)it.next();
            System.out.println("Área figura: " + obj.area()); //obj.calculo();
        }
    }
}

public class DuvidaAD2_2009 {
	public static void main(String[] args) {		
		ObjListMeu minhalista = new ObjListMeu();
		Retangulo r1 = new Retangulo(2, 3);
		Retangulo r2 = new Retangulo(7, 15);
		Circulo c1 = new Circulo(5);
		minhalista.add(r1);
		minhalista.add(r2);
		minhalista.add(c1);
		minhalista.imprimirLista();
	}
}


