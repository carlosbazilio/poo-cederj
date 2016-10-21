package br.cederj.comp.ano2013;

import java.util.ArrayList;
import java.util.List;

class MinhaData {
	int dia;
	int mes;
	int ano;
	
	public MinhaData(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public MinhaData(String data) {
		this(Integer.valueOf(data.split("/")[0].trim()), 
			 Integer.valueOf(data.split("/")[1].trim()),
			 Integer.valueOf(data.split("/")[2].trim()));
	}
	
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
	
	public int compara (MinhaData d) {
		if (dia == d.dia && mes == d.mes && ano == d.ano)
			return 0;
		if (ano < d.ano ||
				(ano == d.ano && mes < d.mes) ||
					(ano == d.ano && mes == d.mes && dia < d.dia))
			return -1;
		return 1;
	}
}

class DataComemorativa extends MinhaData {
	String nome;
	boolean feriado;
	boolean mundial;
	public DataComemorativa(String nome, boolean feriado, boolean mundial, int dia, int mes, int ano) {
		super(dia, mes, ano);
		this.nome = nome;
		this.feriado = feriado;
		this.mundial = mundial;
	}
	public DataComemorativa(String nome, boolean feriado, boolean mundial, String data) {
		super(data);
		this.nome = nome;
		this.feriado = feriado;
		this.mundial = mundial;
	}
}

class DatasComemorativas {
	static List<DataComemorativa> datas = new ArrayList<DataComemorativa>();
	public static void adiciona(String n, boolean f, boolean m, int dia, int mes, int ano) {
		datas.add(new DataComemorativa(n, f, m, dia, mes, ano));
	}
	public static void adiciona(DataComemorativa d) {
		datas.add(d);
	}
	public static void remove(String n) {
		for (DataComemorativa d: datas) {
			if (d.nome == n) {
				datas.remove(d);
				break;
			}
		}
	}
	public static int quantidade() {
		int qtd = 0;
		for (DataComemorativa d: datas) {
			if (d.feriado) {
				qtd++;
			}
		}
		return qtd;
	}
	public static int horasNaoTrabalhadas() {
		return quantidade() * 8;
	}
}

// Classe de teste para a classe Telefone acima
public class AP1_2013_1_Q3 {
	public static void main(String[] args) {
		MinhaData d = new MinhaData(1, 4, 2013);
		//MinhaData d2 = new MinhaData(4, 4, 2011);
		DataComemorativa d2 = new DataComemorativa("Natal", true, true, "25/12/2013");
		String comparacao = d.compara(d2) == 0 ? "iguais" : (d.compara(d2) == -1 ? "menor" : "maior");
		System.out.println("Comparação de datas " + d.toString() + " e " + d2.toString() + ": " + comparacao);
		DatasComemorativas.adiciona(d2);
		System.out.println("Horas não trabalhadas: " + DatasComemorativas.horasNaoTrabalhadas());
	}
}
