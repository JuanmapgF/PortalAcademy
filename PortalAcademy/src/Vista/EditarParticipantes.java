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
		
		this.setBounds(0, 0, 1920, 1080);
		
		addElements(cur.getEstudiantes());
		
		JScrollPane sp_cursos = new JScrollPane();
		sp_cursos.setBounds(591, 275, 465, 500);
		sp_cursos.setViewportView(listaC);
		add(sp_cursos);
		
		JLabel t_curso = new JLabel("Estudiantes:");
		t_curso.setFont(new Font("Tahoma", Font.PLAIN, 30));
		t_curso.setBounds(591, 215, 215, 49);
		add(t_curso);
		
		bEliminar = new JButton("Eliminar usuario");
		bEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bEliminar.setBounds(1165, 424, 191, 40);
		add(bEliminar);
		
		bVolver = new JButton("Volver");
		bVolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bVolver.setBounds(1184, 944, 129, 40);
		add(bVolver);
		
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
