package Controlador;


import javax.swing.JPanel;

import Modelo.Curso;
import Modelo.Usuario;
import Vista.InformacionCurso;

public class CtrInformacionCurso {

	private InformacionCurso ventana;

	public CtrInformacionCurso(Usuario user, Curso curso) {
		ventana = new InformacionCurso(user, curso);
	}


	public JPanel getPanel() {
		return ventana;
	}

}
