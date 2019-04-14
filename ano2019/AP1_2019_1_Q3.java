package br.cederj.comp.ano2019;

public class AP1_2019_1_Q3 { 
	
	public static void main(String[] args) {
		int n1 = Integer.parseInt(args[0]), n2 = Integer.parseInt(args[1]);
		
		if((n1 <= 0)||(n2 <= 0)||(args[0].charAt(0) == '0')|(args[1].charAt(0) == '0')) return;

		if (ePalindromo(args[0])) 
			System.out.println(args[0] + ": s"); 
		else 
			System.out.println(args[0] + ": n");

		if (ePalindromo(args[1])) 
			System.out.println(args[1] + ": s"); 
		else 
			System.out.println(args[1] + ": n");

		System.out.println("mdc(" + n1 + "," + n2 + ") = " + mdc(n1,n2)); 
	}

	public static boolean ePalindromo(String str) { 
		int n = str.length(), metade = str.length()/2, i; 
		for (i = 0; i <= metade; i++) 
			if(str.charAt(i) != str.charAt(n - 1 - i)) 
				return false; 
		return true; 
	}

	public static int mdc(int n1, int n2) {
		while (n1 != n2) 
			if (n1 > n2) 
				n1 -= n2; 
			else 
				n2 -= n1; 
		return n1; 
	} 
}
