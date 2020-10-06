package br.cederj.comp.ano2020;

class Cartao {
	int id;
	String tarefa;
	private static int numCartoes = 0;
	
	public Cartao(String texto) {
		this.tarefa = texto;
		id = numCartoes;
		numCartoes++;
	}
	
	public String toString() {
		return id + " " + tarefa + "\n";
	}
}

class Fase {
	Cartao tarefas[];
	private int numTarefas = 0;
	
	public Fase() {
		tarefas = new Cartao [100];
	}
	
	public void adiciona(Cartao c) {
		tarefas[numTarefas] = c;
		numTarefas++;
	}

	public void remove(Cartao c) {
		boolean achou = false;
		for (int i=0; i<numTarefas; i++) {
			if ((achou) || (tarefas[i] == c)) {
				tarefas[i] = tarefas[i+1];
				achou = true;
			}
		}
		if (achou)
			numTarefas--;
	}
	
	public String toString() {
		String saida = "";
		for (int i=0; i<numTarefas; i++) {
			saida += tarefas[i].toString();
		}
		return saida;
	}
}

class Quadro {
	static int BACKLOG = 0;
	static int TODO = 1;
	static int DOING = 2;
	static int DONE = 3;
	String labelFases[] = {"BACKLOG", "TODO", "DOING", "DONE"};
	Fase fase[] = new Fase[4];
	
	public Quadro() {
		for (int i=0; i<4; i++)
			fase[i] = new Fase();
	}
	
	public void adiciona (Cartao c) {
		fase[BACKLOG].adiciona(c);
	}
	
	public void prepara (Cartao c) {
		fase[BACKLOG].remove(c);
		fase[TODO].adiciona(c);
	}
	
	public void inicia (Cartao c) {
		fase[TODO].remove(c);
		fase[DOING].adiciona(c);
	}
	
	public void encerra (Cartao c) {
		fase[DOING].remove(c);
		fase[DONE].adiciona(c);
	}
	
	public String toString() {
		String saida = "";
		for (int i=0; i<4; i++) 
			saida += labelFases[i] + "\n" + fase[i].toString() + "\n";
		return saida;
	}
}

public class AD1_2020_1 {
	public static void main(String[] args) {
		Quadro semestre2010_1 = new Quadro();
		Cartao fazerAD1 = new Cartao("Fazer a AD1");
		semestre2010_1.adiciona(fazerAD1);
		Cartao fazerAD2 = new Cartao("Fazer a AD2");
		semestre2010_1.adiciona(fazerAD2);
		System.out.println(semestre2010_1);
		semestre2010_1.prepara(fazerAD1);
		System.out.println(semestre2010_1);
		semestre2010_1.inicia(fazerAD1);
		System.out.println(semestre2010_1);
		semestre2010_1.encerra(fazerAD1);
		System.out.println(semestre2010_1);
	}
}
