package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;

public class AdminUsuarios extends JPanel {
	private JTable table;
	private JTextField txtBuscarUsuario;

	public JButton bCerrarSesion, bInicio, bCursos_1, bActividades_1, bUsuarios_1, bAjustes;
	/**
	 * Create the panel.
	 */
	public AdminUsuarios() {
		setLayout(null);
		this.setBounds(0, 0, 1080, 650);
		
		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setBounds(429, 627, 222, 13);
		add(lblNewLabel);
		
		JButton bCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		bCerrarSesion.setVerticalAlignment(SwingConstants.TOP);
		bCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		bCerrarSesion.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCerrarSesion.setBounds(973, 10, 97, 23);
		add(bCerrarSesion);
		
		JButton bInicio = new JButton("Inicio");
		bInicio.setBounds(10, 85, 91, 21);
		add(bInicio);
		
		JButton bCursos_1 = new JButton("Cursos");
		bCursos_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCursos_1.setBounds(10, 116, 91, 23);
		add(bCursos_1);
		
		JButton bActividades_1 = new JButton("Actividades");
		bActividades_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bActividades_1.setBounds(10, 149, 91, 23);
		add(bActividades_1);
		
		JButton bUsuarios_1 = new JButton("Usuarios");
		bUsuarios_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bUsuarios_1.setBounds(10, 182, 91, 23);
		add(bUsuarios_1);
		
		JButton bAjustes = new JButton("Ajustes");
		bAjustes.setFont(new Font("Calibri", Font.PLAIN, 12));
		bAjustes.setBounds(10, 214, 91, 21);
		add(bAjustes);
		
		table = new JTable();
		table.setBounds(266, 215, 548, 340);
		add(table);
		
		txtBuscarUsuario = new JTextField();
		txtBuscarUsuario.setForeground(Color.LIGHT_GRAY);
		txtBuscarUsuario.setFont(new Font("Calibri", Font.PLAIN, 10));
		txtBuscarUsuario.setText("Buscar usuario");
		txtBuscarUsuario.setBounds(266, 169, 370, 25);
		add(txtBuscarUsuario);
		txtBuscarUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuarios");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(160, 54, 211, 74);
		add(lblNewLabel_1);
	}
}