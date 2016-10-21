package br.cederj.comp.ano2013;

class URL {
	String protocolo;
	String dominio;
	int porta;
	String recurso;

	public URL(String protocolo, String dominio, int porta, String recurso) {
		this.protocolo = protocolo;
		this.dominio = dominio;
		this.porta = porta;
		this.recurso = recurso;
	}
	
	public boolean valida() {
		return ((protocolo.equalsIgnoreCase("http") || protocolo.equalsIgnoreCase("ftp")) &&
		        (!dominio.contains("@") || !dominio.contains("#") || !dominio.contains("$")) &&
		        (porta >= 0 && porta <= 65535) &&
		        this.toString().length() < 2000);
	}
	
	public String toString() {
		return protocolo + "://" + dominio + ":" + porta + "/" + recurso;
	}
}

public class AP1_2013_2_Q2 {
	public static void main(String[] args) {
		URL url1 = new URL("http", "www.cederj.edu.br", 8080, "extensao");
		if (url1.valida())
			System.out.println(url1);
		else
			System.out.println("URL mal formada!");
	}
}

