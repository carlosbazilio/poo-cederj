package br.cederj.comp.ano2008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe principal que inicia o programa
 * @author bazilio
 */
public class AP2_2008_2_Q2 {
	public static void main(String[] args) {
		Polinomio polinomio1 = new Polinomio();
		Polinomio polinomio2 = new Polinomio();
		
		polinomio1.lePolinomio();
		polinomio2.lePolinomio();
		
		Polinomio polinomio3 = polinomio1.adicao(polinomio2);
		
		polinomio3.imprimePolinomio();
		polinomio3.imprimeValorPolinomio();		
	}
}

/**
 * Classe que modela um polinômio
 * @author bazilio
 */
class Polinomio {
	private List<Termo> termos;
	
	public Polinomio() {
		termos = new ArrayList<Termo>();
	}
	
	public List<Termo> obtemTermos() {
		return termos;
	}
	
	public void imprimePolinomio() {
		Iterator<Termo> it = termos.iterator();
		while (it.hasNext()) {
			System.out.print(((Termo)it.next()).toString() + " ");
		}
		System.out.println();
	}
	
	public void lePolinomio() {
		try {
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String str = "";
	        int exp = -1, coef = -1;
	        System.out.println("Digite os expoentes e coeficientes do polinômio ");
            while (exp != 0 && coef != 0) {
            	System.out.println("Expoente: ");
	            str = in.readLine();
	            exp = Integer.parseInt(str);
	            System.out.println("Coeficiente: ");
	            str = in.readLine();
	            coef = Integer.parseInt(str);
	            if (exp != 0 && coef != 0) {
		            Termo t = new Termo(coef, exp);
		            termos.add(t);
	            }
	        }
	    } catch (IOException e) {
	    }
	}
	
	public Polinomio adicao(Polinomio p) {
		Termo t1 = null;
		Termo t2 = null;
		
		Iterator<Termo> it1 = termos.iterator();
		Iterator<Termo> it2 = p.obtemTermos().iterator();
		
		Polinomio pRes = new Polinomio();		
		List<Termo> res = pRes.obtemTermos();
		
		while (it1.hasNext() && it2.hasNext()) {
			if (t1 == null)
				t1 = (Termo)(it1.next());
			if (t2 == null)
				t2 = (Termo)(it2.next()); 
			if (t1.getExpoente() == t2.getExpoente())
				res.add(new Termo(t1.getCoeficiente()+t2.getCoeficiente(), t1.getExpoente()));
			else 
				if (t1.getExpoente() < t2.getExpoente())
					res.add(new Termo(t1.getCoeficiente(), t1.getExpoente()));
				else
					res.add(new Termo(t2.getCoeficiente(), t2.getExpoente()));
				
			if (it1.hasNext())
				t1 = (Termo)(it1.next());
			else
			{
				res.add(new Termo(t2.getCoeficiente(), t2.getExpoente()));
				while (it2.hasNext()) {
					t2 = (Termo)(it2.next());
					res.add(new Termo(t2.getCoeficiente(), t2.getExpoente()));
				}
				break;
			}
			if (it2.hasNext())
				t2 = (Termo)(it2.next());
			else
			{
				res.add(new Termo(t1.getCoeficiente(), t1.getExpoente()));
				while (it1.hasNext()) {
					t1 = (Termo)(it1.next());
					res.add(new Termo(t1.getCoeficiente(), t1.getExpoente()));
				}
				break;
			}
		}
		
		while (it1.hasNext()) {
			t1 = (Termo)(it1.next());
			res.add(new Termo(t1.getCoeficiente(), t1.getExpoente()));
		}
		
		while (it2.hasNext()) {
			t2 = (Termo)(it2.next());
			res.add(new Termo(t2.getCoeficiente(), t2.getExpoente()));
		}
		
		return pRes;
	}
	
	public void imprimeValorPolinomio() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        int exp = 0;
        System.out.println("Digite o valor de x: ");
        try {
			str = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
        exp = Integer.parseInt(str);
        System.out.println("O valor do polinomio(" + str + ") é: " + this.calculaPolinomio(exp));
	}
	
	public double calculaPolinomio(int x) {
		double valor = 0;
		Termo t1 = null;
		Iterator<Termo> it1 = termos.iterator();
		
		while (it1.hasNext()) {
			t1 = (Termo)(it1.next());
			valor = valor + t1.getCoeficiente() * Math.pow(x, t1.getExpoente());
		}
		
		return valor;
	}
}

/**
 * Classe que modela 1 único termo
 * @author bazilio
 */
class Termo {
	int coeficiente;
	int expoente;
	
	public Termo(int c, int e) {
		coeficiente = c;
		expoente = e;
	}
	
	public int getCoeficiente() {
		return coeficiente;
	}
	
	public int getExpoente() {
		return expoente;
	}

	public void setCoeficiente(int coeficiente) {
		this.coeficiente = coeficiente;
	}

	public void setExpoente(int expoente) {
		this.expoente = expoente;
	}
	
	public String toString() {
		return coeficiente + "x" + expoente;
	}
}
