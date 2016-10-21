package br.cederj.comp.ano2015;

class Telefone {
    String codInternacional;
    String codArea;
    String numero;
    public Telefone(String codInternacional, String codArea, String numero) {
            this.codInternacional = codInternacional;
            this.codArea = codArea;
            this.numero = numero;
            if (numero.length() == 8 && 
            		(numero.startsWith("6") ||
            		 numero.startsWith("7") ||
            		 numero.startsWith("8") ||
            		 numero.startsWith("9")))
            	this.numero = "9" + this.numero;
    }
    public Telefone(String codArea, String numero) {
            this("55", codArea, numero);
    }
    public Telefone(String numero) {
            this("55", "21", numero);
    }
    public String toString() {
    	return "+" + codInternacional + " " + codArea + " " + numero;
    }
}

public class AP1_2015_2_Q2 {
	public static void main(String[] args) {
		System.out.println(new Telefone("88884444"));
	}
}
