package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Organizacion;
import Vista.EditarActividad;
import Vista.Main;
import Vista.MenuActividad;

public class CtrMenuActividad  implements ActionListener {
	
	private MenuActividad ventana;

	public CtrMenuActividad (MenuActividad v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("INICIO")) {
			CtrInformacionActividad c = new CtrInformacionActividad(Main.getUser(),ventana.getActividad());
			Main.setPanel(c.getPanel());
		}
		
		
		if (e.getActionCommand().equals("CUESTIONARIOS")) {
			if (Main.getUser() == null) {
				JOptionPane.showMessageDialog(ventana, "No tienes permiso para hacer cuestionarios");
			} else {
				CtrInformacionActividadCuestionario c = new CtrInformacionActividadCuestionario (ventana.getActividad(),Main.getUser());
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("EDITAR")) {
			CtrEditarActividad c = new CtrEditarActividad(new EditarActividad(ventana.getActividad(), (Organizacion) Main.getUser()));
			Main.setPanel(c.getPanel());
		}
	}
	public JPanel getPanel() {
		return ventana;
	}
}
