package Controlador;

import java.awt.event.*;

import Vista.*;
import Modelo.*;

public class CtrDescripcionCurso implements ActionListener {
	private Usuario user;
	private Curso curso;
	
	private DescripcionCurso ventana;
	
	public CtrDescripcionCurso(Usuario user, Curso curso) {
		this.user = user;
		this.curso = curso;
		ventana = new DescripcionCurso(curso.getNombre(), curso.getDescripcion());
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("Unirse")) {
			curso.addEstudiante(user);
		}
	}
	
}
