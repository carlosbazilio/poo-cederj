package br.cederj.comp.ano2007;

public class AP3_2007_2_Q4 {
	public static void main(String[] args) {
		Numero n = new Numero(5);
		Numero n2 = new Numero(3);
		System.out.println(n.toString());
		System.out.println(n2.toString());
		System.out.println(n.add(n2));
	}
}

class Numero {
	private String sbits;
	
	public Numero() {
		sbits = "";
	}
	
	public Numero(int valor) {
		sbits = Integer.toBinaryString(valor);
	}
	
	public Numero(int valor, String bit) {
		sbits = bit;
		for (int i = 1; i < valor; i++)
			sbits = sbits + bit;
	}
	
	public Numero(String valor) {
		sbits = valor;
	}
	
	public String add(Numero n) {
		String res = "";
		int vai1 = 0;
		
		if (n.sbits.length() > this.sbits.length()) {
			int d;
			d = n.sbits.length() - this.sbits.length();
			this.sbits = (new Numero(d, "0")).toString() + this.sbits;
		}
		else
			if (n.sbits.length() < this.sbits.length()) {
				int d;
				d = this.sbits.length() - n.sbits.length();
				n.sbits = (new Numero(d, "0")).toString() + n.sbits;
			}
		
		for (int x = this.sbits.length()-1; x >= 0; x--) {
			if (sbits.charAt(x) == '0' && n.sbits.charAt(x) == '0') {
				if (vai1 == 0) {
					res = "0" + res;
					vai1 = 0;
				}
				else
				{
					res = "1" + res;
					vai1 = 0;
				}
			}
			else
				if (sbits.charAt(x) == '1' && n.sbits.charAt(x) == '1') {
					if (vai1 == 0) {
						res = "0" + res;
						vai1 = 1;
					}
					else
					{
						res = "1" + res;
						vai1 = 1;
					}
				}
				else {
					if (vai1 == 0) {
						res = "1" + res;
						vai1 = 0;
					}
					else
					{
						res = "0" + res;
						vai1 = 1;
					}
				}
		}
		
		if (vai1 == 1)
			res = "1" + res;
			
		return res;
	}
	
	public String toString() {
		return sbits;
	}
}
