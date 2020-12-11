package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.*;
import Vista.Explorar;

public class CtrExplorar implements ActionListener {
	
	private Explorar ventana;
	
	public CtrExplorar(Explorar v) {
		ventana = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void visible(Boolean b) {
		ventana.setVisible(b);
	}

}
