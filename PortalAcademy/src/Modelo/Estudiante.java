package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario {
	
	private List<Curso> cursos;
	private List<Actividad> actividades;
	private BD bd;
	
	public Estudiante(String nick, String correo, String password) {
		super(nick,correo,password);
		this.actividades = new ArrayList<Actividad>();
		this.cursos = new ArrayList<Curso>();
		bd = BD.getBD();
		bd.Insert("INSERT INTO Estudiante (nick) VALUES ('"+this.getNick() + "')");
		bd.finalize();
	}
	
	
	public Estudiante (String nick) {
		super(nick);
		
		List<Curso> c = new ArrayList<Curso>();
		//ACCESO BASEDATOS PARA OBTENER CURSOS DEL ESTUDIANTE
		Curso curso;
		c.add(curso);
		for(Curso cu : c) {
			cursos.add(cu);
		}
		
		List<Actividad> ca = new ArrayList<Actividad>();
		//ACCESO BASEDATOS PARA OBTENER ACTIVIDADES DEL ESTUDIANTE
		Actividad activ;
		ca.add(activ);
		for(Actividad ct : ca) {
			actividades.add(ct);
		}
	}
	
	

	

	public List<Curso> getCursos() {
		return this.cursos;
	}
	
	public void anadirCurso(Curso curso) {
		cursos.add(curso);
		//ACCESO BASEDATOS PARA AÑADIR CURSO AL ESTUDIANTE
	}
	
	public void eliminarCurso(Curso curso) {
		cursos.remove(curso);
		//ACCESO BASEDATOS PARA ELIMINAR CURSO DEL ESTUDIANTE
	}
	
	public List<Actividad> getActividades() {
		return this.actividades;
	}
	
	public void anadirActividad(Actividad actividad) {
		actividades.add(actividad);
		//ACCESO BASEDATOS PARA AÑADIR ACTIVIDAD AL ESTUDIANTE
	}
	
	public void eliminarActividad(Actividad actividad) {
		actividades.remove(actividad);
		//ACCESO BASEDATOS PARA ELIMINAR ACTIVIDAD DEL ESTUDIANTE
	}
	

}
