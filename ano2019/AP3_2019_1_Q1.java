package br.cederj.comp.ano2019;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Tarefa {
	String descricao;
	boolean feita;
	
	public Tarefa(String descricao) {
		this.descricao = descricao;
		this.feita = false;
	}
	
	public void realizar() {
		this.feita = true;
	}
	
	public String toString() {
		return this.descricao + " : " + (this.feita ? "feita" : "não feita");
	}
}

class Recorrente extends Tarefa {
	LocalDate dia;
	tFrequencia frequencia;
	static enum tFrequencia {DIARIA, SEMANAL, MENSAL};

	public Recorrente(String descricao, LocalDate dia, tFrequencia frequencia) {
		super(descricao);
		this.dia = dia;
		this.frequencia = frequencia;
	}
	
	public void realizar() {
		switch (this.frequencia) {
		case DIARIA:
			this.dia = this.dia.plusDays(1);
			break;
		case SEMANAL:
			this.dia = this.dia.plusWeeks(1);
			break;
		case MENSAL:
			this.dia = this.dia.plusMonths(1);
			break;
		default:
			break;
		}
	}
	
	public String getSFrequencia() {
		switch (this.frequencia) {
		case DIARIA:
			return "diaria";
		case SEMANAL:
			return "semanal";
		case MENSAL:
			return "mensal";
		default:
			return "";
		}
	}
	
	public String toString() {
		return super.toString() + " Frequencia : " + this.getSFrequencia() + " data:" + this.dia;
	}
}

class Tarefas {
	List<Tarefa> tarefas;
	
	public Tarefas() {
		tarefas = new ArrayList<Tarefa>();
	}
	
	public void adicionaTarefa (Tarefa t) {
		tarefas.add(t);
	}
	
	public void realizaTarefas () {
//		for (Tarefa t : tarefas)
//			t.realizar();
		tarefas.forEach(x -> x.realizar());
	}
	
	public void imprimirTarefas () {
		for (Tarefa t : tarefas)
			System.out.println(t);
		
		// Versão funcional (Não apresentada no curso!)
		//tarefas.forEach(System.out::println);
	}
}

public class AP3_2019_1_Q1 {
	public static void main(String[] args) {
		Tarefas faculdade = new Tarefas();
		faculdade.adicionaTarefa(new Recorrente("Revisar materia", LocalDate.now(), Recorrente.tFrequencia.DIARIA));
		faculdade.adicionaTarefa(new Tarefa("Consertar servidor"));
		faculdade.imprimirTarefas();
		faculdade.realizaTarefas();
		faculdade.imprimirTarefas();
	}
}
