package Vista;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Modelo.*;

public class InformacionActividad extends JPanel {
	private JButton cerrarSesion;
	private JButton iniciar;
	private JButton registrarse;
	private JButton editar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;
	private JButton explorar;
	
	/**
	 * Create the panel.
	 */
	public InformacionActividad(String nombre, String descripcion, Usuario user) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		JLabel nombreActividad = new JLabel(nombre);
		nombreActividad.setBounds(428, 34, 269, 33);
		add(nombreActividad);
		
		JTextArea descripcionActividad = new JTextArea(descripcion);
		descripcionActividad.setBounds(278, 102, 652, 371);
		add(descripcionActividad);
		
		
		
		if (user == null) {
			iniciar = new JButton("Iniciar sesi\u00F3n");
			iniciar.setBounds(729, 37, 121, 23);
			add(iniciar);
				
			registrarse = new JButton("Registrarse");
			registrarse.setBounds(860, 37, 121, 23);
			add(registrarse);
		} else if (user instanceof Estudiante) {
			cursos = new JButton("Mis cursos");
			cursos.setBounds(36, 261, 131, 32);
			add(cursos);
			
			actividades = new JButton("Mis actividades");
			actividades.setBounds(36, 336, 131, 32);
			add(actividades);
			
			ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 413, 131, 32);
			add(ajustes);
			
			cerrarSesion = new JButton("Cerrar Sesi\u00F3n");
			cerrarSesion.setBounds(952, 39, 118, 23);
			add(cerrarSesion);
		} else if (user instanceof Organizacion) {
			actividades = new JButton("Mis actividades");
			actividades.setBounds(36, 336, 131, 32);
			add(actividades);
			
			editar = new JButton("Editar");
			editar.setBounds(752, 68, 89, 23);
			add(editar);
			
			cerrarSesion = new JButton("Cerrar Sesi\u00F3n");
			cerrarSesion.setBounds(952, 39, 118, 23);
			add(cerrarSesion);
			
			ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 413, 131, 32);
			add(ajustes);
		}
		
		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
	}
	
	public void controlador(ActionListener ctr) {
		
		if (cerrarSesion != null) {
			cerrarSesion.addActionListener(ctr);
			cerrarSesion.setActionCommand("CERRAR_SESION");
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
		
		if (cursos != null) {
			cursos.addActionListener(ctr);
			cursos.setActionCommand("CURSO");
		}
		if (actividades != null) {
			actividades.addActionListener(ctr);
			actividades.setActionCommand("ACTIVIDAD");
		}
		if (ajustes != null) {
			ajustes.addActionListener(ctr);
			ajustes.setActionCommand("AJUSTES");
		}
		
		if (explorar != null) {
			explorar.addActionListener(ctr);
			explorar.setActionCommand("EXPLORAR");
		}
	}

}
