package br.cederj.comp.ano2017;

import br.cederj.comp.ano2014.Bombeiro;
import br.cederj.comp.ano2014.IPTU;
import br.cederj.comp.ano2014.Imovel;

public class AP2_2017_1_Q3 {
	public static void main(String[] args) {
		Imovel apto = new Imovel(100000);
		apto.adicionaImposto(new IPTU(0.03));
		apto.adicionaImposto(new Bombeiro());
		System.out.println(apto.calculaSomaImpostos());
	}
}

