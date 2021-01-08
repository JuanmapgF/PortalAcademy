package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AdminInicio extends JPanel {

	public JButton bCerrarSesion, bCursos, bActividades, bUsuarios, bInicio, bCursos_1, bActividades_1, bUsuarios_1, bAjustes;
	
	
	/**
	 * Create the panel.
	 */
	public AdminInicio() {
		
		this.setBounds(0, 0, 1920, 1080);
		this.setLayout(null);
		
		
		
		
		 bCursos = new JButton("Cursos");
		bCursos.setVerticalAlignment(SwingConstants.BOTTOM);
		bCursos.setFont(new Font("Calibri", Font.PLAIN, 30));
		bCursos.setBounds(764, 229, 199, 47);
		add(bCursos);
		add(bCerrarSesion);
		
		 bActividades = new JButton("Actividades");
		bActividades.setVerticalAlignment(SwingConstants.BOTTOM);
		bActividades.setFont(new Font("Calibri", Font.PLAIN, 30));
		bActividades.setBounds(764, 324, 199, 47);
		add(bActividades);
		
		 bUsuarios = new JButton("Usuarios");
		bUsuarios.setVerticalAlignment(SwingConstants.BOTTOM);
		bUsuarios.setFont(new Font("Calibri", Font.PLAIN, 30));
		bUsuarios.setBounds(764, 416, 199, 47);
		add(bUsuarios);
		
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
		bInicio.setForeground(Color.BLUE);
		bInicio.setBounds(64, 246, 143, 40);
		add(bInicio);

		bCursos_1 = new JButton("Cursos");
		bCursos_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		
		JLabel lblNewLabel_1 = new JLabel("Administrador");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(735, 105, 534, 74);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);
		
		JButton bForos = new JButton("Foros");
		bForos.setVerticalAlignment(SwingConstants.BOTTOM);
		bForos.setFont(new Font("Calibri", Font.PLAIN, 30));
		bForos.setBounds(764, 518, 199, 47);
		add(bForos);

	}
}
