package Modelo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario {

	private static BD bd;

	public Estudiante(String nick, String correo, String password) {
		super(nick, correo, password);
		bd = BD.getBD();
		bd.Insert("INSERT INTO Estudiante (nick) VALUES ('" + this.getNick() + "')");
		bd.finalize();
	}

	public Estudiante(String nick) throws ParseException {
		super(nick);
	}

	public List<Curso> getCursos() {
		List<Curso> c = new ArrayList<Curso>();
		bd = BD.getBD();
		List<Object[]> cursos = bd.Select("SELECT * FROM RelCursoUsuario WHERE nickUsuario = '" + this.getNick() + "'");
		BD.contadorFinalize(cursos.size() + 1);
		bd.finalize();
		for (Object[] o : cursos) {
			c.add(new Curso((int) o[1]));
		}
		return c;
	}

	public void anadirCurso(Curso curso) {
		bd = BD.getBD();
		bd.Insert("INSERT INTO RelCursoUsuario (nickUsuario,idCurso) VALUES ('" + this.getNick() + "'," + curso.getId()
				+ ")");
		bd.finalize();
	}

	public void eliminarCurso(Curso curso) {
		bd = BD.getBD();
		bd.Delete("DELETE FROM RelCursoUsuario WHERE idCurso = " + curso.getId());
		bd.finalize();
	}

	public List<Actividad> getActividades() {
		List<Actividad> ac = new ArrayList<Actividad>();
		bd = BD.getBD();
		List<Object[]> actividades = bd
				.Select("SELECT * FROM RelActividadUsuario WHERE nickUsuario = '" + this.getNick() + "'");
		BD.contadorFinalize(actividades.size() + 1);
		bd.finalize();
		for (Object[] e : actividades) {
			ac.add(new Actividad((int) e[1]));
		}
		return ac;
	}

	public void anadirActividad(Actividad actividad) {
		bd = BD.getBD();
		bd.Insert("INSERT INTO RelActividadUsuario (nickUsuario,idActividad) VALUES ('" + this.getNick() + "',"
				+ actividad.getId() + ")");
		bd.finalize();
	}

	public void eliminarActividad(Actividad actividad) {
		bd = BD.getBD();
		bd.Delete("DELETE FROM RelActividadUsuario WHERE idActividad = " + actividad.getId());
		bd.finalize();
	}

	public Boolean estaEnCurso(Curso curso) {
		return getCursos().contains(curso);
	}

	public Boolean estaEnActividad(Actividad actividad) {
		return getActividades().contains(actividad);

	}

	@Override
	public void eliminarUsuario() {
		super.eliminarUsuario();
	}

	@Override
	public void setPassword(String p) {
		super.setPassword(p);
	}
}
