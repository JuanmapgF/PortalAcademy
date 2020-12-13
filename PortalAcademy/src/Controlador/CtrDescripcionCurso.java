package Controlador;

import java.awt.event.*;
import java.text.ParseException;

import javax.swing.JPanel;

import Vista.*;
import Modelo.*;

public class CtrDescripcionCurso implements ActionListener {
	private Usuario user;
	private Curso curso;
	
	private DescripcionCurso ventana;
	
	public CtrDescripcionCurso(Usuario user, Curso curso) {
		this.user = user;
		this.curso = curso;
		Boolean esInvitado = user == null;
		Boolean esEstudiante = user != null && user instanceof Estudiante;
		Boolean estaEnCurso;
		if (esEstudiante) {
			estaEnCurso = ((Estudiante) user).estaEnCurso(curso);
		} else {
			estaEnCurso = false;
		}
		Boolean usuarioPuedeUnirse = (esInvitado && curso.getPublico() || esEstudiante) && curso.quedanPlazas() && !estaEnCurso;
		ventana = new DescripcionCurso(curso.getNombre(), curso.getDescripcion(), usuarioPuedeUnirse);
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("Unirse")) {
			curso.addEstudiante(user);
			//TODO: Entramos en informacionCurso con su foro
		}
		
		if (e.getActionCommand().equals("Cerrar Sesi\u00F3n")) {
			try {
				CtrExplorar c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
				Main.setPanel(c.getPanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	public JPanel getPanel() {
		return ventana;
	}
	
}
