package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Curso;
import Vista.CrearCurso;
import Vista.Main;
import Vista.MisCursos;

public class CtrMisCursos implements ActionListener {

	private MisCursos ventana;

	public CtrMisCursos(MisCursos v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("CREARCURSO")) {
			CtrCrearCurso ccc = new CtrCrearCurso(new CrearCurso());
			Main.setPanel(ccc.getPanel());
		}

		if (e.getActionCommand().equals("VERCURSO")) {
			Curso c = ventana.getCurso();
			if (c != null) {
				if (ventana.esEstudiante()) {
					CtrInformacionCurso cr = new CtrInformacionCurso(ventana.getEstudiante(), c);
					Main.setPanel(cr.getPanel());
				} else {
					CtrInformacionCurso cr = new CtrInformacionCurso(ventana.getProfesor(), c);
					Main.setPanel(cr.getPanel());
				}
			}
		}

		if (e.getActionCommand().equals("VERCURSOA")) {
			Curso c = ventana.getCursoProfesor();
			if (c != null) {
				if (ventana.esProfesor()) {
					CtrInformacionCurso cr = new CtrInformacionCurso(ventana.getProfesor(), c);
					Main.setPanel(cr.getPanel());
				}
			}
		}

	}

	public JPanel getPanel() {
		return ventana;
	}

	public void visible(Boolean b) {
		ventana.setVisible(b);
	}
}
