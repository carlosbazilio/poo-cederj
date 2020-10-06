package br.cederj.comp.ano2020;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AbaAnonima {
	String url;

    public AbaAnonima(String url) {
    	this.url = url;
    }

    public void acessaPagina(String url) {
    	this.url = url;
    }

    public String exibePagina() {
    	return this.url;
    }
}

class Aba extends AbaAnonima {
    LocalDateTime ultimoAcesso;

    public Aba(String url) {
        super(url);
        this.ultimoAcesso = LocalDateTime.now();
    }

    public String exibePagina() {
        return super.exibePagina() + ", " + ultimoAcesso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm"));
    }
}

class Navegador {
    String empresa;
    final static String url_inicial = "www.uff.br";
    private int numAbas;
    AbaAnonima abas[];
    private int indAbaSelecionada;
    private final static int MAX_ABAS = 100;

    public Navegador(String empresa, String url_inicial) {
        this.empresa = empresa;
        this.abas = new AbaAnonima[MAX_ABAS];
        this.abas[0] = new Aba(url_inicial);
        this.indAbaSelecionada = 0;
        this.numAbas = 1;
    }

    public Navegador(String empresa) {
        this(empresa, url_inicial);
    }

    public void adicionaAba(AbaAnonima aba) {
    	if (this.numAbas < MAX_ABAS) {
    		this.abas[this.numAbas] = aba;
            this.numAbas++;
    	}
    	else
    		System.out.println("Número limite de abas alcançado!");
    }
    
    public void fechaAba () {
    	if (this.numAbas == 1)
    		this.abaCorrente().acessaPagina(url_inicial);
    	else {
	    	for (int i=this.indAbaSelecionada; i<MAX_ABAS && this.abas[i] != null; i++)
	    		this.abas[i] = this.abas[i+1];
	    	this.numAbas--;
    	}
    }

    public void proximaAba() {
        if (this.indAbaSelecionada < this.numAbas-1)
            this.indAbaSelecionada++;
        else
            this.indAbaSelecionada = 0;
    }
   
    private AbaAnonima abaCorrente() {
    	return this.abas[this.indAbaSelecionada];
    }

    public void acessaPagina(String url) {
        this.abaCorrente().acessaPagina(url);
    }

    public String exibePaginas() {
    	String paginas = "";
    	for (int i=0; i<this.numAbas; i++)
    		paginas += "Aba " + i + ": " + this.abas[i].exibePagina() + "\n";
    	return paginas;
    }
}

public class AP1_2020_2_Q2 {
	public static void main(String[] args) {
        Navegador raposa = new Navegador("Firefox", "http://pesquisadores.uff.br/researcher/carlos-bazilio-martins");
        raposa.adicionaAba(new AbaAnonima("http://www.ic.uff.br/~bazilio/"));
        raposa.adicionaAba(new Aba("https://www.escavador.com/sobre/7717446/carlos-bazilio-martins"));
        System.out.println(raposa.exibePaginas());
        raposa.proximaAba();
        raposa.acessaPagina("https://github.com/carlosbazilio");
        System.out.println(raposa.exibePaginas());
        raposa.proximaAba();
        raposa.acessaPagina("https://www.youtube.com/channel/UCCqz9CJtH17DSMU4KJs-mfQ");
        System.out.println(raposa.exibePaginas());
        raposa.proximaAba();
        raposa.fechaAba();
        System.out.println(raposa.exibePaginas());   
    }
}
