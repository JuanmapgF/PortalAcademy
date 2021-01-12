package Controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import Vista.Explorar;

public class CtrFocusBusqueda implements FocusListener {

	private Explorar ventana;

	public CtrFocusBusqueda(Explorar v) {
		ventana = v;
		ventana.controladorFocus(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == ventana.busquedaCurso) {
			if (ventana.busquedaCurso.getText().equals("Busca un curso")) {
				ventana.busquedaCurso.setText("");
				ventana.busquedaCurso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
				ventana.busquedaCurso.setForeground(Color.BLACK);
			}
		}

		if (e.getSource() == ventana.busquedaActividad) {
			if (ventana.busquedaActividad.getText().equals("Busca una actividad")) {
				ventana.busquedaActividad.setText("");
				ventana.busquedaActividad.setFont(new Font("Segoe UI", Font.PLAIN, 20));
				ventana.busquedaActividad.setForeground(Color.BLACK);
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == ventana.busquedaCurso) {
			if (ventana.busquedaCurso.getText().equals("")) {
				ventana.busquedaCurso.setText("Busca un curso");
				ventana.busquedaCurso.setFont(new Font("Segoe UI", Font.ITALIC, 20));
				ventana.busquedaCurso.setForeground(Color.GRAY);
			}
		}

		if (e.getSource() == ventana.busquedaActividad) {
			if (ventana.busquedaActividad.getText().equals("")) {
				ventana.busquedaActividad.setText("Busca una actividad");
				ventana.busquedaActividad.setFont(new Font("Segoe UI", Font.ITALIC, 20));
				ventana.busquedaActividad.setForeground(Color.GRAY);
			}
		}
	}

}
