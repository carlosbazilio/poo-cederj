package br.cederj.comp.ano2017;

//LETRA (a)
class Time {
	private final String nome;
	private final String nacionalidade;
	public Time(String nome, String nacionalidade) { 
		this.nome = nome;
		this.nacionalidade = nacionalidade;
	}
	public final String getNome() { return nome; }
	public final String getNacionalidade() { return nacionalidade; } 
}

//LETRA (b)
class Esporte {
	private final String nome; 
	private final Time[][] times;
	public static enum PODIO {OURO, PRATA, BRONZE};
	public Esporte(String nome, int n) { 
		this.nome = nome;
		this.times = new Time[3][n];
	}
	public final String getNome() { return nome; }
	public final int getN() { 
		return this.times[0].length; 
	}
//	public Time getTimeOuro(int id) { 
//		return this.times[0][id]; 
//	} 
//	public Time getTimePrata(int id) { 
//		return this.times[1][id]; 
//	} 
//	public Time getTimeBronze(int id) { 
//		return this.times[2][id]; 
//	}
//	public void setTimeOuro(Time time, int id) { 
//		this.times[0][id] = time;
//	}
//	public void setTimePrata(Time time, int id) { 
//		this.times[1][id] = time;
//	}
//	public void setTimeBronze(Time time, int id) { 
//		this.times[2][id] = time;
//	} 
	public Time getTime(int id, PODIO p) { 
		return this.times[p.ordinal()][id];
	}
	public void setTime(Time time, int id, PODIO p) { 
		this.times[p.ordinal()][id] = time;
	} 
}

//LETRA (c)
class Basquetebol extends Esporte {
	public Basquetebol() { 
		super("Basquetebol", 2); 
	} 
}

class TenisDeMesa extends Esporte {
	public TenisDeMesa() { 
		super("TenisDeMesa", 6); 
	}
}

//LETRA (d)
class QuadroDeMedalhas {
	private final Esporte[] esportes; 
	public QuadroDeMedalhas() {
		//this.esportes = new Esporte[42];
		this.esportes = new Esporte[2];
		this.esportes[0] = new Basquetebol(); 
		//this.esportes[0] = new Esporte("Basquetebol", 2);
		this.esportes[1] = new TenisDeMesa();
	}
	
	public Esporte getEsporte(String nome) { 
		for (Esporte e : this.esportes) {
			if (e.getNome().equals(nome)) { 
				return e; 
			} 
		}
		return null; 
	}
	
	public int getMedalhas(String pais) { 
		int ouro = 0;
		for (Esporte e : this.esportes) {
			for (int id = 0; id < e.getN(); ++id) {
				//Time t = e.getTimeOuro(id);
				Time t = e.getTime(id, Esporte.PODIO.OURO);
				if (t != null && t.getNacionalidade().equals(pais)) {
					ouro++; 
				}
			} 
		}
		return ouro; 
	}
}

public class AP1_2017_2_Q1 {
	public static void main(String[] args){
		Time brasil = new Time("Tupiniquim", "Brasil");
		Time argentina = new Time("Hermanos", "Argentina");
		Time chile = new Time("ChiChiChilelele", "Chile");
		QuadroDeMedalhas medalhas = new QuadroDeMedalhas();
//		medalhas.getEsporte("Basquetebol").setTimeOuro(brasil, 0);
//		medalhas.getEsporte("Basquetebol").setTimeOuro(brasil, 1);
//		medalhas.getEsporte("Basquetebol").setTimePrata(argentina, 0);
//		medalhas.getEsporte("Basquetebol").setTimePrata(argentina, 1);
//		medalhas.getEsporte("Basquetebol").setTimeBronze(chile, 0);
//		medalhas.getEsporte("Basquetebol").setTimeBronze(chile, 1);
		Esporte basquete = medalhas.getEsporte("Basquetebol"); 
		basquete.setTime(brasil, 0, Esporte.PODIO.OURO);
		basquete.setTime(brasil, 1, Esporte.PODIO.OURO);
		basquete.setTime(argentina, 0, Esporte.PODIO.PRATA);
		basquete.setTime(argentina, 1, Esporte.PODIO.PRATA);
		basquete.setTime(chile, 0, Esporte.PODIO.BRONZE);
		basquete.setTime(chile, 1, Esporte.PODIO.BRONZE);
		System.out.println("O Brasil obteve " + medalhas.getMedalhas("Brasil") + " medalhas");
		System.out.println("A Argentina obteve " + medalhas.getMedalhas("Argentina") + " medalhas");
		System.out.println("O Chile obteve " + medalhas.getMedalhas("Chile") + " medalhas");
	}
}

