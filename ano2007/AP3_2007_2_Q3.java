package br.cederj.comp.ano2007;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AP3_2007_2_Q3 {
	public static void main(String[] args) {
		new JTexto2();
	}
}

class JTexto2 implements ActionListener {
	JFrame frame = new JFrame("Troca Texto");
	JTextField tf = new JTextField(20);
	JTextField tf2 = new JTextField(20);
	JButton bt = new JButton("Troca");
	
	public JTexto2() {
		tf.setEditable(true);
		tf.addActionListener(this);
		bt.addActionListener(this);
//		frame.addWindowListener(
//			new WindowAdapter() {
//				public void windowClosing(WindowEvent arg0) {
//					int answer = JOptionPane.showConfirmDialog(null, "Deseja fechar o diálogo?", "Caixa de texto", JOptionPane.YES_NO_OPTION);
//					//super.windowClosing(arg0);
//				}
//			}
//		);
		Container c = frame.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		c.add(tf); c.add(tf2); c.add(bt);
		frame.setSize(300, 120);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == bt) { 
			if (tf.getText().length() > 0 && tf2.getText().length() > 0)
			{
				String temp = tf.getText();
				tf.setText(tf2.getText());
				tf2.setText(temp);
			}
		}
		else if (o == tf)			
			JOptionPane.showMessageDialog(null, "O campo texto contém: " + tf.getText());
	}
}
