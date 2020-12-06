package Vista;

import java.awt.BorderLayout;

import javax.swing.*;

public class MenuEstudiante extends JPanel {

	private JButton explorar = new JButton("Explorar");
	private JButton misCursos = new JButton("Mis cursos");
	private JButton misActividades = new JButton("Mis actividades");
	private JButton ajustes = new JButton("Ajustes");
	
	public MenuEstudiante() {
		
		JPanel norte = new JPanel();
		norte.setLayout(new BorderLayout());
		norte.add(explorar, BorderLayout.NORTH);
		norte.add(misCursos, BorderLayout.SOUTH);
		
		JPanel sur = new JPanel();
		sur.setLayout(new BorderLayout());
		sur.add(misActividades, BorderLayout.NORTH);
		sur.add(ajustes, BorderLayout.SOUTH);
		
		JPanel menu = new JPanel();
		menu.setLayout(new BorderLayout());
		menu.add(norte, BorderLayout.NORTH);
		menu.add(sur, BorderLayout.SOUTH);
	}

}
