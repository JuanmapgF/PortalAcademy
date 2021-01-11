package Vista;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Modelo.Curso;

@SuppressWarnings("serial")
public class AdminCursos extends JPanel {

	public JButton bCerrarSesion, bInicio, bCursos_1, bActividades_1, bUsuarios_1, bAjustes, bEliminar;

	private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	private JList<String> listA = new JList<String>();
	private List<Curso> lista_cursos;

	/**
	 * Create the panel.
	 */
	public AdminCursos() {

		// para mostrar la lista de Cursos en el scrollpanel
		listA.setModel(modeloA);
		lista_cursos = Curso.getTodosLosCursos();
		for (Curso c : lista_cursos) {
			modeloA.addElement(c.toString());
		}
		listA.setLayoutOrientation(JList.VERTICAL);
		// --------------------------------------------------------

		setLayout(null);
		this.setBounds(0, 0, 1920, 1080);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(726, 812, 466, 40);
		add(lblNewLabel);

		bCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		bCerrarSesion.setVerticalAlignment(SwingConstants.TOP);
		bCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bCerrarSesion.setBounds(1647, 58, 202, 48);
		add(bCerrarSesion);

		bInicio = new JButton("Inicio");
		bInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bInicio.setBounds(64, 246, 143, 40);
		add(bInicio);

		bCursos_1 = new JButton("Cursos");
		bCursos_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bCursos_1.setForeground(Color.BLUE);
		bCursos_1.setBounds(64, 339, 143, 40);
		add(bCursos_1);

		bActividades_1 = new JButton("Actividades");
		bActividades_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bActividades_1.setBounds(64, 431, 143, 40);
		add(bActividades_1);

		bUsuarios_1 = new JButton("Usuarios");
		bUsuarios_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bUsuarios_1.setBounds(64, 525, 143, 40);
		add(bUsuarios_1);

		bAjustes = new JButton("Ajustes");
		bAjustes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bAjustes.setBounds(64, 627, 143, 40);
		add(bAjustes);

		JLabel lblNewLabel_1 = new JLabel("Cursos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(892, 190, 211, 74);
		add(lblNewLabel_1);

		JScrollPane spCursos = new JScrollPane();
		spCursos.setBounds(600, 300, 700, 400);
		spCursos.setViewportView(listA);
		add(spCursos);

		bEliminar = new JButton("ELIMINAR");
		bEliminar.setFont(new Font("Tahoma", Font.BOLD, 20));
		bEliminar.setForeground(Color.RED);
		bEliminar.setBounds(1451, 454, 143, 74);
		add(bEliminar);

		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: " + Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);
	}

	public Curso getCurso() {
		if (listA.isSelectionEmpty()) {
			return null;
		} else {
			return lista_cursos.get(listA.getSelectedIndex());
		}
	}
}
