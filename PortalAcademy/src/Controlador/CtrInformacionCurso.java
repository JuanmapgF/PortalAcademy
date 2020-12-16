package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JPanel;

import Modelo.*;
import Vista.*;

public class CtrInformacionCurso implements ActionListener {
	private Usuario user;
	private Curso curso;
	
	private InformacionCurso ventana;
	
	public CtrInformacionCurso(Usuario user, Curso curso) {
		this.user = user;
		this.curso = curso;
		Boolean esProfesor;
		if (user == null) {
			esProfesor = null;
		} else if (user instanceof Profesor) {
			esProfesor = true;
		} else {
			esProfesor = false;
		}
		ventana = new InformacionCurso(curso.getNombre(), curso.getDescripcion(), curso.getTieneForo(), curso.getMensajes(), user);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Enviar")) {
			Mensaje m = new Mensaje(ventana.mensajeAEnviar(), user, curso);
			CtrInformacionCurso c = new CtrInformacionCurso(user, curso);
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("Refrescar")) {
			CtrInformacionCurso c = new CtrInformacionCurso(user, curso);
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
			CtrEditarCurso c = new CtrEditarCurso(new EditarCurso(curso, (Profesor)user));
			Main.setPanel(c.getPanel());
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
			} else if (user != null && user instanceof Profesor) {
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
			if (user != null && user instanceof Estudiante) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Estudiante)user));
				Main.setPanel(c.getPanel());
			} else if (user != null && user instanceof Profesor) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Profesor)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("ACTIVIDAD")) {
			if (user != null && user instanceof Estudiante) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Estudiante)user));
				Main.setPanel(c.getPanel());
			}
		}
		
		if (e.getActionCommand().equals("AJUSTES")) {
			if (user != null && user instanceof Estudiante) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Estudiante)user));
				Main.setPanel(c.getPanel());
			}else if (user != null && user instanceof Profesor) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Profesor)user));
				Main.setPanel(c.getPanel());
			}
		}
	}

	public JPanel getPanel() {
		return ventana;
	}
	
}
