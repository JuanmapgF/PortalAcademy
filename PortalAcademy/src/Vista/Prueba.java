package Vista;

import java.awt.*;
import javax.swing.*;

import Controlador.ControladorRegistro;

public class Prueba extends JFrame {
	public Prueba() {
	}

	public static void crearGUI(JFrame ventana) {
		
		
//		MenuEstudiante m = new MenuEstudiante();
//		Ajustes a = new Ajustes();
		ControladorRegistro cr = new ControladorRegistro(new Registro());
		ventana.add(cr.getPanel());
//		ventana.add(m);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(1080, 650);
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
