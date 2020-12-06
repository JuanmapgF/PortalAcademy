package Vista;

import java.awt.*;
import javax.swing.*;

public class Prueba extends JFrame {

	public static void crearGUI(JFrame ventana) {
		MenuEstudiante m = new MenuEstudiante();
		ventana.setContentPane(m);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setExtendedState(MAXIMIZED_BOTH);
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
