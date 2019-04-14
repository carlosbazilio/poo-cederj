package br.cederj.comp.ano2019;

// Item a
class Startup {
	String nome;
	String area; // tecnologia, social, saúde, finanças, educação
	double investimentos;
	double receitas;
	double despesas;
	
	public Startup(String n, String a, double i, double r, double d) {
		this.nome = n; this.area = a; this.investimentos = i;
		this.receitas = r; this.despesas = d;
	}
	
	public double obtemInvestimentos () {
		return investimentos;
	}
	
	public double obtemDespesas () {
		return despesas;
	}
	
	public double obtemReceitas () {
		return receitas;
	}
	
	public double situacao () {
		return obtemInvestimentos() + obtemReceitas() - obtemDespesas();
	}

	public double obtemVolume() {
		return this.obtemInvestimentos() + this.obtemReceitas() + this.obtemDespesas();
	}
	
	public String toString() {
		return "Nome: " + this.nome + "\n" + 
	           "Área: " + this.area + "\n" + 
	           "Investimentos: " + obtemInvestimentos() + "\n" + 
	           "Receitas: " + obtemReceitas() + "\n" + 
	           "Despesas: " + obtemDespesas() + "\n";
	}
}

// Item b
class Aceleradora {
	private Startup empresas[];
	private int qtdEmpresas;
	
	public Aceleradora (int q) {
		empresas = new Startup[q];
		qtdEmpresas = 0;
	}
	
	public void adicionaEmpresa(Startup s) {
		empresas[qtdEmpresas] = s;
		qtdEmpresas++;
	}
	
	public double volumeRecursos () {
		double volume = 0;
		for (int i = 0; i < qtdEmpresas; i++) {
			volume += empresas[i].obtemVolume();
		}
		return volume;
	}
	
	@Override 
	public String toString() {
		String saida = "";
		for (int i = 0; i < qtdEmpresas; i++) {
			saida += empresas[i].toString();
		}
		return saida;
	}
}

public class AP1_2019_1_Q1 {
	public static void main(String[] args) {
		// Item c
		Startup e99 = new Startup("99", "transporte", 300, 500, 100);
		Startup nubank = new Startup("Nubank", "finanças", 400, 500, 200);
		Startup cargox = new Startup("CargoX", "transporte", 200, 400, 150);
		Startup movile = new Startup("Movile", "tecnologia", 500, 300, 150);
		
		Aceleradora acel = new Aceleradora(10);
		acel.adicionaEmpresa(e99);
		acel.adicionaEmpresa(nubank);
		acel.adicionaEmpresa(cargox);
		acel.adicionaEmpresa(movile);
		
		System.out.println("Volume de recursos da aceleradora: " + acel.volumeRecursos());
		
		System.out.println("Relatório da aceleradora:\n" + acel);
	}
}
