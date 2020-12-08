package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.*;

import Modelo.*;
import Vista.*;

public class Controlador implements ActionListener {
	
	private Explorar explorar;
	private Inicio inicio;
	private Registro registro;
	private Menu menu;
	
	private JPanel panel;
	
	public void setVista(JPanel v) {
		panel = v;
		tipo(panel);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	private void tipo(JPanel p) {
		if (p instanceof Explorar) {
			explorar = (Explorar) p;
		} else if (p instanceof Inicio) {
			inicio = (Inicio) p;
		} else if (p instanceof Registro) {
			registro = (Registro) p;
		} else if (p instanceof Menu) {
			menu = (Menu) p;
		}
	}
	
	public void setVista(JPanel m, JPanel e) {
		JPanel contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1080, 650);
		contentPane.add(m);
		contentPane.add(e);
		
		panel = contentPane;
		
		tipo(m);
		tipo(e);
	}
	
	public Controlador() {
		try {
			setVista(new Explorar(null, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("INICIAR")) {
			tipo(panel);
			Usuario u = new Usuario(inicio.getUser(), inicio.getPass());
			List<Usuario> users = Usuario.getUsuarios();
			Usuario ini;
			
			for (Usuario us : users) {
				if (us.equals(u)) {
					ini = us;
					if (ini instanceof Estudiante) {
						Menu m = new Menu(ini);
						Explorar ex = null;
						try {
							ex = new Explorar(ini, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						setVista(m,ex);
					} else {
						
					}
				}
			}
		}
		
		if (e.getActionCommand().equals("REGISTRATE")) {
			setVista(new Registro());
		}
		
	}

}
