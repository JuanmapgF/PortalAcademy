package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.Curso;
import Modelo.ErrorBD;
import Modelo.Profesor;
import Vista.CrearCurso;
import Vista.Main;

public class CtrCrearCurso implements ActionListener {

	private CrearCurso vista;
	private Profesor profesor;

	public CtrCrearCurso(CrearCurso v) {
		vista = v;
		profesor = new Profesor(Main.getUser().getNick());
		vista.btnCrearCurso.addActionListener(this);
		vista.btnCancelar.addActionListener(this);
		vista.btnCerrarSesion.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.btnCrearCurso) {
			try {
				if (!nombreValido()) {
					throw new ErrorBD("El nombre no puede estar vac�o.");
				}
				if (!descripcionValida()) {
					throw new ErrorBD("La descripci�n no puede estar vac�a.");
				}
				if (!aforoValido()) {
					throw new ErrorBD("El aforo debe ser un n�mero mayor que 0");
				}

				Curso curso = new Curso(vista.textFieldNombre.getText(), vista.textAreaDescripcion.getText(),
						vista.textFieldImagen.getText(), getPublico(),
						Integer.parseInt(vista.spinnerAforo.getValue().toString()), getPresencial(), getTieneForo(),
						profesor);

				JOptionPane.showMessageDialog(vista,
						"El curso " + curso.getNombre() + " ha sido creado satisfactoriamente.", "Curso creado",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (ErrorBD err) {
				JOptionPane.showMessageDialog(vista, err.getMessage(), "Error crear curso", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == vista.btnCancelar) {
			// Hasta que no est� bien explorar
		}

		if (e.getSource() == vista.btnCerrarSesion) {
			// ?
		}

	}

	private Boolean getTieneForo() {
		return vista.chckbxForo.isSelected();
	}

	private Boolean getPresencial() {
		return vista.rdbtnPresencial.isSelected();
	}

	private Boolean getPublico() {
		return vista.rdbtnPublico.isSelected();
	}

	private boolean aforoValido() {
		return Integer.parseInt(vista.spinnerAforo.getValue().toString()) > 0;
	}

	private boolean descripcionValida() {
		return !(vista.textFieldImagen.getText().isEmpty() || vista.textFieldImagen.getText() == null);
	}

	private boolean nombreValido() {
		return !(vista.textFieldNombre.getText().isEmpty() || vista.textFieldNombre.getText() == null);
	}

}
