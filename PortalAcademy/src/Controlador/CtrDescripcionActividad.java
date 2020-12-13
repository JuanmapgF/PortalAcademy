package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import Modelo.*;
import Vista.*;

public class CtrDescripcionActividad implements ActionListener {
	private Usuario user;
	private Actividad actividad;
	
	private DescripcionActividad ventana;
	
	public CtrDescripcionActividad(Usuario user, Actividad actividad) {
		this.user = user;
		this.actividad = actividad;
		Boolean esInvitado = user == null;
		Boolean esEstudiante = user != null && user instanceof Estudiante;
		Boolean estaEnActividad;
		if (esEstudiante) {
			estaEnActividad = ((Estudiante) user).estaEnActividad(actividad);
		} else {
			estaEnActividad = false;
		}
		Boolean usuarioPuedeUnirse = (esInvitado || esEstudiante) && actividad.quedanPlazas() && !estaEnActividad;
		ventana = new DescripcionActividad(actividad.getNombre(), actividad.getDescripcion(), usuarioPuedeUnirse);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Unirse")) {
			actividad.addParticipante(user);
			//TODO: Entramos en informacionActividad
		}
		
		if (e.getActionCommand().equals("Cerrar Sesi\u00F3n")) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

}
