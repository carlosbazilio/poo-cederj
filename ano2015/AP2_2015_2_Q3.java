package br.cederj.comp.ano2015;

import java.util.Scanner; //para testar a classe. Nao precisava...
class PolyTerm {
	protected int grau;
	protected double coef;
	protected PolyTerm prox;
	PolyTerm(int g, double c){
		grau = g;
		coef = c; 
	}
	public int getGrau() { return grau; } 
	public double getCoef() { return coef; }
	
	//para conferir a implementacao
	public String toString() { return coef + "X^" + grau + " "; } 
}

//ERA PARA SER IMPLEMENTADA...
class Poly{
	//ERA PARA SER IMPLEMENTADA...
	PolyTerm ini, fim;
	//ERA PARA SER IMPLEMENTADA...
	Poly(){ ini = fim = null; }
	//para conferir a implementacao
	public String toString(){
		String resp = "";
		PolyTerm p = ini;
		while(p != null){
			resp += p.toString();
			p = p.prox; }
		return resp;
	}
	PolyTerm Copia(PolyTerm outro){
		return new PolyTerm(outro.grau, outro.coef);
	}
	//ja existia...
	void insereInicio (PolyTerm p){
		PolyTerm copia = Copia(p);
		copia.prox = ini;
		ini = copia;
		if(fim == null) fim = ini;
	}
	//ja existia...
	void insereFim (PolyTerm p){
		PolyTerm copia = Copia(p);
		copia.prox = null;
		if(fim == null){ ini = fim = copia; return; }
		fim.prox = copia;
		fim = copia;
	}
	//ja existia...
	PolyTerm removeInicio(){
		if(ini == null) return null;
		PolyTerm resp = ini;
		ini = ini.prox;
		if(ini == null) fim = null;
		return resp;
	}
	//ja existia...
	PolyTerm removeFim(){
		if(fim == null) return null;
		PolyTerm resp = ini, p = null;
		while(resp.prox != null){
			p = resp;
			resp = resp.prox;
		}
		if(p == null) ini = fim = null;
		else{
			p.prox = null;
			fim = p; }
		return resp;
	}
	//ja existia...
	PolyTerm ConsultaElemento(int pos){
		if(ini == null) return null;
		PolyTerm p = ini;
		while((p != null) && (p.grau != pos)) p = p.prox; return p;
	}
	//ERA PARA SER IMPLEMENTADA...
	void Soma(Poly p){
		PolyTerm x = p.ini;
		while(x != null){
			PolyTerm y = ConsultaElemento(x.grau);
			if (y == null) insereFim(x);
			else y.coef += x.coef;
			x = x.prox;
		} }
	//ERA PARA SER IMPLEMENTADA...
	void Subtrai(Poly p){
		PolyTerm x = p.ini;
		while(x != null){
			PolyTerm y = ConsultaElemento(x.grau);
			if (y == null){
				PolyTerm z = Copia(x);
				z.coef *= 1.0;
				insereFim(z);
			}
			else y.coef = x.coef;
			x = x.prox;
		} }
	//ERA PARA SER IMPLEMENTADA...
	void Multiplica(Poly p){
		Poly resp = new Poly();
		PolyTerm p1 = ini, p2;
		while(p1 != null){
			p2 = p.ini;
			while(p2 != null){
				PolyTerm z = resp.ConsultaElemento(p1.grau + p2.grau);
				if(z == null){
					z = new PolyTerm(p1.grau + p2.grau, p1.coef * p2.coef);
					resp.insereFim(z);
				}
				else z.coef = z.coef + (p1.coef * p2.coef);
				p2 = p2.prox;
			}
			p1 = p1.prox;
		}
		this.ini = resp.ini;
	}
}
//para conferir a implementacao
public class AP2_2015_2_Q3{
	public static void main(String[] args){
		int grau, i;
		double coef;
		Poly pol1 = new Poly(), pol2 = new Poly();
		Scanner sc = new Scanner(System.in);
		grau = sc.nextInt();
		for(i = 0; i <= grau; i++){
			coef = sc.nextDouble();
			PolyTerm x = new PolyTerm(i, coef);
			pol1.insereFim(x);
		}
		grau = sc.nextInt();
		for(i = 0; i <= grau; i++){
			coef = sc.nextDouble();
			PolyTerm x = new PolyTerm(i, coef);
			pol2.insereFim(x);
		}
		sc.close();
		pol1.Soma(pol2);
		System.out.println(pol1);
		System.out.println(pol2);
		pol1.Subtrai(pol2);
		System.out.println(pol1);
		System.out.println(pol2);
		pol1.Multiplica(pol2);
		System.out.println(pol1);
		System.out.println(pol2);
	} 
}

