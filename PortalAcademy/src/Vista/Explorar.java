package Vista;

import java.awt.Color;
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
import Modelo.MensajeNoticia;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

@SuppressWarnings("serial")
public class Explorar extends JPanel {

	private JTable cursos;
	private JTable actividades;
	private JTable noticias;
	private ButtonEditorCurso editorCurso = new ButtonEditorCurso(new JTextField());
	private ButtonEditorActividad editorActividad = new ButtonEditorActividad(new JTextField());

	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;

	private List<MensajeNoticia> lista_noticias = MensajeNoticia.getTodasLasNoticias();
	private List<Curso> lista_cursos = null;
	private List<Actividad> lista_actividades = null;

	private Object[][] datosNoticias = null;
	private Object[][] datosCurso = null;
	private Object[][] datosActividad = null;

	/**
	 * @wbp.parser.constructor
	 */
	public Explorar(Estudiante e, List<Curso> lc, List<Actividad> la) {
		estudiante = true;
		lista_cursos = lc;
		lista_actividades = la;
		this.setBounds(0, 0, 1920, 1080);
		est = e;
		setLayout(null);

		datosTablaUsuario();

		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(904, 60, 170, 49);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblNewLabel);

		JLabel t_curso = new JLabel("Cursos");
		t_curso.setBorder(new LineBorder(Color.BLACK));
		t_curso.setHorizontalAlignment(SwingConstants.CENTER);
		t_curso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_curso.setBounds(431, 401, 475, 41);
		add(t_curso);

		JLabel t_actividad = new JLabel("Actividades");
		t_actividad.setBorder(new LineBorder(Color.BLACK));
		t_actividad.setHorizontalAlignment(SwingConstants.CENTER);
		t_actividad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_actividad.setBounds(1089, 401, 475, 41);
		add(t_actividad);
		
		JLabel t_noticias = new JLabel("Noticias");
		t_noticias.setBorder(new LineBorder(Color.BLACK));
		t_noticias.setHorizontalAlignment(SwingConstants.CENTER);
		t_noticias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_noticias.setBounds(431, 133, 1133, 41);
		add(t_noticias);
		
		cargarNoticias();
		
