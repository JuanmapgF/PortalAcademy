package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Curso;
import Modelo.Usuario;
import Vista.InformacionCurso;

public class CtrInformacionCurso implements ActionListener {

	private InformacionCurso ventana;

	public CtrInformacionCurso(Usuario user, Curso curso) {
		ventana = new InformacionCurso(user, curso);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public JPanel getPanel() {
		return ventana;
	}

}
