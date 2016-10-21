package br.cederj.comp.ano2016;

class Contato {
	private String nome;
	private String telefone;
	private String endereco;
	public Contato(String nome, String telefone, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String toString() {
		return this.getNome() + "\n" + this.getEndereco() + "\n" + this.getTelefone() + "\n";
	}
}

class Agenda {
	Contato contatos[];
	int ultimo;

	public Agenda() {
		contatos = new Contato[1000];
		ultimo = 0;
	}
	
	public void listar () {
		System.out.println("===");
		for (int i=0; i<=ultimo; i++) {
			if (contatos[i] != null)
				System.out.println(contatos[i]);
		}
	}
	
	public Contato busca (String nome) {
		for (int i=0; i<ultimo; i++) {
			if ((contatos[i] != null) && (contatos[i].getNome().contains(nome))) {
				return contatos[i];
			}
		}
		return null;
	}
	
	public void insere (Contato novo) {
		Contato c = busca(novo.getNome());
		if (c != null) {
			c.setEndereco(novo.getEndereco());
			c.setTelefone(novo.getTelefone());
		}
		else {
			for (int i=0; i<ultimo; i++) {
				if (contatos[i] == null) {
					contatos[i] = novo;
					return;
				}
			}
			contatos[ultimo] = novo;
			ultimo++;
		}
	}
	
	public void remove (String nome) {
		for (int i=0; i<ultimo; i++) {
			if ((contatos[i] != null) && (contatos[i].getNome().equals(nome))) {
				contatos[i] = null;
				if (i == (ultimo-1))
					ultimo--;
			}
		}
	}
}

public class AD1_2016_2 {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		agenda.insere(new Contato("Fulano", "99999999", "Rua A"));
		agenda.insere(new Contato("Ciclano", "88888888", "Rua B"));
		agenda.insere(new Contato("Beltrano", "88889999", "Rua C"));
		agenda.listar();
		agenda.insere(new Contato("Fulano", "77777777", "Rua D"));
		agenda.remove("Ciclano");
		agenda.listar();
		agenda.remove("Beltrano");
		agenda.listar();
		System.out.println(agenda.busca("Ful"));
	}
}
