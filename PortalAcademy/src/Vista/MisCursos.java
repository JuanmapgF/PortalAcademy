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
	
	private JButton explorar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;
	
	
	
	public MisCursos(Estudiante u) {
		this.setLayout(null);
		addElements(u.getCursos());
		
		JScrollPane sp_cursos = new JScrollPane();
		sp_cursos.setBounds(441, 75, 346, 346);
		sp_cursos.setViewportView(listaC);
		add(sp_cursos);
		
		JLabel t_curso = new JLabel("Mis cursos:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_curso.setBounds(530, 31, 161, 33);
		add(t_curso);
		
		this.setBounds(0, 0, 1080, 650);
		
		JButton bVer = new JButton("Ver curso");
		bVer.setBounds(562, 475, 89, 23);
		add(bVer);
		
		explorar = new JButton("Explorar");
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
	}
	
	public MisCursos(Profesor u) {
		this.setLayout(null);
		addElements(u.getCursos());
		
		JScrollPane sp_cursos2 = new JScrollPane();
		sp_cursos2.setBounds(441, 75, 346, 346);
		sp_cursos2.setViewportView(listaC);
		add(sp_cursos2);
		
		JLabel t_curso2 = new JLabel("Mis cursos:");
		t_curso2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_curso2.setBounds(530, 31, 161, 33);
		add(t_curso2);
		
		this.setBounds(0, 0, 1080, 650);
		
		JButton bVer2 = new JButton("Ver curso");
		bVer2.setBounds(562, 475, 89, 23);
		add(bVer2);
		
		explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
		
		cursos = new JButton("Mis cursos");
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);
		
		ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 336, 131, 32);
		add(ajustes);
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
}
