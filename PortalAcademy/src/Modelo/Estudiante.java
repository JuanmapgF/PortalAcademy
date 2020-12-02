package Modelo;

import java.util.List;

public class Estudiante extends Usuario {
	
	private List<Curso> cursos;
	private List<Actividad> actividades;
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public List<Actividad> getActividades() {
		return actividades;
	}
	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

}
