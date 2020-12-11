package Modelo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario {
	
	private List<Curso> cursos;
	private List<Actividad> actividades;
	private static BD bd;
	
	public Estudiante(String nick, String correo, String password) {
		super(nick,correo,password);
		this.actividades = new ArrayList<Actividad>();
		this.cursos = new ArrayList<Curso>();
		bd = BD.getBD();
		bd.Insert("INSERT INTO Estudiante (nick) VALUES ('"+this.getNick() + "')");
		bd.finalize();
	}
	
	
	public Estudiante (String nick) throws ParseException {
		super(nick);
		
		this.cursos = new ArrayList<Curso>();
		this.actividades = new ArrayList<Actividad>();
		
		bd = BD.getBD();
		List<Object[]> cursos = bd.Select("SELECT * FROM RelCursoUsuario WHERE nickUsuario = '" +nick+"'");
		for (Object[] o : cursos) {
			this.cursos.add(new Curso((int) o[1]));
		}

		bd = BD.getBD();
		List<Object[]> actividades = bd.Select("SELECT * FROM RelActividadUsuario WHERE nickUsuario = '" +nick+"'");
		for (Object[] e : actividades) {
			this.actividades.add(new Actividad((int) e[1]));
		}
	}
	

	public List<Curso> getCursos() {
		return this.cursos;
	}
	
	public void anadirCurso(Curso curso) {
		cursos.add(curso);
		bd = BD.getBD();
		bd.Insert("INSERT INTO RelCursoUsuario (nickUsuario,idCurso) VALUES ('"+this.getNick() + "',"+curso.getId()+")");
		bd.finalize();
	}
	
	public void eliminarCurso(Curso curso) {
		cursos.remove(curso);
		bd = BD.getBD();
		bd.Delete("DELETE FROM RelCursoUsuario WHERE idCurso = "+curso.getId());
		bd.finalize();
	}
	
	public List<Actividad> getActividades() {
		return this.actividades;
	}
	
	public void anadirActividad(Actividad actividad) {
		actividades.add(actividad);
		bd = BD.getBD();
		bd.Insert("INSERT INTO RelActividadUsuario (nickUsuario,idActividad) VALUES ('"+this.getNick() + "',"+actividad.getId()+")");
		bd.finalize();
	}
	
	public void eliminarActividad(Actividad actividad) {
		actividades.remove(actividad);
		bd = BD.getBD();
		bd.Delete("DELETE FROM RelActividadUsuario WHERE idActividad = "+actividad.getId());
		bd.finalize();
	}
	
	@Override
	public void eliminarUsuario() {
		super.eliminarUsuario();
		cursos = null;
		actividades = null;
	}
	

}
