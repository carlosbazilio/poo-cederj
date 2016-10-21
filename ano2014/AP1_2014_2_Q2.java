package br.cederj.comp.ano2014;

class IntervaloDeTempo {
	// N�o coloquei os modificadores de acesso
	//(private ou protected) apenas para tornar o 
	//c��digo menor. Mas estes s��o recomend��veis
	//na cria�㍋o de aplica����es reais.
	int hora, min, seg;
	
	// Construtor que converte segundos em h,m,s
	public IntervaloDeTempo(int tempo) {
		hora = tempo / 3600;
		min = (tempo - hora*3600) / 60;
		seg = tempo - hora*3600 - min*60;
	}
	
	// M��todo que realiza some de objetos
	// Chamada do m��todo simplifica para o caso em que a
	//a soma de segundos ou minutos exceder 60 unidades
	public IntervaloDeTempo soma (IntervaloDeTempo t) {
		this.hora = this.hora + t.hora;
		this.min = this.min + t.min;
		this.seg = this.seg + t.seg;
		this.simplifica();
		return this;		
	}
	
	// M��todo que adiciona unidades de segundo ao objeto
	public IntervaloDeTempo soma (int t) {		
		IntervaloDeTempo aux = new IntervaloDeTempo(t);
		aux.soma(this);
		return aux;
	}
	
	// Compara 2 intervalos de tempo.
	// 1: par�metro t maior que this
	// 0: par�metro t igual a this
	// -1: par�metro t menor que this
	public int compara (IntervaloDeTempo t) {
		if ((t.hora == this.hora) && (t.min == this.min) && (t.seg == this.seg))
			return 0;
		else
			if ((t.hora > this.hora) || 
				((t.hora == this.hora) && (t.min > this.min)) ||
				((t.hora == this.hora) && (t.min == this.min) && (t.seg > this.seg)))
					return 1;
				else
					return -1;
	}
	
	public int compara (int t) {
		return this.compara (new IntervaloDeTempo(t));
	}
	
	// M��todo que retorna uma string do objeto
	public String toString () {
		String saida = hora + " horas, " + min + " minutos e " + seg + " segundos";
		return saida;
	}
	
	// M�todo que retorna uma string do objeto
	public String toString (String formato) {
		String saida = formato.replaceAll("#h", String.valueOf(hora));
		saida = saida.replaceAll("#m", String.valueOf(min));
		saida = saida.replaceAll("#s", String.valueOf(seg));
		return saida;
	}
	
	// M��todo que simplifica o objeto. Ap�s uma soma, caso
	// o campo segundos seja maior que 60, cada 60 unidades destas
	// s�o transformadas em minutos.
	// Este m�todo n�o era pedido na quest�o.
	public void simplifica () {
		if (this.seg >= 60) {
			this.seg = this.seg % 60;
			this.min = this.min + this.seg/60;
		}
		
		if (this.min >= 60) {
			this.min = this.min % 60;
			this.hora = this.hora + this.min/60;
		}
	}
}

// Classe de teste, apenas para verificar a corretude
//do c�digo acima
public class AP1_2014_2_Q2 {
	public static void main(String[] args) {
		IntervaloDeTempo t = new IntervaloDeTempo(3500);
		System.out.println(t.toString());
		System.out.println(t.soma(100).toString());
		System.out.println(t.toString());
		System.out.println(t.toString("#h:#m:#s"));
	}
}
