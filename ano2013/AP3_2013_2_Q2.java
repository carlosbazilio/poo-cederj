package br.cederj.comp.ano2013;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/* Classe que modela 1 único termo */
class Termo {
	int coeficiente;
	int expoente;
	
	public Termo(int c, int e) {
		coeficiente = c;
		expoente = e;
	}
	
	public Termo(String t) {
		String valores[] = t.trim().split("x");
		coeficiente = Integer.valueOf(valores[0]);
		expoente = Integer.valueOf(valores[1]);
	}
	
	public int getCoeficiente() {
		return coeficiente;
	}
	
	public int getExpoente() {
		return expoente;
	}
	
	public String toString() {
		return coeficiente + "x" + expoente;
	}
}

/* Classe que modela um polinômio */
class Polinomio {
	private List<Termo> termos;
	
	public Polinomio() {
		termos = new ArrayList<Termo>();
	}
	
	public Polinomio(String polinomio) { // P. ex.: "3x2 + 2x1 + 1x0"
		termos = new ArrayList<Termo>();
		
		String regexp  = "(\\d)*x(\\d)*";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(polinomio);
			
        while (matcher.find()) {
            String t = matcher.group();
            Termo termo = new Termo(t);
            termos.add(termo); // Strings da forma nxn, coeficiente e expoente, respectivamente
        }
	}
	
	public void imprimePolinomio() {
		for (Termo t: termos) {
			System.out.print(t + " ");
		}
	}
	
	public double calculaPolinomio (double x) {
		double soma = 0;
		for (Termo t: termos) {
			soma = soma + Math.pow(x, t.getExpoente())*t.getCoeficiente();
		}
		return soma;
	}
	
	public boolean contemExpoente (int e) {
		for (Termo t: termos) {
			if (t.getExpoente() == e)
				return true;
		}
		return false;
	}
	
	public boolean completo() {
		int tamanho = termos.size();
		for (int i=0; i<tamanho; i++)
			if (! this.contemExpoente(i))
				return false;
		return true;
	}
}

public class AP3_2013_2_Q2 {
	public static void main(String[] args) {
		Polinomio p1 = new Polinomio("3x2 + 2x1");
		p1.imprimePolinomio();
		System.out.println("\nValor do polinomio para x igual a 2: " + p1.calculaPolinomio(2));
		System.out.println("Polinomio completo: " + p1.completo());
	}
}

