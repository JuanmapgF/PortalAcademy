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
		Boolean esInvitado = user == null;
		esEstudiante = user != null && user instanceof Estudiante;
		Boolean estaEnCurso;
		if (esEstudiante) {
			estaEnCurso = ((Estudiante) user).estaEnCurso(curso);
		} else {
			estaEnCurso = false;
		}
		Boolean usuarioPuedeUnirse = (esInvitado && curso.getPublico() || esEstudiante) && curso.quedanPlazas() && !estaEnCurso;
		ventana = new DescripcionCurso(curso.getNombre(), curso.getDescripcion(), usuarioPuedeUnirse, esEstudiante);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Unirse")) {
			curso.addEstudiante(user);
			//TODO: Entramos en informacionCurso con su foro
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
			}
		}
		
		if (e.getActionCommand().equals("AJUSTES")) {
			
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
