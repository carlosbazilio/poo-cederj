package br.cederj.comp.ano2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AP2_2016_2_Q3 {
	public static void main(String[] args) throws IOException{
		BufferedReader in_m, in_t;
		in_m = new BufferedReader(new FileReader(args[0]));
		in_t = new BufferedReader(new FileReader(args[1]));
		BufferedWriter out_m, out_e;
		out_m = new BufferedWriter(new FileWriter("mestre-" + args[0]));
		out_e = new BufferedWriter(new FileWriter("erro-" + args[0]));
		try {
			String s_m, vs_m[], s_t, vs_t[];
			s_m = in_m.readLine();
			s_t = in_t.readLine();
			while((s_m != null) && (s_t != null)){ //mat iguais...
				vs_m = s_m.split(" ");
				vs_t = s_t.split(" ");
				if(vs_m[0].equals(vs_t[0])){
					if(vs_t[1].equals("I")){
						out_e.write(s_t + "\n");
						out_m.write(s_m + "\n");
					}
					else if(vs_t[1].equals("A"))
						out_m.write(vs_t[0] + " " + vs_t[2] + "\n");
					s_m = in_m.readLine();
					s_t = in_t.readLine();
				}
				//matricula do mestre e menor...
				else 
					if(Integer.parseInt(vs_m[0])<Integer.parseInt(vs_t[0])){
						out_m.write(s_m + "\n");
						s_m = in_m.readLine();
					}
					//matricula do arquivo de transacoes e menor...
					else{
						if(vs_t[1].equals("I"))
							out_m.write(vs_t[0] + " " + vs_t[2] + "\n");
						else
							out_e.write(s_t + "\n");
						s_t = in_t.readLine();
					}
			}
			//acabou o arquivo de transacoes: copia o resto no novo mestre...
			while (s_m != null){
				out_m.write(s_m + "\n");
				s_m = in_m.readLine();
			}
			//acabou o arquivo mestre: deve-se analisar todas as transacoes...
			while (s_t != null){
				vs_t = s_t.split(" ");
				if(vs_t[1].equals("I")){
					out_m.write(vs_t[0] + " " + vs_t[2] + "\n");
				}
				else out_e.write(s_t + "\n");
				s_t = in_t.readLine();
			}
			in_m.close();
			in_t.close();
			out_e.close();
			out_m.close();
		}
		catch (Exception e){
			System.out.println("Excecao\n");
		}
	} 
}