package estudos.swing.java;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Display extends JPanel {

	private final JLabel label;
	
	public Display() {
		
		setBackground(new Color(46,49,50));
		label = new JLabel("1234,65");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier",Font.PLAIN,30));
		setLayout(new FlowLayout(FlowLayout.RIGHT,10,25));
		
		add(label);
		
	}

}
