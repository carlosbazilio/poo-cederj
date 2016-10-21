package br.cederj.comp.ano2015;

class Lampada {
	private boolean ligada;
	
	public Lampada(boolean ligada) {
		this.ligada = ligada;
	}

	public boolean isLigada() {
		return ligada;
	}

	public void setLigada(boolean ligada) {
		this.ligada = ligada;
	}

	public void imprimir() {
		if (this.ligada) {
			System.out.println("L�mpada ligada");
		} else {
			System.out.println("L�mpada desligada");
		}
	}
}

public class AP1_2015_1_Q2 {
	public static void main(String[] args) {
		Lampada l = new Lampada(true);
		l.setLigada(false);
		l.imprimir();
		l.setLigada(true);
		l.imprimir();
	}
}
