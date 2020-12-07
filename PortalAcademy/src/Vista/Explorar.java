package Vista;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Modelo.Actividad;
import Modelo.Curso;

public class Explorar extends JPanel {
	
	private JLabel titulo = new JLabel("Explorar");
	private JButton iniciarSesion = new JButton("Iniciar sesión");
	private JButton cerrarSesion = new JButton("Cerrar sesión");
	private List<Curso> cursos;
	private List<Actividad> actividades;
	private JScrollPane scroll1 = new JScrollPane();
	private JScrollPane scroll2 = new JScrollPane();
	private JList listaC = new JList();
	private JList listaA = new JList();
	private DefaultListModel modeloC = new DefaultListModel();
	private DefaultListModel modeloA = new DefaultListModel();
	private JLabel curso = new JLabel("Cursos");
	private JLabel actividad = new JLabel("Actividades");
	
	public Explorar(List<Curso> c, List<Actividad> a) {
		cursos = c;
		actividades = a;
		
		listaC.setModel(modeloC);
		listaA.setModel(modeloA);
		
		addElements();
		
		addScroll();
		
		JPanel title = new JPanel();
		title.setLayout(new BorderLayout());
		title.add(titulo, BorderLayout.CENTER);
		title.add(iniciarSesion, BorderLayout.EAST);
		title.add(cerrarSesion, BorderLayout.EAST);
		
		JPanel explorar = new JPanel();
		explorar.setLayout(new BorderLayout());
		
		JPanel oeste = new JPanel();
		oeste.setLayout(new BorderLayout());
		oeste.add(curso, BorderLayout.NORTH);
		oeste.add(scroll1, BorderLayout.SOUTH);
		
		JPanel este = new JPanel();
		este.setLayout(new BorderLayout());
		este.add(actividad, BorderLayout.NORTH);
		oeste.add(scroll2, BorderLayout.SOUTH);
		
		explorar.add(oeste, BorderLayout.WEST);
		explorar.add(este, BorderLayout.EAST);
		
		JPanel res = new JPanel();
		res.setLayout(new BorderLayout());
		res.add(title, BorderLayout.NORTH);
		res.add(explorar, BorderLayout.SOUTH);
		
		this.add(res);
	}
	
	public void setSize(int width, int height) {
		this.setBounds(0, 0, width, height);
	}
	
	public void addElements() {
		for (Curso c : cursos) {
			modeloC.addElement(c.toString());;
		}
		
		for (Actividad a : actividades) {
			modeloA.addElement(a.toString());
		}
	}
	
	public void addScroll() {
		scroll1.add(listaC);
		listaC.setLayoutOrientation(JList.VERTICAL);
		
		scroll2.add(listaA);
		listaA.setLayoutOrientation(JList.VERTICAL);
	}

}