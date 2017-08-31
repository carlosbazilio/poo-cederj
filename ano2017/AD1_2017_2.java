package br.cederj.comp.ano2017;

class Questao {
	private String enunciado;
	
	public Questao(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public String getEnunciado() {
		return this.enunciado;
	}
}

class Discursiva extends Questao {
	private String gabarito;
	
	public Discursiva(String enunciado, String gabarito) {
		super(enunciado);
		this.gabarito = gabarito;
	}
	
	public String getGabarito() {
		return this.gabarito;
	}
	
	public String toString() {
		return this.getEnunciado() + "\n";
	}
}

class ItemVerdadeiroFalso extends Questao {
	private boolean gabarito;

	public ItemVerdadeiroFalso(String enunciado, boolean gabarito) {
		super(enunciado);
		this.gabarito = gabarito;
	}
	
	public boolean getGabarito() {
		return this.gabarito;
	}
	
	public String toString() {
		return "( ) " + this.getEnunciado();
	}
}

class VerdadeiroFalso extends Questao {
	ItemVerdadeiroFalso itens[];

	public VerdadeiroFalso(ItemVerdadeiroFalso itens[]) {
		super("Assinale verdadeiro ou falso para os itens:");
		this.itens = itens;
	}
	
	public String toString() {
		String texto = "";
		for (ItemVerdadeiroFalso item : itens)
			texto = texto + item.toString() + "\n";
		return this.getEnunciado() + "\n" + texto;
	}
}

class Prova {
	private Questao questoes[];
	private int quantidade;

	public Prova(int numQuestoes) {
		questoes = new Questao[numQuestoes];
		quantidade = 0;
	}
	
	public void adicionaQuestao (Questao q) {
		if (quantidade < questoes.length) {
			questoes[quantidade] = q;
			quantidade++;
		}
	}
	
	public void imprimeProva () {
		int num = 1;
		for (Questao q : questoes) {
			if (q != null) {
				System.out.print(num + ") ");
				System.out.println(q); // Chamada do método toString() para cada questão q
				num++;
			}
			else
				break;
		}
	}
}

public class AD1_2017_2 {
	public static void main(String[] args) {
		Questao[] prova = new Questao[2];
		prova[0] = new Discursiva("Qual é o número da última versão de Java?", "8");
		ItemVerdadeiroFalso[] itens = new ItemVerdadeiroFalso[3];
		itens[0] = new ItemVerdadeiroFalso("Java foi lançada há mais de 20 anos atrás", true);
		itens[1] = new ItemVerdadeiroFalso("OO surgiu com a linguagem Java", false);
		itens[2] = new ItemVerdadeiroFalso("Eclipse é um editor de texto multilinguagem", true);
		prova[1] = new VerdadeiroFalso(itens);
		
//		int num = 1;
//		for (Questao q : prova) {
//			System.out.print(num + ") ");
//			System.out.println(q); // Chamada do método toString() para cada questão q
//			num++;
//		}
		
		Prova p = new Prova(5);
		p.adicionaQuestao(new Discursiva("Qual é o número da última versão de Java?", "8"));
		p.adicionaQuestao(new VerdadeiroFalso(itens));
		p.imprimeProva();
	}
}
