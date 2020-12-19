package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;

@SuppressWarnings("serial")
public class Ajustes extends JPanel {

	private JPasswordField texto;
	private JButton eliminar;
	private JButton cambiar;
	private JButton cerrarSesion;

	private Estudiante estudiante;
	private Profesor prof;
	private Organizacion org;
	private boolean esEstudiante = false;
	private boolean esProfesor = false;
	private boolean esOrganizacion = false;

	private JButton explorar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;

	public String getTexto() {
		return String.valueOf(texto.getPassword());
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public Profesor getProfesor() {
		return prof;
	}

	public Organizacion getOrganizacion() {
		return org;
	}

	public boolean esEstudiante() {
		return esEstudiante;
	}

	public boolean esProfesor() {
		return esProfesor;
	}

	public boolean esOrganizacion() {
		return esOrganizacion;
	}

	public Ajustes(Estudiante u) {
		estudiante = u;
		esEstudiante = true;

		setLayout(null);

		JLabel titulo = new JLabel("Ajustes");
		titulo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		titulo.setBounds(529, 0, 118, 102);
		add(titulo);

		cerrarSesion = new JButton("Cerrar sesi\u00F3n");
		cerrarSesion.setBounds(860, 37, 121, 23);
		add(cerrarSesion);

		JLabel nueva = new JLabel("Nueva contrase\u00F1a:");
		nueva.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		nueva.setBounds(283, 183, 158, 102);
		add(nueva);

		texto = new JPasswordField();
		texto.setBounds(466, 223, 278, 20);
		add(texto);
		texto.setColumns(10);

		cambiar = new JButton("Cambiar contrase\u00F1a");
		cambiar.setBounds(484, 324, 183, 23);
		add(cambiar);

		eliminar = new JButton("Eliminar cuenta");
		eliminar.setBounds(509, 456, 129, 23);
		add(eliminar);

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		cursos = new JButton("Mis cursos");
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);

		actividades = new JButton("Mis actividades");
		actividades.setBounds(36, 336, 131, 32);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setForeground(Color.BLUE);
		ajustes.setBounds(36, 413, 131, 32);
		add(ajustes);
		
		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);

		this.setBounds(0, 0, 1080, 650);
	}

	public Ajustes(Profesor u) {
		esProfesor = true;
		prof = u;
		setLayout(null);

		JLabel titulo = new JLabel("Ajustes");
		titulo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		titulo.setBounds(529, 0, 118, 102);
		add(titulo);

		cerrarSesion = new JButton("Cerrar sesi\u00F3n");
		cerrarSesion.setBounds(860, 37, 121, 23);
		add(cerrarSesion);

		JLabel nueva = new JLabel("Nueva contrase\u00F1a:");
		nueva.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		nueva.setBounds(283, 183, 158, 102);
		add(nueva);

		texto = new JPasswordField();
		texto.setBounds(466, 223, 278, 20);
		add(texto);
		texto.setColumns(10);

		cambiar = new JButton("Cambiar contrase\u00F1a");
		cambiar.setBounds(484, 324, 183, 23);
		add(cambiar);

		eliminar = new JButton("Eliminar cuenta");
		eliminar.setBounds(509, 456, 129, 23);
		add(eliminar);

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		cursos = new JButton("Mis cursos");
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);

		ajustes = new JButton("Ajustes");
		ajustes.setForeground(Color.BLUE);
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);
		
		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);

		this.setBounds(0, 0, 1080, 650);
	}

	public Ajustes(Organizacion u) {
		esOrganizacion = true;
		org = u;
		setLayout(null);

		JLabel titulo = new JLabel("Ajustes");
		titulo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		titulo.setBounds(529, 0, 118, 102);
		add(titulo);

		cerrarSesion = new JButton("Cerrar sesi\u00F3n");
		cerrarSesion.setBounds(860, 37, 121, 23);
		add(cerrarSesion);

		JLabel nueva = new JLabel("Nueva contrase\u00F1a:");
		nueva.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		nueva.setBounds(283, 183, 158, 102);
		add(nueva);

		texto = new JPasswordField();
		texto.setBounds(466, 223, 278, 20);
		add(texto);
		texto.setColumns(10);

		cambiar = new JButton("Cambiar contrase\u00F1a");
		cambiar.setBounds(484, 324, 183, 23);
		add(cambiar);

		eliminar = new JButton("Eliminar cuenta");
		eliminar.setBounds(509, 456, 129, 23);
		add(eliminar);

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		actividades = new JButton("Mis actividades");
		actividades.setBounds(36, 261, 131, 32);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setForeground(Color.BLUE);
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);
		
		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);

		this.setBounds(0, 0, 1080, 650);
	}

	public void controlador(ActionListener ctr) {
		cerrarSesion.addActionListener(ctr);
		cerrarSesion.setActionCommand("CERRAR");

		eliminar.addActionListener(ctr);
		eliminar.setActionCommand("ELIMINAR");

		cambiar.addActionListener(ctr);
		cambiar.setActionCommand("CAMBIAR");

		if (explorar != null) {
			explorar.addActionListener(ctr);
			explorar.setActionCommand("EXPLORAR");
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
	}
}
