package estudos.swing.java;

import java.awt.*;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{
	
	public Calculadora() {
		
		organizarLayout();
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(232,322);
		setLocationRelativeTo(null);
		
	}
	
	private void organizarLayout() {

		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(233,60));
		add(display, BorderLayout.NORTH);
		
		Teclado teclado = new Teclado();
		add(teclado,BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		
		new Calculadora();
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
