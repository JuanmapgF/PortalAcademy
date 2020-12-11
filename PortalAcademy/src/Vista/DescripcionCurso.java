package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import Modelo.Curso;
import Modelo.Usuario;

import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DescripcionCurso extends JPanel {
	Usuario user;
	JButton unirse;
	JButton cerrarSesion;

	/**
	 * Create the panel.
	 */
	public DescripcionCurso(Usuario user, Curso curso) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		JLabel nombreCurso = new JLabel(curso.getNombre());
		nombreCurso.setBounds(428, 34, 269, 33);
		add(nombreCurso);
		
		JTextArea descripcionCurso = new JTextArea(curso.getDescripcion());
		descripcionCurso.setBounds(278, 102, 652, 371);
		add(descripcionCurso);
		
		unirse = new JButton("Unirse");
		unirse.setBounds(278, 511, 89, 23);
		add(unirse);
		
		cerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		cerrarSesion.setBounds(952, 39, 118, 23);
		add(cerrarSesion);
		
		this.user = user;
	}
	
	public void controlador(ActionListener ctr) {
		unirse.addActionListener(ctr);
		unirse.setActionCommand("Unirse");
		
		cerrarSesion.addActionListener(ctr);
		cerrarSesion.setActionCommand("Cerrar Sesi\u00F3n");
	}
	
	public Usuario getUser() {
		return user;
	}
	
}
