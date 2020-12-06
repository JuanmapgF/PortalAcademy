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

public class ExplorarEstudiante extends JPanel {
	
	private String titulo;
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
	
	public ExplorarEstudiante(List<Curso> c, List<Actividad> a) {
		cursos = c;
		actividades = a;
		
		listaC.setModel(modeloC);
		listaA.setModel(modeloA);
		
		addElements();
		
		
		
		JPanel oeste = new JPanel();
		oeste.setLayout(new BorderLayout());
		oeste.add(curso, BorderLayout.NORTH);
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

}