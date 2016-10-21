package br.cederj.comp.ano2012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface InterfaceAgenda {
	void insere(String chave, Contato valor);
	void remove(String chave);
	Contato consulta(String string);
	int tamanho();
	List<String> getEmails();
}

class Contato {
	String nome;
	String tel;
	String email;

	public Contato(String nome, String tel, String email) {
		this.nome = nome;
		this.tel = tel;
		this.email = email;
	}
	
	public String getTel() {
		return this.tel;
	}

	public String getEmail() {
		return this.email;
	}
}

class Agenda implements InterfaceAgenda {
	Map<String, Contato> dicionario = new HashMap<String, Contato>();
	public Contato consulta(String string) {
		return dicionario.get(string);
	}
	public void insere(String chave, Contato valor) {
		dicionario.put(chave, valor);
	}
	public void remove(String chave) {
		dicionario.remove(chave);
	}
	public int tamanho() {
		return dicionario.size();
	}
	public List<String> getEmails() {
		List<String> emails = new ArrayList<String>();
		for (String chave: dicionario.keySet())
			emails.add(dicionario.get(chave).getEmail());
		return emails;
	}
}

public class AP3_2012_2_Q2 {
	public static void main(String[] args) {
		InterfaceAgenda d = new Agenda();	    					
		d.insere("João", new Contato("João", "512-1313", "joao@email.com"));
    	d.insere("Maria", new Contato("Maria", "512-2299", "maria@email.com"));
    	System.out.println("O telefone de João é: "+d.consulta("João").getTel());
    	System.out.println("O telefone de Maria é: "+d.consulta("Maria").getEmail());
    	d.remove("Maria");
    	System.out.println("O dicionário possui "+d.tamanho()+" entradas");
	}

}
