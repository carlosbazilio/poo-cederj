package br.cederj.comp.ano2017;

final class Meses{ 
	static final String[] NOME_DO_MES = {"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};
}

final class UltimosDiasMeses{
	static final int[] DIAS_DO_MES = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
}

//LETRA (a)
class Data {
	int dia;
	int mes;
	int ano;

	//LETRA (b)
	public Data() { 
		this(1, 1, 1900);
		//this.dia = 1; this.mes = 1; this.ano = 1900;
	}

	//LETRA (c)
	public Data(int dia, int mes, int ano) {
		if (this.inconsistente(dia, mes, ano)) return;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public boolean inconsistente(int dia, int mes, int ano) {
		return ((ano < 1900) || (mes < 1 || 12 < mes) || (dia < 1 || UltimosDiasMeses.DIAS_DO_MES[mes - 1] < dia));
	}

	public int getDia() { return this.dia; }

	public int getMes() { return this.mes; }

	public int getAno() { return this.ano; }

	//LETRA (d)
	public void incrementar() {
		this.dia++;
		if (this.dia > UltimosDiasMeses.DIAS_DO_MES[this.mes - 1]) {
			this.dia = 1; this.mes++;
			if (this.mes > 12) {
				this.mes = 1; this.ano++;
			}
		}
	}

	//LETRA (e)
	public String toString() {
		return String.valueOf(this.dia) + " de " + Meses.NOME_DO_MES[this.mes - 1] + " de " + this.ano;
	}
}

public class AP1_2017_1_Q1 {
	public static void main(String[] args){
		Data d = new Data(Integer.parseInt(args[0]), Integer.parseInt (args[1]), Integer.parseInt(args[2]));
		System.out.println(d);
		d.incrementar();
		System.out.println(d);
	}
}

