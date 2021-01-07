package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Usuario;
import Vista.Calendario;
import Vista.Main;
import Vista.Menu;
import Vista.Registro;

public class CtrCalendario   implements ActionListener{
	private Calendario ventana;

	public CtrCalendario(Calendario v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("VER")) {
			if(ventana.getActividad() != null) {
				CtrDescripcionActividad c =  new CtrDescripcionActividad(null, ventana.getActividad()); 
				Main.setPanel(c.getPanel());
			}
			
		}
		
		if (e.getActionCommand().equals("ENTRAR")) {
			if(ventana.getActividad() != null) {
				CtrInformacionActividad c =  new CtrInformacionActividad(ventana.getUsuario(), ventana.getActividad()); 
				Main.setPanel(c.getPanel());
			}
			
		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}
}
