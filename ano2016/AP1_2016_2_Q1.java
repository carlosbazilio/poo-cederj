package br.cederj.comp.ano2016;

class Matriz {
	private int m, n;

	public Matriz(int m, int n) {
		this.m = m;
		this.n = n;
	}
	
    public String[][] constroiMatriz() {
        String[][] s = new String[m][n];
        for(int i = 0; i < m; ++i)
           for(int j = 0; j < n; ++j)
              if(i == j)     s[i][j] = "=";
              else if(i < j) s[i][j] = "<";
              else           s[i][j] = Integer.toString(i + j);
        return s;
    }
}

public class AP1_2016_2_Q1 {
    public static void main(String[] args){
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        
        Matriz mat = new Matriz(m, n);
        String[][] s = mat.constroiMatriz();
        
        //String[][] s = constroiMatriz(m, n);
        for(int i = 0; i < m; i++){
           for(int j = 0; j < n; j++) 
              System.out.print(s[i][j] + " ");
           System.out.println();
        }
        numericos(s);
    }

    private static String[][] constroiMatriz(int m, int n) {
        String[][] s = new String[m][n];
        for(int i = 0; i < m; ++i)
           for(int j = 0; j < n; ++j)
              if(i == j)     s[i][j] = "=";
              else if(i < j) s[i][j] = "<";
              else           s[i][j] = Integer.toString(i + j);
        return s;
    }

    private static boolean ehNumero(String s) {
        if ((s == null) || (s.length() == 0)) return false;
        for (int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0; i < s.length(); ++i)
            if ((s.charAt(i) < '0') || ('9' < s.charAt(i)))
               return false;
        return true;
    }

    private static void numericos(String[][] s) {
        int cont = 0;        
        for(int i = 0; i < s.length; ++i)
            for(int j = 0; j < s[i].length; ++j)
                if(ehNumero(s[i][j])) cont++;
        System.out.println(cont);
    }
}

