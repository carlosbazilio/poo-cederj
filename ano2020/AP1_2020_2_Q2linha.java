package br.cederj.comp.ano2020;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AbaAnonima2 {
	String url;
//	  Remoção do código referente a manipulação de pilha nas abas
//    String url[];
//    private int tamPilha;
//    private int topoCorrente;

    public AbaAnonima2(String url) {
    	this.url = url;
//        this.url = new String[10];
//        this.url[0] = url;
//        this.tamPilha = 1;
//        this.topoCorrente = 0;
    }

//    public void voltar() {
//        if (this.topoCorrente > 0)
//            this.topoCorrente--;
//    }
//
//    public void avancar() {
//        if (this.topoCorrente < this.tamPilha-1)
//            this.topoCorrente++;
//    }

    public void acessaPagina(String url) {
    	this.url = url;
//        this.url[this.topoCorrente] = url;
//        this.tamPilha = this.topoCorrente + 1;
    }

    public String exibePagina() {
    	return this.url;
//        return this.url[this.topoCorrente];
    }
}

class Aba2 extends AbaAnonima2 {
    LocalDateTime ultimoAcesso;

    public Aba2(String url) {
        super(url);
        this.ultimoAcesso = LocalDateTime.now();
    }

    public String exibePagina() {
        return super.exibePagina() + ", " + ultimoAcesso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm"));
    }
}

class Navegador2 {
    String empresa;
    final static String url_inicial = "www.uff.br";
    private int numAbas;
    AbaAnonima2 abas[];
    private int indAbaSelecionada;
    private final static int MAX_ABAS = 100;

    public Navegador2(String empresa, String url_inicial) {
        this.empresa = empresa;
        this.abas = new AbaAnonima2[MAX_ABAS];
        this.abas[0] = new Aba2(url_inicial);
        this.indAbaSelecionada = 0;
        this.numAbas = 1;
    }

    public Navegador2(String empresa) {
        this(empresa, url_inicial);
    }

    public void adicionaAba(AbaAnonima2 aba) {
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
        if (this.numAbas-1 > this.indAbaSelecionada)
            this.indAbaSelecionada++;
        else
            this.indAbaSelecionada = 0;
    }

//    public void abaAnterior() {
//        if (this.indAbaSelecionada == 0)
//            this.indAbaSelecionada = this.numAbas-1;
//        else
//            this.indAbaSelecionada--;
//    }
    
    public AbaAnonima2 abaCorrente() {
    	return this.abas[this.indAbaSelecionada];
    }

    public void acessaPagina(String url) {
        this.abaCorrente().acessaPagina(url);
    }
    
//    public void voltaPagina() {
//    	this.abaCorrente().voltar();
//    }
//    
//    public void avancaPagina() {
//    	this.abaCorrente().avancar();
//    }
//
//    public String exibePagina() {
//        return this.abaCorrente().exibePagina();
//    }

    public String exibePaginas() {
    	String paginas = "";
    	for (int i=0; i<this.numAbas; i++)
    		paginas += "Aba " + i + ": " + this.abas[i].exibePagina() + "\n";
    	return paginas;
    }
}

public class AP1_2020_2_Q2linha {
	public static void main(String[] args) {
        Navegador2 raposa = new Navegador2("Firefox", "http://pesquisadores.uff.br/researcher/carlos-bazilio-martins");
        raposa.adicionaAba(new AbaAnonima2("http://www.ic.uff.br/~bazilio/"));
        raposa.adicionaAba(new Aba2("https://www.escavador.com/sobre/7717446/carlos-bazilio-martins"));
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
