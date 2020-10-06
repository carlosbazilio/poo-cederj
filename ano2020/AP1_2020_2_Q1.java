package br.cederj.comp.ano2020;

import java.util.Scanner;

public class AP1_2020_2_Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();  
		while (!s.equals("FIM")){
			String vs[] = s.split(" ");
			int i, ind_ops = 0, ind_vals = 0;
			char ops[] = new char[s.length()];
			int vals[] = new int[s.length()];
			for (i = 0; i < vs.length; i++){
				if (vs[i].equals("("));
				else if (vs[i].equals("+")) 
					ops[ind_ops++] = vs[i].charAt(0);
				else if (vs[i].equals("-")) 
					ops[ind_ops++] = vs[i].charAt(0);
				else if (vs[i].equals("*")) 
					ops[ind_ops++] = vs[i].charAt(0);
				else if (vs[i].equals("/")) 
					ops[ind_ops++] = vs[i].charAt(0);
				else if (vs[i].equals("%")) 
					ops[ind_ops++] = vs[i].charAt(0);
				else if (vs[i].equals(")")){
					char op = ops[--ind_ops];
					int v = vals[--ind_vals];
					if (op == '+') v = vals[--ind_vals] + v;
					else if (op == '-') v = vals[--ind_vals] - v;
					else if (op == '*') v = vals[--ind_vals] * v;
					else if (op == '/') v = vals[--ind_vals] / v;
					else if (op == '%') v = vals[--ind_vals] % v;
					vals[ind_vals++] = v;
				}
				else vals[ind_vals++] = Integer.parseInt(vs[i]); 
			}
			int resp = vals[--ind_vals];
			System.out.println(s + " = " + resp);
			s = sc.nextLine();
		}
		sc.close();
	}
}
