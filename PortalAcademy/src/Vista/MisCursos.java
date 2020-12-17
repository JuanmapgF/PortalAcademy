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

import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;

@SuppressWarnings("serial")
public class MisCursos extends JPanel {

	private DefaultListModel<String> modeloC = new DefaultListModel<String>();
	private JList<String> listaC = new JList<String>();
	private JButton bVer = new JButton();
	private JButton bVer2 = new JButton();
	private List<Curso> l;

	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;

	private JButton crearCurso;
	private JButton cerrar;
	private JButton explorar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;

	public MisCursos(Estudiante u) {
		estudiante = true;
		est = u;
		this.setLayout(null);
		addElements(u.getCursos());

		JScrollPane sp_cursos = new JScrollPane();
		sp_cursos.setBounds(441, 175, 346, 346);
		sp_cursos.setViewportView(listaC);
		add(sp_cursos);

		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);

		JLabel t_curso = new JLabel("Mis cursos:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_curso.setBounds(536, 115, 161, 33);
		add(t_curso);

		this.setBounds(0, 0, 1080, 650);

		bVer = new JButton("Ver curso");
		bVer.setBounds(560, 551, 104, 23);
		add(bVer);

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		cursos = new JButton("Mis cursos");
		cursos.setForeground(Color.BLUE);
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);

		actividades = new JButton("Mis actividades");
		actividades.setBounds(36, 336, 131, 32);
		add(actividades);

		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 413, 131, 32);
		add(ajustes);

		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 121, 20);
		add(lblNewLabel_2);
	}

	public MisCursos(Profesor u) {
		profesor = true;
		prof = u;
		this.setLayout(null);
		addElements(u.getCursos());

		crearCurso = new JButton("Crear curso");
		crearCurso.setBounds(860, 551, 121, 23);
		add(crearCurso);

		JScrollPane sp_cursos2 = new JScrollPane();
		sp_cursos2.setBounds(441, 175, 346, 346);
		sp_cursos2.setViewportView(listaC);
		add(sp_cursos2);

		cerrar = new JButton("Cerrar sesi\u00F3n");
		cerrar.setBounds(860, 37, 121, 23);
		add(cerrar);

		JLabel t_curso2 = new JLabel("Mis cursos:");
		t_curso2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_curso2.setBounds(536, 115, 161, 33);
		add(t_curso2);

		this.setBounds(0, 0, 1080, 650);

		bVer2 = new JButton("Ver curso");
		bVer2.setBounds(560, 551, 104, 23);
		add(bVer2);

		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);

		cursos = new JButton("Mis cursos");
		cursos.setForeground(Color.BLUE);
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);

		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);

		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 121, 20);
		add(lblNewLabel_2);
	}

	public void addElements(List<Curso> l) {
		this.l = l;
		listaC.setModel(modeloC);

		for (Object o : l) {
			modeloC.addElement(o.toString());
		}

		listaC.setLayoutOrientation(JList.VERTICAL);
	}

	public Curso getC() {
		if (!listaC.isSelectionEmpty()) {
			return l.get(listaC.getSelectedIndex());
		} else {
			return null;
		}
	}

	public void controlador(ActionListener ctr) {
		bVer.addActionListener(ctr);
		bVer.setActionCommand("MISCURSOSUSUARIO");

		bVer2.addActionListener(ctr);
		bVer2.setActionCommand("MISCURSOSPROFESOR");

		if (crearCurso != null) {
			crearCurso.addActionListener(ctr);
			crearCurso.setActionCommand("CREARCURSO");
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
		if (cerrar != null) {
			cerrar.addActionListener(ctr);
			cerrar.setActionCommand("CERRAR_SESION");
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
