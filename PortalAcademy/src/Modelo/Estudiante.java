package Modelo;

import java.text.ParseException;

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

	@Override
	public void eliminarUsuario() {
		super.eliminarUsuario();
	}

	@Override
	public void setPassword(String p) {
		super.setPassword(p);
	}
}
