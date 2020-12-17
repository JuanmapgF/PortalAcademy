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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Modelo.Usuario;

@SuppressWarnings("serial")
public class AdminUsuarios extends JPanel {
	private JTextField txtBuscarUsuario;

	public JButton bCerrarSesion, bInicio, bCursos_1, bActividades_1, bUsuarios_1, bAjustes, bEliminar;
	
	private DefaultListModel<String> modeloA = new DefaultListModel<String>();
	private JList<String> listA = new JList<String>();
	private List<Usuario> lista_usuarios;
	/**
	 * Create the panel.
	 */
	public AdminUsuarios() {
		
		//para mostrar la lista de Usuarios en el scrollpanel
		listA.setModel(modeloA);
		for (Usuario u : Usuario.getUsuarios()) {
			modeloA.addElement(u.toString());
		}
		listA.setLayoutOrientation(JList.VERTICAL);
		//------------------------------------------------------		
		
		
		setLayout(null);
		this.setBounds(0, 0, 1080, 650);
		
		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setBounds(429, 627, 222, 13);
		add(lblNewLabel);
		
		 bCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		bCerrarSesion.setVerticalAlignment(SwingConstants.TOP);
		bCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		bCerrarSesion.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCerrarSesion.setBounds(973, 10, 97, 23);
		add(bCerrarSesion);
		
		 bInicio = new JButton("Inicio");
		bInicio.setBounds(10, 85, 91, 21);
		add(bInicio);
		
		 bCursos_1 = new JButton("Cursos");
		bCursos_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCursos_1.setBounds(10, 116, 91, 23);
		add(bCursos_1);
		
		 bActividades_1 = new JButton("Actividades");
		bActividades_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bActividades_1.setBounds(10, 149, 91, 23);
		add(bActividades_1);
		
		 bUsuarios_1 = new JButton("Usuarios");
		bUsuarios_1.setForeground(Color.BLUE);
		bUsuarios_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bUsuarios_1.setBounds(10, 182, 91, 23);
		add(bUsuarios_1);
		
		 bAjustes = new JButton("Ajustes");
		bAjustes.setFont(new Font("Calibri", Font.PLAIN, 12));
		bAjustes.setBounds(10, 214, 91, 21);
		add(bAjustes);
		
		txtBuscarUsuario = new JTextField();
		txtBuscarUsuario.setForeground(Color.LIGHT_GRAY);
		txtBuscarUsuario.setFont(new Font("Calibri", Font.PLAIN, 10));
		txtBuscarUsuario.setText("Buscar usuario");
		txtBuscarUsuario.setBounds(190, 148, 370, 25);
		add(txtBuscarUsuario);
		txtBuscarUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuarios");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(160, 54, 211, 74);
		add(lblNewLabel_1);
		
		JScrollPane spUsuarios = new JScrollPane();
		spUsuarios.setBounds(190, 195, 700, 400);
		spUsuarios.setViewportView(listA);
		add(spUsuarios);
		
		 bEliminar = new JButton("ELIMINAR");
		bEliminar.setFont(new Font("Tahoma", Font.BOLD, 10));
		bEliminar.setForeground(Color.RED);
		bEliminar.setBounds(944, 330, 85, 74);
		add(bEliminar);
	}
	
	public Usuario getUsuario() {
		if (listA.isSelectionEmpty()) {
			return null;
		} else {
			return lista_usuarios.get(listA.getSelectedIndex());
		}
	}
}
