package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Usuario {

	private Telefono telefono;
	private List<Curso> cursos;
	private BD bd;

	public Profesor(String nick, String correo, String password, Telefono telefono) {
		super(nick, correo, password);
		this.telefono = telefono;
		this.cursos = new ArrayList<Curso>();
		bd = BD.getBD();
		bd.Insert("INSERT INTO Profesor (nick, codigoTelefono, numeroTelefono) VALUES ( '" + this.getNick() + "', "
				+ this.getTelefono().getCodigo() + ",'" + this.getTelefono().getNumero() + "')");
		bd.finalize();
	}

	public Profesor(String nick) {
		super(nick);

		bd = BD.getBD();
		Object[] user = bd.Select("SELECT * FROM Profesor WHERE Profesor.nick = '" + nick + "'").get(0);
		bd.finalize();
		this.telefono = new Telefono(Integer.parseInt(user[1].toString()), user[2].toString());
	
		bd = BD.getBD();
		List<Object[]> cursos = bd.Select("SELECT * FROM Curso WHERE nickProfesor = '" + this.getNick() + "'");
		bd.finalize();
		for (Object[] o : cursos) {
			this.cursos.add(new Curso((int) o[0]));
		}
		
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public Telefono getTelefono() {
		return this.telefono;
	}
}
