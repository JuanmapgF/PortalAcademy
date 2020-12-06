package Modelo;

import java.util.Date;
import java.util.List;

public class Actividad {
	
	private String nombre;
	private String descripcion;
	private String imagen;
	private int aforo;
	private Date fecha;
	private String lugar;
	
	private List<Usuario> participantes;
	private Organizacion organizacion;
	
	private static String server;
	private static String databaseName;
	private static String user;
	private static String password;
	
	public Actividad(String nombre, String descripcion, String imagen, int aforo, Date fecha, String lugar) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.aforo = aforo;
		this.fecha = fecha;
		this.lugar = lugar;
	}

	public Actividad(Integer idActividad) {
		BD miBD = new BD(server, databaseName, user, password);
		List<Object[]> datos = miBD.Select("SELECT * FROM Curso WHERE idActividad = " + idActividad);
		Object[] aux = datos.get(0);
		this.nombre = aux[0].toString();
		this.descripcion = aux[1].toString();
		this.imagen = aux[2].toString();
		this.aforo = Integer.parseInt(aux[4].toString());
		//this.fecha = Date.parse((aux[5].toString());
		this.lugar = aux[6].toString();
	}
	

	public static String getServer() {
		return server;
	}

	public static void setServer(String server) {
		Actividad.server = server;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		Actividad.user = user;
	}

	public static String getDatabaseName() {
		return databaseName;
	}

	public static void setDatabaseName(String databaseName) {
		Actividad.databaseName = databaseName;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Actividad.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}
	
	public String ToString() {
		return nombre;
	}
}
