package br.cederj.comp.ano2008;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;

/*
 Classe principal que inicia a janela da aplicação
 */
public class AP3_2008_1_Q3 {
	public static void main(String[] args) {
		new JTexto2();
	}
}

/*
 Classe que modela a janela principal e seus componentes
 Esta classe implementa a interface ActionListener, a qual
 permite que esta classe trate as ações disparadas pelo
 usuário na janela criada.
 */
class JTexto2 implements ActionListener {
	JFrame frame = new JFrame("Substitui Texto");
	JLabel procura = new JLabel("Procura:");
	JTextField tf = new JTextField(20);
	JLabel substitui = new JLabel("Substitui:");
	JTextField tf2 = new JTextField(20);
	JLabel texto = new JLabel("Texto:");
	JTextArea caixaTexto = new JTextArea(10, 20);
	JButton bt = new JButton("Substitui");
	
	/*
	 Construtor da classe da janela principal, a qual cria
	 os componentes visuais e os inicializa.
	 */
	public JTexto2() {
		tf.setEditable(true);
		tf.addActionListener(this);
		bt.addActionListener(this);
		Container c = frame.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		//caixaTexto.setWrapStyleWord(true);
		//caixaTexto.setLineWrap(true);
		caixaTexto.setBorder(BorderFactory.createLoweredBevelBorder());
		c.add(procura); c.add(tf); c.add(substitui); c.add(tf2); c.add(texto); c.add(caixaTexto); c.add(bt);
		frame.setSize(300, 280);
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
				texto = caixaTexto.getDocument().getText(0, caixaTexto.getDocument().getLength());
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
			// Se as caixas de texto não estão vazias
			if (tf.getText().length() > 0 && tf2.getText().length() > 0)
			{
				String textoNovo = texto.replaceAll(tf.getText(), tf2.getText());
				caixaTexto.replaceRange(textoNovo, 0, caixaTexto.getDocument().getLength());
			}
		}
	}
}
