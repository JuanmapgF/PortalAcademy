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
			Inicio i = new Inicio();
			i.setFocusable(true);
		    i.requestFocusInWindow();
			CtrInicio2 c2 = new CtrInicio2(i);
			CtrInicio c = new CtrInicio(i);
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
				Curso cur = ventana.getCursoN();
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
				Actividad act = ventana.getActividadN();
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
			if (ventana.esEstudiante()) {
				CtrAjustes c = new CtrAjustes(new Ajustes(ventana.getEstudiante()));
				Main.setPanel(c.getPanel());
			} else if (ventana.esProfesor()) {
				CtrAjustes c = new CtrAjustes(new Ajustes(ventana.getProfesor()));
				Main.setPanel(c.getPanel());
			} else if (ventana.esOrganizacion()) {
				CtrAjustes c = new CtrAjustes(new Ajustes(ventana.getOrganizacion()));
				Main.setPanel(c.getPanel());
			}
		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}

}
