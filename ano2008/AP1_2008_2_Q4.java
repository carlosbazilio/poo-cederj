package br.cederj.comp.ano2008;

interface Valor {
	void inc ();
	void print ();
}

class Inteiro implements Valor {
	int a;
	Inteiro (int x) {
		a = x;
	}
	public void add (Inteiro x) {
		a = a + x.a;
	}
	public void inc () {
		a = a + 1;
	}
	public void print () {
		System.out.println(a);
	}
}

class Racional extends Inteiro {
	int b;
	Racional (int x, int y) {
		super(x); b = y;
	}
	public void add (Racional x) {
		a = a * x.b + b * x.a;
		b = b * x.b;
	}
	public void inc () {
		a = a + b;
	}
	public void print () {
		System.out.print(a);
		System.out.print("/");
		System.out.println(b);
	}
}

public class AP1_2008_2_Q4
{
	public static void main(String[] a) {
		Inteiro i = new Inteiro(1);
		Racional r = new Racional(2,3);
		i = r; 
		i.inc(); 
		i.print();
		i.add(new Inteiro(1));
		i.print();
	}
}
