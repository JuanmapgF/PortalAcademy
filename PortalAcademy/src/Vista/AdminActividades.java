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

import Modelo.Actividad;

@SuppressWarnings("serial")
public class AdminActividades extends JPanel {

	public JButton bCerrarSesion, bInicio, bCursos_1, bActividades_1, bUsuarios_1, bAjustes, bEliminar;

	private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	private JList<String> listA = new JList<String>();
	private List<Actividad> lista_actividades;

	/**
	 * Create the panel.
	 */
	public AdminActividades() {

		// para mostrar la lista de actividades en el scrollpanel
		listA.setModel(modeloA);
		lista_actividades = Actividad.getTodasLasActividades();
		for (Actividad d : lista_actividades) {
			modeloA.addElement(d.toString());
		}
		listA.setLayoutOrientation(JList.VERTICAL);
		// --------------------------------------------------------

		setLayout(null);
		this.setBounds(0, 0, 1080, 650);

		bInicio = new JButton("Inicio");
		bInicio.setBounds(10, 85, 106, 21);
		add(bInicio);

		bCursos_1 = new JButton("Cursos");
		bCursos_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCursos_1.setBounds(10, 116, 106, 23);
		add(bCursos_1);

		bActividades_1 = new JButton("Actividades");
		bActividades_1.setForeground(Color.BLUE);
		bActividades_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bActividades_1.setBounds(10, 149, 106, 23);
		add(bActividades_1);

		bUsuarios_1 = new JButton("Usuarios");
		bUsuarios_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bUsuarios_1.setBounds(10, 182, 106, 23);
		add(bUsuarios_1);

		bAjustes = new JButton("Ajustes");
		bAjustes.setFont(new Font("Calibri", Font.PLAIN, 12));
		bAjustes.setBounds(10, 215, 106, 21);
		add(bAjustes);

		bCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		bCerrarSesion.setVerticalAlignment(SwingConstants.TOP);
		bCerrarSesion.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCerrarSesion.setBounds(944, 10, 126, 23);
		add(bCerrarSesion);

		JLabel lblNewLabel_1 = new JLabel("Actividades");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(160, 54, 349, 74);
		add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setBounds(429, 627, 222, 13);
		add(lblNewLabel);

		JScrollPane spActivadades = new JScrollPane();
		spActivadades.setBounds(190, 195, 700, 400);
		spActivadades.setViewportView(listA);
		add(spActivadades);

		bEliminar = new JButton("ELIMINAR");
		bEliminar.setFont(new Font("Tahoma", Font.BOLD, 10));
		bEliminar.setForeground(Color.RED);
		bEliminar.setBounds(944, 330, 97, 74);
		add(bEliminar);

		JLabel lblNewLabel_2 = new JLabel("Sesi�n iniciada como: " + Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);

	}

	public Actividad getActividad() {
		if (listA.isSelectionEmpty()) {
			return null;
		} else {
			return lista_actividades.get(listA.getSelectedIndex());
		}
	}
}
