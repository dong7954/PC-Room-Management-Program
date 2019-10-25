package Server;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTest1 extends JPanel{
	JLabel lblNewLabel;
	JButton btn;
	public PanelTest1() {
		setLayout(null);
		setBackground(Color.pink);
		
		btn=new JButton("¹öÆ°1");
		btn.setBounds(10,10,70,40);
		add(btn);
	
		}
	
}