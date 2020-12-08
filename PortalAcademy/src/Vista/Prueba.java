package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Controlador.Controlador;
import Controlador.CtrInicio;
import Controlador.CtrRegistro;

public class Prueba extends JFrame {
	
	private static JFrame ventana;

	public static void crearGUI(JFrame ventana) {
		CtrInicio c = new CtrInicio(new Inicio());
		c.getPanel().controlador(c);
		ventana = c.getVentana();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(1080, 650);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public static void changeWindow(JPanel p) {
		System.out.println(11);
		ventana.removeAll();
		ventana.add(p);
		System.out.println(1123);
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
