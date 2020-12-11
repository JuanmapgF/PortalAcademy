package Vista;

import java.awt.BorderLayout;

import javax.swing.*;

import Modelo.*;

public class Menu extends JPanel {
	
	public Menu(Usuario u) {
		
		if (u instanceof Estudiante) {
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
		} else if (u instanceof Profesor) {
			JButton explorar = new JButton("Explorar");
			explorar.setBounds(36, 191, 131, 32);
			add(explorar);
			
			JButton cursos = new JButton("Mis cursos");
			cursos.setBounds(36, 261, 131, 32);
			add(cursos);
			
			JButton ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 336, 131, 32);
			add(ajustes);
		} else if (u instanceof Organizacion) {
			JButton explorar = new JButton("Explorar");
			explorar.setBounds(36, 191, 131, 32);
			add(explorar);
			
			JButton actividades = new JButton("Mis actividades");
			actividades.setBounds(36, 261, 131, 32);
			add(actividades);
			
			JButton ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 336, 131, 32);
			add(ajustes);
		} else {
			JButton explorar = new JButton("Explorar");
			explorar.setBounds(36, 191, 131, 32);
			add(explorar);
		}
		
		
		setLayout(null);
		
		
		
		this.setBounds(0,0,200,650);
		
	}
	
}
