package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.*;
import Vista.*;

public class CtrDescripcionActividad implements ActionListener {
	private Usuario user;
	private Actividad actividad;
	private DescripcionActividad ventana;
	
	public CtrDescripcionActividad(Usuario user, Actividad actividad) {
		this.user = user;
		this.actividad = actividad;
		
		ventana = new DescripcionActividad(user, actividad);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Unirse")) {
			if(user == null) {
				CtrInformacionActividad c = new CtrInformacionActividad(null, actividad);
				JOptionPane.showMessageDialog(ventana, "Se ha unido a la actividad correctamente");
				Main.setPanel(c.getPanel());		
			} else {
				actividad.addParticipante(user);
				CtrInformacionActividad c = new CtrInformacionActividad(user, actividad);
				JOptionPane.showMessageDialog(ventana, "Se ha unido a la actividad correctamente");
				Main.setPanel(c.getPanel());
			}
			
			//TODO: Entramos en informacionActividad
		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}

}
