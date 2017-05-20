package br.cederj.comp.ano2017;

import java.io.*;

class no{
	String nome;
	int pontos, gols_favor, gols_sof, vit;
	no prox;
	no(String nome){
		this.nome = nome;
		pontos = vit = gols_favor = gols_sof = 0;
		prox = null;
	}
	public String toString(){ return nome; }
}

class lista{
	no prim;
	lista(){ prim = null; }
	no busca(String nome){
		no p = prim;
		while((p != null) && (nome.compareToIgnoreCase(p.nome) != 0))
			p = p.prox;
		return p;
	}
	void insere(String nome){
		no novo = new no(nome);
		if(prim == null)
			prim = novo;
		else{
			no p = prim;
			while(p != null){
				if(nome.compareToIgnoreCase(p.nome) == 0) return;
				p = p.prox; }
			novo.prox = prim;
			prim = novo; }
	}
	void insere(String nome, int gf, int gc){
		no p = busca(nome);
		if(p == null) return;
		p.gols_favor += gf;
		p.gols_sof += gc;
		if(gf > gc){ p.vit++; p.pontos += 3; }
		if(gf == gc) p.pontos += 1;
	}
	public String toString(){
		String resp = "";
		no p = prim;
		while (p != null){
			resp += p.toString() + " " + p.pontos + " " + p.vit + " " + p.gols_favor + " " + p.gols_sof + "\n";
			p = p.prox; }
		return resp;
	}
}

public class AD2_2017_1{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		String s;
		lista l = new lista();
		try{
			while((s = in.readLine()) != null){
				String vs[] = s.split("/");
				l.insere(vs[1]);
				l.insere(vs[2]);
				String placar[] = vs[3].split(" : ");
				l.insere(vs[1], Integer.parseInt(placar[0].trim()),
						Integer.parseInt(placar[1].trim()));
				l.insere(vs[2], Integer.parseInt(placar[1].trim()),
						Integer.parseInt(placar[0].trim()));
			}
		}catch (Exception e){
			System.out.println("Excecao leitura\n");
		}finally{ in.close(); }
		Ordena(l);
		System.out.println(imprimeFinalistas(l));
	}
	static void Ordena(lista l){
		if(l.prim != null){
			for(no p = l.prim; p != null; p = p.prox){
				no maior = p;
				for(no q = p.prox; q != null; q = q.prox)
					if (maiorEq(maior, q)) maior = q;
				if(maior != p) troca(maior, p);
			} }
	}
	static boolean maiorEq (no maior, no q){
		if(q.pontos > maior.pontos) return true;
		if((q.pontos == maior.pontos) && (q.vit > maior.vit)) return true;
		int saldo_maior = maior.gols_favor - maior.gols_sof;
		int saldo_q = q.gols_favor - q.gols_sof;
		if((q.pontos == maior.pontos) && (q.vit == maior.vit) && (saldo_q > saldo_maior)) return true;
		return false;
	}
	static void troca(no maior, no p){
		String nome_aux = maior.nome; //troca nome
		maior.nome = p.nome;
		p.nome = nome_aux;
		int temp = maior.pontos; //troca pontos
		maior.pontos = p.pontos;
		p.pontos = temp;
		temp = maior.vit; //troca numero de vitorias
		maior.vit = p.vit;
		p.vit = temp;
		temp = maior.gols_favor; //troca gols a favor
		maior.gols_favor = p.gols_favor;
		p.gols_favor = temp;
		temp = maior.gols_sof; //troca gols sofridos
		maior.gols_sof = p.gols_sof;
		p.gols_sof = temp;
	}
	static String imprimeFinalistas(lista l){
		String resp = l.prim.toString() + " X ";
		resp += l.prim.prox.prox.prox.toString() + "\n";
		resp += l.prim.prox.toString() + " X ";
		resp += l.prim.prox.prox.toString();
		return resp;
	}
}
