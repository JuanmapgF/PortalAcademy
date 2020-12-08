package Vista;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Controlador.Controlador;
import Controlador.ControladorRegistro;

public class Prueba extends JFrame {

	public static void crearGUI(JFrame ventana) {
		Controlador c = new Controlador();
		ventana.add(c.getPanel());
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
