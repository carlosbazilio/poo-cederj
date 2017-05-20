import java.util.*;
import java.io.*;

class Time 
implements Comparable<Time> 
{
	String nome;
	int numVitorias;
	int numEmpates;
	int saldoGols;

	public Time (String n) {
		this(n, 0, 0, 0);
	}

	public Time (String n, int v, int e, int s) {
		this.nome = n;
		this.numVitorias = v;
		this.numEmpates = e;
		this.saldoGols = s;
	}

	public int obtemPontuacao() {
		return (3 * this.obtemNumVitorias()) + this.numEmpates;
	}

	public int obtemNumVitorias() {
		return numVitorias;
	}

	public int obtemSaldoGols() {
		return saldoGols;
	}

	public void ganhou(int saldo) {
		this.numVitorias++;
		this.saldoGols += saldo;
	}

	public void empatou() {
		this.numEmpates++;
	}

	public void perdeu(int saldo) {
		this.saldoGols += saldo;
	}

	// public boolean equals (Time t) {
	// 	return t.nome == this.nome;
	// }

	public int compareTo(Time t) {
		int pontuacao_this = this.obtemPontuacao();
		int pontuacao_t = t.obtemPontuacao();
		if (pontuacao_this > pontuacao_t)
			return 1;
		else
			if (pontuacao_this < pontuacao_t)
				return -1;
			else {
				if (this.obtemNumVitorias() > t.obtemNumVitorias())
					return 1;
				else
					if (this.obtemNumVitorias() < t.obtemNumVitorias())
						return -1;
					else {
						if (this.obtemSaldoGols() > t.obtemSaldoGols())
							return 1;
						else
							if (this.obtemSaldoGols() < t.obtemSaldoGols())
								return -1;
							else
								return 0;
					}
			}
	}
}

class Campeonato {
	List<Time> times;

	public Campeonato () {
		times = new ArrayList();
	}

	public Time adicionaTime (String n) {
		for (Time t : times)
			if (t.nome.equals(n.trim()))
				return t;

		Time novo = new Time(n.trim());
		times.add(novo);
		return novo;
	}

	public void adicionaPartida (String partida) {
		String dados[] = partida.split("/");
		// Divisão da partida
		// Comportamento do método split()
		// partida = 02.04. 16:00/Boavista/Portuguesa-RJ/1 : 1
		// dados[0] = 02.04. 16:00
		// dados[1] = Boavista
		// dados[2] = Portuguesa-RJ
		// dados[3] = 1 : 1
		String placar[] = dados[3].split(":"); // Divisão do placar
		
		Time casa = this.adicionaTime(dados[1]);
		Time visitante = this.adicionaTime(dados[2]);

		int iplacar[] = {Integer.parseInt(placar[0].trim()), Integer.parseInt(placar[1].trim())};

		if (iplacar[0] == iplacar[1]) {
			casa.empatou(); visitante.empatou();
		}
		else
			if (iplacar[0] > iplacar[1]) {
				casa.ganhou(iplacar[0]-iplacar[1]); visitante.perdeu(iplacar[1]-iplacar[0]);
			}
			else {
				casa.perdeu(iplacar[0]-iplacar[1]); visitante.ganhou(iplacar[1]-iplacar[0]);
			}
	}

	public void ordena() {
		Collections.sort(times);
	}

	public void geraCruzamento() {
		System.out.println(times.get(times.size() - 1).nome + " x " + times.get(times.size() - 4).nome);
		System.out.println(times.get(times.size() - 2).nome + " x " + times.get(times.size() - 3).nome);
	}

}

public class AD2_2017_1_Alternativa {
	public static void main(String[] args) {
		String linha = null;
		Campeonato carioca = new Campeonato();
		try {
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
      		linha = in.readLine();
	      	while (linha != null) {
	      		carioca.adicionaPartida(linha);
	      		linha = in.readLine();
	      	}
	      	carioca.ordena();
	      	carioca.geraCruzamento();
      	} catch (FileNotFoundException e) {
      		System.out.println("Arquivo não encontrado!");
      	} catch (IOException e) {
      		System.out.println("Erro no processamento do arquivo de entrada!");
      	}
	}
	
}


