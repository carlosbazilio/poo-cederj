package br.cederj.comp.ano2015;

class DespesaMesOld {
	private int mes;
	// mes da despesa
	private float valor;

	// valor da despesa
	public DespesaMesOld(int mes, float valor) {
		this.mes = mes;
		this.valor = valor;
	}

	public int getMes() {
		return mes;
	}

	public float getValor() {
		return valor;
	}
}

class DespesaDiaOld extends DespesaMesOld {
	private int dia;

	// dia da despesa
	public DespesaDiaOld(int dia, int mes, float valor) {
		super(mes, valor);
		this.dia = dia;
	}

	public int getDia() {
		return dia;
	}
}

class DespesasOld {
	DespesaMesOld despesas [];
	String cpf;
	
	public DespesasOld(DespesaMesOld[] despesas, String cpf) {
		this.despesas = despesas;
		this.cpf = cpf;
	}
	
	public String getCpf () {
		return this.cpf;
	}
	
	public DespesaMesOld totalizaMes (int mes) {
		float valor = 0;
		for (int i=0; i<despesas.length; i++)
		{
			if (despesas[i].getMes() == mes)
				valor = valor + despesas[i].getValor(); 
		}		
		return new DespesaMesOld(mes, valor);
	}
}

