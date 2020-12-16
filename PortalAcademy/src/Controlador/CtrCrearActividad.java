package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.ErrorBD;
import Modelo.Organizacion;
import Vista.CrearActividad;
import Vista.Explorar;
import Vista.Main;
import Vista.MisActividades;

public class CtrCrearActividad implements ActionListener {

	private CrearActividad vista;
	private Organizacion organizacion;

	public CtrCrearActividad(CrearActividad v) {
		vista = v;
		organizacion = new Organizacion(Main.getUser().getNick());
		vista.btnCrearActividad.addActionListener(this);
		vista.btnCancelar.addActionListener(this);
		vista.btnCerrarSesion.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

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
						vista.textAreaDescripcion.getText(), vista.textFieldImagen.getText(),
						Integer.parseInt(vista.spinnerAforo.getValue().toString()), vista.dateChooser.getDate(),
						vista.textFieldLugar.getText(), organizacion);

				JOptionPane.showMessageDialog(vista,
						"La actividad " + actividad.getNombre() + " ha sido creado satisfactoriamente.",
						"Actividad creada", JOptionPane.INFORMATION_MESSAGE);
				CtrInformacionActividad cia = new CtrInformacionActividad(organizacion, actividad);
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

		if (e.getSource() == vista.btnCerrarSesion) {
			CtrExplorar c = new CtrExplorar(
					new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
			Main.setPanel(c.getPanel());
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
