package br.cederj.comp.ano2008;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class AP2_2008_1_Q4 extends JFrame implements ActionListener {
	JPanel panel;
	JButton botao;
	List<Color> cores;
	Iterator<Color> it_cores;

	public AP2_2008_1_Q4() {
		// Define configurações gerais da janela principal
		this.setBounds(0, 0, 800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Cria os objetos gráficos
		panel = new JPanel();
		botao = new JButton("Troca Cor");
		
		// Configura esta própria classe para tratar os eventos do botão
		botao.addActionListener(this);
		panel.add(botao);
		
		// Cria coleção que irá armazenar as cores desejadas
		cores = new ArrayList<Color>();
		cores.add(Color.RED);
		cores.add(Color.GREEN);
		cores.add(Color.BLUE);
		
		// Inicializa iterador que será utilizado para percorrer as cores
		it_cores = cores.iterator();
		panel.setBackground((Color)it_cores.next());
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent e) {
		// Trat os cliques no botão
		if (e.getSource() == botao) {
			if (!it_cores.hasNext())
				it_cores = cores.iterator();
			panel.setBackground((Color)it_cores.next());			
		}
	}
	
	public static void main(String[] args) {
		AP2_2008_1_Q4 janela = new AP2_2008_1_Q4();
		janela.setVisible(true);
	}
}
