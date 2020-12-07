package Modelo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Organizacion extends Usuario {

	private String sede;
	private List<Actividad> actividades;
	private BD bd;
	
	public Organizacion (String nick, String correo, String password, String sede) {
		super(nick,correo,password);
		this.sede = sede;
		this.actividades = new ArrayList<Actividad>();
		bd = BD.getBD();
		bd.Insert("INSERT INTO Organizacion (nick,sede) VALUES ('"+this.getNick() + "','"+this.getSede()+"')");
		bd.finalize();
	}
	
	public Organizacion (String nick) throws ParseException {
		super(nick);
		bd = BD.getBD();
		Object [] user = bd.Select("SELECT * FROM Organizacion WHERE Organizacion.nick = '" + nick + "'").get(0);
		bd.finalize();
		this.sede = user[1].toString();
		
		bd = BD.getBD();
		List<Object[]> actividades = bd.Select("SELECT * FROM Actividad WHERE nickOrganizacion = '" +nick+"'");
		for (Object[] o : actividades) {
			this.actividades.add(new Actividad((int) o[0]));
		}
		
	}
	
	public List<Actividad> getActividades() {
		return this.actividades;
	}
	
	public String getSede() {
		return sede;
	}
	
}
