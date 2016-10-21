package br.cederj.comp.ano2008;

import java.util.HashMap;
import java.util.Map;

interface InterfaceDicionario {
	void insere(String string, String string2);
	String consulta(String string);
}

class Dicionario implements InterfaceDicionario {
	Map<String, String> dicionario = new HashMap<String, String>();
	public String consulta(String string) {
		return (String)dicionario.get(string);
	}
	public void insere(String string, String string2) {
		dicionario.put(string, string2);
	}
}

public class AP2_2008_1_Q3 {
	public static void main(String[] args) {
		InterfaceDicionario d = new Dicionario();
	    d.insere("Joao", "512-1313");
	    d.insere("Maria", "512-2299");
	    System.out.println("O telefone de João é: "+d.consulta("Joao"));
	    System.out.println("O telefone de Maria é: "+d.consulta("Maria"));
	}
}
