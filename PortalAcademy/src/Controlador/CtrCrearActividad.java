package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.ErrorBD;
import Modelo.Organizacion;
import Vista.CrearActividad;
import Vista.Main;
import Vista.MisActividades;

public class CtrCrearActividad implements ActionListener {

	private CrearActividad vista;
	private Organizacion organizacion;
	private File imagen;

	public CtrCrearActividad(CrearActividad v) {
		vista = v;
		organizacion = new Organizacion(Main.getUser().getNick());
		vista.btnCrearActividad.addActionListener(this);
		vista.btnCancelar.addActionListener(this);
		vista.btnSeleccionar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.btnSeleccionar) {
			if (vista.fileChooserImagen.showOpenDialog(vista.fileChooserImagen) == JFileChooser.APPROVE_OPTION) {
				imagen = vista.fileChooserImagen.getSelectedFile();
				vista.lblImagenSeleccionada.setText(imagen.getName());
			}
		}

		if (e.getSource() == vista.btnCrearActividad) {
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

				Actividad actividad = new Actividad(vista.textFieldNombre.getText(),
						vista.textAreaDescripcion.getText(), vista.fileChooserImagen.getSelectedFile(),
						Integer.parseInt(vista.spinnerAforo.getValue().toString()), vista.dateChooser.getDate(),
						vista.textFieldLugar.getText(), organizacion);
				// (Juanma) Comprobar el paso a la vista siguiente despues de crear
				// curso/actividad
				JOptionPane.showMessageDialog(vista,
						"La actividad " + actividad.getNombre() + " ha sido creada satisfactoriamente.",
						"Actividad creada", JOptionPane.INFORMATION_MESSAGE);
				CtrInformacionActividad cia = new CtrInformacionActividad(organizacion, Actividad.cogerId(organizacion));
				Main.setPanel(cia.getPanel());
			} catch (ErrorBD err) {
				JOptionPane.showMessageDialog(vista, err.getMessage(), "Error crear actividad",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == vista.btnCancelar) {
			CtrMisActividades cma = new CtrMisActividades(new MisActividades(organizacion));
			Main.setPanel(cma.getPanel());
		}

	}

	private boolean fechaValida() {
		return vista.dateChooser.getDate() != null;
	}

	private boolean aforoValido() {
		return Integer.parseInt(vista.spinnerAforo.getValue().toString()) > 0;
	}

	private boolean descripcionValida() {
		return !(vista.textAreaDescripcion.getText().isEmpty() || vista.textAreaDescripcion.getText() == null);
	}

	private boolean nombreValido() {
		return !(vista.textFieldNombre.getText().isEmpty() || vista.textFieldNombre.getText() == null);
	}

	public JPanel getPanel() {
		return vista;
	}

}
