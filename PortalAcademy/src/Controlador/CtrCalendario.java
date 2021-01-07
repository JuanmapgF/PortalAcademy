package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Vista.Calendario;
import Vista.Menu;

public class CtrCalendario   implements ActionListener{
	private Calendario ventana;

	public CtrCalendario(Calendario v) {
		ventana = v;
		//ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public JPanel getPanel() {
		return ventana;
	}
}
