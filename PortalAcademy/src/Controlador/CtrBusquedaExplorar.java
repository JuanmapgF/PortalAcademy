package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Vista.Explorar;

public class CtrBusquedaExplorar implements KeyListener {
	
	private Explorar ventana;
	
	public CtrBusquedaExplorar(Explorar v) {
		ventana = v;
		ventana.controladorBusqueda(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == ventana.busquedaCurso) {
			if (ventana.esInvitado()) {
				ventana.cargarCursosInvitado(ventana.getBusquedaCurso());
			} else {
				ventana.cargarCursosUsuario(ventana.getBusquedaCurso());
			}
		}

		if (e.getSource() == ventana.busquedaActividad) {
			if (ventana.esInvitado()) {
				ventana.cargarActividadesInvitado(ventana.getBusquedaActividad());
			} else {
				ventana.cargarActividadesUsuario(ventana.getBusquedaActividad());
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
