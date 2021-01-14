package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Usuario;
import Vista.InformacionActividad;

public class CtrInformacionActividad implements ActionListener {
	private Usuario user;
	private Actividad actividad;

	private InformacionActividad ventana;

	public CtrInformacionActividad(Usuario user, Actividad actividad) {
		this.user = user;
		this.actividad = actividad;
		ventana = new InformacionActividad(actividad, user);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	public JPanel getPanel() {
		return ventana;
	}

}
