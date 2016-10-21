package br.cederj.comp.ano2013;

class Veiculo {
	int numRodas;
	String marca;
	float peso;
	int potencia;
	int qtdLugares;
	
	public Veiculo(int numRodas, String marca, float peso, int potencia, int lugares) {
		this.numRodas = numRodas;
		this.marca = marca;
		this.peso = peso;
		this.potencia = potencia;
		this.qtdLugares = lugares;
	}

	public float cargaUtil() {
		return this.peso + this.qtdLugares * 70;
	}
	
	public float rpp() {
		return this.cargaUtil() / this.potencia;
	}
}

class Carro extends Veiculo {
	
	public Carro(String marca, float peso, int potencia) {
		super(4, marca, peso, potencia, 5);
	}
}

public class AP1_2013_2_Q3 {
	public static void main(String[] args) {
		Carro logan = new Carro("Logan", 1080, 95);
		Carro cobalt = new Carro("Cobalt", 1117, 102);
		System.out.println("O carro com menor relação peso/potência é o: " + (logan.rpp() < cobalt.rpp() ? logan.marca : cobalt.marca));
	}
}

