package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controlador.CtrMenu;
import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class Explorar extends JPanel {

	private JTable cursos;
	private JTable actividades;
	private ButtonEditorCurso editorCurso = new ButtonEditorCurso(new JTextField());
	private ButtonEditorActividad editorActividad = new ButtonEditorActividad(new JTextField());

	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;

	private List<Curso> lista_cursos = null;
	private List<Actividad> lista_actividades = null;

	private Object[][] datosCurso = null;
	private Object[][] datosActividad = null;

	public Explorar(Estudiante e, List<Curso> lc, List<Actividad> la) {
		estudiante = true;
		lista_cursos = lc;
		lista_actividades = la;
		this.setBounds(0, 0, 1080, 650);
		est = e;
		setLayout(null);

		datosTablaUsuario();

		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);

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
		sp_curso.setViewportView(cursos);
		add(sp_curso);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(656, 215, 273, 339);
		sp_actividad.setViewportView(actividades);
		add(sp_actividad);
		

		CtrMenu menu = new CtrMenu(new Menu(e));
		add(menu.getPanel());
	}

	public Explorar(List<Curso> lc, List<Actividad> la) {
		lista_cursos = lc;
		lista_actividades = la;
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);

		datosTabla();

		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);

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
		sp_curso.setViewportView(cursos);
		add(sp_curso);
		sp_curso.setBorder(BorderFactory.createEmptyBorder());
		cursos.setRowHeight(90);
		cursos.setShowVerticalLines(false);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(656, 215, 273, 339);
		sp_actividad.setViewportView(actividades);
		add(sp_actividad);
		sp_curso.setBorder(BorderFactory.createEmptyBorder());
		actividades.setRowHeight(90);
		actividades.setShowVerticalLines(false);

		CtrMenu menu = new CtrMenu(new Menu());
		add(menu.getPanel());
	}

	public Explorar(Profesor e, List<Curso> lc, List<Actividad> la) {
		profesor = true;
		lista_cursos = lc;
		lista_actividades = la;
		this.setBounds(0, 0, 1080, 650);
		prof = e;
		setLayout(null);

		datosTablaUsuario();

		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);

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
		sp_curso.setViewportView(cursos);
		add(sp_curso);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(656, 215, 273, 339);
		sp_actividad.setViewportView(actividades);
		add(sp_actividad);

		CtrMenu menu = new CtrMenu(new Menu(e));
		add(menu.getPanel());
	}

	public Explorar(Organizacion e, List<Curso> lc, List<Actividad> la) {
		organizacion = true;
		lista_cursos = lc;
		lista_actividades = la;
		this.setBounds(0, 0, 1080, 650);
		org = e;
		setLayout(null);

		datosTabla();

		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(543, 30, 107, 33);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		add(lblNewLabel);

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
		sp_curso.setViewportView(cursos);
		add(sp_curso);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(656, 215, 273, 339);
		sp_actividad.setViewportView(actividades);
		add(sp_actividad);

		CtrMenu menu = new CtrMenu(new Menu(e));
		add(menu.getPanel());
	}

	public void controlador(ActionListener ctr) {
		editorCurso.controlador(ctr);
		editorActividad.controlador(ctr);
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

	public void datosTablaUsuario() {
		datosCurso = new Object[lista_cursos.size()][3];

		int k = 0;

		Usuario u = null;

		if (estudiante) {
			u = est;
		} else if (profesor) {
			u = prof;
		} else if (organizacion) {
			u = org;
		}

		for (Curso curso : lista_cursos) {
			datosCurso[k][0] = curso.getImagen();
			datosCurso[k][1] = curso.getNombre();
			if (u.estaEnCurso(curso)) {
				datosCurso[k][2] = "✔";
			} else if (!curso.quedanPlazas()) {
				datosCurso[k][2] = "Lleno";
			} else {
				datosCurso[k][2] = "Disponible";
			}
			k++;
		}

		String[] columnHeadersCurso = { "Imagen", "Curso", "Acceso" };

		cursos = new JTable(datosCurso, columnHeadersCurso);
		cursos.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(true));
		cursos.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		cursos.getColumnModel().getColumn(1).setCellEditor(editorCurso);
		cursos.setTableHeader(null);
		cursos.setCellSelectionEnabled(false);

		datosActividad = new Object[lista_actividades.size()][3];

		k = 0;
		for (Actividad actividad : lista_actividades) {
			datosActividad[k][0] = actividad.getImagen();
			datosActividad[k][1] = actividad.getNombre();
			if (u.estaEnActividad(actividad)) {
				datosActividad[k][2] = "✔";
			} else if (!actividad.quedanPlazas()) {
				datosActividad[k][2] = "Lleno";
			} else {
				datosActividad[k][2] = "Disponible";
			}
			k++;
		}

		String[] columnHeadersActividad = { "Imagen", "Actividad", "Acceso" };

		actividades = new JTable(datosActividad, columnHeadersActividad);

		actividades.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(false));
		actividades.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		actividades.getColumnModel().getColumn(1).setCellEditor(editorActividad);
		actividades.setTableHeader(null);
		actividades.setCellSelectionEnabled(false);
	}

	public void datosTabla() {

		datosCurso = new Object[lista_cursos.size()][3];

		int k = 0;
		for (Curso curso : lista_cursos) {
			datosCurso[k][0] = curso.getImagen();
			datosCurso[k][1] = curso.getNombre();
			if (!curso.quedanPlazas()) {
				datosCurso[k][2] = "Lleno";
			} else {
				datosCurso[k][2] = "Disponible";
			}

			k++;
		}

		String[] columnHeadersCurso = { "Imagen", "Curso", "Acceso" };

		cursos = new JTable(datosCurso, columnHeadersCurso);
		cursos.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(true));
		cursos.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		cursos.getColumnModel().getColumn(1).setCellEditor(editorCurso);
		cursos.setTableHeader(null);
		cursos.setCellSelectionEnabled(false);

		datosActividad = new Object[lista_actividades.size()][3];

		k = 0;
		for (Actividad actividad : lista_actividades) {
			datosActividad[k][0] = actividad.getImagen();
			datosActividad[k][1] = actividad.getNombre();
			if (!actividad.quedanPlazas()) {
				datosActividad[k][2] = "Lleno";
			} else {
				datosActividad[k][2] = "Disponible";
			}
			k++;
		}

		String[] columnHeadersActividad = { "Imagen", "Actividad", "Acceso" };

		actividades = new JTable(datosActividad, columnHeadersActividad);
		actividades.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(false));
		actividades.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		actividades.getColumnModel().getColumn(1).setCellEditor(editorActividad);
		actividades.setTableHeader(null);
		actividades.setCellSelectionEnabled(false);
	}

	public Curso getCurso() {
		return lista_cursos.get(cursos.getSelectedRow());
	}

	public Actividad getActividad() {
		return lista_actividades.get(actividades.getSelectedRow());
	}

	/*
	 * private DefaultListModel<String> modeloC = new DefaultListModel<String>();
	 * private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	 * private JList<String> listaC; private JList<String> listaA; private JButton
	 * verCurso; private JButton verActividad;
	 * 
	 * private Estudiante est = null; private Organizacion org = null; private
	 * Profesor prof = null; private boolean estudiante = false; private boolean
	 * organizacion = false; private boolean profesor = false;
	 * 
	 * private List<Curso> lista_cursos = null; private List<Actividad>
	 * lista_actividades = null;
	 * 
	 * public Explorar(Estudiante e, List<Curso> lc, List<Actividad> la) {
	 * estudiante = true; lista_cursos = lc; lista_actividades = la;
	 * this.setBounds(0, 0, 1080, 650); est = e; setLayout(null);
	 * 
	 * listaC = new JList<String>(); listaA = new JList<String>();
	 * addElementsEstudiante();
	 * 
	 * JLabel lblNewLabel = new JLabel("Explorar"); lblNewLabel.setBounds(543, 30,
	 * 107, 33); lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
	 * add(lblNewLabel);
	 * 
	 * JLabel t_curso = new JLabel("Cursos:"); t_curso.setFont(new
	 * Font("Segoe UI Emoji", Font.PLAIN, 20)); t_curso.setBounds(295, 159, 90, 33);
	 * add(t_curso);
	 * 
	 * JLabel t_actividad = new JLabel("Actividades:"); t_actividad.setFont(new
	 * Font("Segoe UI Emoji", Font.PLAIN, 20)); t_actividad.setBounds(619, 159, 159,
	 * 33); add(t_actividad);
	 * 
	 * JScrollPane sp_curso = new JScrollPane(); sp_curso.setBounds(325, 215, 273,
	 * 339); sp_curso.setViewportView(listaC); add(sp_curso);
	 * 
	 * JScrollPane sp_actividad = new JScrollPane(); sp_actividad.setBounds(656,
	 * 215, 273, 339); sp_actividad.setViewportView(listaA); add(sp_actividad);
	 * 
	 * verCurso = new JButton("Ver curso"); verCurso.setBounds(399, 575, 121, 23);
	 * add(verCurso);
	 * 
	 * verActividad = new JButton("Ver actividad"); verActividad.setBounds(741, 575,
	 * 121, 23); add(verActividad);
	 * 
	 * CtrMenu menu = new CtrMenu(new Menu(e)); add(menu.getPanel()); }
	 * 
	 * public Explorar(Profesor e, List<Curso> lc, List<Actividad> la) { profesor =
	 * true; lista_cursos = lc; lista_actividades = la; this.setBounds(0, 0, 1080,
	 * 650); prof = e; setLayout(null);
	 * 
	 * listaC = new JList<String>(); listaA = new JList<String>();
	 * addElementsProfesor();
	 * 
	 * JLabel lblNewLabel = new JLabel("Explorar"); lblNewLabel.setBounds(543, 30,
	 * 107, 33); lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
	 * add(lblNewLabel);
	 * 
	 * JLabel t_curso = new JLabel("Cursos:"); t_curso.setFont(new
	 * Font("Segoe UI Emoji", Font.PLAIN, 20)); t_curso.setBounds(295, 159, 90, 33);
	 * add(t_curso);
	 * 
	 * JLabel t_actividad = new JLabel("Actividades:"); t_actividad.setFont(new
	 * Font("Segoe UI Emoji", Font.PLAIN, 20)); t_actividad.setBounds(619, 159, 159,
	 * 33); add(t_actividad);
	 * 
	 * JScrollPane sp_curso = new JScrollPane(); sp_curso.setBounds(325, 215, 273,
	 * 339); sp_curso.setViewportView(listaC); add(sp_curso);
	 * 
	 * JScrollPane sp_actividad = new JScrollPane(); sp_actividad.setBounds(656,
	 * 215, 273, 339); sp_actividad.setViewportView(listaA); add(sp_actividad);
	 * 
	 * verCurso = new JButton("Ver curso"); verCurso.setBounds(399, 575, 121, 23);
	 * add(verCurso);
	 * 
	 * verActividad = new JButton("Ver actividad"); verActividad.setBounds(741, 575,
	 * 121, 23); add(verActividad);
	 * 
	 * CtrMenu menu = new CtrMenu(new Menu(e)); add(menu.getPanel()); }
	 * 
	 * public Explorar(Organizacion e, List<Curso> lc, List<Actividad> la) {
	 * organizacion = true; lista_cursos = lc; lista_actividades = la;
	 * this.setBounds(0, 0, 1080, 650); org = e; setLayout(null);
	 * 
	 * listaC = new JList<String>(); listaA = new JList<String>(); addElements();
	 * 
	 * JLabel lblNewLabel = new JLabel("Explorar"); lblNewLabel.setBounds(543, 30,
	 * 107, 33); lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
	 * add(lblNewLabel);
	 * 
	 * JLabel t_curso = new JLabel("Cursos:"); t_curso.setFont(new
	 * Font("Segoe UI Emoji", Font.PLAIN, 20)); t_curso.setBounds(295, 159, 90, 33);
	 * add(t_curso);
	 * 
	 * JLabel t_actividad = new JLabel("Actividades:"); t_actividad.setFont(new
	 * Font("Segoe UI Emoji", Font.PLAIN, 20)); t_actividad.setBounds(619, 159, 159,
	 * 33); add(t_actividad);
	 * 
	 * JScrollPane sp_curso = new JScrollPane(); sp_curso.setBounds(325, 215, 273,
	 * 339); sp_curso.setViewportView(listaC); add(sp_curso);
	 * 
	 * JScrollPane sp_actividad = new JScrollPane(); sp_actividad.setBounds(656,
	 * 215, 273, 339); sp_actividad.setViewportView(listaA); add(sp_actividad);
	 * 
	 * verCurso = new JButton("Ver curso"); verCurso.setBounds(399, 575, 121, 23);
	 * add(verCurso);
	 * 
	 * verActividad = new JButton("Ver actividad"); verActividad.setBounds(741, 575,
	 * 121, 23); add(verActividad);
	 * 
	 * CtrMenu menu = new CtrMenu(new Menu(e)); add(menu.getPanel());
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void addElementsEstudiante() { listaC.setModel(modeloC);
	 * listaA.setModel(modeloA);
	 * 
	 * for (Curso o : lista_cursos) { if (est.estaEnCurso(o)) {
	 * modeloC.addElement("✔ " + o.toString()); } else {
	 * modeloC.addElement(o.toString()); } }
	 * 
	 * for (Actividad d : lista_actividades) { if (est.estaEnActividad(d)) {
	 * modeloA.addElement("✔ " + d.toString()); } else {
	 * modeloA.addElement(d.toString()); } }
	 * 
	 * listaC.setLayoutOrientation(JList.VERTICAL);
	 * listaA.setLayoutOrientation(JList.VERTICAL); }
	 * 
	 * public void addElementsProfesor() { listaC.setModel(modeloC);
	 * listaA.setModel(modeloA);
	 * 
	 * for (Curso o : lista_cursos) { if (prof.estaEnCurso(o)) {
	 * modeloC.addElement("✔ " + o.toString()); } else {
	 * modeloC.addElement(o.toString()); } }
	 * 
	 * for (Actividad d : lista_actividades) { if (prof.estaEnActividad(d)) {
	 * modeloA.addElement("✔ " + d.toString()); } else {
	 * modeloA.addElement(d.toString()); } }
	 * 
	 * listaC.setLayoutOrientation(JList.VERTICAL);
	 * listaA.setLayoutOrientation(JList.VERTICAL); }
	 * 
	 * public void addElements() { listaC.setModel(modeloC);
	 * listaA.setModel(modeloA);
	 * 
	 * for (Curso o : lista_cursos) { modeloC.addElement(o.toString()); }
	 * 
	 * for (Actividad d : lista_actividades) { modeloA.addElement(d.toString()); }
	 * 
	 * listaC.setLayoutOrientation(JList.VERTICAL);
	 * listaA.setLayoutOrientation(JList.VERTICAL); }
	 * 
	 * public void controlador(ActionListener ctr) { if (verCurso != null) {
	 * verCurso.addActionListener(ctr); verCurso.setActionCommand("VER_CURSO"); } if
	 * (verActividad != null) { verActividad.addActionListener(ctr);
	 * verActividad.setActionCommand("VER_ACTIVIDAD"); }
	 * 
	 * }
	 * 
	 * public Curso getCurso() { if (listaC.isSelectionEmpty()) { return null; }
	 * else { return lista_cursos.get(listaC.getSelectedIndex()); } }
	 * 
	 * public Actividad getActividad() { if (listaA.isSelectionEmpty()) { return
	 * null; } else { return lista_actividades.get(listaA.getSelectedIndex()); } }
	 * 
	 * public boolean esEstudiante() { return estudiante; }
	 * 
	 * public boolean esOrganizacion() { return organizacion; }
	 * 
	 * public boolean esProfesor() { return profesor; }
	 * 
	 * public Estudiante getEstudiante() { return est; }
	 * 
	 * public Organizacion getOrganizacion() { return org; }
	 * 
	 * public Profesor getProfesor() { return prof; }
	 * 
	 * public void datosTabla() { Object[][] data = new
	 * Object[lista_cursos.size()][] }
	 */
}