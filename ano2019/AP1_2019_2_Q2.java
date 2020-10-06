package br.cederj.comp.ano2019;

class App {
	String nome;
	boolean rodando;
	int memoria;
	
	public App(String nome, int memoria) {
		this.nome = nome;
		this.memoria = memoria;
		this.rodando = false;
	}
	
	public void iniciar() {
		this.rodando = true;
	}
	
	public void parar() {
		this.rodando = false;
	}
	
	public boolean estaRodandao() {
		return this.rodando;
	}
}

class Sistema extends App {
	App instalados[];
	int qtdInstalados;

	public Sistema(String nome, int memoria) {
		super(nome, memoria);
		this.instalados = new App[1000];
		qtdInstalados = 0;
	}
	
	public void instalar (App aplic) {
		if (this.estaRodandao()) {
			this.instalados[qtdInstalados] = aplic;
			qtdInstalados++;
		}
		else
			System.out.println("Sistema desligado");
	}
		
//	public void remover (String nomeAplic) {
//		if (this.estaRodandao()) {
//			for (int i=0; i<qtdInstalados; i++) {
//				if (this.instalados[i].nome == nomeAplic) {
//					this.instalados[i] = null;
//					break;
//				}
//			}
//		}
//		else
//			System.out.println("Sistema desligado");
//	}
	
	public int memoriaOcupada () {
		int tamAplics = 0;
		for (int i=0; i<qtdInstalados; i++) {
			tamAplics += this.instalados[i].memoria;
		}
		return tamAplics + this.memoria;
	}
}

public class AP1_2019_2_Q2 {
	public static void main(String[] args) {
		App uber = new App("Uber", 150);
		App spotify = new App("Spotify", 110);
		Sistema android = new Sistema("Android", 550);
		android.instalar(uber);
		android.iniciar();
		android.instalar(uber);
		android.instalar(spotify);
		System.out.println("Memória ocupada: " + android.memoriaOcupada());
	}
}