		JScrollPane sp_noticias = new JScrollPane(noticias, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp_noticias.setWheelScrollingEnabled(true);
		sp_noticias.setBounds(431, 179, 1133, 170);
		sp_noticias.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_noticias);
		sp_noticias.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		noticias.setRowHeight(0, 130);
		noticias.setRowHeight(1, 40);
		noticias.setShowHorizontalLines(false);
		noticias.setShowVerticalLines(false);
		for (int i = 0; i < noticias.getModel().getColumnCount(); i++) {
			noticias.getColumnModel().getColumn(i).setMaxWidth(170);
			noticias.getColumnModel().getColumn(i).setMinWidth(170);
		}
		noticias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		

		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(431, 447, 475, 500);
		sp_curso.setViewportView(cursos);
		sp_curso.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_curso);
		sp_curso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		cursos.setRowHeight(75);
		cursos.setShowVerticalLines(false);
		cursos.getColumnModel().getColumn(0).setMaxWidth(75);
		cursos.getColumnModel().getColumn(0).setMinWidth(75);
		cursos.getColumnModel().getColumn(1).setMaxWidth(315);
		cursos.getColumnModel().getColumn(1).setMinWidth(315);
		cursos.getColumnModel().getColumn(2).setMaxWidth(75);
		cursos.getColumnModel().getColumn(2).setMinWidth(75);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(1089, 447, 475, 500);
		sp_actividad.setViewportView(actividades);
		sp_actividad.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_actividad);
		sp_actividad.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		actividades.setRowHeight(75);
		actividades.setShowVerticalLines(false);
		actividades.getColumnModel().getColumn(0).setMaxWidth(75);
		actividades.getColumnModel().getColumn(0).setMinWidth(75);
		actividades.getColumnModel().getColumn(1).setMaxWidth(315);
		actividades.getColumnModel().getColumn(1).setMinWidth(315);
		actividades.getColumnModel().getColumn(2).setMaxWidth(75);
		actividades.getColumnModel().getColumn(2).setMinWidth(75);
		

		CtrMenu menu = new CtrMenu(new Menu(e));
		add(menu.getPanel());
		
		
	}

	
	public Explorar(List<Curso> lc, List<Actividad> la) {
		lista_cursos = lc;
		lista_actividades = la;
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		datosTabla();

		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(904, 60, 170, 49);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblNewLabel);

		JLabel t_curso = new JLabel("Cursos");
		t_curso.setBorder(new LineBorder(Color.BLACK));
		t_curso.setHorizontalAlignment(SwingConstants.CENTER);
		t_curso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_curso.setBounds(431, 401, 475, 41);
		add(t_curso);

		JLabel t_actividad = new JLabel("Actividades");
		t_actividad.setBorder(new LineBorder(Color.BLACK));
		t_actividad.setHorizontalAlignment(SwingConstants.CENTER);
		t_actividad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_actividad.setBounds(1089, 401, 475, 41);
		add(t_actividad);
		
		JLabel t_noticias = new JLabel("Noticias");
		t_noticias.setBorder(new LineBorder(Color.BLACK));
		t_noticias.setHorizontalAlignment(SwingConstants.CENTER);
		t_noticias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_noticias.setBounds(431, 133, 1133, 41);
		add(t_noticias);
		
		cargarNoticias();
		
		JScrollPane sp_noticias = new JScrollPane(noticias, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp_noticias.setWheelScrollingEnabled(true);
		sp_noticias.setBounds(431, 179, 1133, 170);
		sp_noticias.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_noticias);
		sp_noticias.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		noticias.setRowHeight(0, 130);
		noticias.setRowHeight(1, 40);
		noticias.setShowHorizontalLines(false);
		noticias.setShowVerticalLines(false);
		for (int i = 0; i < noticias.getModel().getColumnCount(); i++) {
			noticias.getColumnModel().getColumn(i).setMaxWidth(170);
			noticias.getColumnModel().getColumn(i).setMinWidth(170);
		}
		noticias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(431, 447, 475, 500);
		sp_curso.setViewportView(cursos);
		sp_curso.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_curso);
		sp_curso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		cursos.setRowHeight(75);
		cursos.setShowVerticalLines(false);
		cursos.getColumnModel().getColumn(0).setMaxWidth(75);
		cursos.getColumnModel().getColumn(0).setMinWidth(75);
		cursos.getColumnModel().getColumn(1).setMaxWidth(315);
		cursos.getColumnModel().getColumn(1).setMinWidth(315);
		cursos.getColumnModel().getColumn(2).setMaxWidth(75);
		cursos.getColumnModel().getColumn(2).setMinWidth(75);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(1089, 447, 475, 500);
		sp_actividad.setViewportView(actividades);
		sp_actividad.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_actividad);
		sp_actividad.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		actividades.setRowHeight(75);
		actividades.setShowVerticalLines(false);
		actividades.getColumnModel().getColumn(0).setMaxWidth(75);
		actividades.getColumnModel().getColumn(0).setMinWidth(75);
		actividades.getColumnModel().getColumn(1).setMaxWidth(315);
		actividades.getColumnModel().getColumn(1).setMinWidth(315);
		actividades.getColumnModel().getColumn(2).setMaxWidth(75);
		actividades.getColumnModel().getColumn(2).setMinWidth(75);

		CtrMenu menu = new CtrMenu(new Menu());
		add(menu.getPanel());
	}

	public Explorar(Profesor e, List<Curso> lc, List<Actividad> la) {
		profesor = true;
		lista_cursos = lc;
		lista_actividades = la;
		this.setBounds(0, 0, 1920, 1080);
		prof = e;
		setLayout(null);

		datosTablaUsuario();

		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(904, 60, 170, 49);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblNewLabel);

		JLabel t_curso = new JLabel("Cursos");
		t_curso.setBorder(new LineBorder(Color.BLACK));
		t_curso.setHorizontalAlignment(SwingConstants.CENTER);
		t_curso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_curso.setBounds(431, 401, 475, 41);
		add(t_curso);

		JLabel t_actividad = new JLabel("Actividades");
		t_actividad.setBorder(new LineBorder(Color.BLACK));
		t_actividad.setHorizontalAlignment(SwingConstants.CENTER);
		t_actividad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_actividad.setBounds(1089, 401, 475, 41);
		add(t_actividad);
		
		JLabel t_noticias = new JLabel("Noticias");
		t_noticias.setBorder(new LineBorder(Color.BLACK));
		t_noticias.setHorizontalAlignment(SwingConstants.CENTER);
		t_noticias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_noticias.setBounds(431, 133, 1133, 41);
		add(t_noticias);
		
		cargarNoticias();
		
		JScrollPane sp_noticias = new JScrollPane(noticias, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp_noticias.setWheelScrollingEnabled(true);
		sp_noticias.setBounds(431, 179, 1133, 170);
		sp_noticias.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_noticias);
		sp_noticias.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		noticias.setRowHeight(0, 130);
		noticias.setRowHeight(1, 40);
		noticias.setShowHorizontalLines(false);
		noticias.setShowVerticalLines(false);
		for (int i = 0; i < noticias.getModel().getColumnCount(); i++) {
			noticias.getColumnModel().getColumn(i).setMaxWidth(170);
			noticias.getColumnModel().getColumn(i).setMinWidth(170);
		}
		noticias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(431, 447, 475, 500);
		sp_curso.setViewportView(cursos);
		sp_curso.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_curso);
		sp_curso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		cursos.setRowHeight(75);
		cursos.setShowVerticalLines(false);
		cursos.getColumnModel().getColumn(0).setMaxWidth(75);
		cursos.getColumnModel().getColumn(0).setMinWidth(75);
		cursos.getColumnModel().getColumn(1).setMaxWidth(315);
		cursos.getColumnModel().getColumn(1).setMinWidth(315);
		cursos.getColumnModel().getColumn(2).setMaxWidth(75);
		cursos.getColumnModel().getColumn(2).setMinWidth(75);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(1089, 447, 475, 500);
		sp_actividad.setViewportView(actividades);
		sp_actividad.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_actividad);
		sp_actividad.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		actividades.setRowHeight(75);
		actividades.setShowVerticalLines(false);
		actividades.getColumnModel().getColumn(0).setMaxWidth(75);
		actividades.getColumnModel().getColumn(0).setMinWidth(75);
		actividades.getColumnModel().getColumn(1).setMaxWidth(315);
		actividades.getColumnModel().getColumn(1).setMinWidth(315);
		actividades.getColumnModel().getColumn(2).setMaxWidth(75);
		actividades.getColumnModel().getColumn(2).setMinWidth(75);

		CtrMenu menu = new CtrMenu(new Menu(e));
		add(menu.getPanel());
	}

	public Explorar(Organizacion e, List<Curso> lc, List<Actividad> la) {
		organizacion = true;
		lista_cursos = lc;
		lista_actividades = la;
		this.setBounds(0, 0, 1920, 1080);
		org = e;
		setLayout(null);

		datosTabla();

		JLabel lblNewLabel = new JLabel("Explorar");
		lblNewLabel.setBounds(904, 60, 170, 49);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblNewLabel);

		JLabel t_curso = new JLabel("Cursos");
		t_curso.setBorder(new LineBorder(Color.BLACK));
		t_curso.setHorizontalAlignment(SwingConstants.CENTER);
		t_curso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_curso.setBounds(431, 401, 475, 41);
		add(t_curso);

		JLabel t_actividad = new JLabel("Actividades");
		t_actividad.setBorder(new LineBorder(Color.BLACK));
		t_actividad.setHorizontalAlignment(SwingConstants.CENTER);
		t_actividad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_actividad.setBounds(1089, 401, 475, 41);
		add(t_actividad);
		
		JLabel t_noticias = new JLabel("Noticias");
		t_noticias.setBorder(new LineBorder(Color.BLACK));
		t_noticias.setHorizontalAlignment(SwingConstants.CENTER);
		t_noticias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_noticias.setBounds(431, 133, 1133, 41);
		add(t_noticias);
		
		cargarNoticias();
		
		JScrollPane sp_noticias = new JScrollPane(noticias, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp_noticias.setWheelScrollingEnabled(true);
		sp_noticias.setBounds(431, 179, 1133, 170);
		sp_noticias.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_noticias);
		sp_noticias.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		noticias.setRowHeight(0, 130);
		noticias.setRowHeight(1, 40);
		noticias.setShowHorizontalLines(false);
		noticias.setShowVerticalLines(false);
		for (int i = 0; i < noticias.getModel().getColumnCount(); i++) {
			noticias.getColumnModel().getColumn(i).setMaxWidth(170);
			noticias.getColumnModel().getColumn(i).setMinWidth(170);
		}
		noticias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(431, 447, 475, 500);
		sp_curso.setViewportView(cursos);
		sp_curso.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_curso);
		sp_curso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		cursos.setRowHeight(75);
		cursos.setShowVerticalLines(false);
		cursos.getColumnModel().getColumn(0).setMaxWidth(75);
		cursos.getColumnModel().getColumn(0).setMinWidth(75);
		cursos.getColumnModel().getColumn(1).setMaxWidth(315);
		cursos.getColumnModel().getColumn(1).setMinWidth(315);
		cursos.getColumnModel().getColumn(2).setMaxWidth(75);
		cursos.getColumnModel().getColumn(2).setMinWidth(75);

		JScrollPane sp_actividad = new JScrollPane();
		sp_actividad.setBounds(1089, 447, 475, 500);
		sp_actividad.setViewportView(actividades);
		sp_actividad.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_actividad);
		sp_actividad.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		actividades.setRowHeight(75);
		actividades.setShowVerticalLines(false);
		actividades.getColumnModel().getColumn(0).setMaxWidth(75);
		actividades.getColumnModel().getColumn(0).setMinWidth(75);
		actividades.getColumnModel().getColumn(1).setMaxWidth(315);
		actividades.getColumnModel().getColumn(1).setMinWidth(315);
		actividades.getColumnModel().getColumn(2).setMaxWidth(75);
		actividades.getColumnModel().getColumn(2).setMinWidth(75);

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
	
	private void cargarNoticias() {
		datosNoticias = new Object[2][lista_noticias.size()];
		
		int k = 0;
		
		for (MensajeNoticia noticia : lista_noticias) {
			datosNoticias[0][k] = noticia.getTexto();
			datosNoticias[1][k] = noticia.getFecha();
			k++;
		}
		
		String columnHeadersNoticias[] = new String[lista_noticias.size()];
		for (int i = 0; i < lista_noticias.size(); i++) {
			columnHeadersNoticias[i] = "";
		}
		
		noticias = new JTable(datosNoticias, columnHeadersNoticias);
		for (int i = 0; i < noticias.getModel().getColumnCount(); i++) {
			noticias.getColumnModel().getColumn(i).setCellRenderer(new NoticiasRenderer());
		}
		noticias.setTableHeader(null);
		noticias.setCellSelectionEnabled(false);
	}

	private void datosTablaUsuario() {
		
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
		cursos.getColumnModel().getColumn(0).setCellEditor(editorCurso);
		cursos.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		cursos.getColumnModel().getColumn(1).setCellEditor(editorCurso);
		cursos.getColumnModel().getColumn(2).setCellEditor(editorCurso);
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
		actividades.getColumnModel().getColumn(0).setCellEditor(editorActividad);
		actividades.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		actividades.getColumnModel().getColumn(1).setCellEditor(editorActividad);
		actividades.getColumnModel().getColumn(2).setCellEditor(editorActividad);
		actividades.setTableHeader(null);
		actividades.setCellSelectionEnabled(false);
	}

	private void datosTabla() {

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
		cursos.getColumnModel().getColumn(0).setCellEditor(editorCurso);
		cursos.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		cursos.getColumnModel().getColumn(1).setCellEditor(editorCurso);
		cursos.getColumnModel().getColumn(2).setCellEditor(editorCurso);
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
		actividades.getColumnModel().getColumn(0).setCellEditor(editorActividad);
		actividades.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		actividades.getColumnModel().getColumn(1).setCellEditor(editorActividad);
		actividades.getColumnModel().getColumn(2).setCellEditor(editorActividad);
		actividades.setTableHeader(null);
		actividades.setCellSelectionEnabled(false);
	}

	public Curso getCurso() {
		return lista_cursos.get(cursos.getSelectedRow());
	}

	public Actividad getActividad() {
		return lista_actividades.get(actividades.getSelectedRow());
	}
}