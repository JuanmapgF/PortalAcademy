package Vista;

import java.awt.BorderLayout;

import javax.swing.*;

public class MenuEstudiante extends JPanel {

	/*private JButton explorar = new JButton("Explorar");
	private JButton misCursos = new JButton("Mis cursos");
	private JButton misActividades = new JButton("Mis actividades");
	private JButton ajustes = new JButton("Ajustes");*/
	
	public MenuEstudiante() {
		setLayout(null);
		
		JButton explorar = new JButton("Explorar");
		explorar.setBounds(36, 191, 131, 32);
		add(explorar);
		
		JButton cursos = new JButton("Mis cursos");
		cursos.setBounds(36, 261, 131, 32);
		add(cursos);
		
		JButton actividades = new JButton("Mis actividades");
		actividades.setBounds(36, 336, 131, 32);
		add(actividades);
		
		JButton ajustes = new JButton("Ajustes");
		ajustes.setBounds(36, 413, 131, 32);
		add(ajustes);
		
		this.setBounds(0,0,200,650);
		
	}
}
