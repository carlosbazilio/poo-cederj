package br.cederj.comp.ano2012;

class Data {
	int dia;
	int mes;
	int ano;
	
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	boolean maior (Data d) {
		if ((this.ano > d.ano) ||
			((this.ano == d.ano) && (this.mes > d.mes)) ||
			((this.ano == d.ano) && (this.mes == d.mes) && (this.dia > d.dia)))
			return true;
		return false;
	}
}

class Feriado extends Data {
	String nome;

	public Feriado(int dia, int mes, int ano, String nome) {
		super(dia, mes, ano);
		this.nome = nome;
	}
}

class Intervalo {
	Data data1;
	Data data2;
	
	public Intervalo(Data data1, Data data2) {
		// Não é obrigatório de existir na solução
		// Colocado para garantir que o atributo data2 sempre 
		//conterá a maior data do intervalo
		if (data2.maior(data1)) {
			this.data1 = data1;
			this.data2 = data2;
		}
		else {
			this.data1 = data2;
			this.data2 = data1;
		}
	}
	
	public Intervalo(int d1, int m1, int a1, int d2, int m2, int a2) {
		// Reusa o construtor acima
		this(new Data(d1, m1, a1), new Data(d2, m2, a2));
	}
	
	public int obtemMeses () {
		int meses = 0;
		if (data1.ano == data2.ano)
			meses = Math.abs(data1.mes - data2.mes);
		else
		{
			int anos = Math.abs(data1.ano - data2.ano);
			if (anos > 1)
				meses = (anos - 1) * 12;
			if (data2.mes > data1.mes)
				meses = meses + data1.mes - data2.mes;
			else
				meses = (12 - data1.mes) + data2.mes;
		}
		return meses;
	}
}

public class AD1_2012_1 {
	public static void main(String[] args) {
		Data d1 = new Data(8,2,2012);
		Data d2 = new Data(31,12,2011);
		System.out.println(d2.maior(d1));
		Intervalo i = new Intervalo(d1, d2);
		System.out.println(i.obtemMeses());
	}
}
