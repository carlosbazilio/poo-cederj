package br.cederj.comp.ano2019;

class Media {
	private int duracao; // Em minutos
	String titulo;
	
	public Media (int d, String t) {
		this.duracao = d; this.titulo = t;
	}
	
	public int getDuracao () {
		return this.duracao;
	}
}

class Video extends Media {
	String assunto;
	String titulo;
	int visualizaçoes;
	String canal;
	
	public Video(int d, String a, String t, int v, String c) {
		super(d, t);
		this.assunto = a; this.visualizaçoes = v; this.canal = c;
	}
	
	public int getDuracao () {
		int minimo = super.getDuracao();
		if (this.visualizaçoes < 1000)
			return minimo;
		else
			if (this.visualizaçoes < 10000)
				return (int) (minimo * 1.02);
			else
				return (int) (minimo * 1.05);	
	}
}

class Musica extends Media {
	String interprete;
	String compositor;
	
	public Musica(int duracao, String nome, String interprete, String compositor) {
		super(duracao, nome);
		this.interprete = interprete; this.compositor = compositor;
	}
}

class Playlist {
	Media musicas[];
	private int quantMusicas;
	
	public Playlist() {
		musicas = new Media[1000];
		quantMusicas = 0;
	}
	
	public void adicionaMedia (Media m) {
		musicas[quantMusicas] = m;
		quantMusicas++;
	}
	
	public int getDuracao() {
		int total = 0;
		for (int i=0; i<quantMusicas; i++)
			total += musicas[i].getDuracao();
		return total;
	}
	
	public String toString() {
		int total = this.getDuracao();
		return (total / 60) + "h e " + (total - ((total / 60) * 60)) + "min";
	}
}

public class AD1_2019_1 {
	public static void main(String[] args) {
		Musica aguadebeber = new Musica(140, "Agua de beber", "Astrud Gilberto", "Antonio Carlos Jobim");
		Musica omarserenou = new Musica(179, "O mar serenou", "Clara Nunes", "Candeia");
		Musica rapazfolgado = new Musica(180, "Rapaz Folgado", "Martinho da Vila e Mart'nália", "Noel Rosa");
		
		Video despacito = new Video(280, "Musica", "Despacito", 5926796, "Luis Fonsi");
		Video gangnam = new Video(252, "Musica", "PSY - GANGNAM STYLE", 3276192, "officialpsy");
		
		Playlist samba = new Playlist();
		samba.adicionaMedia(aguadebeber);
		samba.adicionaMedia(omarserenou);
		samba.adicionaMedia(rapazfolgado);
		samba.adicionaMedia(despacito);
		samba.adicionaMedia(gangnam);
		
		System.out.println("Duração da playlist: " + samba);
	}
}
