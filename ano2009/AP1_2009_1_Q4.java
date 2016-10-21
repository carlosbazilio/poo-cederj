package br.cederj.comp.ano2009;

class EnderecoWWW {
	private String dominio;
	private int porta;
	private String recurso;
	
	
	// Construtores pedidos no item 2
	public EnderecoWWW(String dom,
					   int port,
					   String rec) {
		dominio = dom;
		porta = port;
		recurso = rec;
	}
	
	public EnderecoWWW(String endereco) {
		// Para criação deste objetos foram implementados métodos estáticos
		//que recuperam cada campo de uma string www em separado
		dominio = EnderecoWWW.obtemDominio(endereco);
		porta = EnderecoWWW.obtemPorta(endereco);
		recurso = EnderecoWWW.obtemRecurso(endereco);
	}
	
	public static String obtemDominio(String endereco) {
		String inicioPadrao = "http://", dominio;
		if (endereco.startsWith(inicioPadrao)) // Remote inicio padrão
			endereco = endereco.substring(inicioPadrao.length(), endereco.length());
		
		int fimDominio = endereco.indexOf(':');
		if (fimDominio == -1) { // testa se existe porta não padrão
			fimDominio = endereco.indexOf('/');
			if (fimDominio == -1)
				fimDominio = endereco.length();
		}
		dominio = endereco.substring(0, fimDominio);
		return dominio;		
	}
	
	public static int obtemPorta(String endereco) {
		int fimDominio, fimPorta, porta;
		String inicioPadrao = "http://", sporta;
		if (endereco.startsWith(inicioPadrao)) // Remote inicio padrão
			endereco = endereco.substring(inicioPadrao.length(), endereco.length());
			
		fimDominio = endereco.indexOf(':');
		if (fimDominio == -1)
			porta = 80;
		else {
			fimPorta = endereco.indexOf('/', fimDominio);
			if (fimPorta == -1)
				fimPorta = endereco.length();
			sporta = endereco.substring(fimDominio + 1, fimPorta);
			porta = Integer.parseInt(sporta);
		}
		
		return porta;
	}
	
	public static String obtemRecurso(String endereco) {
		int inicioRecurso;
		String inicioPadrao = "http://", recurso;
		if (endereco.startsWith(inicioPadrao)) // Remote inicio padrão
			endereco = endereco.substring(inicioPadrao.length(), endereco.length());

		inicioRecurso = endereco.indexOf('/');
		if (inicioRecurso != -1)
			recurso = endereco.substring(inicioRecurso+1, endereco.length());
		else
			recurso = null;
		return recurso;		
	}
		
	// Método exemplo de exibição (não solicitado na questão)
	public void exibe() {
		String saida = "URL criada: " + "http://" + dominio;
		if (porta != 80) {
			saida = saida + ":" + porta;
		}
		if (recurso != null) {
			saida = saida + "/" + recurso;
		}
		System.out.println(saida);
	}

	// Métodos de obtenção e alteração de campos solicitados no item c)
	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public String getRecurso() {
		return recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}
}

public class AP1_2009_1_Q4 {
	public static void main(String[] args) {
		String www = "http://www.cederj.edu.br/vest";
		EnderecoWWW cederj = new EnderecoWWW(www);
		cederj.exibe();
	}
}
