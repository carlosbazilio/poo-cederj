package br.cederj.comp.ano2015;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

enum PLANO {
	AMIL, UNIMED, AMS, ASSIM, GOLDEN, OUTRO, PARTICULAR
}

class Contato {
	String nome;
	String telefone;
	String email;
	PLANO plano;
	
	public Contato(String nome, String telefone, String email, PLANO p) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.plano = p;	
	}
}

class ContatoEmpresa extends Contato {
	String empresa;
	String cnpj;
	
	public ContatoEmpresa(String nome, String telefone, String email, PLANO p, String empresa, String cnpj) {
		super(nome, telefone, email, p);
		this.empresa = empresa;
		this.cnpj = cnpj;
	}
}

class Clientes {
	Map<Contato, GregorianCalendar> clientes;

	public Clientes() {
		this.clientes = new HashMap<Contato, GregorianCalendar>();
	}
	
	public Clientes(Map<Contato, GregorianCalendar> clientes) {
		this.clientes = clientes;
	}
	
	public GregorianCalendar agendaCliente (Contato c, GregorianCalendar data) {
		if (clientes.containsKey(c)) {
			GregorianCalendar ultimaData = clientes.get(c);
			if (ultimaData.after(new GregorianCalendar()))
				return ultimaData;
		}
		clientes.put(c, data);
		return data;
	}
	
	public String toString() {
		String saida = "";
		// http://stackoverflow.com/questions/46898/iterate-over-each-entry-in-a-map
		for (Entry<Contato, GregorianCalendar> entrada : clientes.entrySet()) {
			GregorianCalendar data = entrada.getValue();
			saida = saida + entrada.getKey().nome + " " + data.get(Calendar.DAY_OF_MONTH) + "/" + data.get(Calendar.MONTH) + "\n";
		}
		return saida;
	}
}

public class AD2_2015_2 {
	public static void main(String[] args) {
		Contato pessoa1 = new Contato("Fulano", "22222222", "fulano@dominio.com", PLANO.PARTICULAR);
		ContatoEmpresa empresa1 = new ContatoEmpresa("Beltrano", "33333333", "beltrano@dominio.com", PLANO.GOLDEN, "UFF", "11111");
		Clientes agenda = new Clientes();
		agenda.agendaCliente(pessoa1, new GregorianCalendar(2015, 9, 30, 9, 0, 0));
		agenda.agendaCliente(empresa1, new GregorianCalendar(2015, 10, 1, 9, 0, 0));
		System.out.println(agenda);
	}
}
