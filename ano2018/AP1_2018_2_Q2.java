package br.cederj.comp.ano2018;

class Data {
	int dia;
	int mes;
	int ano;
	
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
	
	public int compara (Data d) {
		if (dia == d.dia && mes == d.mes && ano == d.ano)
			return 0;
		if (ano < d.ano ||
				(ano == d.ano && mes < d.mes) ||
					(ano == d.ano && mes == d.mes && dia < d.dia))
			return -1;
		return 1;
	}
}

class Reuniao extends Data {
	String assunto;
	int horaInicio;
	int horaFim;

	public Reuniao(String a, int hi, int hf, int dia, int mes, int ano) {
		super(dia, mes, ano);
		this.assunto = a;
		this.horaInicio = hi;
		this.horaFim = hf;
	}
	
	public int getDuracao() {
		return this.horaFim - this.horaInicio;
	}
}

public class AP1_2018_2_Q2 {
	public static void main(String[] args) {
		Reuniao r1 = new Reuniao("Reunião com sócios", 15, 17, 13, 8, 2018);
		Reuniao r2 = new Reuniao("Reunião com clientes", 17, 18, 13, 8, 2018);
		Reuniao r3 = new Reuniao("Confraternização", 21, 23, 13, 8, 2018);
		Reuniao reunioes[] = {r1, r2, r3};
		int duracao = 0;
		for (Reuniao r : reunioes) {
			duracao += r.getDuracao();
		}
		System.out.println("O tempo total de reunião é: " + duracao);
	}
}


