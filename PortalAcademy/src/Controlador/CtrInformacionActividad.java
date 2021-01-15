package Controlador;


import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Usuario;
import Vista.InformacionActividad;

public class CtrInformacionActividad {

	private InformacionActividad ventana;

	public CtrInformacionActividad(Usuario user, Actividad actividad) {
		ventana = new InformacionActividad(actividad, user);
	}

	public JPanel getPanel() {
		return ventana;
	}

}
