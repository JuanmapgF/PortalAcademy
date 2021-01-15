package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.ErrorBD;
import Modelo.Organizacion;
import Vista.EditarActividad;
import Vista.Main;
import Vista.MisActividades;

public class CtrEditarActividad implements ActionListener {

	private EditarActividad ventana;
	private Organizacion organizacion;
	private Actividad actividad;
	private File imagen;

	public CtrEditarActividad(EditarActividad v) {
		ventana = v;
		organizacion = ventana.getUsuario();
		actividad = ventana.getC();
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {


		if (e.getActionCommand().equals("SELECCIONAR")) {
			if (ventana.getFileChooserImagen()
					.showOpenDialog(ventana.getFileChooserImagen()) == JFileChooser.APPROVE_OPTION) {
				imagen = ventana.getFileChooserImagen().getSelectedFile();
				ventana.setLabelImagen(imagen.getName());
			}
		}

		if (e.getActionCommand().equals("GUARDAR")) {
			try {
				if (!nombreValido()) {
					throw new ErrorBD("El nombre no puede estar vacío.");
				}
				if (!descripcionValida()) {
					throw new ErrorBD("La descripción no puede estar vacía.");
				}
				if (!aforoValido()) {
					throw new ErrorBD("El aforo debe ser un número mayor que 0");
				}

				if (!fechaValida()) {
					throw new ErrorBD("La fecha debe ser asignada para algún día");
				}

				actividad.setAforo(ventana.getAforo());
				actividad.setDescripcion(ventana.getDescripcion());
				actividad.setNombre(ventana.getNombre());
				actividad.setFecha(ventana.getFecha());
				actividad.setLugar(ventana.getLugar());
				actividad.setImagen(imagen);

				JOptionPane.showMessageDialog(ventana, "Se ha actualizado la información del curso correctamente");

				CtrInformacionActividad c = new CtrInformacionActividad(organizacion, actividad);
				Main.setPanel(c.getPanel());

			} catch (ErrorBD err) {
				JOptionPane.showMessageDialog(ventana, err.getMessage(), "Editar actividad", JOptionPane.ERROR_MESSAGE);
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
				CtrInformacionActividad c = new CtrInformacionActividad(organizacion, actividad);
				Main.setPanel(c.getPanel());
			}
		}
	}

	public JPanel getPanel() {
		return ventana;
	}

	private boolean fechaValida() {
		return ventana.getFecha() != null;
	}

	private boolean aforoValido() {
		return Integer.parseInt(ventana.getAforo().toString()) > 0;
	}

	private boolean descripcionValida() {
		return !(ventana.getDescripcion().isEmpty() || ventana.getDescripcion() == null);
	}

	private boolean nombreValido() {
		return !(ventana.getNombre().isEmpty() || ventana.getNombre() == null);
	}
}
