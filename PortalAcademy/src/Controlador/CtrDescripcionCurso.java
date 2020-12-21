package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Profesor;
import Modelo.Usuario;
import Vista.Ajustes;
import Vista.DescripcionCurso;
import Vista.Explorar;
import Vista.Inicio;
import Vista.Main;
import Vista.MisActividades;
import Vista.MisCursos;
import Vista.Registro;

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
		Boolean usuarioPuedeUnirse = (esEstudiante == null && curso.getPublico()
				|| esEstudiante != null && esEstudiante) && curso.quedanPlazas() && !estaEnCurso;
		ventana = new DescripcionCurso(curso.getNombre(), curso.getDescripcion(), usuarioPuedeUnirse, esEstudiante,
				curso.getImagen());
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Unirse")) {
			if (esEstudiante != null && esEstudiante) {
				curso.addEstudiante(user);
				CtrInformacionCurso c = new CtrInformacionCurso(user, curso);
				JOptionPane.showMessageDialog(ventana, "Se ha unido al curso correctamente");
				Main.setPanel(c.getPanel());
			} else {
				CtrInformacionCurso c = new CtrInformacionCurso(null, curso);
				JOptionPane.showMessageDialog(ventana, "Se ha unido al curso correctamente");
				Main.setPanel(c.getPanel());
			}

		}

		if (e.getActionCommand().equals("CERRAR_SESION")) {
			CtrExplorar c = new CtrExplorar(
					new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
			Main.setPanel(c.getPanel());

		}

		if (e.getActionCommand().equals("EXPLORAR")) {
			if (esEstudiante != null && esEstudiante) {
				CtrExplorar c = new CtrExplorar(
						new Explorar((Estudiante) user, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} else if (esEstudiante != null && !esEstudiante) {
				CtrExplorar c;
				c = new CtrExplorar(new Explorar((Profesor) user, Curso.getTodosLosCursos()));
				Main.setPanel(c.getPanel());

			} else {
				CtrExplorar c = new CtrExplorar(
						new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("CURSO")) {
			if (esEstudiante != null && esEstudiante) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Estudiante) user));
				Main.setPanel(c.getPanel());
			} else if (esEstudiante != null && !esEstudiante) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos((Profesor) user));
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("ACTIVIDAD")) {
			if (esEstudiante != null && esEstudiante) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades((Estudiante) user));
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("AJUSTES")) {
			if (esEstudiante != null && esEstudiante) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Estudiante) user));
				Main.setPanel(c.getPanel());
			} else if (esEstudiante != null && !esEstudiante) {
				CtrAjustes c = new CtrAjustes(new Ajustes((Profesor) user));
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
