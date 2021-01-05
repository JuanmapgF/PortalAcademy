package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Curso;
import Modelo.Profesor;
import Modelo.Usuario;
import Vista.EditarCurso;
import Vista.EditarParticipantes;
import Vista.Main;
import Vista.MisCursos;

public class CtrEditarParticipantes implements ActionListener {

	private EditarParticipantes ventana;
	private Usuario usuario;
	private Profesor profesor;
	private Curso curso;

	public CtrEditarParticipantes (EditarParticipantes v) {
		ventana = v;
		ventana.controlador(this);
		curso = ventana.getCurso();
		usuario = ventana.getUsuario();
		profesor = ventana.getProfesor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("ELIMINAR")) {
			curso.eliminarUsuario(usuario);
			JOptionPane.showMessageDialog(ventana, "Se ha eliminado al usuario del curso correctamente");
			CtrEditarParticipantes c = new CtrEditarParticipantes(new EditarParticipantes(curso, profesor));
			Main.setPanel(c.getPanel());
		}
		
		if (e.getActionCommand().equals("VOLVER")) {
			CtrInformacionCurso c = new CtrInformacionCurso(profesor, curso);
			Main.setPanel(c.getPanel());
		}
	}

	public JPanel getPanel() {
		return ventana;
	}
}
