package br.cederj.comp.ano2008;

class IntervaloDeTempo {
	int hora, min, seg;
	
	// Construtor que converte segundos em h,m,s
	public IntervaloDeTempo(int tempo) {
		hora = tempo / 3600;
		min = (tempo - hora*3600) / 60;
		seg = tempo - hora*3600 - min*60;
	}
	
	// Método que realiza some de objetos
	// Chamada do método simplifica para o caso em que a
	//a soma de segundos ou minutos exceder 60 unidades
	public IntervaloDeTempo soma (IntervaloDeTempo t) {
		this.hora = this.hora + t.hora;
		this.min = this.min + t.min;
		this.seg = this.seg + t.seg;
		this.simplifica();
		return this;		
	}
	
	// Método que adiciona unidades de segundo ao objeto
	// Novamente, chamada ao método simplifica
	public IntervaloDeTempo soma (int t) {		
		IntervaloDeTempo aux = new IntervaloDeTempo(t);
		
		aux.hora = aux.hora + this.hora;
		aux.min = aux.min + this.min;
		aux.seg = aux.seg + this.seg;
		
		aux.simplifica();
		
		return aux;		
	}
	
	// Método que retorna uma string do objeto
	public String toString () {
		String saida = hora + " horas, " + min + " minutos e " + seg + " segundos";
		return saida;
	}
	
	// Método que simplifica o objeto
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

public class AP1_2008_1_Q3 {
	public static void main(String[] args) {
		IntervaloDeTempo t = new IntervaloDeTempo(3500);
		System.out.println(t.toString());
		System.out.println(t.soma(100).toString());
		System.out.println(t.toString());
	}
}
