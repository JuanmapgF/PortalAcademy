package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JPanel;

import Modelo.*;
import Vista.*;

public class CtrDescripcionActividad implements ActionListener {
	private Usuario user;
	private Actividad actividad;
	private Boolean esEstudiante;
	private DescripcionActividad ventana;
	
	public CtrDescripcionActividad(Usuario user, Actividad actividad) {
		this.user = user;
		this.actividad = actividad;
		Boolean esInvitado = user == null;
		esEstudiante = user != null && user instanceof Estudiante;
		Boolean estaEnActividad;
		if (esEstudiante) {
			estaEnActividad = ((Estudiante) user).estaEnActividad(actividad);
		} else {
			estaEnActividad = false;
		}
		Boolean usuarioPuedeUnirse = (esInvitado || esEstudiante) && actividad.quedanPlazas() && !estaEnActividad;
		ventana = new DescripcionActividad(actividad.getNombre(), actividad.getDescripcion(), usuarioPuedeUnirse, esEstudiante);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Unirse")) {
			actividad.addParticipante(user);
			//TODO: Entramos en informacionActividad
		}
		if (e.getActionCommand().equals("CERRAR_SESION")) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if (e.getActionCommand().equals("EXPLORAR")) {
			if (esEstudiante) {
				try {
					CtrExplorar c = new CtrExplorar(new Explorar((Estudiante)user, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
					Main.setPanel(c.getPanel());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
			if (esEstudiante) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Estudiante)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("ACTIVIDAD")) {
			if (esEstudiante) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Estudiante)user));
				Main.setPanel(c.getPanel());
			} else {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Organizacion)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("AJUSTES")) {
			if (esEstudiante) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Estudiante)user));
				Main.setPanel(c.getPanel());
			} else {
				CtrAjustes c = new CtrAjustes(new Ajustes((Organizacion)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("INICIAR_SESION")) {
			Inicio i = new Inicio();
			i.setFocusable(true);
		    i.requestFocusInWindow();
			CtrInicio2 c2 = new CtrInicio2(i);
			CtrInicio c = new CtrInicio(i);
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("REGISTRO")) {
			CtrRegistro c = new CtrRegistro(new Registro());
			Main.setPanel(c.getPanel());
		}
		
	}
	
	public JPanel getPanel() {
		return ventana;
	}

}
