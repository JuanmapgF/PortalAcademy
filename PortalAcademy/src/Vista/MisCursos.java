package Vista;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controlador.CtrMenu;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;

@SuppressWarnings("serial")
public class MisCursos extends JPanel {

	private DefaultListModel<String> modeloC = new DefaultListModel<String>();
	private DefaultListModel<String> modeloCA = new DefaultListModel<String>();
	private JList<String> listaC = new JList<String>();
	private JList<String> listaCA = new JList<String>();
	private JButton bVer = new JButton();
	private JButton bVer2 = new JButton();
	private List<Curso> l;
	private List<Curso> l1;

	private Estudiante est = null;
	private Organizacion org = null;
	private Profesor prof = null;
	private boolean estudiante = false;
	private boolean organizacion = false;
	private boolean profesor = false;

	private JButton crearCurso;

	
	public MisCursos(Estudiante u) {
		estudiante = true;
		est = u;
		this.setLayout(null);
		u.setListaCursos();
		addElements(u.getListaCursos());

		JScrollPane sp_cursos = new JScrollPane();
		sp_cursos.setBounds(591, 275, 465, 500);
		sp_cursos.setViewportView(listaC);
		add(sp_cursos);

		JLabel t_curso = new JLabel("Mis cursos");
		t_curso.setFont(new Font("Tahoma", Font.PLAIN, 40));
		t_curso.setBounds(758, 122, 213, 56);
		add(t_curso);

		this.setBounds(0, 0, 1920, 1080);

		bVer = new JButton("Ver curso");
		bVer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bVer.setBounds(771, 914, 129, 40);
		add(bVer);

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
		
		addElements(u.getCursosImpartidos());
		addElements2(u.getCursosApuntados());

		crearCurso = new JButton("Crear curso");
		crearCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crearCurso.setBounds(1599, 400, 171, 40);
		add(crearCurso);

		JScrollPane sp_cursosImpartidos = new JScrollPane();
		sp_cursosImpartidos.setBounds(1041, 400, 400, 546);
		sp_cursosImpartidos.setViewportView(listaC);
		add(sp_cursosImpartidos);

		JScrollPane sp_cursosApuntados = new JScrollPane();
		sp_cursosApuntados.setBounds(441, 400, 400, 546);
		sp_cursosApuntados.setViewportView(listaCA);
		add(sp_cursosApuntados);

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
		
		

		bVer = new JButton("Ver curso");
		bVer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bVer.setBounds(1180, 996, 129, 40);
		add(bVer);

		bVer2 = new JButton("Ver curso");
		bVer2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bVer2.setBounds(568, 996, 129, 40);
		add(bVer2);

		CtrMenu menu = new CtrMenu(new Menu(u));
		add(menu.getPanel());

	}

	public void addElements(List<Curso> l) {
		this.l = l;
		listaC.setModel(modeloC);

		for (Object o : l) {
			modeloC.addElement(o.toString());
		}

		listaC.setLayoutOrientation(JList.VERTICAL);
	}

	public void addElements2(List<Curso> l) {
		this.l1 = l;
		listaCA.setModel(modeloCA);

		for (Object o : l1) {
			modeloCA.addElement(o.toString());
		}

		listaCA.setLayoutOrientation(JList.VERTICAL);
	}

	public Curso getC() {
		if (!listaC.isSelectionEmpty()) {
			return l.get(listaC.getSelectedIndex());
		} else {
			return null;
		}
	}

	public Curso getCA() {
		if (!listaCA.isSelectionEmpty()) {
			return l1.get(listaCA.getSelectedIndex());
		} else {
			return null;
		}
	}

	public void controlador(ActionListener ctr) {
		bVer.addActionListener(ctr);
		bVer.setActionCommand("VERCURSO");
		
		if(crearCurso!=null) {
			crearCurso.addActionListener(ctr);
			crearCurso.setActionCommand("CREARCURSO");
		}
		bVer2.addActionListener(ctr);
		bVer2.setActionCommand("VERCURSOA");

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
