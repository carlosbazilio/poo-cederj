package br.cederj.comp.ano2020;

import java.util.Scanner;

class Pilha {
	private Object valores[];
	private int topo;
	
	public Pilha (int tamanho) {
		valores = new Object[tamanho];
		topo = 0;
	}
	
	public boolean vazia() {
		return topo == 0;
	}
	
	public void empilha (Object o) {
		valores[topo] = o;
		topo++;
	}
	
	public Object desempilha () {
		if (! vazia()) {
			topo--;
			return valores[topo];
		}
		return null;
	}
}

class Calculadora {
	public static Integer calcula (Integer op1, String op, Integer op2) {
		if (op.compareTo("+") == 0) return op1 + op2;
		else if (op.compareTo("-") == 0) return op1 - op2;
		else if (op.compareTo("*") == 0) return op1 * op2;
		else if (op.compareTo("/") == 0) return op1 / op2;
		else if (op.compareTo("%") == 0) return op1 % op2;
		return 0;
	}
}

class Conjunto {
	private String simbolos[];
	public Conjunto (String valores[]) {
		simbolos = valores.clone();
	}
	
	public boolean contem (String simbolo) {
		for (int i=0; i<simbolos.length; i++)
			if (simbolos[i].compareTo(simbolo) == 0)
				return true;
		return false;
	}
}

public class AP1_2020_2_Q1linha {
	public static void main(String[] args) {
		//final List<String> operadores = Arrays.asList("+", "-", "*", "/", "%");
		Conjunto operadores = new Conjunto(new String[]{"+", "-", "*", "/", "%"});
		Scanner sc = new Scanner(System.in);
		String soriginal = sc.nextLine();  
		while (!soriginal.equals("FIM")) {
			//String vs[] = s.split(" ");
			String s = soriginal.replaceAll("\\s+",""); // Expressão Regular === Regex
			int i; //, ind_ops = 0, ind_vals = 0;
//			char ops[] = new char[s.length()];
//			int vals[] = new int[s.length()];
			Pilha expressao = new Pilha(s.length());
			for (i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(');
				/*if (vs[i].equals("("));
				else if (vs[i].equals("+")) 
					ops[ind_ops++] = vs[i].charAt(0);
				else if (vs[i].equals("-")) 
					ops[ind_ops++] = vs[i].charAt(0);
				else if (vs[i].equals("*")) 
					ops[ind_ops++] = vs[i].charAt(0);
				else if (vs[i].equals("/")) 
					ops[ind_ops++] = vs[i].charAt(0);
				else if (vs[i].equals("%")) 
					ops[ind_ops++] = vs[i].charAt(0);*/
				else if (operadores.contem(String.valueOf(s.charAt(i))))
					expressao.empilha(String.valueOf(s.charAt(i)));
				else if (s.charAt(i) == ')') {
					/*char op = ops[--ind_ops];
					int v = vals[--ind_vals];
					if (op == '+') v = vals[--ind_vals] + v;
					else if (op == '-') v = vals[--ind_vals] - v;
					else if (op == '*') v = vals[--ind_vals] * v;
					else if (op == '/') v = vals[--ind_vals] / v;
					else if (op == '%') v = vals[--ind_vals] % v;
					vals[ind_vals++] = v;*/
					Integer operando2 = (Integer) expressao.desempilha();
					String operador = (String) expressao.desempilha();
					Integer operando1 = (Integer) expressao.desempilha();
					expressao.empilha(Calculadora.calcula(operando1, operador, operando2));
				}
				else {
					//vals[ind_vals++] = Integer.parseInt(vs[i]);
					String numero = "";
					while (Character.isDigit(s.charAt(i))) {
						numero += s.charAt(i);
						i++;
					}
					expressao.empilha(Integer.valueOf(numero));
					i--;
				}
			}
			//int resp = vals[--ind_vals];
			int resp = (Integer) expressao.desempilha();
			System.out.println(soriginal + " = " + resp);
			soriginal = sc.nextLine();
		}
		sc.close();
	}
}
