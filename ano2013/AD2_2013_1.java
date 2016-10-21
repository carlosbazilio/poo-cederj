package br.cederj.comp.ano2013;

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
		String campos[] = data.split("/");
		this.dia = Integer.valueOf(campos[0]);
		this.mes = Integer.valueOf(campos[1]);
		this.ano = Integer.valueOf(campos[2]);
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

// Classe de teste para a classe Telefone acima
public class AD2_2013_1 {
	public static void main(String[] args) {
		MinhaData d = new MinhaData(28, 4, 2011);
		MinhaData d2 = new MinhaData(4, 4, 2011);
		String comparacao = d.compara(d2) == 0 ? "iguais" : (d.compara(d2) == -1 ? "menor" : "maior");
		System.out.println("Comparação de datas " + d.toString() + " e " + d2.toString() + ": " + comparacao);
	}
}
