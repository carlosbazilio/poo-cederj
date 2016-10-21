package br.cederj.comp.ano2009;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class JanelaJogo extends JFrame implements ActionListener {
	JButton bt1, bt2, bt3;
	public JanelaJogo() {
		// Define tamanho padrão da janela
		this.setSize(600, 200);
		// Atribui título da janela
		this.setTitle("Escolha o botão correto!");
		// Termina o processo no fechamando da janela
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Adiciona botões à janela
		Container contentPane = this.getContentPane();
		this.getContentPane().setLayout(new GridLayout(1,3));
		bt1 = new JButton("?");
		bt2 = new JButton("?");
		bt3 = new JButton("?");
		contentPane.add(bt1); 
		contentPane.add(bt2);
		contentPane.add(bt3);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent arg0) {
		int botaoSorteado = this.sorteiaBotao();
		if ((((JButton)arg0.getSource()) == bt1 && botaoSorteado == 1) ||
		    (((JButton)arg0.getSource()) == bt2 && botaoSorteado == 2) ||
		    (((JButton)arg0.getSource()) == bt3 && botaoSorteado == 3)) {
			setaAcerto((JButton)arg0.getSource(), botaoSorteado);
			JOptionPane.showMessageDialog(this, "!!! Acertou !!!");			
		}
		else {
			this.setaValorBotoes("X");
			JOptionPane.showMessageDialog(this, "Errou! Tente novamente !!");
		}
		this.setaValorBotoes("?");
	}
	
	public int sorteiaBotao() {
		return ((int)(Math.random()*100) % 3) + 1;
	}
	
	public void setaAcerto (JButton botao, int valor) {
		this.setaValorBotoes("X");
		botao.setText(String.valueOf(valor));
	}

	public void setaValorBotoes (String v) {
		bt1.setText(v);
		bt2.setText(v);
		bt3.setText(v);
	}
}

public class AP2_2009_1_Q3 {
	public static void main(String[] args) {
		JanelaJogo edt = new JanelaJogo();
		edt.setVisible(true);
	}
}
