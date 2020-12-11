package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import Modelo.*;

public class Menu extends JPanel {
	
	private JButton explorar;
	private JButton cursos;
	private JButton actividades;
	private JButton ajustes;
	
	public Menu(Usuario u) {
		
		if (u instanceof Estudiante) {
			explorar = new JButton("Explorar");
			explorar.setBounds(36, 191, 131, 32);
			add(explorar);
			
			cursos = new JButton("Mis cursos");
			cursos.setBounds(36, 261, 131, 32);
			add(cursos);
			
			actividades = new JButton("Mis actividades");
			actividades.setBounds(36, 336, 131, 32);
			add(actividades);
			
			ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 413, 131, 32);
			add(ajustes);
		} else if (u instanceof Profesor) {
			explorar = new JButton("Explorar");
			explorar.setBounds(36, 191, 131, 32);
			add(explorar);
			
			cursos = new JButton("Mis cursos");
			cursos.setBounds(36, 261, 131, 32);
			add(cursos);
			
			ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 336, 131, 32);
			add(ajustes);
		} else if (u instanceof Organizacion) {
			explorar = new JButton("Explorar");
			explorar.setBounds(36, 191, 131, 32);
			add(explorar);
			
			actividades = new JButton("Mis actividades");
			actividades.setBounds(36, 261, 131, 32);
			add(actividades);
			
			ajustes = new JButton("Ajustes");
			ajustes.setBounds(36, 336, 131, 32);
			add(ajustes);
		} else {
			explorar = new JButton("Explorar");
			explorar.setBounds(36, 191, 131, 32);
			add(explorar);
		}
		
		
		setLayout(null);
		
		
		
		this.setBounds(0,0,200,650);
		
	}
	
	public void controlador(ActionListener ctr) {
		if (explorar != null) {
			explorar.addActionListener(ctr);
			explorar.setActionCommand("EXPLORAR");
		}
		
		if (cursos != null) {
			cursos.addActionListener(ctr);
			cursos.setActionCommand("MIS_CURSOS");
		}
		
		if (actividades != null) {
			actividades.addActionListener(ctr);
			actividades.setActionCommand("MIS_ACTIVIDADES");
		}
		
		if (ajustes != null) {
			ajustes.addActionListener(ctr);
			ajustes.setActionCommand("AJUSTES");
		}
		
		
	}
	
}
