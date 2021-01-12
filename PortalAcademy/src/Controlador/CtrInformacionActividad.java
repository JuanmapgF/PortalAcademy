package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Organizacion;
import Modelo.Usuario;
import Vista.EditarActividad;
import Vista.InformacionActividad;
import Vista.Main;

public class CtrInformacionActividad implements ActionListener {
	private Usuario user;
	private Actividad actividad;

	private InformacionActividad ventana;

	public CtrInformacionActividad(Usuario user, Actividad actividad) {
		this.user = user;
		this.actividad = actividad;
		ventana = new InformacionActividad(actividad, user);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		

		if (e.getActionCommand().equals("Editar")) {
			CtrEditarActividad c = new CtrEditarActividad(new EditarActividad(actividad, (Organizacion) user));
			Main.setPanel(c.getPanel());
		}
		
	}

	public JPanel getPanel() {
		return ventana;
	}

}
