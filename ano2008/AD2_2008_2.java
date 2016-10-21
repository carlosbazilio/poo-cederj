package br.cederj.comp.ano2008;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe que implementa um limite, a ser utilizado na definição da classe
 * intervalo (Exercício da AD2 de Prog III / 2008-2)
 * @author Carlos Bazilio
 */

class Limite {
	private float valor;
	private boolean aberto;
	
	public Limite(float li, boolean a) {
		valor = li;
		aberto = a;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	
	public boolean equals(Limite l) {
		return (this.valor == l.valor &&
				this.aberto == l.aberto);
	}
}

/**
 * Classe que implementa um intervalo simples
 * (Exercício da AD2 de Prog III / 2008-2)
 * @author Carlos Bazilio
 */
class IntervaloSimples {
	private Limite limiteInf;
	private Limite limiteSup;
	
	public IntervaloSimples(float linf, boolean abertolinf, float lsup, boolean abertolsup) {
		limiteInf = new Limite(linf, abertolinf);
		limiteSup = new Limite(lsup, abertolsup);
	}

	public boolean contem (float v) {
		return ((v > limiteInf.getValor() && v < limiteSup.getValor()) ||
				(!limiteInf.isAberto() && v == limiteInf.getValor()) || 
				(!limiteSup.isAberto() && v == limiteSup.getValor()));
	}
	
	public boolean intercepta (IntervaloSimples i) {
		return (this.contem(i.limiteInf.getValor()) || this.contem(i.limiteSup.getValor()) ||
				i.contem(this.limiteInf.getValor()) || i.contem(this.limiteSup.getValor()) ||
				this.limiteInf.equals(i.limiteInf) ||
				this.limiteSup.equals(i.limiteSup));
	}
	
	public float media () {
		return ((limiteInf.getValor() + limiteSup.getValor()) / 2);
	}
	
	public IntervaloSimples produto (IntervaloSimples i) {
		float infProd, supProd;
		infProd = Math.min(this.limiteInf.getValor()*i.limiteInf.getValor(),
						   this.limiteInf.getValor()*i.limiteSup.getValor());
		infProd = Math.min(infProd, this.limiteSup.getValor()*i.limiteInf.getValor());
		infProd = Math.min(infProd, this.limiteSup.getValor()*i.limiteSup.getValor());
		
		supProd = Math.min(this.limiteInf.getValor()*i.limiteInf.getValor(),
				           this.limiteInf.getValor()*i.limiteSup.getValor());
		supProd = Math.min(supProd, this.limiteSup.getValor()*i.limiteInf.getValor());
		supProd = Math.min(supProd, this.limiteSup.getValor()*i.limiteSup.getValor());
		
		return new IntervaloSimples(infProd, true, supProd, true);
	}
	
	public void exibe () {
		System.out.println("Intervalo: " + this);
	}
	
	public String toString() {
		String abre = "[", fecha = "]";
		if (limiteInf.isAberto())
			abre = "(";
		if (limiteSup.isAberto())
			fecha = ")";
		return abre + limiteInf.getValor() + "," + limiteSup.getValor() + fecha;
	}
}

/**
 * Classe que implementa um intervalo com possíveis sub-intervalos sem
 * interseção
 * (Exercício da AD2 de Prog III / 2008-2)
 * @author Carlos Bazilio
 */
class Intervalo {
	private List<IntervaloSimples> intervalos;
	
	public Intervalo() {
		intervalos = new ArrayList<IntervaloSimples>();
	}
	
	public Intervalo(IntervaloSimples i) {
		intervalos = new ArrayList<IntervaloSimples>();
		intervalos.add(i);
	}
	
	public void adiciona (IntervaloSimples i) {
		intervalos.add(i);
	}
	
	public void uniao (Intervalo i) {
		intervalos.addAll(i.intervalos);
	}
	
	public void exibe () {
		Iterator<IntervaloSimples> it = intervalos.iterator();
		while (it.hasNext()) {
			IntervaloSimples interv = it.next();
			interv.exibe();
		}
	}
}

/**
 * Classe de teste da classe intervalo 
 * (Exercício da AD2 de Prog III / 2008-2)
 * @author Carlos Bazilio
 */
public class AD2_2008_2 {
	public static void main(String[] args) {
		IntervaloSimples interv_simples = new IntervaloSimples(2, false, 5, true);
		Intervalo interv = new Intervalo(interv_simples);
		interv.adiciona(new IntervaloSimples(7, false, 8, true));
		interv.exibe();
	}
}
