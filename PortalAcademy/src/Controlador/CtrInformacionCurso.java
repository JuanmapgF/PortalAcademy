package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
		ventana = new InformacionCurso(curso.getNombre(), curso.getDescripcion(), curso.getTieneForo(), curso.getMensajes(), esProfesor, user);
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
		
		if (e.getActionCommand().equals("Cerrar Sesi\\u00F3n")) {
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
			// TODO: Accede a la vista de editar Curso
		}
	}

	public JPanel getPanel() {
		return ventana;
	}
	
}
