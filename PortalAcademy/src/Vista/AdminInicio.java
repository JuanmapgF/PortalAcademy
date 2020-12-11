package Vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;

public class AdminInicio extends JPanel {

	public JButton bCerrarSesion, bCursos, bActividades, bUsuarios, bInicio, bCursos_1, bActividades_1, bUsuarios_1, bAjustes;
	
	
	/**
	 * Create the panel.
	 */
	public AdminInicio() {
		
		bCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		bCerrarSesion.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCerrarSesion.setBounds(973, 10, 97, 23);
		bCerrarSesion.setVerticalAlignment(SwingConstants.TOP);
		bCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		bCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setLayout(null);
		this.setBounds(0,0,1080,650);
		
		 bCursos = new JButton("Cursos");
		bCursos.setVerticalAlignment(SwingConstants.BOTTOM);
		bCursos.setFont(new Font("Calibri", Font.PLAIN, 30));
		bCursos.setBounds(452, 189, 175, 47);
		add(bCursos);
		add(bCerrarSesion);
		
		 bActividades = new JButton("Actividades");
		bActividades.setVerticalAlignment(SwingConstants.BOTTOM);
		bActividades.setFont(new Font("Calibri", Font.PLAIN, 30));
		bActividades.setBounds(452, 278, 175, 47);
		add(bActividades);
		
		 bUsuarios = new JButton("Usuarios");
		bUsuarios.setVerticalAlignment(SwingConstants.BOTTOM);
		bUsuarios.setFont(new Font("Calibri", Font.PLAIN, 30));
		bUsuarios.setBounds(452, 368, 175, 47);
		add(bUsuarios);
		
		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setBounds(429, 627, 222, 13);
		add(lblNewLabel);
		
		 bInicio = new JButton("Inicio");
		bInicio.setForeground(Color.BLUE);
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
		bUsuarios_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bUsuarios_1.setBounds(10, 182, 91, 23);
		add(bUsuarios_1);
		
		 bAjustes = new JButton("Ajustes");
		bAjustes.setFont(new Font("Calibri", Font.PLAIN, 12));
		bAjustes.setBounds(10, 215, 91, 21);
		add(bAjustes);
		
		JLabel lblNewLabel_1 = new JLabel("Administrador");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(160, 54, 349, 74);
		add(lblNewLabel_1);

	}
}
