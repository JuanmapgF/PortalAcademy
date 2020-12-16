package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;
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
		
		if (user != null && user instanceof Estudiante) {
			esEstudiante = true;
		} else if (user != null && user instanceof Organizacion) {
			esEstudiante = false;
		} else {
			esEstudiante = null;
		}
		
		Boolean estaEnActividad;
		if (esEstudiante != null && esEstudiante) {
			estaEnActividad = ((Estudiante) user).estaEnActividad(actividad);
		} else {
			estaEnActividad = false;
		}
		
		Boolean usuarioPuedeUnirse = (esEstudiante == null || esEstudiante) && actividad.quedanPlazas() && !estaEnActividad;
		ventana = new DescripcionActividad(actividad.getNombre(), actividad.getDescripcion(), usuarioPuedeUnirse, esEstudiante);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Unirse")) {
			if(esEstudiante != null && esEstudiante) {
				actividad.addParticipante(user);
				CtrInformacionActividad c = new CtrInformacionActividad(user, actividad);
				JOptionPane.showMessageDialog(ventana, "Se ha unido a la actividad correctamente");
				Main.setPanel(c.getPanel());
			}else {
				CtrInformacionActividad c = new CtrInformacionActividad(null, actividad);
				JOptionPane.showMessageDialog(ventana, "Se ha unido a la actividad correctamente");
				Main.setPanel(c.getPanel());
			}
			
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
			if (esEstudiante != null && esEstudiante) {
				try {
					CtrExplorar c = new CtrExplorar(new Explorar((Estudiante)user, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
					Main.setPanel(c.getPanel());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (esEstudiante != null && !esEstudiante) {
				CtrExplorar c;
				try {
					c = new CtrExplorar(new Explorar((Organizacion)user, Actividad.getTodasLasActividades()));
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
			if (esEstudiante != null && esEstudiante) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Estudiante)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("ACTIVIDAD")) {
			if (esEstudiante != null && esEstudiante) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Estudiante)user));
				Main.setPanel(c.getPanel());
			} else if ( esEstudiante != null && !esEstudiante) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Organizacion)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("AJUSTES")) {
			if (esEstudiante != null && esEstudiante) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Estudiante)user));
				Main.setPanel(c.getPanel());
			}else if (esEstudiante != null && !esEstudiante) {
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
