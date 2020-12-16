package Controlador;

import java.awt.event.*;
import java.text.ParseException;

import javax.swing.JPanel;

import Vista.*;
import Modelo.*;

public class CtrDescripcionCurso implements ActionListener {
	private Usuario user;
	private Curso curso;
	private Boolean esEstudiante;
	private DescripcionCurso ventana;
	
	public CtrDescripcionCurso(Usuario user, Curso curso) {
		this.user = user;
		this.curso = curso;
		if (user != null && user instanceof Estudiante) {
			esEstudiante = true;
		} else if (user != null && user instanceof Profesor) {
			esEstudiante = false;
		} else {
			esEstudiante = null;
		}
		Boolean estaEnCurso;
		if (esEstudiante != null && esEstudiante) {
			estaEnCurso = ((Estudiante) user).estaEnCurso(curso);
		} else {
			estaEnCurso = false;
		}
		Boolean usuarioPuedeUnirse = (esEstudiante == null && curso.getPublico() || esEstudiante != null && esEstudiante)
				&& curso.quedanPlazas() && !estaEnCurso;
		ventana = new DescripcionCurso(curso.getNombre(), curso.getDescripcion(), usuarioPuedeUnirse, esEstudiante);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Unirse")) {
			curso.addEstudiante(user);
			CtrInformacionCurso c = new CtrInformacionCurso(user, curso);
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("CERRAR_SESION")) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
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
				c = new CtrExplorar(new Explorar((Profesor)user, Curso.getTodosLosCursos()));
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
			if (esEstudiante != null && esEstudiante) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Estudiante)user));
				Main.setPanel(c.getPanel());
			} else if ( esEstudiante != null && !esEstudiante) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Profesor)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("ACTIVIDAD")) {
			if (esEstudiante != null && esEstudiante) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Estudiante)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("AJUSTES")) {
			if (esEstudiante != null && esEstudiante) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Estudiante)user));
				Main.setPanel(c.getPanel());
			}else if (esEstudiante != null && !esEstudiante) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Profesor)user));
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
