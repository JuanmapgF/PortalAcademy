package Vista;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class DescripcionActividad extends JPanel {
	private JButton unirse;
	private JButton cerrarSesion;

	/**
	 * Create the panel.
	 */
	public DescripcionActividad(String nombre, String descripcion, Boolean puedeUnirse) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		JLabel nombreActividad = new JLabel(nombre);
		nombreActividad.setBounds(428, 34, 269, 33);
		add(nombreActividad);
		
		JTextArea descripcionActividad = new JTextArea(descripcion);
		descripcionActividad.setBounds(278, 102, 652, 371);
		add(descripcionActividad);
		
		if (puedeUnirse) {
			unirse = new JButton("Unirse");
			unirse.setBounds(278, 511, 89, 23);
			add(unirse);
		}
		
		cerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		cerrarSesion.setBounds(952, 39, 118, 23);
		add(cerrarSesion);
	}
	
	public void controlador(ActionListener ctr) {
		if(unirse != null) {
			unirse.addActionListener(ctr);
			unirse.setActionCommand("Unirse");
		}
		
		
		cerrarSesion.addActionListener(ctr);
		cerrarSesion.setActionCommand("Cerrar Sesi\u00F3n");
	}

}
