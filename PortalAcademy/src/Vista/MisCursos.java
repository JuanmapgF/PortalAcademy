package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;

import Controlador.CtrMenu;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;

@SuppressWarnings("serial")
public class MisCursos extends JPanel {

	private JTable cursos;
	private ButtonEditorCurso editorCurso = new ButtonEditorCurso(new JTextField());
	
	private JTable impartidos;
	private ButtonEditorCurso editorImpartidos = new ButtonEditorCurso(new JTextField());

	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;

	private JButton crearCurso;
	
	private List<Curso> lista_cursos = null;
	private Object[][] datos = null;
	
	private List<Curso> lista_impartidos = null;
	private Object[][] propios = null;
	
	public MisCursos(Estudiante u) {
		estudiante = true;
		est = u;
		this.setLayout(null);
		u.setListaCursos();
		lista_cursos = u.getListaCursos();
		
		datosTablaEstudiante();

		JLabel t_curso = new JLabel("Mis cursos");
		t_curso.setFont(new Font("Tahoma", Font.PLAIN, 40));
		t_curso.setBounds(758, 122, 213, 56);
		add(t_curso);
		
		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(591, 275, 465, 500);
		sp_curso.setViewportView(cursos);
		sp_curso.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_curso);
		sp_curso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		cursos.setRowHeight(75);
		cursos.setShowVerticalLines(false);
		cursos.getColumnModel().getColumn(0).setMaxWidth(75);
		cursos.getColumnModel().getColumn(0).setMinWidth(75);
//		cursos.getColumnModel().getColumn(1).setMaxWidth(315);
//		cursos.getColumnModel().getColumn(1).setMinWidth(315);

		this.setBounds(0, 0, 1920, 1080);

		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());
	}

	
	/**
	 * @wbp.parser.constructor
	 */
	public MisCursos(Profesor u) {
		profesor = true;
		prof = u;
		this.setLayout(null);
		
		this.setBounds(0, 0, 1920, 1080);
		lista_cursos = u.getCursosApuntados();
		lista_impartidos = u.getCursosImpartidos();
		
		datosTablaProfesor();

		crearCurso = new JButton("Crear curso");
		crearCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crearCurso.setBounds(1599, 400, 171, 40);
		add(crearCurso);

		JScrollPane sp_curso = new JScrollPane();
		sp_curso.setBounds(441, 400, 400, 546);
		sp_curso.setViewportView(cursos);
		sp_curso.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_curso);
		sp_curso.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		cursos.setRowHeight(75);
		cursos.setShowVerticalLines(false);
		cursos.getColumnModel().getColumn(0).setMaxWidth(75);
		cursos.getColumnModel().getColumn(0).setMinWidth(75);
//		cursos.getColumnModel().getColumn(1).setMaxWidth(315);
//		cursos.getColumnModel().getColumn(1).setMinWidth(315);
		
		JScrollPane sp_curso1 = new JScrollPane();
		sp_curso1.setBounds(1041, 400, 400, 546);
		sp_curso1.setViewportView(impartidos);
		sp_curso1.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp_curso1);
		sp_curso1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		impartidos.setRowHeight(75);
		impartidos.setShowVerticalLines(false);
		cursos.getColumnModel().getColumn(0).setMaxWidth(75);
		cursos.getColumnModel().getColumn(0).setMinWidth(75);
//		cursos.getColumnModel().getColumn(1).setMaxWidth(315);
//		cursos.getColumnModel().getColumn(1).setMinWidth(315);

		JLabel t_curso2 = new JLabel("Mis cursos");
		t_curso2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		t_curso2.setBounds(837, 124, 213, 56);
		add(t_curso2);

		JLabel t_curso3 = new JLabel("Cursos apuntados:");
		t_curso3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		t_curso3.setBounds(441, 356, 266, 33);
		add(t_curso3);
		
		JLabel t_curso4 = new JLabel("Cursos impartidos:");
		t_curso4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		t_curso4.setBounds(1041, 356, 256, 33);
		add(t_curso4);

		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());

	}
	
	public void datosTablaEstudiante() {
		datos = new Object[lista_cursos.size()][2];
		
		int k = 0;
		for (Curso c : lista_cursos) {
			datos[k][0] = c.getImagen();
			datos[k][1] = c.getNombre();
			k++;
		}
		
		String[] columnHeadersCurso = {"Imagen", "Curso"};
		
		cursos = new JTable(datos, columnHeadersCurso);
		cursos.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(true));
		cursos.getColumnModel().getColumn(1).setCellEditor(editorCurso);
		cursos.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		cursos.getColumnModel().getColumn(1).setCellEditor(editorCurso);
		cursos.setTableHeader(null);
		cursos.setCellSelectionEnabled(false);
	}
	
	public void datosTablaProfesor() {
		datos = new Object[lista_cursos.size()][2];
		
		int k = 0;
		for (Curso c : lista_cursos) {
			datos[k][0] = c.getImagen();
			datos[k][1] = c.getNombre();
			k++;
		}
		
		String[] columnHeadersCurso = {"Imagen", "Curso"};
		
		cursos = new JTable(datos, columnHeadersCurso);
		cursos.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(true));
		cursos.getColumnModel().getColumn(1).setCellEditor(editorCurso);
		cursos.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		cursos.setTableHeader(null);
		cursos.setCellSelectionEnabled(false);
		
		propios = new Object[lista_impartidos.size()][2];
		
		k = 0;
		for (Curso c : lista_impartidos) {
			propios[k][0] = c.getImagen();
			propios[k][1] = c.getNombre();
			k++;
		}
		
		impartidos = new JTable(propios, columnHeadersCurso);
		impartidos.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(true));
		impartidos.getColumnModel().getColumn(1).setCellEditor(editorImpartidos);
		impartidos.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
		impartidos.getColumnModel().getColumn(0).setCellEditor(editorImpartidos);
		impartidos.setTableHeader(null);
		impartidos.setCellSelectionEnabled(false);
	}
	
	public Curso getCurso() {
		return lista_cursos.get(cursos.getSelectedRow());
	}
	
	public Curso getCursoProfesor() {
		return lista_impartidos.get(impartidos.getSelectedRow());
	}

	public void controlador(ActionListener ctr) {
		editorCurso.controladorMisCursos(ctr);		
		if(crearCurso!=null) {
			crearCurso.addActionListener(ctr);
			crearCurso.setActionCommand("CREARCURSO");
		}
		editorImpartidos.controladorMisCursosProfesor(ctr);
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
