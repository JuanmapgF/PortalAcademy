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
import Modelo.Profesor;
import Modelo.Usuario;

public class EditarParticipantes extends JPanel {

	private DefaultListModel<String> modeloC = new DefaultListModel<String>();
	private JList<String> listaC = new JList<String>();
	private JButton bEliminar = new JButton();
	private JButton bVolver = new JButton();
	private List<Usuario> l;
	private Profesor prof;
	private Curso curso;
	
	
	public EditarParticipantes(Curso cur, Profesor p) {
		this.curso = cur;
		this.prof = p;
		this.setLayout(null);
		addElements(cur.getEstudiantes());
		
		JScrollPane sp_cursos = new JScrollPane();
		sp_cursos.setBounds(441, 175, 346, 346);
		sp_cursos.setViewportView(listaC);
		add(sp_cursos);
		
		JLabel t_curso = new JLabel("Estudiantes:");
		t_curso.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		t_curso.setBounds(536, 115, 161, 33);
		add(t_curso);
		
		bEliminar = new JButton("Eliminar usuario");
		bEliminar.setBounds(860, 551, 121, 23);
		add(bEliminar);
		
		bVolver = new JButton("Volver");
		bVolver.setBounds(250, 551, 121, 23);
		add(bVolver);
		
		this.setBounds(0, 0, 1080, 650);
		
		CtrMenu menu = new CtrMenu(new Menu(p));
		add(menu.getPanel());
	}
	
	public void addElements(List<Usuario> l) {
		this.l = l;
		listaC.setModel(modeloC);

		for (Object o : l) {
			modeloC.addElement(o.toString());
		}

		listaC.setLayoutOrientation(JList.VERTICAL);
	}
	
	public Profesor getProfesor() {
		return prof;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public Usuario getUsuario() {
		if (!listaC.isSelectionEmpty()) {
			return l.get(listaC.getSelectedIndex());
		} else {
			return null;
		}
	}
	
	public void controlador(ActionListener ctr) {
		bEliminar.addActionListener(ctr);
		bEliminar.setActionCommand("ELIMINAR");
		
		bVolver.addActionListener(ctr);
		bVolver.setActionCommand("VOLVER");
	}
}
