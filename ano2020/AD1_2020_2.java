package br.cederj.comp.ano2020;

import java.util.Arrays;

class Email {
	private String remetente;
	private String destinatarios[];
	private String assunto;
	private String mensagem;
	
	public Email(String remetente, String destinatarios[], String assunto, String mensagem) {
		this.remetente = remetente;
		this.destinatarios = destinatarios;
		this.assunto = assunto;
		this.mensagem = mensagem;
	}
	
	public String[] getDestinatarios() {
		return this.destinatarios;
	}
	
	public void lerMensagem() {
		System.out.println(this);
	}
	
	public String toString() {
		return "De: " + this.remetente + "\n" +
	           "Para: " + Arrays.toString(this.destinatarios) + "\n" +
			   this.assunto + "\n" +
	           this.mensagem;
	}
}

class CaixaPostal {
	private String usuario;
	private Email emails[];
	private int qtdEmails;
	private static short MAX_EMAILS = 1000;
	
	public CaixaPostal(String usuario) {
		this.usuario = usuario;
		this.emails = new Email[MAX_EMAILS];
		qtdEmails = 0;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public void recebeMensagem(Email e) {
		if (qtdEmails >= MAX_EMAILS)
			System.out.println("Caixa postal cheia!");
		else {
			this.emails[qtdEmails] = e;
			qtdEmails++;
		}
	}
	
	public String toString() {
		String retorno = ">>> Caixa Postal de " + this.usuario + " <<<\n";
		for (Email e: emails)
			if (e != null)
				retorno = retorno + e;
			else
				break;
		return retorno + "\n";
	}
}

class ServidorEmails {
	private CaixaPostal caixas[];
	private int qtdCaixas;
	private static short MAX_CAIXAS = 10000;
	
	public ServidorEmails() {
		this.caixas = new CaixaPostal[MAX_CAIXAS];
		qtdCaixas = 0;
	}
	
	public CaixaPostal obtemCaixa (String usuario) {
		for (CaixaPostal c: caixas)
			if (c.getUsuario() == usuario)
				return c;
		return null;
	}
	
	public void adicionaCaixa(CaixaPostal c) {
		if (qtdCaixas >= MAX_CAIXAS)
			System.out.println("Servidor com capacidade excedida!");
		else {
			this.caixas[qtdCaixas] = c;
			qtdCaixas++;
		}
	}
	
	public void enviaEmail(Email e) {
		for (String dest: e.getDestinatarios()) {
			CaixaPostal destinatario = this.obtemCaixa(dest);
			destinatario.recebeMensagem(e);
		}
	}
	
	public void encaminhaEmail(Email e, String outroDestinarario) {
		CaixaPostal destinatario = this.obtemCaixa(outroDestinarario);
		destinatario.recebeMensagem(e);
	}
}

public class AD1_2020_2 {
	public static void main(String[] args) {
		ServidorEmails servidor = new ServidorEmails();
		CaixaPostal fulano = new CaixaPostal("Fulano");
		CaixaPostal sicrano = new CaixaPostal("Sicrano");
		CaixaPostal beltrano = new CaixaPostal("Beltrano");
		CaixaPostal outrano = new CaixaPostal("Outrano");
		servidor.adicionaCaixa(fulano);
		servidor.adicionaCaixa(sicrano);
		servidor.adicionaCaixa(beltrano);
		servidor.adicionaCaixa(outrano);
		Email e1 = new Email("Fulano", 
				             new String[]{"Sicrano", "Beltrano"}, 
				             "Super importante!", 
				             "Retorne-me o quanto antes!");
		servidor.enviaEmail(e1);
		servidor.encaminhaEmail(e1, "Outrano");
		System.out.println(fulano);
		System.out.println(sicrano);
		System.out.println(beltrano);
		System.out.println(outrano);
	}
}
