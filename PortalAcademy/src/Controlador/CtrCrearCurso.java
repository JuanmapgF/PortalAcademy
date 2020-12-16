package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.ErrorBD;
import Modelo.Profesor;
import Vista.CrearCurso;
import Vista.Explorar;
import Vista.Main;
import Vista.MisCursos;

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
					throw new ErrorBD("El nombre no puede estar vacío.");
				}
				if (!descripcionValida()) {
					throw new ErrorBD("La descripción no puede estar vacía.");
				}
				if (!aforoValido()) {
					throw new ErrorBD("El aforo debe ser un número mayor que 0");
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
			CtrMisCursos cmc = new CtrMisCursos(new MisCursos(profesor));
			Main.setPanel(cmc.getPanel());
		}

		if (e.getSource() == vista.btnCerrarSesion) {
			try {
				CtrExplorar c = new CtrExplorar(
						new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
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
