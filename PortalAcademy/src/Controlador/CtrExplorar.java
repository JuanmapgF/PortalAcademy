package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JPanel;

import Modelo.*;
import Vista.*;

public class CtrExplorar implements ActionListener {
	
	private Explorar ventana;
	
	public CtrExplorar(Explorar v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("INICIAR_SESION")) {
			CtrInicio c = new CtrInicio(new Inicio());
			Main.setPanel(c.getPanel());
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
		
		if (e.getActionCommand().equals("REGISTRO")) {
			CtrRegistro c = new CtrRegistro(new Registro());
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("VER_CURSO")) {
			if (ventana.esEstudiante()) {
				Curso cur = ventana.getCurso();
				Estudiante user = ventana.getEstudiante();
				if (cur != null) {
					CtrDescripcionCurso c = new CtrDescripcionCurso(user, cur);
					Main.setPanel(c.getPanel());
				}
			} else if (ventana.esProfesor()) {
				Curso cur = ventana.getCurso();
				Profesor user = ventana.getProfesor();
				if (cur != null) {
					CtrDescripcionCurso c = new CtrDescripcionCurso(user, cur);
					Main.setPanel(c.getPanel());
				}
			} else {
				Curso cur = ventana.getCurso();
				if (cur != null) {
					CtrDescripcionCurso c = new CtrDescripcionCurso(null, cur);
					Main.setPanel(c.getPanel());
				}
			}
		}
		
		if (e.getActionCommand().equals("VER_ACTIVIDAD")) {
			if (ventana.esEstudiante()) {
				Actividad act = ventana.getActividad();
				Estudiante user = ventana.getEstudiante();
				if (act != null) {
					CtrDescripcionActividad c = new CtrDescripcionActividad(user, act);
					Main.setPanel(c.getPanel());
				}
			} else if (ventana.esOrganizacion()) {
				Actividad act = ventana.getActividad();
				Organizacion user = ventana.getOrganizacion();
				if (act != null) {
					CtrDescripcionActividad c = new CtrDescripcionActividad(user, act);
					Main.setPanel(c.getPanel());
				}
			} else {
				Actividad act = ventana.getActividad();
				if (act != null) {
					CtrDescripcionActividad c = new CtrDescripcionActividad(null, act);
					Main.setPanel(c.getPanel());
				}
			}
		}
		
		if (e.getActionCommand().equals("EXPLORAR")) {
			if (ventana.esEstudiante()) {
				try {
					CtrExplorar c = new CtrExplorar(new Explorar(ventana.getEstudiante(), Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
					Main.setPanel(c.getPanel());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (ventana.esOrganizacion()) {
				try {
					CtrExplorar c = new CtrExplorar(new Explorar(ventana.getOrganizacion(), Actividad.getTodasLasActividades()));
					Main.setPanel(c.getPanel());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (ventana.esProfesor()) {
				CtrExplorar c = new CtrExplorar(new Explorar(ventana.getProfesor(), Curso.getTodosLosCursos()));
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
			if (ventana.esEstudiante()) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos(ventana.getEstudiante()));
				Main.setPanel(c.getPanel());
			} else {
				CtrMisCursos c = new CtrMisCursos(new MisCursos(ventana.getProfesor()));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("ACTIVIDAD")) {
			if (ventana.esEstudiante()) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades(ventana.getEstudiante()));
				Main.setPanel(c.getPanel());
			} else {
				CtrMisActividades c = new CtrMisActividades(new MisActividades(ventana.getOrganizacion()));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("AJUSTES")) {
			
		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}

}
