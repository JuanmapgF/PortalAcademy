package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;

public class Menu extends JPanel{
	
	private JButton iniciar;
	private JButton explorar;
	private JButton cursos;	
	private JButton actividades;
	private JButton cerrar;
	private JButton ajustes;
	private JButton registrarse;
	
	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;
	
	public Menu() {
		
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);

		iniciar = new JButton("Iniciar sesi\u00F3n");
		iniciar.setBounds(729, 37, 121, 23);
		add(iniciar);

		registrarse = new JButton("Registrarse");
		registrarse.setBounds(860, 37, 121, 23);
		add(registrarse);


		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

	
	}

	public Menu(Estudiante estudiante) {
		this.estudiante = true;
		this.est = estudiante;
				
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);

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
		ajustes.setBounds(36, 413, 131, 32);
		add(ajustes);

		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+estudiante.getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);
	}
	
	public Menu(Profesor profesor) {
		this.prof = profesor;
		this.profesor = true;
		
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);

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
		ajustes.setBounds(36, 413, 131, 32);
		add(ajustes);

		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+profesor.getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);
	}
	
	public Menu(Organizacion organizacion) {
		this.org = organizacion;
		this.organizacion = true;
		
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		actividades = new JButton("Mis actividades");
		actividades.setBounds(36, 336, 131, 32);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 413, 131, 32);
		add(ajustes);

		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+organizacion.getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);
	}
	
	public void controlador(ActionListener ctr) {
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
		if (cerrar != null) {
			cerrar.addActionListener(ctr);
			cerrar.setActionCommand("CERRAR_SESION");
		}
		if (iniciar != null) {
			iniciar.addActionListener(ctr);
			iniciar.setActionCommand("INICIAR_SESION");
		}
		
		if (registrarse != null) {
			registrarse.addActionListener(ctr);
			registrarse.setActionCommand("REGISTRARSE");
		}
	}
	
	public boolean esEstudiante() {
		return estudiante;
	}

	public boolean esOrganizacion() {
		return organizacion;
	}

	public boolean esProfesor() {
		return profesor;
	}

	public Estudiante getEstudiante() {
		return est;
	}

	public Organizacion getOrganizacion() {
		return org;
	}

	public Profesor getProfesor() {
		return prof;
	}
	
}
