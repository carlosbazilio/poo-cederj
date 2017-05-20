package br.cederj.comp.ano2017;

interface Figura3D {
    public double getArea();
    public double getVolume();
    public String toString();
    public boolean equals(Object obj);
}

class Esfera implements Figura3D {
    private double raio;

    public Esfera(double r) {
        raio = r;
    }

    public double getRadius() {
        return raio;
    }

    public double getArea() {
        return 4 * Math.PI * Math.pow(raio, 2);
    }

    public double getVolume() {
        return 4.0 * Math.PI * Math.pow(raio, 3) / 3.0;
    }

    public String toString() {
        return "Esta � uma esfera. Seu volume �: " + this.getVolume();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Esfera) {
            Esfera other = (Esfera) obj;
            return raio == other.raio;
        }
        else
            return false;
    }
}

// Item a)
class Cubo implements Figura3D {
	private double lado;
	
	public Cubo(int l) {
		this.lado = l;
	}

	public double getArea() {
		return 6 * lado * lado;
	}

	public double getVolume() {
		return lado * lado * lado;
	}

    public String toString() {
        return "Este � um cubo. Seu volume �: " + this.getVolume();
    }	

    public boolean equals(Object obj) {
        if (obj instanceof Cubo) {
            Cubo other = (Cubo) obj;
            return this.lado == other.lado;
        }
        else
            return false;
    }
}

// Item b)
class Cilindro implements Figura3D {
	double raio, altura;
	public Cilindro(double r, double h) {
		this.raio = r; this.altura = h;
	}

	public double getArea() {
		return 2 * Math.PI * this.raio * this.altura;
	}

	public double getVolume() {
		return Math.PI * Math.pow(this.raio, 2) * this.altura;
	}

    public String toString() {
        return "Este � um cilindro. Seu volume �: " + this.getVolume();
    }
}

// Item d)
class CilindroOco extends Cilindro {
	double raioInterno;
	public CilindroOco(int r, int R, int h) {
		super(R, h);
		this.raioInterno = r;
	}
	
	public double getVolume() {
		Cilindro interno = new Cilindro (this.raioInterno, this.altura);
		Cilindro externo = new Cilindro (this.raio, this.altura);
		return (externo.getVolume() - interno.getVolume());
	}
	
	public String toString() {
        return "Este � um cilindro oco. Seu volume �: " + this.getVolume();
	}
}

public class AD1_2017_1 {
    public static final int MAX = 4; 
	public static void main(String[] args) {
        Figura3D[] shapes = new Figura3D[MAX];
        shapes[0] = new Esfera(20);
        shapes[1] = new Cubo(10);
        shapes[2] = new Cilindro(10, 20);

        for (int i = 0; i < shapes.length; i++) {
            switch(i) {
	            case 0:
	                System.out.print("\nEsta � uma esfera. Seu volume �: " + shapes[0].getVolume());
	                break;
	            case 1:
	                System.out.print("\nEste � um cubo. Seu volume �: " + shapes[1].getVolume());
	                break;
	            case 2:
	                System.out.print("\nEste � um cilindro. Seu volume �: " + shapes[2].getVolume());
	                break;
            }
        }
        
        shapes[3] = new CilindroOco(5, 10, 20);
        
        // Item c)
        for (Figura3D f : shapes) {
        	System.out.println(f);
        }
	}
}
