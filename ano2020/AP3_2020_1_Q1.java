package br.cederj.comp.ano2020;

import java.io.*; import java.util.*;

abstract class ClassePizza{ private String desc;

ClassePizza (String d){ desc = d; }

public String toString(){ return desc; }

}

class Doce extends ClassePizza{ Doce(){ super("Doce"); }

protected Doce(String d){ super(d); }

}

class DoceEspecial extends Doce{ DoceEspecial(){ super("Doce Especial"); } }

class Salgada extends ClassePizza{ Salgada(){ super("Salgada"); }

protected Salgada(String d){ super(d); }

}

class Especial extends Salgada{ Especial(){ super("Especial"); } } class Vegetariana extends Salgada{ Vegetariana(){ super("Vegetariana"); } }

class Pizza implements Comparable{ int codigo; String nome; ClassePizza classe; float preco;

Pizza(int c, String n, ClassePizza cp, float p){ codigo = c;

nome = n;

classe = cp;

preco = p;

} public int compareTo(Object o) {

	Pizza pizza = (Pizza) o; int resp = classe.toString().compareTo(pizza.classe.toString()); if (resp != 0) return resp; if (preco > pizza.preco) return 1; if (preco < pizza.preco) return -1; if (codigo > pizza.codigo) return 1; if (codigo < pizza.codigo) return -1; return 0;

}

public String toString(){ return codigo + " - " + nome + " - R$ " + preco + "\n"; }

}

public class Q1_AP3_2020_1{

	public static void main(String[] args) throws IOException{ BufferedReader in;

	in = new BufferedReader(new FileReader(args[0]));

	BufferedWriter out; out = new BufferedWriter(new FileWriter("out-" + args[0])); try {

		List<Pizza> l = new ArrayList<Pizza>();

		String s = in.readLine(); while(s != null){ String vs[] = s.split(" / ");

		int cod = Integer.parseInt(vs[0]);

		String aux[] = vs[3].split(" ");

		float preco = Float.parseFloat(aux[1]);

		ClassePizza cp; if(vs[2].equals("Doce Especial")) cp = new DoceEspecial(); else if(vs[2].equals("Doce")) cp = new Doce(); else if(vs[2].equals("Especial")) cp = new Especial(); else if(vs[2].equals("Salgada")) cp = new Salgada(); else cp = new Vegetariana(); Pizza pizza = new Pizza(cod, vs[1], cp, preco); l.add(pizza); s = in.readLine();

		} in.close(); Collections.sort(l);

		String resp = "Doce:\n", desc = "Doce";

		for(Pizza pizza:l){

			if(!desc.equals(pizza.classe.toString())){ desc = pizza.classe.toString();

			resp += desc + ":\n";

			} resp += pizza.toString();

		} out.write(resp); out.close();

	} catch (Exception e){ System.out.println("Excecao\n"); }

	}

}