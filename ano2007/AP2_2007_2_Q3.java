package br.cederj.comp.ano2007;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AP2_2007_2_Q3 {
	public static void main(String[] args) {
		new JTexto();
	}
}

class JTexto implements ActionListener {
	JFrame frame = new JFrame("Apaga Texto");
	JTextField tf = new JTextField(20);
	JButton bt = new JButton("Limpa");
	
	public JTexto() {
		tf.setEditable(true);
		tf.addActionListener(this);
		bt.addActionListener(this);
		Container c = frame.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		c.add(tf); c.add(bt);
		frame.setSize(300, 120);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == bt) { 
			tf.setText("");
		}
		else if (o == tf)			
			JOptionPane.showMessageDialog(null, "O campo texto contém: " + tf.getText());
	}
}
