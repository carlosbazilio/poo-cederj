package br.cederj.comp.ano2011;

class Data {
	int dia;
	int mes;
	int ano;
	
	public Data(int dia, int mes, int ano) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
	
	public int compara (Data d) {
		if (dia == d.getDia() && mes == d.getMes() && ano == d.getAno())
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

// Classe de teste para a classe Telefone acima
public class AP1_2011_1_Q2 {
	public static void main(String[] args) {
		Data d = new Data(28, 4, 2011);
		Data d2 = new Data(4, 4, 2011);
		String comparacao = d.compara(d2) == 0 ? "iguais" : (d.compara(d2) == -1 ? "menor" : "maior");
		System.out.println("Comparação de datas " + d.toString() + " e " + d2.toString() + ": " + comparacao);
	}
}
