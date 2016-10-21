package br.cederj.comp.ano2010;

import java.awt.Color;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/* Alguns pontos importantes neste gabarito:
 * - Definicao de classes abstratas para Item, Item Eletrico e Movel
 * - Naturalmente, heranca das classes concretas Televisor, Geladeira, etc, para estas abstratas
 * - Definicao da classe Deposito que devera contar uma forma de armazenar itens
 * - Esta classe Deposito deve utilizar a classe item para definir o tipo da colecao, de forma a permitir
 * o polimorfismo
 * - Defini metodos get e set para todos os campos, alem de construtores completos, mas pode relaxar um
 * pouco quanto a isso, pois o codigo fica muito grande
 */

abstract class Item {
	int codigo;
	String descricao;
	int tamanho_x, tamanho_y, tamanho_z; // Nao indiquei como seria o campo tamanho. Entao, pode ser qualquer descricao
	float peso;
	GregorianCalendar armazenagem, venda;
	
	public Item(int codigo, String descricao, int tamanhoX, int tamanhoY,
			int tamanhoZ, float peso, GregorianCalendar armazenagem,
			GregorianCalendar venda) {
		this.codigo = codigo;
		this.descricao = descricao;
		tamanho_x = tamanhoX;
		tamanho_y = tamanhoY;
		tamanho_z = tamanhoZ;
		this.peso = peso;
		this.armazenagem = armazenagem;
		this.venda = venda;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getTamanho_x() {
		return tamanho_x;
	}
	public void setTamanho_x(int tamanhoX) {
		tamanho_x = tamanhoX;
	}
	public int getTamanho_y() {
		return tamanho_y;
	}
	public void setTamanho_y(int tamanhoY) {
		tamanho_y = tamanhoY;
	}
	public int getTamanho_z() {
		return tamanho_z;
	}
	public void setTamanho_z(int tamanhoZ) {
		tamanho_z = tamanhoZ;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public GregorianCalendar getArmazenagem() {
		return armazenagem;
	}
	public void setArmazenagem(GregorianCalendar armazenagem) {
		this.armazenagem = armazenagem;
	}
	public GregorianCalendar getVenda() {
		return venda;
	}
	public void setVenda(GregorianCalendar venda) {
		this.venda = venda;
	}
	abstract public void exibe();
}

abstract class Eletrico extends Item {
	Color cor;
	int voltagem;
	
	public Eletrico(int codigo, String descricao, int tamanhoX, int tamanhoY,
			int tamanhoZ, float peso, GregorianCalendar armazenagem,
			GregorianCalendar venda, Color cor, int voltagem) {
		super(codigo, descricao, tamanhoX, tamanhoY, tamanhoZ, peso,
				armazenagem, venda);
		this.cor = cor;
		this.voltagem = voltagem;
	}
	public Color getCor() {
		return cor;
	}
	public void setCor(Color cor) {
		this.cor = cor;
	}
	public int getVoltagem() {
		return voltagem;
	}
	public void setVoltagem(int voltagem) {
		this.voltagem = voltagem;
	}
}

abstract class Movel extends Item {
	String material; // Poderia ser definido um campo enum também

	public Movel(int codigo, String descricao, int tamanhoX, int tamanhoY,
			int tamanhoZ, float peso, GregorianCalendar armazenagem,
			GregorianCalendar venda, String material) {
		super(codigo, descricao, tamanhoX, tamanhoY, tamanhoZ, peso,
				armazenagem, venda);
		this.material = material;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
}

class Televisor extends Eletrico {
	public Televisor(int codigo, String descricao, int tamanhoX, int tamanhoY,
			int tamanhoZ, float peso, GregorianCalendar armazenagem,
			GregorianCalendar venda, Color cor, int voltagem) {
		super(codigo, descricao, tamanhoX, tamanhoY, tamanhoZ, peso, armazenagem,
				venda, cor, voltagem);
	}
	public void exibe() {
		System.out.println("Televisor: " + this.getDescricao() + " " + this.getVoltagem());
	}
}

class Geladeira extends Eletrico {
	public Geladeira(int codigo, String descricao, int tamanhoX, int tamanhoY,
			int tamanhoZ, float peso, GregorianCalendar armazenagem,
			GregorianCalendar venda, Color cor, int voltagem) {
		super(codigo, descricao, tamanhoX, tamanhoY, tamanhoZ, peso, armazenagem,
				venda, cor, voltagem);
	}
	public void exibe() {
		System.out.println("Geladeira: " + this.getDescricao() + " " + this.getPeso() + " " + this.getVoltagem());
	}
}

class Armario extends Movel {
	public Armario(int codigo, String descricao, int tamanhoX, int tamanhoY,
			int tamanhoZ, float peso, GregorianCalendar armazenagem,
			GregorianCalendar venda, String material) {
		super(codigo, descricao, tamanhoX, tamanhoY, tamanhoZ, peso, armazenagem,
				venda, material);
	}
	public void exibe() {
		System.out.println("Armario: " + this.getDescricao() + this.getMaterial());
	}
}

class Fogao extends Item {
	public Fogao(int codigo, String descricao, int tamanhoX, int tamanhoY,
			int tamanhoZ, float peso, GregorianCalendar armazenagem,
			GregorianCalendar venda) {
		super(codigo, descricao, tamanhoX, tamanhoY, tamanhoZ, peso, armazenagem, venda);
	}
	public void exibe() {
		System.out.println("Fogao: " + this.getDescricao() + " " + this.getPeso());
	}
}

class Mesa extends Movel {
	public Mesa(int codigo, String descricao, int tamanhoX, int tamanhoY,
			int tamanhoZ, float peso, GregorianCalendar armazenagem,
			GregorianCalendar venda, String material) {
		super(codigo, descricao, tamanhoX, tamanhoY, tamanhoZ, peso, armazenagem,
				venda, material);
	}
	public void exibe() {
		System.out.println("Mesa: " + this.getDescricao() + " " + this.getMaterial());
	}
}

class Estoque {
	List <Item> itens;
	public Estoque() {
		itens = new ArrayList<Item>();
	}
	
	public void adicionaItem (Item i) {
		itens.add(i);
	}
	
	public void removeItem (int cod) {
		itens.remove(buscaItem(cod));
	}
	
	public Item buscaItem (int cod) {
		for (Item it : itens) {
			if (it.getCodigo() == cod)
				return it;
		}
		return null;
	}
	public void exibeItens () {
		for (Item it : itens) {
			it.exibe();
		}
	}
}

public class Tutoria_2010_1 {
	public static void main(String[] args) {
		Estoque dep = new Estoque();
		dep.adicionaItem(new Fogao(1, "6 bocas", 20, 20, 40, 60, new GregorianCalendar(), new GregorianCalendar()));
		dep.adicionaItem(new Geladeira(1, "6 bocas", 20, 20, 40, 60, new GregorianCalendar(), new GregorianCalendar(), Color.WHITE, 110));
		dep.exibeItens();
	}
}
