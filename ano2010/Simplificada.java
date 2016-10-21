package br.cederj.comp.ano2010;

import java.util.*;

class Monitor {
	public static enum Tipo {crt, lcd, oled}; // tipos de monitores
	private Tipo tipo; // tipo do monitor
	private int tamanho; // tamanho em polegadas
	private double valor; // valor em reais
	
	public Monitor(Monitor.Tipo t, int sz, double v) {
		this.tipo = t;
		this.tamanho = sz;
		this.valor = v;
	}
	
	public double obtemValor () {
		return valor;
	}
}

public class Simplificada {
	public static void main(String[] args) {
		Monitor monitor = new Monitor(Monitor.Tipo.lcd, 17, 600.99);
		List carrinhoCompras = new ArrayList(); // Criação da lista de objetos
		carrinhoCompras.add(monitor); // Adiciona ao carrinho
		System.out.println("O total no carrinho Ž: " + 
				((Monitor)carrinhoCompras.get(0)).obtemValor());
	}
}
