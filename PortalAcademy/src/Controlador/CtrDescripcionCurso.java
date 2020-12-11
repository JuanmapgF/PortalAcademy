package Controlador;

import java.awt.event.*;

import Vista.*;
import Modelo.*;

public class CtrDescripcionCurso implements ActionListener {
	private Usuario user;
	private Curso curso;
	
	private DescripcionCurso ventana;
	
	public CtrDescripcionCurso(Usuario user, Curso curso, Boolean puedeUnirse) {
		this.user = user;
		this.curso = curso;
		Boolean esInvitado = user == null;
		Boolean esEstudiante = user != null && user instanceof Estudiante;
		Boolean esCursoPublico = curso.getPublico();
		Boolean quedaEspacio = curso.getAforo() < curso.getEstudiantes().size();
		Boolean estaEnCurso;
		if (esEstudiante) {
			estaEnCurso = ((Estudiante) user).getCursos().contains(curso);
		} else {
			estaEnCurso = false;
		}
		Boolean usuarioPuedeUnirse = (esInvitado && esCursoPublico || esEstudiante) && quedaEspacio && !estaEnCurso;
		ventana = new DescripcionCurso(curso.getNombre(), curso.getDescripcion(), usuarioPuedeUnirse);
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
