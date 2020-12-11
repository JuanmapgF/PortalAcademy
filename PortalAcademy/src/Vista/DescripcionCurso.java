package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class DescripcionCurso extends JPanel {
	private JButton unirse;
	private JButton cerrarSesion;

	/**
	 * Create the panel.
	 */
	public DescripcionCurso(String nombre, String descripcion) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		JLabel nombreCurso = new JLabel(nombre);
		nombreCurso.setBounds(428, 34, 269, 33);
		add(nombreCurso);
		
		JTextArea descripcionCurso = new JTextArea(descripcion);
		descripcionCurso.setBounds(278, 102, 652, 371);
		add(descripcionCurso);
		
		unirse = new JButton("Unirse");
		unirse.setBounds(278, 511, 89, 23);
		add(unirse);
		
		cerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		cerrarSesion.setBounds(952, 39, 118, 23);
		add(cerrarSesion);

	}
	
	public void controlador(ActionListener ctr) {
		unirse.addActionListener(ctr);
		unirse.setActionCommand("Unirse");
		
		cerrarSesion.addActionListener(ctr);
		cerrarSesion.setActionCommand("Cerrar Sesi\u00F3n");
	}
	
}
