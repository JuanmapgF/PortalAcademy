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
	}

	@Override
	public void keyPressed(KeyEvent e) {
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
	public void keyReleased(KeyEvent e) {
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

}
