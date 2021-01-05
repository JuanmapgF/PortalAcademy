package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Curso;
import Modelo.Profesor;
import Vista.EditarCurso;
import Vista.EditarParticipantes;
import Vista.Main;
import Vista.MisCursos;

public class CtrEditarParticipantes implements ActionListener {

	private EditarParticipantes ventana;
	private Curso curso;
	private Profesor profesor;

	public CtrEditarParticipantes (EditarParticipantes v) {
		ventana = v;
		ventana.controlador(this);
		curso = ventana.getC();
		profesor = ventana.getUsuario();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO (Juanma) Añadir el cambio de la imagen.

		if (e.getActionCommand().equals("GUARDAR")) {
			if (ventana.getAforo() > 0) {
				curso.setAforo(ventana.getAforo());
				curso.setDescripcion(ventana.getDescripcion());
				curso.setNombre(ventana.getNombre());
				curso.setPresencial(ventana.getPresencial());
				curso.setPublico(ventana.getPublico());
				curso.setTieneForo(ventana.getForo());

				JOptionPane.showMessageDialog(ventana, "Se ha actualizado la información del curso correctamente");

				CtrInformacionCurso c = new CtrInformacionCurso(profesor, curso);
				Main.setPanel(c.getPanel());
			} else {
				JOptionPane.showMessageDialog(ventana, "El aforo debe ser un entero positivo");
			}
		}

		if (e.getActionCommand().equals("ELIMINAR")) {
			curso.eliminarCurso();
			CtrMisCursos c = new CtrMisCursos(new MisCursos(profesor));
			Main.setPanel(c.getPanel());
			JOptionPane.showMessageDialog(ventana, "Se ha eliminado al usuario del curso correctamente");
		}

		if (e.getActionCommand().equals("VOLVER")) {
				CtrInformacionCurso c = new CtrInformacionCurso(profesor, curso);
				Main.setPanel(c.getPanel());
			}
		}


	}

	public JPanel getPanel() {
		return ventana;
	}
}
