package br.cederj.comp.ano2008;

import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;

/*
 Classe principal que inicia a janela da aplicação
 */
public class AP2_2010_1_Q3 {
	public static void main(String[] args) {
		new JTexto3();
	}
}

/*
 Classe que modela a janela principal e seus componentes
 Esta classe implementa a interface ActionListener, a qual
 permite que esta classe trate as ações disparadas pelo
 usuário na janela criada.
 */
class JTexto3 implements ActionListener {
	JFrame frame = new JFrame("Calcula Propriedades");
	JLabel texto = new JLabel("Texto:");
	JTextArea caixaTexto = new JTextArea(10, 20);
	JButton bt = new JButton("Calcula");
	
	/*
	 Construtor da classe da janela principal, a qual cria
	 os componentes visuais e os inicializa.
	 */
	public JTexto3() {
		bt.addActionListener(this);
		Container c = frame.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		//caixaTexto.setWrapStyleWord(true);
		//caixaTexto.setLineWrap(true);
		caixaTexto.setBorder(BorderFactory.createLoweredBevelBorder());
		c.add(texto); c.add(caixaTexto); c.add(bt);
		frame.setSize(300, 230);
		frame.setVisible(true);
	}
	
	/*
	 Método que trata as ações disparadas pelo usuário. Neste
	 caso, apenas o clique no botão para substituição das
	 palavras no texto.
	 */
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == bt) {
			String texto = null;
			try {
				int tamanho = caixaTexto.getDocument().getLength();
				texto = caixaTexto.getDocument().getText(0, tamanho);
				String [] palavras = texto.split("[ \n]");
				int numPalavrasVazias = 0;
				for (int i=0; i<palavras.length; i++)
					if (palavras[i].trim().length() == 0)
						numPalavrasVazias++;
				int numPalavras = palavras.length - numPalavrasVazias;
				int numLinhas = texto.split("\n").length;
			    JOptionPane.showMessageDialog(frame, 
			    		"Caracteres: " + (tamanho-numLinhas+1) + 
			    		"\nPalavras: " + numPalavras + 
			    		"\nLinhas: " + numLinhas);
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}
	}
}
