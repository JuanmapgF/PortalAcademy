package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Vista.Main;
import Vista.MenuActividad;
import Vista.MenuCurso;

public class CtrMenuActividad  implements ActionListener {
	
	private MenuActividad ventana;

	public CtrMenuActividad (MenuActividad v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("INICIO")) {
			CtrInformacionActividadInicio c = new CtrInformacionActividadInicio(Main.getUser(),ventana.getActividad());
			Main.setPanel(c.getPanel());
		}
		
		
		if (e.getActionCommand().equals("CUESTIONARIOS")) {
			CtrInformacionActividadCuestionarios c = new CtrInformacionActividadCuestionarios(Main.getUser(),ventana.getActividad());
			Main.setPanel(c.getPanel());
		}

		
	}
	public JPanel getPanel() {
		return ventana;
	}
}
