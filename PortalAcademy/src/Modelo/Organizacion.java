package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Organizacion extends Usuario {

	private String sede;
	private List<Actividad> actividades;
	private static BD bd;

	public Organizacion(String nick, String correo, String password, String sede) {
		super(nick, correo, password);
		this.sede = sede;
		this.actividades = new ArrayList<Actividad>();
		bd = BD.getBD();
		bd.Insert("INSERT INTO Organizacion (nick,sede) VALUES ('" + this.getNick() + "','" + this.getSede() + "')");
		bd.finalize();
	}

	public Organizacion(String nick) {
		super(nick);
	}

	public List<Actividad> getActividades() {
		if (actividades == null) {
			bd = BD.getBD();
			List<Object[]> actividades = bd
					.Select("SELECT idActividad FROM Actividad WHERE nickOrganizacion = '" + this.getNick() + "'");
			bd.finalize();
			for (Object[] o : actividades) {
				this.actividades.add(new Actividad(Integer.parseInt(o[0].toString())));
			}
		}
		return this.actividades;
	}

	public String getSede() {
		if (sede == null) {
			bd = BD.getBD();
			Object[] user = bd.Select("SELECT * FROM Organizacion WHERE Organizacion.nick = '" + this.getNick() + "'")
					.get(0);
			bd.finalize();
			this.sede = user[1].toString();
		}
		return sede;
	}
	
	
	@Override
	public void eliminarUsuario() {
		super.eliminarUsuario();
		sede = null;
		actividades = null;
	}

}
