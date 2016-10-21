package br.cederj.comp.ano2012;

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
	
	public float media () {
		return ((limiteInf.getValor() + limiteSup.getValor()) / 2);
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
 * Classe de teste da classe intervalo 
 * (Exercício da AD2 de Prog III / 2008-2)
 * @author Carlos Bazilio
 */
public class AP1_2012_1_Q3 {
	public static void main(String[] args) {
		IntervaloSimples interv_simples = new IntervaloSimples(2, false, 5, true);
		interv_simples.exibe();
	}
}
