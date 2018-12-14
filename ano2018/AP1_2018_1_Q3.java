package br.cederj.comp.ano2018;

import java.util.ArrayList;
import java.util.List;

//class Lampada {
	private boolean ligada = false;
	private boolean funcionando = true;

//	public Lampada () {
//		this.ligada = false;
//	}

	public void ligar() {
		if (funcionando)
			this.ligada = true;
	}

	public void desligar() {
		this.ligada = false;
	}

	public String toString() {
		return (this.ligada) ? "Lâmpada ligada" : "Lâmpada desligada";
	}

	public void imprime() {
		System.out.println(this);
	}
	
	public void queimar() {
		this.ligada = false;
		this.funcionando = false;
	}
}

//class Luminaria extends Lampada {
	List <Lampada> lampadas = new ArrayList();
	
//	public Luminaria(int num_lampadas) {
//		for (int i=0; i<num_lampadas; i++)
//			lampadas.add(new Lampada());
//	}
	
	public void adicionaLampada (Lampada l) {
		lampadas.add(l);
	}

	public void ligar() {
		for (Lampada l : lampadas) {
			l.ligar();
		}
	}

	public void desligar() {
		for (Lampada l : lampadas) {
			l.desligar();
		}
	}
}

public class AP1_2018_1_Q3 {
	public static void main(String[] args) {
		Lampada l1 = new Lampada();
		l1.imprime();
		l1.ligar();
		l1.imprime();
		Lampada l2 = new Lampada();
		Lampada l3 = new Lampada();
		Luminaria lumi = new Luminaria();
		lumi.adicionaLampada(l1);
		lumi.adicionaLampada(l2);
		
		List<Lampada> iluminacao = new ArrayList();
		iluminacao.add(lumi);
		iluminacao.add(l3);
	}
}



