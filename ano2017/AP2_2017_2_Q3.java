package br.cederj.comp.ano2017;

interface Fila {
	public Object inicio();
	public Object fim();
	public void enfileirar(Object o); 
	public void desenfileirar(); 
	public boolean estaVazia();
}

class Elemento {
	Object info;
	Elemento prox;
	Elemento(Object o){
		info = o;
		prox = null;
	}
	public String toString(){ return info.toString() + "\n"; }
}

class FilaObjeto implements Fila{
	Elemento ini, fim;
	FilaObjeto(){ ini = fim = null; }
	public boolean estaVazia(){ return (ini == null); }
	public Object inicio(){
		if (estaVazia()) return null;
		return ini.info;
	}
	public Object fim(){
		if (estaVazia()) return null;
		return fim.info;
	}
	public void enfileirar(Object o){
		Elemento novo = new Elemento(o);
		if(estaVazia()) ini = fim = novo;
		else{
			fim.prox = novo;
			fim = novo; }
	}
	public void desenfileirar(){
		if(!estaVazia()){
			Elemento novo = ini;
			ini = ini.prox;
			if(ini == null) fim = null;
		} 
	}
	public String toString(){
		if(estaVazia()) return null;
		String s = "";
		Elemento p = ini;
		while(p != null){
			s += p.toString();
			p = p.prox;
		}
		return s; 
	}
}
//SOMENTE PARA TESTAR A QUESTAO...
public class AP2_2017_2_Q3 {
	public static void main(String[] args){
		FilaObjeto f = new FilaObjeto();
		int i;
		System.out.println("Enfileirar !!!");
		for(i = 0; i < args.length; i++){
			f.enfileirar(args[i]);
			System.out.println(f);
		}
		System.out.println("Desenfileirar !!!");
		for(i = 0; i < args.length; i++){
			f.desenfileirar();
			System.out.println(f);
		} 
	}
}

