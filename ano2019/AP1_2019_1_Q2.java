package br.cederj.comp.ano2019;

import java.time.LocalDate;

class ToDo {
	String titulo;
	boolean feita;
	LocalDate dataLimite;
	boolean recorrente;
	String razao; // semanal ou mensal
	
	public ToDo(String titulo, LocalDate dataLimite, boolean recorrente) {
		this.titulo = titulo;
		this.feita = false;
		this.dataLimite = dataLimite;
		this.recorrente = recorrente;
	}

	public ToDo(String titulo) {
		this(titulo, null, false);
	}
	
	public void feito () {
		if (! recorrente)
			this.feita = true;
		else {
			if (razao == "semanal")
				dataLimite.plusWeeks(1);
			else
				dataLimite.plusMonths(1);
		}
	}
	
	public void desfeito () {
		this.feita = false;
	}
}

public class AP1_2019_1_Q2 {
	public static void main(String[] args) {
	}
}
