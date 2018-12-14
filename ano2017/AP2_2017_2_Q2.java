package br.cederj.comp.ano2017;

import java.io.*;

public class AP2_2017_2_Q2 {
	public static void main(String[] args) throws IOException {
		int indiceNovaLinha = Integer.parseInt(args[1]);
		try (BufferedReader in = new BufferedReader(new FileReader(args[0]));
				BufferedWriter tmp = new BufferedWriter(new FileWriter(args[0] + ".temp"))) {
			String linhaAtual;
			int indiceLinhaAtual = 1;
			while ((linhaAtual = in.readLine()) != null) {
				if (indiceLinhaAtual == indiceNovaLinha) {
					tmp.write(args[2]);
					tmp.newLine();
				}
				tmp.write(linhaAtual);
				tmp.newLine();
				indiceLinhaAtual++;
			}
			if (indiceLinhaAtual <= indiceNovaLinha) {
				for(;indiceLinhaAtual < indiceNovaLinha;indiceLinhaAtual++)
					tmp.newLine();
				tmp.write(args[2]);
				tmp.newLine();
			}
		}
		try (InputStream tmp = new FileInputStream(args[0] + ".temp");
				OutputStream out = new FileOutputStream(args[0])) {
			int b;
			while ((b = tmp.read()) != -1) out.write(b);
		}
	} }
