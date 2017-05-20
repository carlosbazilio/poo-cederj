package br.cederj.comp.ano2016;

class EmptyGroupException extends RuntimeException {    
	public EmptyGroupException(int grupo) { 
		super("O grupo " + grupo + " está vazio"); 
	}
}

class No {    
	int grupo;
	Object dado;
	No anterior;
	No proximo;

	No(int grupo, Object dado) {
		this.grupo = grupo;
		this.dado = dado;
	}  
}

interface ListaMaluca {
	public void inserir(int grupo, Object dado);
	public Object consultar(int grupo);
	public boolean estaVazia();
}

class MinhaListaMaluca implements ListaMaluca {
	private No primeiro = null;
	private No ultimo = null;

	//Resposta da Questão 2 letra (b)
	private No obterPrimeiro(int grupo) {
		No atual = this.primeiro;
		while ((atual != null) && (atual.grupo < grupo)) 
			atual = atual.proximo;
		return atual;
	}

	public Object consultar(int grupo) {
		No no = obterPrimeiro(grupo);
		if ((no == null) || (no.grupo != grupo)) 
			throw new EmptyGroupException(grupo);
		return no.dado;
	}

	//Resposta da Questão 2 letra (a)
	private void inserirAntes(No atual, No novo) {
		if (atual != null) {
			novo.anterior = atual.anterior;
			novo.proximo = atual;      
			atual.anterior = novo;
			if (novo.anterior != null) novo.anterior.proximo = novo;
			else this.primeiro = novo;        
		}
		else {
			novo.anterior = this.ultimo;
			novo.proximo = null;      
			if (this.ultimo != null) this.ultimo.proximo = novo;
			else this.primeiro = novo;
			this.ultimo = novo;
		}
	}

	public void inserir(int grupo, Object dado) {
		inserirAntes(obterPrimeiro(grupo + 1), new No(grupo, dado));
	}
	
	//Resposta da Questão 2 letra (c)  
	public boolean estaVazia() { return (this.primeiro == null); }
}

//Classe para testar a implementação...
public class AP3_2016_2_Q2{
	public static void main (String[] args) throws Exception{
		ListaMaluca l = new MinhaListaMaluca();
		try{
			System.out.println(l.estaVazia());    
			l.inserir(5, new String("E"));
			System.out.println(l.estaVazia());
			l.inserir(4, new String("B"));
			l.inserir(5, new String("C"));
			l.inserir(9, new String("D"));
			l.inserir(4, new String("A"));
			l.inserir(5, new String("F"));
			System.out.println(l.consultar(9));
			System.out.println(l.consultar(6));
		} catch (Exception e) { System.out.println(e); }    
	}
}