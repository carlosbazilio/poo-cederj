package br.cederj.comp.ano2018;

class Valor implements Comparable {
	int x;
	int m;
	
	public Valor (int x, int m) {
		this.x = x; this.m = m;
	}

	public int compareTo(Object o) {
		Valor v = (Valor)o;
		
		int restox = this.x % this.m;
		int restov = v.x % this.m;
		
		boolean ximpar = (this.x % 2) == 0;
		boolean vimpar = (v.x % 2) == 0;
		
		if (restox < restov)
			return -1;
		else
			if (restox > restov)
				return 1;
			else
				if (ximpar && vimpar)
					return (this.x < v.x) ? 1 : -1;
				else
					
		
	}
}


public class AP1_2018_2_Q3 {
	public static void main(String[] args) {
	}
}


