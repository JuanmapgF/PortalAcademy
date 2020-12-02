package Modelo;

import java.util.List;

public class Profesor extends Usuario {
	
	private String telefono;
	private List<Curso> cursos;

	public Profesor(String idProfesor) {
		
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
