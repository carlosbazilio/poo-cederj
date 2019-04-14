package br.cederj.comp.ano2018;

import java.io.*; 

public class AP3_2018_2_Q2 {

	public static void main(String[] args) throws IOException { 
		
		BufferedReader in; in = new BufferedReader(new FileReader(args[0])); 
		int n, m; 
		
		try {

			String s = in.readLine(), vs[]; 
			
			while (s != null) { 
				vs = s.split(" "); 
				n = Integer.parseInt(vs[0]); 
				m = Integer.parseInt(vs[1]); 
				if((n == 0) && (m == 0)) { 
					System.out.println ("FIM"); 
					in.close(); 
					return; 
				} 
				if ((n == 0) || (m == 0)) continue; 
				if ((n < 2) || (m < 2) || (n > 100) || (m > 100)) continue;
	
				int mat[][] = new int[n][m], i, j; 
				for (i = 0; i < n; i++) { 
					s = in.readLine(); 
					vs = s.split(" "); 
					for(j = 0; j < m; j++) 
						mat[i][j] = Integer.parseInt(vs[j]); 
				}
	
				int aux, carac1, carac2, carac3, carac4; carac1 = carac2 = carac3 = carac4 = 0; 
				//carac1: Ninguém resolveu todos os problemas 
				
				for (i = 0; i < n; i++) {
					aux = 0;
					for (j = 0; j < m; j++) 
						aux += mat[i][j];
					if (aux == m) {
						carac1 = 0;
						break;
					} 
				} 
				if (i == n) carac1 = 1;
	
				//carac2: Todo problema foi resolvido por pelo menos uma //pessoa (não necessariamente a mesma) 
				for (j = 0; j < m; j++) { 
					aux = 0; 
					for (i = 0; i < n; i++) 
						aux += mat[i][j]; 
					if (aux == 0) { 
						carac2 = 0; 
						break; 
					} 
				} 
				if (j == m) carac2 = 1;
		
				//carac3: Não há nenhum problema resolvido por todos 
				for (j = 0; j < m; j++) { 
					aux = 0; 
					for (i = 0; i < n; i++) 
						aux += mat[i][j]; 
					if (aux == n) { 
						carac3 = 0; 
						break; 
					} 
				} 
				if (j == m) carac3 = 1; 
				
				//carac4: Todos resolveram ao menos um problema //(não necessariamente o mesmo) 
				for (i = 0; i < n; i++) { 
					aux = 0; 
					for (j = 0; j < m; j++) 
						aux += mat[i][j]; 
					if (aux == 0) { 
						carac4 = 0; 
						break; 
					} 
				} 
				if (i == n) carac4 = 1;
	
				System.out.println(carac1 + carac2 + carac3 + carac4); 
				s = in.readLine();
			}
	
		} catch (Exception e) {
	
			System.out.println("Excecao\n");
	
			in.close(); 
		}
	}
}