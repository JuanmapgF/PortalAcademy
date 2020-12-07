package Vista;

import java.awt.*;
import javax.swing.*;

import Controlador.ControladorRegistro;

public class Prueba extends JFrame {
	public Prueba() {
	}

	public static void crearGUI(JFrame ventana) {
		Estudiante e = new Estudiante("qwwghre", "rtrgwert", "hola");
		Explorar ex = new Explorar(e, null, null);
		Menu m = new Menu(e);
		Ajustes a = new Ajustes();
		ventana.add(ex);
		ventana.add(m);
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
