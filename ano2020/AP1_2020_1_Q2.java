package br.cederj.comp.ano2020;

import java.util.*;

public class AP1_2020_1_Q2 {

	public static void main (String[] args) { 
		Scanner sc = new Scanner(System.in); 
		int i, j, aux, sudoku[][] = new int[9][9];

		for (i = 0; i < 9; i++)

			for (j = 0; j < 9; j++){

				aux = sc.nextInt(); sudoku[i][j] = aux;

			} 
		sc.close();

		boolean resp = testaLinhas(sudoku); 

		if(!resp) {

			System.out.println(resp);

			return; 
		} 
		resp = testaColunas(sudoku); 

		if(!resp) {

			System.out.println(resp);

			return; 
		} 
		resp = testaBlocos(sudoku); System.out.println(resp);

	}

	static boolean testaLinhas (int[][] mat){ 
		int i, j;

		for(i = 0; i < 9; i++){ 
			//int vet[] = new int[9];
			boolean vet[] = new boolean[9];
	
			for(j = 0; j < 9; j++) 
				//vet[mat[i][j] - 1]++;
				vet[mat[i][j] - 1] = true;
			
		
			for(j = 0; j < 9; j++)
				//if(vet[j] != 1) return false;
				if(! vet[j])
					return false;
		
			} 
		return true;

	}

	static boolean testaColunas (int[][] mat) { 
		int i, j;

		for(j = 0; j < 9; j++) {
	
			int vet[] = new int[9];
	
			for(i = 0; i < 9; i++) 
				vet[mat[i][j] - 1]++;
	
			for(i = 0; i < 9; i++)
	
				if(vet[i] != 1) return false;
	
		} 
		return true;

	}

	static boolean testaBlocos (int[][] mat) { 
		int i, j;

		for(i = 0; i < 9; i = i + 3)
	
			for(j = 0; j < 9; j = j + 3){
	
				boolean resp = testaBlocos (mat, i, i + 3, j, j + 3); 
				if(!resp) 
					return true;
	
			} return true;

	}

	static boolean testaBlocos (int[][] mat, int lini, int lfim, int cini, int cfim) { 
		int i, j, vet[] = new int[9]; 
		for(i = lini; i < lfim; i++) 
			for(j = cini; j < cfim; j++) 
				vet[mat[i][j] - 1]++;


		for(int k = 0; k < 9; k++)
			if(vet[k] != 1) 
				return false; 
		return true;
	}
}