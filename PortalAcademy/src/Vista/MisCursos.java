package Vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Profesor;

import javax.swing.JList;
import javax.swing.JLabel;

public class MisCursos extends JPanel {

	private DefaultListModel<String> modeloC = new DefaultListModel<String>();
	private JList<String> listaC = new JList<String>();
	private JButton bVer = new JButton();
	private JButton bVer2 = new JButton();
	private List<Curso> l;
	
	public MisCursos(Estudiante u) {
		this.setLayout(null);
		addElements(u.getCursos());
		
		JScrollPane sp_cursos = new JScrollPane();
		sp_cursos.setBounds(241, 75, 346, 346);
		sp_cursos.setViewportView(listaC);
		add(sp_cursos);
		
		JLabel t_curso = new JLabel("Mis cursos:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_curso.setBounds(330, 31, 161, 33);
		add(t_curso);
		
		this.setBounds(200, 0, 880, 650);
		
		JButton bVer = new JButton("Ver curso");
		bVer.setBounds(362, 475, 89, 23);
		add(bVer);
	}
	
	public MisCursos(Profesor u) {
		this.setLayout(null);
		addElements(u.getCursos());
		
		JScrollPane sp_cursos2 = new JScrollPane();
		sp_cursos2.setBounds(241, 75, 346, 346);
		sp_cursos2.setViewportView(listaC);
		add(sp_cursos2);
		
		JLabel t_curso2 = new JLabel("Mis cursos:");
		t_curso2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_curso2.setBounds(330, 31, 161, 33);
		add(t_curso2);
		
		this.setBounds(200, 0, 880, 650);
		
		JButton bVer2 = new JButton("Ver curso");
		bVer2.setBounds(362, 475, 89, 23);
		add(bVer2);
	}
	
	
	public void addElements(List<Curso> l) {
		this.l = l;
		listaC.setModel(modeloC);
		
		for (Object o : l) {
			modeloC.addElement(o.toString());
		}
		
		listaC.setLayoutOrientation(JList.VERTICAL);
	}
	
	public Curso getC(){
		if(!listaC.isSelectionEmpty()) {
			return l.get(listaC.getSelectedIndex());
		}else {
			return null;
		}
	}
	
	public void controlador(ActionListener ctr) {
		bVer.addActionListener(ctr);
		bVer.setActionCommand("MISCURSOSUSUARIO");
		
		bVer2.addActionListener(ctr);
		bVer2.setActionCommand("MISCURSOSPROFESOR");
	}
}
