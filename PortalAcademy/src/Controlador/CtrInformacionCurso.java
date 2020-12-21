package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Mensaje;
import Modelo.Profesor;
import Modelo.Usuario;
import Vista.Ajustes;
import Vista.EditarCurso;
import Vista.Explorar;
import Vista.InformacionCurso;
import Vista.Inicio;
import Vista.Main;
import Vista.MisActividades;
import Vista.MisCursos;
import Vista.Registro;

public class CtrInformacionCurso implements ActionListener {
	private Usuario user;
	private Curso curso;

	private InformacionCurso ventana;

	public CtrInformacionCurso(Usuario user, Curso curso) {
		this.user = user;
		this.curso = curso;
		ventana = new InformacionCurso(user, curso);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Enviar")) {
			if(ventana.mensajeAEnviar().length() > 0) {
				if(user == null) {
					Usuario x = new Usuario("anonimo");
					Mensaje m = new Mensaje(ventana.mensajeAEnviar(), x, curso);
					CtrInformacionCurso c = new CtrInformacionCurso(user, curso);
					Main.setPanel(c.getPanel());
				}else {
					Mensaje m = new Mensaje(ventana.mensajeAEnviar(), user, curso);
					CtrInformacionCurso c = new CtrInformacionCurso(user, curso);
					Main.setPanel(c.getPanel());
				}
				
			}
		}

		if (e.getActionCommand().equals("Refrescar")) {
			CtrInformacionCurso c = new CtrInformacionCurso(user, curso);
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("CERRAR_SESION")) {

			CtrExplorar c = new CtrExplorar(
					new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
			Main.setPanel(c.getPanel());

		}

		if (e.getActionCommand().equals("Iniciar")) {
			Inicio i = new Inicio();
			i.setFocusable(true);
			i.requestFocusInWindow();
			CtrInicio c = new CtrInicio(i);
			CtrInicio2 c2 = new CtrInicio2(i);
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("Registrarse")) {
			CtrRegistro c = new CtrRegistro(new Registro());
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("Editar")) {
			CtrEditarCurso c = new CtrEditarCurso(new EditarCurso(curso, (Profesor) user));
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("EXPLORAR")) {
			if (user == null) {			
				CtrExplorar c = new CtrExplorar(
						new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} else if (user instanceof Estudiante) {
				CtrExplorar c = new CtrExplorar(
						new Explorar((Estudiante) user, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} else {
				 CtrExplorar c = new CtrExplorar(new Explorar((Profesor) user, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("CURSO")) {
			if (user instanceof Estudiante) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Estudiante) user));
				Main.setPanel(c.getPanel());
			} else {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Profesor) user));
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("ACTIVIDAD")) {
			if (user instanceof Estudiante) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Estudiante) user));
				Main.setPanel(c.getPanel());

			} else if (user != null && user instanceof Profesor) {
				CtrMisActividades c = new CtrMisActividades (new MisActividades((Profesor) user));
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("AJUSTES")) {
			if (user instanceof Estudiante) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Estudiante)user));
				Main.setPanel(c.getPanel());
			}else  {
				CtrAjustes c = new CtrAjustes(new Ajustes((Profesor)user));
				Main.setPanel(c.getPanel());
			}
		}
	}

	public JPanel getPanel() {
		return ventana;
	}

}
