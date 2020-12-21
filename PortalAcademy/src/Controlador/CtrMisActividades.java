package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Vista.Ajustes;
import Vista.CrearActividad;
import Vista.Explorar;
import Vista.Main;
import Vista.MisActividades;
import Vista.MisCursos;

public class CtrMisActividades implements ActionListener {

	private MisActividades ventana;

	public CtrMisActividades(MisActividades v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("CERRAR_SESION")) {

			CtrExplorar c = new CtrExplorar(
					new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
			Main.setPanel(c.getPanel());

		}

		if (e.getActionCommand().equals("CREARACTIVIDAD")) {
			CtrCrearActividad cca = new CtrCrearActividad(new CrearActividad());
			Main.setPanel(cca.getPanel());
		}

		if (e.getActionCommand().equals("MISACTIVIDADESUSUARIO")) {
			Actividad c = ventana.getA();
			if (c != null) {
				if (ventana.esEstudiante()) {
					CtrInformacionActividad cr = new CtrInformacionActividad(ventana.getEstudiante(), c);
					Main.setPanel(cr.getPanel());
				}
			}
		}
		
		if (e.getActionCommand().equals("MISACTIVIDADESPROFESOR")) {
			Actividad c = ventana.getA();
			if (c != null) {
				if (ventana.esProfesor()) {
					CtrInformacionActividad cr = new CtrInformacionActividad(ventana.getProfesor(), c);
					Main.setPanel(cr.getPanel());
				}
			}
		}

		if (e.getActionCommand().equals("MISACTIVIDADESORGANIZACION")) {
			Actividad c = ventana.getA();
			if (c != null) {
				if (ventana.esOrganizacion()) {
					CtrInformacionActividad cr = new CtrInformacionActividad(ventana.getOrganizacion(), c);
					Main.setPanel(cr.getPanel());
				}
			}
		}

		if (e.getActionCommand().equals("EXPLORAR")) {
			if (ventana.esEstudiante()) {

				CtrExplorar c = new CtrExplorar(new Explorar(ventana.getEstudiante(), Curso.getTodosLosCursos(),
						Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());

			} else if (ventana.esOrganizacion()) {

				CtrExplorar c = new CtrExplorar(
						new Explorar(ventana.getOrganizacion(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());

			} else {
				CtrExplorar c = new CtrExplorar(new Explorar(ventana.getProfesor(), Curso.getTodosLosCursos()));
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("CURSO")) {
			if (ventana.esEstudiante()) {
				CtrMisCursos c = new CtrMisCursos(new MisCursos(ventana.getEstudiante()));
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
			} else {
				CtrMisActividades c = new CtrMisActividades(new MisActividades(ventana.getProfesor()));
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("AJUSTES")) {
			if (ventana.esEstudiante()) {
				CtrAjustes c = new CtrAjustes(new Ajustes(ventana.getEstudiante()));
				Main.setPanel(c.getPanel());
			} else {
				CtrAjustes c = new CtrAjustes(new Ajustes(ventana.getOrganizacion()));
				Main.setPanel(c.getPanel());
			}
		}

	}

	public JPanel getPanel() {
		return ventana;
	}

	public void visible(Boolean b) {
		ventana.setVisible(b);
	}
}
