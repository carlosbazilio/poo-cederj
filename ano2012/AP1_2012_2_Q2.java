package br.cederj.comp.ano2012;

/*
 * Crit�rios gerais de corre��o:
 * 
 * - Quest�o vale 3 pontos
 * - Cada classe vale 1 ponto
 * - Erro na heran�a (- 0.5 pontos)
 * - Erro na defini��o de classe abstrata ou interface (- 0.5 pontos)
 * - Erro na defini��o de atributo est�tico da classe Poupan�a (- 0.2 pontos)
 * 
 */

import java.util.GregorianCalendar;

abstract class Aplicacao {
	float saldoInicial;
	float saldoAcumulado;
	GregorianCalendar inicio;
	
	public Aplicacao(float saldoInicial, float saldoAcumulado, GregorianCalendar inicio) {
		this.saldoInicial = saldoInicial;
		this.saldoAcumulado = saldoAcumulado;
		this.inicio = inicio;
	}

	abstract int periodicidade();
}

class FundoInvestimento extends Aplicacao {
	float percentualIR;
	float taxaAdministracao;

	public FundoInvestimento(float saldoInicial, float saldoAcumulado,
			float percentualIR, float taxaAdministracao, GregorianCalendar inicio) {
		super(saldoInicial, saldoAcumulado, inicio);
		this.percentualIR = percentualIR;
		this.taxaAdministracao = taxaAdministracao;
	}
	
	int periodicidade() {
		return 1;
	}
}

class Poupanca extends Aplicacao {
	static float juros;
	
	public Poupanca(float saldoInicial, float saldoAcumulado, GregorianCalendar inicio) {
		super(saldoInicial, saldoAcumulado, inicio);
	}

	int periodicidade() {
		return 30;
	}
}
