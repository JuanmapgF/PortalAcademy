package Vista;

import java.awt.*;
import javax.swing.*;

public class Prueba extends JFrame {
	public Prueba() {
	}

	public static void crearGUI(JFrame ventana) {
		
		
		MenuEstudiante m = new MenuEstudiante();
		Ajustes a = new Ajustes();
		ventana.getContentPane().setLayout(new BorderLayout());
		ventana.getContentPane().add(m, BorderLayout.WEST);
		ventana.getContentPane().add(a, BorderLayout.CENTER);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setSize(1000, 650);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame ventana = new JFrame("Portal Academy");
				crearGUI(ventana);
			}
		});
	}

}
