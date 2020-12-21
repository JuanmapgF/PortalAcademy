package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Organizacion;
import Vista.Ajustes;
import Vista.EditarActividad;
import Vista.Explorar;
import Vista.Main;
import Vista.MisActividades;

public class CtrEditarActividad implements ActionListener {

	private EditarActividad ventana;
	private Organizacion organizacion;
	private Actividad actividad;

	public CtrEditarActividad(EditarActividad v) {
		ventana = v;
		organizacion = ventana.getUsuario();
		actividad = ventana.getC();
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("GUARDAR")) {
			if (ventana.getAforo() > 0) {
				actividad.setAforo(ventana.getAforo());
				actividad.setDescripcion(ventana.getDescripcion());
				actividad.setNombre(ventana.getNombre());
				actividad.setFecha(ventana.getFecha());
				actividad.setLugar(ventana.getLugar());

				JOptionPane.showMessageDialog(ventana, "Se ha actualizado la información del curso correctamente");

				CtrInformacionActividad c = new CtrInformacionActividad(organizacion, actividad);
				Main.setPanel(c.getPanel());
			} else {
				JOptionPane.showMessageDialog(ventana, "El aforo debe ser un entero positivo");
			}
		}

		if (e.getActionCommand().equals("ELIMINAR")) {
			actividad.eliminarActividad();
			CtrMisActividades c = new CtrMisActividades(new MisActividades(organizacion));
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("VOLVER")) {
			int res = JOptionPane.showConfirmDialog(ventana, "¿Salir sin guardar?");

			if (res == 0) {
				CtrMisActividades c = new CtrMisActividades(new MisActividades(organizacion));
				Main.setPanel(c.getPanel());
			}
		}
	}

	public JPanel getPanel() {
		return ventana;
	}

}
