package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Organizacion extends Usuario {

	private String sede;
	private List<Actividad> actividades;
	
	public Organizacion (String nick, String correo, String password, String sede) {
		super(nick,correo,password);
		this.sede = sede;
		this.actividades = new ArrayList<Actividad>();
	}
	
	public Organizacion (String idOrganizacion) {
		super(idOrganizacion);
		
		//ACCESO BASEDATOS PARA OBTENER INFO ORGANIZACION
		String sede;	
		this.sede = sede;
		
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
		//ACCESO BASEDATOS PARA AÑADIR ACTIVIDAD A LA ORGANIZACION
	}
	
	public void eliminarActividad(Actividad actividad) {
		actividades.remove(actividad);
		//ACCESO BASEDATOS PARA ELIMINAR ACTIVIDAD DE LA ORGANIZACION
	}
	
	public String getSede() {
		return sede;
	}
}
