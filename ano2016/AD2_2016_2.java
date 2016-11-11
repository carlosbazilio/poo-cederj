import java.util.*;
import java.io.*;

class Aresta {
	int origem;
	int destino;

	public Aresta(int o, int d) {
		this.origem = o; this.destino = d;
	}
}

class Grafo {
	List<Integer> nos;
	List<Aresta> arestas;
	HashMap<Integer, List<Integer>> subgrafos;

	public Grafo() {
		nos = new ArrayList();
		arestas = new ArrayList();
		subgrafos = new HashMap();
	}

	public void adicionaNo (int n) {
		nos.add(n);
	}

	// Na adição de uma aresta, adicionamos os nós isolados como
	//parte de um subgrafo
	public void adicionaAresta (int orig, int dest) {
		boolean entrou = false;
		arestas.add(new Aresta(orig, dest));
		if (subgrafos.size() > 0) {
			// Verifica a existência de algum dos nós da aresta
			//num subgrafo
			for (List l : subgrafos.values()) {
				if (l.contains(orig) && l.contains(dest)) {
					entrou = true;
					break;
				}
				else
					if (l.contains(orig)) {
						l.add(dest);
						entrou = true;
						break;
					}
					else {
						if (l.contains(dest)) {
							l.add(orig);
							entrou = true;
							break;
						}
					}
			}
		}

		// Caso ainda não haja subgrafos criados ou
		//a aresta não tenha conexão com nenhum subgrafo 
		//criado
		if ((subgrafos.size() == 0) || (!entrou)) {
			List<Integer> snos = new ArrayList();
			snos.add(orig);
			snos.add(dest);
			subgrafos.putIfAbsent(subgrafos.size(), snos);
		}
	}

	// Método chamado quando se identifica que 2 subgrafos devem ser colapsados
	// Cada nó de l2 que ainda não pertence a l1 é acionado
	private static void adicionaSeNaoExiste (List<Integer> l1, List<Integer> l2) {
		for (Integer i : l2) {
			if (! l1.contains(i))
				l1.add(i);
		}
	}

	// Verifica nós desconexos (sem conexão com outros nós)
	public void adicionaNosDesconexos() {
		for (Integer i : nos) {
			boolean achou = false;
			for (List l : subgrafos.values()) {
				if (l.contains(i)) {
					achou = true;
					break;
				}
			}
			if (!achou) {
				List<Integer> snos = new ArrayList();
				snos.add(i);
				subgrafos.putIfAbsent(subgrafos.size(), snos);
			}
		}
	}

	// Verifica se subgrafos criados em separados possuem nós em comum
	//e os colapsa
	// Ao final, verifica se ainda possuem nós isolados (não conectados)
	//a nenhum outro nó, e os insere como um subgrafo
	public void colapsaSubgrafos() {
		List<Integer> keysToRemove = new ArrayList();
		// Percorre os subgrafos tentando uni-los
		for (Map.Entry<Integer, List<Integer>> m1 : subgrafos.entrySet()) {
			for (Map.Entry<Integer, List<Integer>> m2 : subgrafos.entrySet()) {
				boolean colapsa = false;
				// Nao compara um subgrafo com ele proprio
				if (m1.getKey() < m2.getKey()) {
					for (Integer i : m2.getValue()) {
						if (m1.getValue().contains(i)) {
							colapsa = true;
							break;
						}
					}
				}
				if (colapsa) {
					Grafo.adicionaSeNaoExiste(m1.getValue(), m2.getValue());
					// Cria lista para remover subgrafos após essas iterações
					//e evitar conflito na alteração de uma coleção que está
					//sendo percorrida (*)
					if (!keysToRemove.contains(m2.getKey())) {
						keysToRemove.add(m2.getKey());
					}
				}
			}
		}
		// Remove as chaves de subgrafos que foram colapsados (*)
		for (Integer chave : keysToRemove)
			subgrafos.remove(chave);
	}

	public void imprimeSubgrafos() {
		System.out.println("Numero de subgrafos: " + subgrafos.size());
		for (List<Integer> l : subgrafos.values()) {
			for (Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.print("\n");
		}
	}
}

public class AD2_ProgOO_2015_2 {
	public static void main(String[] args) {
		// Try with resources
		// https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		try (BufferedReader br = new BufferedReader(new FileReader(args[0])))
		{
			Grafo g = new Grafo();
			
			String sCurrentLine;
			// Lê nós do arquivo
			if ((sCurrentLine = br.readLine()) != null) {
				List<String> snos = Arrays.asList(sCurrentLine.split(" "));
				for (String s : snos) {
					g.adicionaNo(Integer.parseInt(s));
				}
			}
			// Lê arestas do arquivo
			while ((sCurrentLine = br.readLine()) != null) {
				String sarestas[] = sCurrentLine.split(" ");
				g.adicionaAresta(Integer.parseInt(sarestas[0]), Integer.parseInt(sarestas[1]));
			}
			g.adicionaNosDesconexos();
			g.colapsaSubgrafos();
			g.imprimeSubgrafos();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}








