package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.*;
import Vista.Explorar;

public class CtrExplorar implements ActionListener {
	
	private Explorer ventana;
	
	public CtrExplorar(Usuario u, ) {
		if (u instanceof Estudiante) {
			ventana = new Explorer
		} else if (u instanceof Organizacion) {
			
		} else {
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void visible(Boolean b) {
		ventana.setVisible(b);
	}

}
