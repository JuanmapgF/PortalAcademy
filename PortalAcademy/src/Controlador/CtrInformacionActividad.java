package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JPanel;

import Modelo.*;
import Vista.*;

public class CtrInformacionActividad implements ActionListener {
	private Usuario user;
	private Actividad actividad;
	
	private InformacionActividad ventana;
	
	public CtrInformacionActividad(Usuario user, Actividad actividad) {
		this.user = user;
		this.actividad = actividad;
		Boolean esOrganizacion;
		if (user == null) {
			esOrganizacion = null;
		} else if (user instanceof Organizacion) {
			esOrganizacion = true;
		} else {
			esOrganizacion = false;
		}
		ventana = new InformacionActividad(actividad.getNombre(), actividad.getDescripcion(), user);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("CERRAR_SESION")) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		
		if (e.getActionCommand().equals("Iniciar")) {
			Inicio i = new Inicio();
			i.setFocusable(true);
		    i.requestFocusInWindow();
			CtrInicio c = new CtrInicio(i);
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("Registrarse")) {
			CtrRegistro c = new CtrRegistro(new Registro());
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("Editar")) {
			// TODO: Accede a la vista de editar Curso
		}
		
		if (e.getActionCommand().equals("EXPLORAR")) {
			if (user != null && user instanceof Estudiante) {
				try {
					CtrExplorar c = new CtrExplorar(new Explorar((Estudiante)user, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
					Main.setPanel(c.getPanel());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (user != null && user instanceof Organizacion) {
				CtrExplorar c = null;
				try {
					c = new CtrExplorar(new Explorar((Organizacion)user, Actividad.getTodasLasActividades()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Main.setPanel(c.getPanel());
				
			} else {
				try {
					CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
					Main.setPanel(c.getPanel());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		if (e.getActionCommand().equals("CURSO")) {
			if (user != null && user instanceof Estudiante) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Estudiante)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("ACTIVIDAD")) {
			if (user != null && user instanceof Estudiante) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Estudiante)user));
				Main.setPanel(c.getPanel());
			} else if (user != null && user instanceof Organizacion) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Organizacion)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("AJUSTES")) {
			if (user != null && user instanceof Estudiante) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Estudiante)user));
				Main.setPanel(c.getPanel());
			}else if (user != null && user instanceof Organizacion) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Organizacion)user));
				Main.setPanel(c.getPanel());
			}
		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}

}
