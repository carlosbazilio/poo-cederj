package br.cederj.comp.ano2018;

abstract class Item {
	String nome;
	abstract double getTamanho();
}

class Arquivo extends Item {
	String nome;
	String extensao;
	double tamanho;
	
	public Arquivo(String nome, String extensao, double tamanho) {
		this.nome = nome;
		this.extensao = extensao;
		this.tamanho = tamanho;
	}
	
	public String toString() {
		return this.nome + "." + this.extensao + ", " + this.tamanho + "\n";
	}

	double getTamanho() {
		return this.tamanho;
	}
}

class Diretorio extends Item {
	String nome;
// Removido em função da inserção da classe Item
//	Arquivo conteudo[];
//	Diretorio subpastas[];
	Item conteudo[];
	
	public Diretorio(String nome, Item[] conteudo/*, Diretorio[] subpastas*/) {
		this.nome = nome;
		this.conteudo = conteudo;
		// Removido em função da inserção da classe Item
		// this.subpastas = subpastas;
	}
	
	public String toString() {
		String saida = "Dir: " + this.nome + " s = " + this.getTamanho() + "\n";
		if (this.conteudo != null)
			for (Item i : conteudo) {
				saida += i;
			}
// Removido em função da inserção da classe Item
//		if (this.subpastas != null)
//			for (Diretorio d : subpastas) {
//				saida += d;
//			}
		return saida;
	}

	double getTamanho() {
		double total = 0;
		for (Item i : conteudo) {
			total += i.getTamanho();
		}
		return total;
	}
}

public class AD1_2018_2 {
	public static void main(String[] args) {
		Arquivo ad1 = new Arquivo("Ad1", "odt", 20.7);
		Arquivo gab_ad1 = new Arquivo("Ad1-gabarito", "pdf", 55.3);
		Item ads[] = {ad1, gab_ad1};
		Diretorio dir_ads = new Diretorio("ADs", ads);
		
		Arquivo ap1 = new Arquivo("Ap1", "odt", 45.3);
		Arquivo gab_ap1 = new Arquivo("Ap1-gabarito", "pdf", 60.2);	
		Item aps[] = {ap1, gab_ap1};
		Diretorio dir_aps = new Diretorio("APs", aps);
		
		Diretorio dir_poo[] = {dir_ads, dir_aps};
		Diretorio dir3 = new Diretorio("POO", dir_poo);
		
		System.out.println(dir3);
	}
}



