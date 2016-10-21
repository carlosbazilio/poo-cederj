package br.cederj.comp.ano2011;

/*
 * PossÌvel soluÁ„o para a AD1 de 2011.1
 * 
 * Houve um equÌvoco na formulaÁ„o da quest„o que colocou as palavras
 * domÌnio e url como equivalentes. SoluÁıes incorretas em funÁ„o deste
 * equÌvoco ser„o consideradas, naturalmente.
 * 
 * Para o item f) a verificaÁ„o se uma string contÈm um n˙mero (no caso,
 * a porta), na vers„o atual de Java envolve o uso de expressıes regulares
 * ou o tratamento de uma exceÁ„o. Como nenhum dos assuntos s„o abordados
 * no curso, esta parte do item (verificar se a porta È um n˙mero) tambÈm
 * ser· desconsiderada.
 */

class EnderecoWWW {
	// DeclaraçõÁıes do item a)	
	private String dominio;
	private int porta;
	private String recurso;
	
	
	// Construtores pedidos no item b)
	public EnderecoWWW(String dom,
					   int port,
					   String rec) {
		dominio = dom;
		porta = port;
		recurso = rec;
	}

	// Construtores pedidos no item c)
	public EnderecoWWW(String endereco) {
		// Para a criaçãÁ„o deste objetos foram implementados méÈtodos est·áticos
		//que recuperam cada campo de uma string www em separado
		
		dominio = "";
		porta = 0;
		recurso = "";
		
		if (this.verificaConsistencia(endereco)) { // ApóÛs item f)
			dominio = EnderecoWWW.obtemDominio(endereco);
			porta = EnderecoWWW.obtemPorta(endereco);
			recurso = EnderecoWWW.obtemRecurso(endereco);
		}
	}
	
	// MÈétodos auxiliares para o item c)
	public static String obtemDominio(String endereco) {
		String inicioPadrao = "http://", dominio;
		if (endereco.startsWith(inicioPadrao))
			endereco = endereco.substring(inicioPadrao.length(), endereco.length());
		
		int fimDominio = endereco.indexOf(':');
		if (fimDominio == -1) {
			fimDominio = endereco.indexOf('/');
			if (fimDominio == -1)
				fimDominio = endereco.length();
		}
		dominio = endereco.substring(0, fimDominio);
		return dominio;		
	}
	
	// MÈétodos auxiliares para o item c)
	public static int obtemPorta(String endereco) {
		int fimDominio, fimPorta, porta;
		String inicioPadrao = "http://", sporta;
		if (endereco.startsWith(inicioPadrao))
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
	
	// MéÈtodos auxiliares para o item c)
	public static String obtemRecurso(String endereco) {
		int inicioRecurso;
		String inicioPadrao = "http://", recurso;
		if (endereco.startsWith(inicioPadrao))
			endereco = endereco.substring(inicioPadrao.length(), endereco.length());

		inicioRecurso = endereco.indexOf('/');
		if (inicioRecurso != -1)
			recurso = endereco.substring(inicioRecurso+1, endereco.length());
		else
			recurso = null;
		return recurso;		
	}
		
	// MÈétodos de obtenÁ„ção de campos solicitados no item d)
	public String getDominio() {
		return dominio;
	}

	public int getPorta() {
		return porta;
	}

	public String getRecurso() {
		return recurso;
	}

	// MéÈtodo do item e)
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

	// MÈétodo do item f)
	public boolean verificaConsistencia (String endereco) {
		if ((endereco.startsWith("http") || endereco.startsWith("www")) &&
				!(endereco.contains("*")) &&
				!(endereco.contains("@")) &&
				!(endereco.contains("%")) &&
				!(endereco.contains("&")))
			return true;
		return false;
	}
	
	// MÈtodo do item g)
	public boolean dominioEquivalente (String endereco) {
		return this.dominio.equals(EnderecoWWW.obtemDominio(endereco));
	}
}

// Classe de teste para o cÛódigo acima
public class AD1_2011_1 {
	public static void main(String[] args) {
		String www = "http://www.cederj.edu.br/vest";
		EnderecoWWW cederj = new EnderecoWWW(www);
		cederj.exibe();
	}
}

