package br.cederj.comp.ano2016;

class Pilha {
	private static int TAM_MAX = 1000;
	private int valores[];
	private int topo;
	
	public Pilha() {
		valores = new int[TAM_MAX];
		this.topo = -1;
	}
	
	public boolean empty () {
		return topo == -1;
	}
	
	public void push (int v) {
		topo++;
		valores[topo] = v;
	}
	
	public void push (int v[], int qtd) {
		for (int i=0; i<qtd; i++) {
			push(v[i]);
		}
	}
	
	public void push (Pilha p) {
		while (! p.empty()) {
			this.push(p.pop());
		}
	}
	
	public int pop () {
		if (! this.empty()) { 
			topo--;
			return valores[topo+1];
		}
		else
			return -1;
	}
	
	public void pop (int x) {
		topo = topo - x;
		if (topo < -1)
			topo = -1;
	}
	
	public int top () {
		if (! this.empty()) 
			return valores[topo];
		else
			return -1;	
	}
}

public class AD1_2016_1 {
	public static void main(String[] args) {
		Pilha p = new Pilha();
		p.push(10);
		System.out.println("Valor no topo da pilha: " + p.top());
		System.out.println("Valor na pilha (pop): " + p.pop());
		p.push(15);
		p.push(20);
		int valores[] = {30, 40, 50}; 
		p.push(valores, 3);
		p.pop(1);
		Pilha p2 = new Pilha();
		p2.push(p);
		System.out.println("Valor na pilha (pop): " + p2.pop());
	}
}
