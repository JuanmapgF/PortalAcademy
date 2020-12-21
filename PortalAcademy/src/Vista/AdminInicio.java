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
		
		this.setBounds(0, 0, 1080, 650);
		this.setLayout(null);
		
		bCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		bCerrarSesion.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCerrarSesion.setBounds(952, 10, 118, 23);
		bCerrarSesion.setVerticalAlignment(SwingConstants.TOP);
		bCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		 bCursos = new JButton("Cursos");
		bCursos.setVerticalAlignment(SwingConstants.BOTTOM);
		bCursos.setFont(new Font("Calibri", Font.PLAIN, 30));
		bCursos.setBounds(429, 182, 199, 47);
		add(bCursos);
		add(bCerrarSesion);
		
		 bActividades = new JButton("Actividades");
		bActividades.setVerticalAlignment(SwingConstants.BOTTOM);
		bActividades.setFont(new Font("Calibri", Font.PLAIN, 30));
		bActividades.setBounds(429, 277, 199, 47);
		add(bActividades);
		
		 bUsuarios = new JButton("Usuarios");
		bUsuarios.setVerticalAlignment(SwingConstants.BOTTOM);
		bUsuarios.setFont(new Font("Calibri", Font.PLAIN, 30));
		bUsuarios.setBounds(429, 369, 199, 47);
		add(bUsuarios);
		
		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setBounds(429, 627, 222, 13);
		add(lblNewLabel);
		
		 bInicio = new JButton("Inicio");
		bInicio.setForeground(Color.BLUE);
		bInicio.setBounds(10, 85, 104, 21);
		add(bInicio);
		
		 bCursos_1 = new JButton("Cursos");
		bCursos_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCursos_1.setBounds(10, 116, 104, 23);
		add(bCursos_1);
		
		 bActividades_1 = new JButton("Actividades");
		bActividades_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bActividades_1.setBounds(10, 149, 104, 23);
		add(bActividades_1);
		
		 bUsuarios_1 = new JButton("Usuarios");
		bUsuarios_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bUsuarios_1.setBounds(10, 182, 104, 23);
		add(bUsuarios_1);
		
		 bAjustes = new JButton("Ajustes");
		bAjustes.setFont(new Font("Calibri", Font.PLAIN, 12));
		bAjustes.setBounds(10, 215, 104, 21);
		add(bAjustes);
		
		JLabel lblNewLabel_1 = new JLabel("Administrador");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(160, 54, 534, 74);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sesión iniciada como: "+Main.getUser().getNick());
		lblNewLabel_2.setBounds(10, 11, 240, 20);
		add(lblNewLabel_2);
		
		JButton bForos = new JButton("Foros");
		bForos.setVerticalAlignment(SwingConstants.BOTTOM);
		bForos.setFont(new Font("Calibri", Font.PLAIN, 30));
		bForos.setBounds(429, 471, 199, 47);
		add(bForos);

	}
}
