package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Usuario {
	
	private int telefono;
	private List<Curso> cursos;
	
	public Profesor(String nick, String correo, String password, int telefono) {
		super(nick,correo,password);
		this.telefono = telefono;
		this.cursos = new ArrayList<Curso>();
	}
	
	public Profesor(String idProfesor) {
		super(idProfesor);
		
		//ACCESO BASEDATOS PARA OBTENER INFO PROFESOR
		int telefono;	
		this.telefono = telefono;
		
		List<Curso> c = new ArrayList<Curso>();
		//ACCESO BASEDATOS PARA OBTENER CURSOS DEL PROFESOR
		Curso curso;
		c.add(curso);
		for(Curso cu : c) {
			cursos.add(cu);
		}
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void anadirCurso(Curso curso) {
		cursos.add(curso);
		//ACCESO BASEDATOS PARA AÑADIR CURSO AL PROFESOR
	}
	
	public void eliminarCurso(Curso curso) {
		cursos.remove(curso);
		//ACCESO BASEDATOS PARA ELIMINAR CURSO DEL PROFESOR
	}

	public int getTelefono() {
		return this.telefono;
	}
}
