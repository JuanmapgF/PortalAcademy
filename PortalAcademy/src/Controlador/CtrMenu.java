package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Vista.Ajustes;
import Vista.Explorar;
import Vista.Inicio;
import Vista.Main;
import Vista.Menu;
import Vista.MisActividades;
import Vista.MisCursos;
import Vista.Registro;

public class CtrMenu implements ActionListener{
	private Menu ventana;

	public CtrMenu(Menu v) {
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

				CtrExplorar c = new CtrExplorar(new Explorar(ventana.getEstudiante(), Curso.getTodosLosCursos(),
						Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());

			} else if (ventana.esOrganizacion()) {

				CtrExplorar c = new CtrExplorar(
						new Explorar(ventana.getOrganizacion(),Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());

			} else if (ventana.esProfesor()) {
				CtrExplorar c = new CtrExplorar(new Explorar(ventana.getProfesor(), Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} else {

				CtrExplorar c = new CtrExplorar(
						new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());

			}
		}

		if (e.getActionCommand().equals("CURSO")) {
			if (ventana.esEstudiante()) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos(ventana.getEstudiante()));
				Main.setPanel(c.getPanel());
			} else if (ventana.esProfesor()){
				CtrMisCursos c = new CtrMisCursos(new MisCursos(ventana.getProfesor()));
				Main.setPanel(c.getPanel());
			} 
		}

		if (e.getActionCommand().equals("ACTIVIDAD")) {
			if (ventana.esEstudiante()) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades(ventana.getEstudiante()));
				Main.setPanel(c.getPanel());
			} else if (ventana.esOrganizacion()) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades(ventana.getOrganizacion()));
				Main.setPanel(c.getPanel());
			} else if (ventana.esProfesor()) {
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
	}

	public JPanel getPanel() {
		return ventana;
	}
}