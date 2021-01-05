package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Vista.Ajustes;
import Vista.Explorar;
import Vista.Inicio;
import Vista.Main;
import Vista.Menu;
import Vista.MisActividades;
import Vista.MisCursos;
import Vista.Registro;

public class CtrMenu implements ActionListener {
	
	private Menu ventana;

	public CtrMenu(Menu v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("INICIAR_SESION")) {
			Inicio i = new Inicio();
			i.setFocusable(true);
			i.requestFocusInWindow();
			CtrInicio2 c2 = new CtrInicio2(i);
			CtrInicio c = new CtrInicio(i);
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("CERRAR_SESION")) {
			Main.setUser(null);
			CtrExplorar c = new CtrExplorar(
					new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
			Main.setPanel(c.getPanel());

		}

		if (e.getActionCommand().equals("REGISTRARSE")) {
			CtrRegistro c = new CtrRegistro(new Registro());
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("EXPLORAR")) {
			if (ventana.esEstudiante()) {
				Main.getUser().setListaActividades();
				Main.getUser().setListaCursos();
				CtrExplorar c = new CtrExplorar(new Explorar(ventana.getEstudiante(), Curso.getTodosLosCursos(),
						Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());

			} else if (ventana.esOrganizacion()) {
				Main.getUser().setListaActividades();
				Main.getUser().setListaCursos();
				CtrExplorar c = new CtrExplorar(new Explorar(ventana.getOrganizacion(), Curso.getTodosLosCursos(),
						Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());

			} else if (ventana.esProfesor()) {
				Main.getUser().setListaActividades();
				Main.getUser().setListaCursos();
				CtrExplorar c = new CtrExplorar(new Explorar(ventana.getProfesor(), Curso.getTodosLosCursos(),
						Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} else {
				CtrExplorar c = new CtrExplorar(
						new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("CURSO")) {
			if (ventana.esEstudiante()) {
				Main.getUser().setListaActividades();
				Main.getUser().setListaCursos();
				CtrMisCursos c = new CtrMisCursos(new MisCursos(ventana.getEstudiante()));
				Main.setPanel(c.getPanel());
			} else if (ventana.esProfesor()) {
				Main.getUser().setListaActividades();
				Main.getUser().setListaCursos();
				CtrMisCursos c = new CtrMisCursos(new MisCursos(ventana.getProfesor()));
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("ACTIVIDAD")) {
			if (ventana.esEstudiante()) {
				Main.getUser().setListaActividades();
				Main.getUser().setListaCursos();
				CtrMisActividades c = new CtrMisActividades(new MisActividades(ventana.getEstudiante()));
				Main.setPanel(c.getPanel());
			} else if (ventana.esOrganizacion()) {
				Main.getUser().setListaActividades();
				Main.getUser().setListaCursos();
				CtrMisActividades c = new CtrMisActividades(new MisActividades(ventana.getOrganizacion()));
				Main.setPanel(c.getPanel());
			} else if (ventana.esProfesor()) {
				Main.getUser().setListaActividades();
				Main.getUser().setListaCursos();
				CtrMisActividades c = new CtrMisActividades(new MisActividades(ventana.getProfesor()));
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

		if (e.getActionCommand().equals("CHAT")) {
			if (ventana.esEstudiante()) {
				CtrChatPrivado c = new CtrChatPrivado(ventana.getEstudiante());
				Main.setPanel(c.getPanel());
			} else if (ventana.esProfesor()) {
				CtrChatPrivado c = new CtrChatPrivado(ventana.getProfesor());
				Main.setPanel(c.getPanel());
			} else if (ventana.esOrganizacion()) {
				CtrChatPrivado c = new CtrChatPrivado(ventana.getOrganizacion());
				Main.setPanel(c.getPanel());
			}

		}
	}

	public JPanel getPanel() {
		return ventana;
	}
}
