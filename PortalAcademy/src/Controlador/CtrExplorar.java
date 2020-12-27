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
import Vista.MisActividades;
import Vista.MisCursos;
import Vista.Registro;

public class CtrExplorar implements ActionListener {

	private Explorar ventana;

	public CtrExplorar(Explorar v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("VER_CURSO")) {
			if (ventana.esEstudiante()) {
				Curso cur = ventana.getCurso();
				Estudiante user = ventana.getEstudiante();
				if (cur != null) {
					CtrDescripcionCurso c = new CtrDescripcionCurso(user, cur);
					Main.setPanel(c.getPanel());
				}
			} else if (ventana.esProfesor()) {
				Curso cur = ventana.getCurso();
				Profesor user = ventana.getProfesor();
				if (cur != null) {
					CtrDescripcionCurso c = new CtrDescripcionCurso(user, cur);
					Main.setPanel(c.getPanel());
				}
			} else if (ventana.esOrganizacion()) {
				Curso cur = ventana.getCurso();
				Organizacion user = ventana.getOrganizacion();
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
				Actividad act = ventana.getActividad();
				Organizacion user = ventana.getOrganizacion();
				if (act != null) {
					CtrDescripcionActividad c = new CtrDescripcionActividad(user, act);
					Main.setPanel(c.getPanel());
				}
			} else if (ventana.esProfesor()) {
				Actividad act = ventana.getActividad();
				Profesor user = ventana.getProfesor();
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
	}

	public JPanel getPanel() {
		return ventana;
	}

}
