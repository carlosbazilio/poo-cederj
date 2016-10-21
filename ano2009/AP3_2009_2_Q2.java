package br.cederj.comp.ano2009;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Comparator;

enum TipoOperacao {
	saque, deposito, transferencia
};

class OperacaoIlegal2 extends Exception {
	ContaCorrente2 cc;
	float valor;
	TipoOperacao operacao; 
	public OperacaoIlegal2(ContaCorrente2 contaCorrente, float valor, TipoOperacao op) {
		this.cc = contaCorrente;
		this.valor = valor;
		this.operacao = op;
	}
}

class Transacao {
	ContaCorrente2 conta;
	TipoOperacao operacao; 
	float valor;
	GregorianCalendar hora;
	public Transacao(ContaCorrente2 c, TipoOperacao op, float v) {
		conta = c;
		operacao = op;
		valor = v;
		hora = new GregorianCalendar();
	}
	public void exibeTransacao () {
		System.out.println("***");
		System.out.println("Cliente: " + conta.numConta);
		System.out.println("Operacao: " + operacao);
		System.out.println("Valor: " + valor);
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss - dd.MM.yyyy");
		System.out.println("Hora: " + sdf.format(hora.getTime()));
	}
}

class TransacaoComparator implements Comparator<Transacao> {
    public int compare(Transacao t1, Transacao t2) {
    	return t1.hora.compareTo(t2.hora);
    }
}

class Transferencia extends Transacao {
	ContaCorrente2 conta2;
	public Transferencia(ContaCorrente2 c, float v, ContaCorrente2 c2) {
		super(c, TipoOperacao.transferencia, v);
		conta2 = c2;
	}
	public void exibeTransacao () {
		super.exibeTransacao();
		System.out.println("Cliente Parceiro: " + conta2.numConta);
	}
}

class ContaCorrente2 {
	int numConta;
	float saldo;
	List<Transacao> transacoes;
	public ContaCorrente2(int pConta, float pSaldo) {
		this.numConta = pConta; this.saldo = pSaldo;
		transacoes = new ArrayList<Transacao>();
	}
	public float consultaSaldo() {
		return this.saldo;
	}
	public void realizaDeposito(float valor) throws OperacaoIlegal2 {
		if (valor < 0)
			throw new OperacaoIlegal2(this, valor, TipoOperacao.deposito);
		else {
			this.saldo = this.saldo + valor;
			transacoes.add(new Transacao(this, TipoOperacao.deposito, valor));
		}
	}
	public void realizaSaque(float valor) throws OperacaoIlegal2 {
		if (valor >= this.saldo)
			throw new OperacaoIlegal2(this, valor, TipoOperacao.saque);
		else {
			this.saldo = this.saldo - valor;
			transacoes.add(new Transacao(this, TipoOperacao.saque, valor));
		}
	}
	public void realizaTransferencia(float valor, ContaCorrente2 pBenef) throws OperacaoIlegal2 {
		try {
			this.realizaSaque(valor);
			pBenef.realizaDeposito(valor);
			transacoes.add(new Transferencia(this, -valor, pBenef));
			pBenef.transacoes.add(new Transferencia(pBenef, valor, this));
		} catch (OperacaoIlegal2 e) {
			throw new OperacaoIlegal2(this, valor, TipoOperacao.transferencia);
		}
	}
	public void exibeExtrato() {
		TransacaoComparator comp = new TransacaoComparator();
		Collections.sort(transacoes, comp);
		for (Transacao trans : transacoes) {
			trans.exibeTransacao();
		}
	}
}

public class AP3_2009_2_Q2 {
	public static void main(String[] args) {
		ContaCorrente2 c1 = new ContaCorrente2(1, 500);
		ContaCorrente2 c2 = new ContaCorrente2(2, 500);
		try {
			c1.realizaDeposito(50);
			c1.realizaSaque(100);
			c1.realizaTransferencia(10, c2);
			c1.exibeExtrato();
			c2.exibeExtrato();
		} catch (OperacaoIlegal2 e) {
			System.out.println("Operação de " + e.operacao + " com valor " + e.valor + " inválida para a conta " + e.cc.numConta + "!");
		}
	}
}
