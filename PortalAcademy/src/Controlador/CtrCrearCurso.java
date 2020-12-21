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
import Modelo.Profesor;
import Vista.Ajustes;
import Vista.CrearCurso;
import Vista.Explorar;
import Vista.Main;
import Vista.MisCursos;

public class CtrCrearCurso implements ActionListener {

	private CrearCurso vista;
	private Profesor profesor;
	private File imagen;

	public CtrCrearCurso(CrearCurso v) {
		vista = v;
		profesor = new Profesor(Main.getUser().getNick());
		vista.btnCrearCurso.addActionListener(this);
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
						vista.fileChooserImagen.getSelectedFile(), getPublico(),
						Integer.parseInt(vista.spinnerAforo.getValue().toString()), getPresencial(), getTieneForo(),
						profesor);

				JOptionPane.showMessageDialog(vista,
						"El curso " + curso.getNombre() + " ha sido creado satisfactoriamente.", "Curso creado",
						JOptionPane.INFORMATION_MESSAGE);
				CtrInformacionCurso cic = new CtrInformacionCurso(profesor, curso);
				Main.setPanel(cic.getPanel());
			} catch (ErrorBD err) {
				JOptionPane.showMessageDialog(vista, err.getMessage(), "Error crear curso", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == vista.btnCancelar) {
			CtrMisCursos cmc = new CtrMisCursos(new MisCursos(profesor));
			Main.setPanel(cmc.getPanel());
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
		return !(vista.textAreaDescripcion.getText().isEmpty() || vista.textAreaDescripcion.getText() == null);
	}

	private boolean nombreValido() {
		return !(vista.textFieldNombre.getText().isEmpty() || vista.textFieldNombre.getText() == null);
	}

	public JPanel getPanel() {
		return vista;
	}

}
