package br.cederj.comp.ano2008;

import java.util.*;

/**
 * Classe que implementa somat�rio para cole��es 
 */
class MinhaCollections {
	/**
	 * M�todo somat�rio a ser chamado por classes externas
	 * @param c Cole��o que cont�m valores a serem somados
	 * @return Valor da Soma
	 */
	public static Number somatorio (Collection c) {
		Number valor = 0;
		Iterator it = c.iterator();
		if (it.hasNext())
		{
			Object obj = it.next();
			// Reflex�o para obter a classe do objeto armazenado na cole��o
			String nomeClasse = obj.getClass().getSimpleName();
			if (nomeClasse.equalsIgnoreCase("Double"))
				valor = somatorioDouble(c);
			else if (nomeClasse.equalsIgnoreCase("Integer"))
				valor = somatorioInt(c);
		}
		return valor;
	}
	
	/**
	 * M�todo interno (private) da classe para soma de valores Double
	 * @param c Cole��o que cont�m valores a serem somados
	 * @return Valor da Soma
	 */
	private static Double somatorioDouble(Collection<Double> c) {
		Double valor = new Double(0);
		Iterator<Double> it = c.iterator();
		while (it.hasNext()) {
			Double obj = (Double)it.next();
			valor = valor + obj;
		}
		return valor;
	}

	/**
	 * M�todo interno (private) da classe para soma de valores Integer
	 * @param c Cole��o que cont�m valores a serem somados
	 * @return Valor da Soma
	 */
	private static Integer somatorioInt(Collection<Integer> c) {
		Integer valor = 0;
		Iterator<Integer> it = c.iterator();
		while (it.hasNext()) {
			Integer obj = (Integer)it.next();
			valor = valor + obj;
		}
		return valor;
	}
}

public class AP3_2008_2_Q3 {
	/**
	 * M�todo que inicia a aplica��o
	 * Observem que apenas o m�todo somatorio pode ser chamado aqui!
	 */
	public static void main(String[] args) {
		Double[] numeros = new Double[]{new Double(10), new Double(5), new Double(8)};
		System.out.println("Soma: " + MinhaCollections.somatorio(Arrays.asList(numeros)));
		Integer[] numeros2 = new Integer[]{new Integer(10), new Integer(5), new Integer(8)};
		System.out.println("Soma: " + MinhaCollections.somatorio(Arrays.asList(numeros2)));
	}	
}
