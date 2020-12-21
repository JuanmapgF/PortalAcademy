package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class Explorar extends JPanel {
	
	private DefaultListModel<String> modeloC = new DefaultListModel<String>();
	private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	private JList<String> listaC;
	private JList<String> listaA;
	private JButton iniciar;
	private JButton cerrar;
	private JButton registrarse;
	private JButton verCurso;
	private JButton verActividad;
	
	private JButton explorar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;
	
	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;
	
	private List<Curso> lista_cursos = null;
	private List<Actividad> lista_actividades = null;
	
	public Explorar(Estudiante e, List<Curso> lc, List<Actividad> la) {
		estudiante = true;
		lista_cursos = lc;
		lista_actividades = la;
		this.setBounds(0, 0, 1080, 650);
		est = e;
		setLayout(null);
		
		listaC = new JList<String>();
		listaA = new JList<String>();
		addElementsEstudiante();
		
		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);

		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);

		JLabel t_curso = new JLabel("Cursos:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_curso.setBounds(295, 159, 90, 33);
		add(t_curso);

		JLabel t_actividad = new JLabel("Actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_actividad.setBounds(619, 159, 159, 33);
		add(t_actividad);

		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(325, 215, 273, 339);
		sp_curso.setViewportView(listaC);
		add(sp_curso);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(656, 215, 273, 339);
		sp_actividad.setViewportView(listaA);
		add(sp_actividad);

		verCurso = new JButton("Ver curso");
		verCurso.setBounds(399, 575, 121, 23);
		add(verCurso);

		verActividad = new JButton("Ver actividad");
		verActividad.setBounds(741, 575, 121, 23);
		add(verActividad);

		explorar = new JButton("Explorar");
		explorar.setForeground(Color.BLUE);
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
		
		add(Main.getLabel());
	}
	
	public Explorar(Profesor e, List<Curso> lc, List<Actividad> la) {
		profesor = true;
		lista_cursos = lc;
		lista_actividades = la;
		this.setBounds(0, 0, 1080, 650);
		prof = e;
		setLayout(null);
		
		listaC = new JList<String>();
		listaA = new JList<String>();
		addElementsProfesor();
		
		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);

		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);

		JLabel t_curso = new JLabel("Cursos:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_curso.setBounds(295, 159, 90, 33);
		add(t_curso);

		JLabel t_actividad = new JLabel("Actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_actividad.setBounds(619, 159, 159, 33);
		add(t_actividad);

		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(325, 215, 273, 339);
		sp_curso.setViewportView(listaC);
		add(sp_curso);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(656, 215, 273, 339);
		sp_actividad.setViewportView(listaA);
		add(sp_actividad);

		verCurso = new JButton("Ver curso");
		verCurso.setBounds(399, 575, 121, 23);
		add(verCurso);

		verActividad = new JButton("Ver actividad");
		verActividad.setBounds(741, 575, 121, 23);
		add(verActividad);

		explorar = new JButton("Explorar");
		explorar.setForeground(Color.BLUE);
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
		
		add(Main.getLabel());
	}
	
	public void addElementsEstudiante() {
		listaC.setModel(modeloC);
		listaA.setModel(modeloA);

		for (Curso o : lista_cursos) {
			if (est.estaEnCurso(o)) {
				modeloC.addElement("✔ - " + o.toString());
			} else {
				modeloC.addElement(o.toString());
			}			
		}

		for (Actividad d : lista_actividades) {
			if (est.estaEnActividad(d)) {
				modeloA.addElement("✔ - " + d.toString());
			} else {
				modeloA.addElement(d.toString());
			}
		}

		listaC.setLayoutOrientation(JList.VERTICAL);
		listaA.setLayoutOrientation(JList.VERTICAL);
	}
	
	public void addElementsProfesor() {
		listaC.setModel(modeloC);
		listaA.setModel(modeloA);

		for (Curso o : lista_cursos) {
			if (prof.estaEnCurso(o)) {
				modeloC.addElement("✔ - " + o.toString());
			} else {
				modeloC.addElement(o.toString());
			}			
		}

		for (Actividad d : lista_actividades) {
			if (prof.estaEnActividad(d)) {
				modeloA.addElement("✔ - " + d.toString());
			} else {
				modeloA.addElement(d.toString());
			}
		}

		listaC.setLayoutOrientation(JList.VERTICAL);
		listaA.setLayoutOrientation(JList.VERTICAL);
	}
	
	/*
	private DefaultListModel<String> modeloC = new DefaultListModel<String>();
	private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	private DefaultListModel<String> modeloN = new DefaultListModel<String>();
	private JList<String> listaC;
	private JList<String> listaA;
	private JList<String> listaN;
	private JButton iniciar;
	private JButton cerrar;
	private JButton registrarse;
	private JButton seleccionC;
	private JButton seleccionA;

	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;

	private List<Curso> lista_cursos;
	private List<Actividad> lista_actividad;

	private JButton explorar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;

	public Explorar(Estudiante u, List<Curso> c, List<Actividad> a) {
		estudiante = true;
		lista_cursos = c;
		lista_actividad = a;
		this.setBounds(0, 0, 1080, 650);
		est = u;
		setLayout(null);

		listaC = new JList<String>();
		listaA = new JList<String>();
		addElements(c, a);

		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);

		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);

		JLabel t_curso = new JLabel("Cursos:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_curso.setBounds(295, 159, 90, 33);
		add(t_curso);

		JLabel t_actividad = new JLabel("Actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_actividad.setBounds(619, 159, 159, 33);
		add(t_actividad);

		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(325, 215, 273, 339);
		sp_curso.setViewportView(listaC);
		add(sp_curso);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(656, 215, 273, 339);
		sp_actividad.setViewportView(listaA);
		add(sp_actividad);

		seleccionC = new JButton("Ver curso");
		seleccionC.setBounds(399, 575, 121, 23);
		add(seleccionC);

		seleccionA = new JButton("Ver actividad");
		seleccionA.setBounds(741, 575, 121, 23);
		add(seleccionA);

		explorar = new JButton("Explorar");
		explorar.setForeground(Color.BLUE);
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
		
		JLabel lblNewLabel_2 = new JLabel(Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);
	}

	public Explorar(List<Curso> c, List<Actividad> a) {
		lista_cursos = c;
		lista_actividad = a;
		setLayout(null);

		listaC = new JList<String>();
		listaA = new JList<String>();
		addElements(c, a);

		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);

		iniciar = new JButton("Iniciar sesi\u00F3n");
		iniciar.setBounds(729, 37, 121, 23);
		add(iniciar);

		registrarse = new JButton("Registrarse");
		registrarse.setBounds(860, 37, 121, 23);
		add(registrarse);

		JLabel t_curso = new JLabel("Cursos:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_curso.setBounds(295, 159, 90, 33);
		add(t_curso);

		JLabel t_actividad = new JLabel("Actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_actividad.setBounds(619, 159, 159, 33);
		add(t_actividad);

		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(325, 215, 273, 339);
		sp_curso.setViewportView(listaC);
		add(sp_curso);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(656, 215, 273, 339);
		sp_actividad.setViewportView(listaA);
		add(sp_actividad);

		seleccionC = new JButton("Ver curso");
		seleccionC.setBounds(399, 575, 121, 23);
		add(seleccionC);

		seleccionA = new JButton("Ver actividad");
		seleccionA.setBounds(741, 575, 121, 23);
		add(seleccionA);

		explorar = new JButton("Explorar");
		explorar.setForeground(Color.BLUE);
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		this.setBounds(0, 0, 1080, 650);
	}

	public Explorar(Profesor u, List<Curso> c, List<Actividad> a) {
		profesor = true;
		lista_cursos = c;
		lista_actividad = a;
		this.setBounds(0, 0, 1080, 650);
		prof = u;
		setLayout(null);

		listaC = new JList<String>();
		listaA = new JList<String>();
		addElements(c, a);

		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);

		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);

		JLabel t_curso = new JLabel("Cursos:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_curso.setBounds(295, 159, 90, 33);
		add(t_curso);

		JLabel t_actividad = new JLabel("Actividades:");
		t_actividad.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_actividad.setBounds(619, 159, 159, 33);
		add(t_actividad);

		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(325, 215, 273, 339);
		sp_curso.setViewportView(listaC);
		add(sp_curso);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(656, 215, 273, 339);
		sp_actividad.setViewportView(listaA);
		add(sp_actividad);

		seleccionC = new JButton("Ver curso");
		seleccionC.setBounds(399, 575, 121, 23);
		add(seleccionC);

		seleccionA = new JButton("Ver actividad");
		seleccionA.setBounds(741, 575, 121, 23);
		add(seleccionA);

		explorar = new JButton("Explorar");
		explorar.setForeground(Color.BLUE);
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
		
		JLabel lblNewLabel_2 = new JLabel(Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);
	}

	public Explorar(Organizacion u, List<Actividad> l) {
		organizacion = true;
		lista_actividad = l;
		org = u;
		this.setLayout(null);

		listaN = new JList<String>();
		addElementsA(l);

		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);

		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);

		JLabel t_n = new JLabel("Actividades:");
		t_n.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		t_n.setBounds(418, 159, 191, 33);
		add(t_n);

		JScrollPane sp_n = new JScrollPane();
		sp_n.setBounds(463, 215, 273, 339);
		sp_n.setViewportView(listaN);
		add(sp_n);

		seleccionA = new JButton("Ver actividad");
		seleccionA.setBounds(537, 575, 121, 23);
		add(seleccionA);

		explorar = new JButton("Explorar");
		explorar.setForeground(Color.BLUE);
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		actividades = new JButton("Mis actividades");
		actividades.setBounds(36, 261, 131, 32);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);

		this.setBounds(0, 0, 1080, 650);
		
		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);
	}

	public void addElements(List<Curso> c, List<Actividad> a) {
		listaC.setModel(modeloC);
		listaA.setModel(modeloA);

		for (Curso o : c) {
			modeloC.addElement(o.toString());
		}

		for (Actividad d : a) {
			modeloA.addElement(d.toString());
		}

		listaC.setLayoutOrientation(JList.VERTICAL);
		listaA.setLayoutOrientation(JList.VERTICAL);
	}

	public void addElementsC(List<Curso> l) {
		listaN.setModel(modeloN);

		for (Curso o : l) {
			modeloN.addElement(o.toString());
		}

		listaN.setLayoutOrientation(JList.VERTICAL);
	}

	public void addElementsA(List<Actividad> l) {
		listaN.setModel(modeloN);

		for (Object o : l) {
			modeloN.addElement(o.toString());
		}

		listaN.setLayoutOrientation(JList.VERTICAL);
	}

	public void controlador(ActionListener ctr) {

		if (iniciar != null) {
			iniciar.addActionListener(ctr);
			iniciar.setActionCommand("INICIAR_SESION");
		}
		if (cerrar != null) {
			cerrar.addActionListener(ctr);
			cerrar.setActionCommand("CERRAR_SESION");
		}
		if (registrarse != null) {
			registrarse.addActionListener(ctr);
			registrarse.setActionCommand("REGISTRO");
		}
		if (seleccionC != null) {
			seleccionC.addActionListener(ctr);
			seleccionC.setActionCommand("VER_CURSO");
		}
		if (seleccionA != null) {
			seleccionA.addActionListener(ctr);
			seleccionA.setActionCommand("VER_ACTIVIDAD");
		}
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

	public Curso getCurso() {
		if (listaC.isSelectionEmpty()) {
			return null;
		} else {
			return lista_cursos.get(listaC.getSelectedIndex());
		}
	}

	public Actividad getActividad() {
		if (listaA.isSelectionEmpty()) {
			return null;
		} else {
			return lista_actividad.get(listaA.getSelectedIndex());
		}
	}

	public Curso getCursoN() {
		if (listaN.isSelectionEmpty()) {
			return null;
		} else {
			return lista_cursos.get(listaN.getSelectedIndex());
		}
	}

	public Actividad getActividadN() {
		if (listaN.isSelectionEmpty()) {
			return null;
		} else {
			return lista_actividad.get(listaN.getSelectedIndex());
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
	
	*/
}
