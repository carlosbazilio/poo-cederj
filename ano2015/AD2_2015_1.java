package br.cederj.comp.ano2015;

abstract class Despesa {
	private float valor;
	
	public Despesa(float valor) {
		this.valor = valor;
	}

	public float getValor() {
		return valor;
	}
	
	abstract public int getMes();
}

class DespesaMes extends Despesa {
	private int mes;
	// mes da despesa

	// valor da despesa
	public DespesaMes(int mes, float valor) {
		super(valor);
		this.mes = mes;
	}

	public int getMes() {
		return mes;
	}
	
	public String toString() {
		return "Mes: " + this.mes + " Valor: " + this.getValor() + "\n";
	}
}

class DespesaDia extends DespesaMes {
	private int dia;

	// dia da despesa
	public DespesaDia(int dia, int mes, float valor) {
		super(mes, valor);
		this.dia = dia;
	}

	public int getDia() {
		return dia;
	}
}

class Despesas {
	Despesa despesas [];
	String cpf;
	
	public Despesas(Despesa[] despesas, String cpf) {
		this.despesas = despesas;
		this.cpf = cpf;
	}
	
	public String getCpf () {
		return this.cpf;
	}
	
	public DespesaMes totalizaMes (int mes) {
		float valor = 0;
		for (int i=0; i<despesas.length; i++)
		{
			if (despesas[i].getMes() == mes)
				valor = valor + despesas[i].getValor(); 
		}		
		return new DespesaMes(mes, valor);
	}
}

class DespesaAntiga extends Despesa {
	String observacao;
	
	public DespesaAntiga (float valor, String obs) {
		super(valor);
		this.observacao = obs;
	}

	public int getMes() {
		return -1;
	}
}

public class AD2_2015_1 {
	public static void main(String[] args) {
		Despesa desp[] = { new DespesaMes(2, 1000), new DespesaDia(10,2,500), new DespesaDia(10,3,500), new DespesaMes(4,750) };
		Despesas totalmes = new Despesas(desp, "001001001-01");
		System.out.println(totalmes.totalizaMes(2));
	}

}
