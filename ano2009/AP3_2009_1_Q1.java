package br.cederj.comp.ano2009;

class OperacaoIlegal extends Exception {
	enum TipoOperacao {saque, deposito};
	ContaCorrente cc;
	float valor;
	TipoOperacao operacao; 
	public OperacaoIlegal(ContaCorrente contaCorrente, float valor, TipoOperacao op) {
		this.cc = contaCorrente;
		this.valor = valor;
		this.operacao = op;
	}
}

class ContaCorrente {
	int conta;
	float saldo;
	public ContaCorrente(int pConta, float pSaldo) {
		this.conta = pConta; this.saldo = pSaldo;
	}
	public float obtemSaldo() {
		return saldo;
	}
	public void realizaDeposito(float valor) throws OperacaoIlegal {
		if (valor < 0)
			throw new OperacaoIlegal(this, valor, OperacaoIlegal.TipoOperacao.deposito);
		else
			this.saldo = this.saldo + valor;
	}
	public void realizaSaque(float valor) throws OperacaoIlegal {
		if (valor >= this.saldo)
			throw new OperacaoIlegal(this, valor, OperacaoIlegal.TipoOperacao.saque);
		else
			this.saldo = this.saldo - valor;
	}
}

public class AP3_2009_1_Q1 {
	public static void main(String[] args) {
		ContaCorrente c = new ContaCorrente(1, 500);
		try {
			c.realizaSaque(1000);
		} catch (OperacaoIlegal e) {
			System.out.println("Operação de " + e.operacao + " com valor " + e.valor + " inválida para a conta " + e.cc.conta + "!");
		}
	}
}
