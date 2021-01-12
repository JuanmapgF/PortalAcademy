package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Modelo.Curso;
import Modelo.Profesor;
import Modelo.Usuario;
import Vista.EditarCurso;
import Vista.EditarParticipantes;
import Vista.InformacionCurso;
import Vista.Main;

public class CtrInformacionCurso implements ActionListener {
	private Usuario user;
	private Curso curso;

	private InformacionCurso ventana;

	public CtrInformacionCurso(Usuario user, Curso curso) {
		this.user = user;
		this.curso = curso;
		ventana = new InformacionCurso(user, curso);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		
		
		
	}

	public JPanel getPanel() {
		return ventana;
	}

}
