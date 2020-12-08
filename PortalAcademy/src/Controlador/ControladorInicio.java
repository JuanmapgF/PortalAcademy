package Controlador;

import java.awt.event.*;
import java.text.ParseException;
import java.util.List;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;
import Vista.*;

public class ControladorInicio implements ActionListener {
	
	private Inicio panel;
	
	public ControladorInicio(Inicio p) {
		panel = p;
	}

	public Inicio getPanel() {
		return panel;
	}

	public void setPanel(Inicio panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("INICIAR")) {
			System.out.println(12);
			String user = panel.getUser() + panel.getPass();
			System.out.println(user);
			Usuario u = new Usuario(panel.getUser(), panel.getPass());
			List<Usuario> users = Usuario.getUsuarios();
			Usuario ini;
			
			for (Usuario us : users) {
				if (us.equals(u)) {
					ini = us;
					
					if (ini instanceof Estudiante) {
						try {
							Prueba.anyadirVentana(Prueba.getVentana(), new Explorar(ini, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else {
					System.out.println("Error");
				}
			}
		}
	}

}
