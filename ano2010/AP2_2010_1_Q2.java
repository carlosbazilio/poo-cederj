package br.cederj.comp.ano2010;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Comparator;

class OperacaoIlegal extends Exception {
	ContaCorrente cc;
	float valor;
	Transacao operacao; 
	public OperacaoIlegal(ContaCorrente contaCorrente, float valor, Transacao op) {
		this.cc = contaCorrente;
		this.valor = valor;
		this.operacao = op;
	}
}

abstract class Transacao {
	ContaCorrente conta; 
	float valor;
	GregorianCalendar hora;
	public Transacao(ContaCorrente c, float v) {
		conta = c;
		valor = v;
		hora = new GregorianCalendar();
	}
	public String obtemTipo() {
		return this.getClass().getSimpleName().toLowerCase(); 
	}
	public float obtemValor() {
		return valor;
	}
	public void exibeTransacao () {
		System.out.println("***");
		System.out.println("Cliente: " + conta.numConta);
		System.out.println("Operacao: " + this.obtemTipo());
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

class Deposito extends Transacao {
	public Deposito(ContaCorrente c, float v) {
		super(c, v);
	}
}

class Saque extends Transacao {
	public Saque(ContaCorrente c, float v) {
		super(c, v);
	}
	public float obtemValor() {
		return -valor;
	}
}

class Transferencia extends Transacao {
	ContaCorrente conta2;
	public Transferencia(ContaCorrente c, float v, ContaCorrente c2) {
		super(c, v);
		conta2 = c2;
	}
	public void exibeTransacao () {
		super.exibeTransacao();
		System.out.println("Cliente Parceiro: " + conta2.numConta);
	}
	public float obtemValor() {
		return -valor;
	}
}

class ContaCorrente {
	int numConta;
	float saldo;
	List<Transacao> transacoes;
	public ContaCorrente(int pConta, float pSaldo) {
		this.numConta = pConta; this.saldo = pSaldo;
		transacoes = new ArrayList<Transacao>();
	}
	public float consultaSaldo() {
		return this.saldo;
	}
	public void realizaDeposito(float valor) throws OperacaoIlegal {
		Transacao t = new Deposito(this, valor);
		if (valor < 0)
			throw new OperacaoIlegal(this, valor, t);
		else {
			this.saldo = this.saldo + valor;
			transacoes.add(t);
		}
	}
	public void realizaSaque(float valor) throws OperacaoIlegal {
		Transacao t = new Saque(this, valor);
		if (valor >= this.saldo)
			throw new OperacaoIlegal(this, valor, t);
		else {
			this.saldo = this.saldo - valor;
			transacoes.add(t);
		}
	}
	public void realizaTransferencia(float valor, ContaCorrente pBenef) throws OperacaoIlegal {
		Transacao t = new Transferencia(this, valor, pBenef); 
		try {
			this.realizaSaque(valor);
			pBenef.realizaDeposito(valor);
			transacoes.add(t);
			pBenef.transacoes.add(t);
		} catch (OperacaoIlegal e) {
			throw new OperacaoIlegal(this, valor, t);
		}
	}
	public void realizaPagamento(int codigo, int valor, String descr, GregorianCalendar data) throws OperacaoIlegal {
		Transacao t = new Pagamento(this, valor, codigo, descr, data);
		if (valor >= this.saldo)
			throw new OperacaoIlegal(this, valor, t);
		else {
			this.saldo = this.saldo - valor;
			transacoes.add(t);
		}
	}
	public void exibeExtrato() {
		TransacaoComparator comp = new TransacaoComparator();
		Collections.sort(transacoes, comp);
		for (Transacao trans : transacoes) {
			trans.exibeTransacao();
		}
		System.out.println("Valores movimentados: " + this.volumeTotal());
	}
	public float volumeTotal() {
		float total = 0f;
		for (Transacao trans : transacoes) {
			total = total + trans.obtemValor();
		}
		return total;
	}
}

class Pagamento extends Transacao {
	int codigo;
	String descricao;
	GregorianCalendar dataPagamento;
	public Pagamento(ContaCorrente c, float v, int codigo, String descricao, GregorianCalendar data) {
		super(c, v);
		this.codigo = codigo;
		this.descricao = descricao;
		this.dataPagamento = data;
	}
	public float obtemValor() {
		return -valor;
	}
}

public class AP2_2010_1_Q2 {
	public static void main(String[] args) {
		ContaCorrente c1 = new ContaCorrente(1, 500);
		ContaCorrente c2 = new ContaCorrente(2, 500);
		try {
			c1.realizaDeposito(50);
			c1.realizaSaque(100);
			c1.realizaTransferencia(10, c2);
			c2.exibeExtrato();
			c1.realizaPagamento(111543, 100, "Conta de Luz", new GregorianCalendar());
			c1.exibeExtrato();
		} catch (OperacaoIlegal e) {
			System.out.println("Operação de " + e.operacao.obtemTipo() + " com valor " + e.valor + " inválida para a conta " + e.cc.numConta + "!");
		}
	}
}
