package br.cederj.comp.ano2009;

// item 4)
/**
 * Interface Objeto solicitada no item 4)
 */
interface Objeto {
	double area ();
}

/**
 * Classe Retangulo apresentada no exercício da AD1/2009
 * com algumas modificações para adequação com os exercícios
 * pedidos
 */
class Retangulo2 implements ObjetoBasico { 
	private double lado1, lado2;
	public Retangulo2() {}
	
	// item 2)
	public Retangulo2(double l1, double l2) {
		this.lado1 = l1;
		this.lado2 = l2;
	}
	public double getLado1 () { 
		return lado1; 
	}   
	public void setLado1 (double l) { 
		lado1 = l; 
	} 
	public double getLado2 () { 
		return lado2; 
	}   
	public void setLado2 (double l) { 
		lado2 = l; 
	}
	public double area () { 
		return this.getLado1()*this.getLado2();
	} 
}

// item 3)
/**
 * Classe Circunferencia solicitada no item 3)
 */
class Circunferencia implements ObjetoBasico {
	double raio;
	
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}
	public double area () { 
		return Math.PI*Math.pow(this.getRaio(),2);
	}
}

// item 5)
/**
 * Classe Caixa solicitada no item 5)
 */
class Caixa extends Retangulo2 {
	double lado3;
	
	public Caixa(double l1, double l2, double l3) {
		super (l1, l2);
		lado3 = l3;
	}
	public double getLado3() {
		return lado3;
	}
	public void setLado3(double lado3) {
		this.lado3 = lado3;
	}
	public double area() {
		return 2*this.getLado1()*this.getLado2() +
			   2*this.getLado2()*this.getLado3() +
			   2*this.getLado1()*this.getLado3();
	}
	public double volume() {
		return this.getLado1()*this.getLado2()*this.getLado3();
	}
}

public class AD1_2009_1 {
	public static void main(String[] args) {
		// item 1)
		Retangulo2 objRetangulo = new Retangulo2();
		objRetangulo.setLado1(1.5);
		objRetangulo.setLado2(1.5);
		System.out.println("Área do retângulo: " + objRetangulo.area());

		// item 2)
		Retangulo2 objRetanguloNovo = new Retangulo2(1.5, 1.5);
		System.out.println("Área do retângulo: " + objRetanguloNovo.area());
	}
}


