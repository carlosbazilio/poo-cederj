package br.cederj.comp.ano2010;

class EnderecoWWW {
	// Declarações do item a)	
	private String dominio;
	private int porta;
	private String recurso;
	
	
	// Construtores pedidos no item b) e c)
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
		
		dominio = "";
		porta = 0;
		recurso = "";
		
		if (this.verificaConsistencia(endereco)) { // Após item e)
			dominio = EnderecoWWW.obtemDominio(endereco);
			porta = EnderecoWWW.obtemPorta(endereco);
			recurso = EnderecoWWW.obtemRecurso(endereco);
		}
	}
	
	// Métodos do item d)
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
	
	// Métodos do item d)
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
	
	// Métodos do item d)
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
	
	// Método do item e)
	public boolean verificaConsistencia (String endereco) {
		if ((endereco.startsWith("http") || endereco.startsWith("www")) &&
				!(endereco.contains("*")) &&
				!(endereco.contains("@")) &&
				!(endereco.contains("%")) &&
				!(endereco.contains("&")))
			return true;
		return false;
	}
}

// Classe de teste para o código acima
public class AP1_2010_2_Q3 {
	public static void main(String[] args) {
		String www = "http://www.cederj.edu.br/vest";
		EnderecoWWW cederj = new EnderecoWWW(www);
		cederj.exibe();
	}
}
