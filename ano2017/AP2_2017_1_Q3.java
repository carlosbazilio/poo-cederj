package br.cederj.comp.ano2017;

import br.cederj.comp.ano2014.Bombeiro;
import br.cederj.comp.ano2014.IPTU;
import br.cederj.comp.ano2014.Imovel;

/*import java.util.ArrayList;
import java.util.List;

interface INotificacao {
	String ler();
	void apagar();
	void encaminhar();
}

class Email implements INotificacao {
	String origem;
	String assunto;
	
	public String ler() {
		return null;
	}
	public void apagar() {
	}
	public void encaminhar() {
		// TODO Auto-generated method stub
	}
}

class Whatsapp implements INotificacao {
	String num_contato;
	public String ler() {
		// TODO Auto-generated method stub
		return null;
	}
	public void apagar() {
		// TODO Auto-generated method stub
	}
	public void encaminhar() {
		// TODO Auto-generated method stub
	}
}

class Notificacoes {
	List<INotificacao> mensagens;
	public Notificacoes() {
		this.mensagens = new ArrayList<INotificacao>();
	}
	public void recebe (INotificacao m) {
		mensagens.add(m);
	}
	public String ler () {
		INotificacao m = mensagens.get(0);
		return m.ler();
	}
	public void apagar () {
		mensagens.remove(0);
	}
}*/

public class AP2_2017_1_Q3 {
	public static void main(String[] args) {
		Imovel apto = new Imovel(100000);
		apto.adicionaImposto(new IPTU(0.03));
		apto.adicionaImposto(new Bombeiro());
		System.out.println(apto.calculaSomaImpostos());
	}
}

