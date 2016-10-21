package br.cederj.comp.ano2015;

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
        return "Esta é uma esfera. Seu volume é: " + this.getVolume();
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
        return "Esta é um cubo. Seu volume é: " + this.getVolume();
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

public class AP2_2015_1_Q3 {
    public static final int MAX = 3; 
	public static void main(String[] args) {
        Figura3D[] shapes = new Figura3D[MAX];
        shapes[0] = new Esfera(20);
        shapes[1] = new Cubo(10);
        //shapes[2] = new Cilindro(10, 20);

        for (int i = 0; i < shapes.length; i++) {
            switch(i) {
	            case 0:
	                System.out.print("\nEsta é uma esfera. Seu volume é: " + shapes[0].getVolume());
	                break;
	            case 1:
	                System.out.print("\nEste é um cubo. Seu volume é: " + shapes[1].getVolume());
	                break;
	            case 2:
	                System.out.print("\nEste é um cilindro. Seu volume é: " + shapes[2].getVolume());
	                break;
            }
        }
        
        for (Figura3D f : shapes) {
        	System.out.println(f);
        }
	}
}
