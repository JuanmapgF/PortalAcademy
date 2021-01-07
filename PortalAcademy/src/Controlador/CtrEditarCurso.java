package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Curso;
import Modelo.ErrorBD;
import Modelo.Profesor;
import Vista.EditarCurso;
import Vista.Main;
import Vista.MisCursos;

public class CtrEditarCurso implements ActionListener {

	private EditarCurso ventana;
	private Curso curso;
	private Profesor profesor;
	private File imagen;

	public CtrEditarCurso(EditarCurso v) {
		ventana = v;
		ventana.controlador(this);
		curso = ventana.getC();
		profesor = ventana.getUsuario();
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
					throw new ErrorBD("El nombre no puede estar vacï¿½o.");
				}
				if (!descripcionValida()) {
					throw new ErrorBD("La descripciï¿½n no puede estar vacï¿½a.");
				}
				if (!aforoValido()) {
					throw new ErrorBD("El aforo debe ser un nï¿½mero mayor que 0");
				}

				curso.setAforo(ventana.getAforo());
				curso.setDescripcion(ventana.getDescripcion());
				curso.setNombre(ventana.getNombre());
				curso.setPresencial(ventana.getPresencial());
				curso.setPublico(ventana.getPublico());
				curso.setTieneForo(ventana.getForo());
				curso.setImagen(imagen);

				CtrInformacionCurso c = new CtrInformacionCurso(profesor, curso);
				Main.setPanel(c.getPanel());
			} catch (ErrorBD err) {
				JOptionPane.showMessageDialog(ventana, err.getMessage(), "Editar curso", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getActionCommand().equals("ELIMINAR")) {
			curso.eliminarCurso();
			CtrMisCursos c = new CtrMisCursos(new MisCursos(profesor));
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("VOLVER")) {
			int res = JOptionPane.showConfirmDialog(ventana, "¿Salir sin guardar?");

			if (res == 0) {
				CtrInformacionCurso c = new CtrInformacionCurso(profesor, curso);
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("PUBLICO")) {
			ventana.setPublico(true);
			ventana.setPrivado(false);
		}

		if (e.getActionCommand().equals("PRIVADO")) {
			ventana.setPublico(false);
			ventana.setPrivado(true);
		}

		if (e.getActionCommand().equals("PRESENCIAL")) {
			ventana.setPresencial(true);
			ventana.setOnline(false);
		}

		if (e.getActionCommand().equals("ONLINE")) {
			ventana.setPresencial(false);
			ventana.setOnline(true);
		}
	}

	public JPanel getPanel() {
		return ventana;
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
