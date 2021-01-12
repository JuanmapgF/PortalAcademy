package Vista;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controlador.CtrMenu;
import Controlador.CtrMenuCurso;
import Modelo.BD;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Test;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class InformacionCursoCuestionarios extends JPanel {

	public JButton bHacerCuestionario, bCrear, bBorrar, bCrearTest, bHacerTest;

	private DefaultListModel<String> modeloC = new DefaultListModel<String>();
	private JList<String> listaC = new JList<String>();
	private List<Test> l;
	private List<Object> lista_test = null;
	private Object[][] datos = null;

	private static BD bd;

	private Curso curso;

	/**
	 * Create the panel.
	 */
	public InformacionCursoCuestionarios(Usuario user, Curso curso) {
		this.curso = curso;

		this.curso = curso;

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);

		addElements(Test.getTodosLosTests(curso.getId()));
		
		JLabel labelTest = new JLabel("Tests de conocimiento");
		labelTest.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelTest.setBounds(647, 365, 368, 46);
		add(labelTest);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(647, 421, 616, 327);
		listaC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(listaC);
		add(scrollPane);

		if(esCreador() || curso.getSatisfaccion()) {
			JLabel labelCuestionario = new JLabel("Cuestionario de satisfacci\u00F3n");
			labelCuestionario.setFont(new Font("Tahoma", Font.BOLD, 30));
			labelCuestionario.setBounds(647, 776, 435, 52);
			add(labelCuestionario);
		}
		
		
		
		if(curso.getSatisfaccion() && !esCreador()) {
			bHacerCuestionario = new JButton(new ImageIcon(getClass().getResource("/img/hacer.png")));
			bHacerCuestionario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			bHacerCuestionario.setContentAreaFilled(false);
			bHacerCuestionario.setFocusPainted(false);
			bHacerCuestionario.setBorderPainted(false);
			bHacerCuestionario.setBounds(1156, 776, 142, 52);
			add(bHacerCuestionario);
		}
		
		if(!esCreador()) {
			bHacerTest = new JButton(new ImageIcon(getClass().getResource("/img/hacerTest.png")));
			bHacerTest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			bHacerTest.setContentAreaFilled(false);
			bHacerTest.setFocusPainted(false);
			bHacerTest.setBorderPainted(false);
			bHacerTest.setBounds(1402, 521, 142, 52);
			add(bHacerTest);
		}
		
		
		if(!curso.getSatisfaccion()) {
			bCrear = new JButton(new ImageIcon(getClass().getResource("/img/crear.png")));
			bCrear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			bCrear.setContentAreaFilled(false);
			bCrear.setFocusPainted(false);
			bCrear.setBorderPainted(false);
			bCrear.setBounds(1156, 776, 142, 52);
			add(bCrear);
		
		}else {
			bBorrar = new JButton(new ImageIcon(getClass().getResource("/img/borrar.png")));
			bBorrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			bBorrar.setContentAreaFilled(false);
			bBorrar.setFocusPainted(false);
			bBorrar.setBorderPainted(false);
			bBorrar.setBounds(1156, 776, 142, 52);
			add(bBorrar);
		}
		
		if(esCreador()) {
			bCrearTest = new JButton(new ImageIcon(getClass().getResource("/img/crearTest.png")));
			bCrearTest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			bCrearTest.setContentAreaFilled(false);
			bCrearTest.setFocusPainted(false);
			bCrearTest.setBorderPainted(false);
			bCrearTest.setBounds(1402, 423, 142, 52);
			add(bCrearTest);
			
		}

		
		if (user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor) user, curso));
			add(menu.getPanel());
		} else if (user instanceof Organizacion) {
			CtrMenu menu = new CtrMenu(new Menu((Organizacion) user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante) user, curso));
			add(menu.getPanel());
		}

		CtrMenuCurso menuc = new CtrMenuCurso(new MenuCurso(curso));
		add(menuc.getPanel());

	}

	public void addElements(List<Test> l) {
		this.l = l;
		listaC.setModel(modeloC);

		for (Object o : l) {
			modeloC.addElement(o.toString());
		}

		listaC.setLayoutOrientation(JList.VERTICAL);
	}

	public Test getTest() {
		if (!listaC.isSelectionEmpty()) {
			return l.get(listaC.getSelectedIndex());
		} else {
			return null;
		}
	}
	
	private boolean esCreador() {
		if (Main.getUser() == null) {
			return false;
		}
		return Main.getUser().equals(curso.getProfesor());
	}

	public void controlador(ActionListener ctr) {
		if(bCrearTest != null) {
			this.bCrearTest.addActionListener(ctr);
			this.bCrearTest.setActionCommand("CREARTEST");
		}
		
		if(bBorrar != null) {
			this.bBorrar.addActionListener(ctr);
			this.bBorrar.setActionCommand("BORRAR");
		}
		
		if(bCrear != null) {
			this.bCrear.addActionListener(ctr);
			this.bCrear.setActionCommand("CREAR");
		}
		
		if(bHacerCuestionario != null) {
			this.bHacerCuestionario.addActionListener(ctr);
			this.bHacerCuestionario.setActionCommand("HACER");
		}
		
		if(bHacerTest != null) {
			this.bHacerTest.addActionListener(ctr);
			this.bHacerTest.setActionCommand("HACERTEST");
		}
	}
}
