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

public class adminInicio extends JPanel {

	public JButton bCerrarSesion, bCursos, bActividades, bUsuarios, bInicio, bCursos_1, bActividades_1, bUsuarios_1, bAjustes;
	
	
	/**
	 * Create the panel.
	 */
	public adminInicio() {
		
		JButton bCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		bCerrarSesion.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCerrarSesion.setBounds(903, 10, 97, 23);
		bCerrarSesion.setVerticalAlignment(SwingConstants.TOP);
		bCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		bCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setLayout(null);
		
		JButton bCursos = new JButton("Cursos");
		bCursos.setFont(new Font("Calibri", Font.PLAIN, 30));
		bCursos.setBounds(426, 189, 175, 47);
		add(bCursos);
		add(bCerrarSesion);
		
		JButton bActividades = new JButton("Actividades");
		bActividades.setVerticalAlignment(SwingConstants.BOTTOM);
		bActividades.setFont(new Font("Calibri", Font.PLAIN, 30));
		bActividades.setBounds(426, 278, 175, 47);
		add(bActividades);
		
		JButton bUsuarios = new JButton("Usuarios");
		bUsuarios.setFont(new Font("Calibri", Font.PLAIN, 30));
		bUsuarios.setBounds(426, 368, 175, 47);
		add(bUsuarios);
		
		JLabel lblNewLabel = new JLabel("\u00A9NoTrabaJava - Todos los derechos reservados");
		lblNewLabel.setBounds(403, 682, 222, 13);
		add(lblNewLabel);
		
		JButton bInicio = new JButton("Inicio");
		bInicio.setBounds(10, 72, 91, 21);
		add(bInicio);
		
		JButton bCursos_1 = new JButton("Cursos");
		bCursos_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bCursos_1.setBounds(10, 103, 91, 23);
		add(bCursos_1);
		
		JButton bActividades_1 = new JButton("Actividades");
		bActividades_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bActividades_1.setBounds(10, 136, 91, 23);
		add(bActividades_1);
		
		JButton bUsuarios_1 = new JButton("Usuarios");
		bUsuarios_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		bUsuarios_1.setBounds(10, 169, 91, 23);
		add(bUsuarios_1);
		
		JButton bAjustes = new JButton("Ajustes");
		bAjustes.setFont(new Font("Calibri", Font.PLAIN, 12));
		bAjustes.setBounds(10, 202, 91, 21);
		add(bAjustes);

	}
}