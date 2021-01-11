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


		if (e.getActionCommand().equals("CREARACTIVIDAD")) {
			CtrCrearActividad cca = new CtrCrearActividad(new CrearActividad());
			Main.setPanel(cca.getPanel());
		}

		if (e.getActionCommand().equals("VERACTIVIDAD")) {
			Actividad c = ventana.getActividad();
			if (c != null) {
				if (ventana.esEstudiante()) {
					CtrInformacionActividad cr = new CtrInformacionActividad(ventana.getEstudiante(), c);
					Main.setPanel(cr.getPanel());
				} else if (ventana.esProfesor()) {
					CtrInformacionActividad cr = new CtrInformacionActividad(ventana.getProfesor(), c);
					Main.setPanel(cr.getPanel());
				}else {
					CtrInformacionActividad cr = new CtrInformacionActividad(ventana.getOrganizacion(), c);
					Main.setPanel(cr.getPanel());
				}
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
