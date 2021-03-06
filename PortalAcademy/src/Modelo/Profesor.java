package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Usuario {

	private Telefono telefono;
	private BD bd;

	public Profesor(String nick, String correo, String password, Telefono telefono) {
		super(nick, correo, password);
		this.telefono = telefono;
		bd = BD.getBD();
		bd.Insert("INSERT INTO Profesor (nick, codigoTelefono, numeroTelefono) VALUES ( '" + this.getNick() + "', "
				+ getTelefono().getCodigo() + ",'" + getTelefono().getNumero() + "')");
		bd.finalize();
	}

	public Profesor(String nick) {
		super(nick);
	}

	public Telefono getTelefono() {
		if(telefono == null) {
			bd = BD.getBD();
			Object[] user = bd.Select("SELECT * FROM Profesor WHERE Profesor.nick = '" + this.getNick() + "'").get(0);
			bd.finalize();
			this.telefono = new Telefono(Integer.parseInt(user[1].toString()), user[2].toString());
		}
		return this.telefono;
	}

	public List<Curso> getCursosImpartidos() {
		List<Curso> c = new ArrayList<Curso>();
		bd = BD.getBD();
		List<Object[]> cursos = bd.Select("SELECT * FROM Curso WHERE nickProfesor = '" + this.getNick() + "'");
		BD.contadorFinalize(cursos.size() + 1);
		bd.finalize();
		for (Object[] o : cursos) {
			c.add(new Curso(Integer.parseInt(o[0].toString())));
		}
		return c;
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
	
	public List<Curso> getCursosApuntados(){
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
	
	public Boolean estaEnCurso(Curso curso) {
		return getCursosApuntados().contains(curso);
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
