package Modelo;

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
	
	public Organizacion (String nick) {
		super(nick);
		bd = BD.getBD();
		Object [] user = bd.Select("SELECT * FROM Organizacion WHERE Organizacion.nick = '" + nick + "'").get(0);
		bd.finalize();
		this.sede = user[1].toString();
		
		List<Actividad> c = new ArrayList<Actividad>();
		//ACCESO BASEDATOS PARA OBTENER ACTIVIDADES DE LA ORGANIZACION
		Actividad acti;
		c.add(acti);
		for(Actividad cu : c) {
			actividades.add(cu);
		}
	}
	
	public List<Actividad> getActividades() {
		return this.actividades;
	}

	public void anadirActividad(Actividad actividad) {
		actividades.add(actividad);
		//ACCESO BASEDATOS PARA A�ADIR ACTIVIDAD A LA ORGANIZACION
	}
	
	public void eliminarActividad(Actividad actividad) {
		actividades.remove(actividad);
		//ACCESO BASEDATOS PARA ELIMINAR ACTIVIDAD DE LA ORGANIZACION
	}
	
	public String getSede() {
		return sede;
	}
	
}
