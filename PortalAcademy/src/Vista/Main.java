package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Controlador.ControladorRegistro;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	public static void crearGUI(JFrame ventana) {
		ControladorRegistro cr = new ControladorRegistro(new Registro());
		ventana.add(cr.getPanel());
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(1080, 650);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ventana = new JFrame("Portal Academy");
				crearGUI(ventana);
			}
		});
	}

}
