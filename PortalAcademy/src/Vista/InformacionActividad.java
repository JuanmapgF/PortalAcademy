package Vista;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InformacionActividad extends JPanel {
	private JButton cerrarSesion;
	private JButton iniciar;
	private JButton registrarse;
	private JButton editar;
	
	/**
	 * Create the panel.
	 */
	public InformacionActividad(String nombre, String descripcion, Boolean esOrganizacion) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		JLabel nombreActividad = new JLabel(nombre);
		nombreActividad.setBounds(428, 34, 269, 33);
		add(nombreActividad);
		
		JTextArea descripcionActividad = new JTextArea(descripcion);
		descripcionActividad.setBounds(278, 102, 652, 371);
		add(descripcionActividad);
		
		if (esOrganizacion != null) {
			cerrarSesion = new JButton("Cerrar Sesi\u00F3n");
			cerrarSesion.setBounds(952, 39, 118, 23);
			add(cerrarSesion);
		}
		
		if (esOrganizacion) {
			editar = new JButton("Editar");
			editar.setBounds(752, 68, 89, 23);
			add(editar);
		}
		
		if (esOrganizacion == null) {
			iniciar = new JButton("Iniciar sesi\u00F3n");
			iniciar.setBounds(729, 37, 121, 23);
			add(iniciar);
			
			registrarse = new JButton("Registrarse");
			registrarse.setBounds(860, 37, 121, 23);
			add(registrarse);
		}
	}
	
	public void controlador(ActionListener ctr) {
		
		if (cerrarSesion != null) {
			cerrarSesion.addActionListener(ctr);
			cerrarSesion.setActionCommand("Cerrar Sesi\u00F3n");
		}
		
		if (iniciar != null) {
			iniciar.addActionListener(ctr);
			iniciar.setActionCommand("Iniciar");
		}
		
		if (registrarse != null) {
			registrarse.addActionListener(ctr);
			registrarse.setActionCommand("Registrarse");
		}
		
		if (editar != null) {
			editar.addActionListener(ctr);
			editar.setActionCommand("Editar");
		}
	}

}
