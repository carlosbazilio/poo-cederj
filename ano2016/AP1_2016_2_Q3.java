package br.cederj.comp.ano2016;

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
		if (this.dia == d.getDia() && this.mes == d.getMes() && this.ano == d.getAno())
			return 0;
		if (ano < d.getAno() ||
				(ano == d.getAno() && mes < d.getMes()) ||
					(ano == d.getAno() && mes == d.getMes() && dia < d.getDia()))
			return -1;
		return 1;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}
}

public class AP1_2016_2_Q3 {
	public static void main(String[] args) {
		Data d = new Data (3, 10, 2016);
		System.out.println("Data de hoje: " + d);
	}
}
