package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Controlador.Controlador;
import Controlador.ControladorInicio;
import Controlador.ControladorRegistro;

public class Prueba extends JFrame {
	
	private static JFrame ventana;

	public static void crearGUI(JFrame ventana) {
		ControladorInicio c = new ControladorInicio(new Inicio());
		c.getPanel().controlador(c);
		ventana.add(c.getPanel());
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(1080, 650);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public static void anyadirVentana(JFrame v, JPanel p) {
		System.out.println(11);
		v.removeAll();
		v.add(p);
	}
	
	public static JFrame getVentana() {
		return ventana;
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
