package Modelo;

import java.util.List;

public class Curso {
	
	private static String server;
	private static String databaseName;

	private Integer idCurso;
	private String nombre;
	private String descripcion;
	private String imagen;
	private Boolean publico;
	private Integer aforo;
	private Boolean presencial;
	private List<Usuario> estudiantes;
	private Boolean tieneForo;
	private Profesor profesor;
	private Foro foro;
	
	
	
	public Curso(String nombre, String descripcion, String imagen, Boolean publico, Integer aforo, Boolean presencial, Boolean tieneForo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.publico = publico;
		this.aforo = aforo;
		this.presencial = presencial;
		this.tieneForo = tieneForo;

	}

	public Curso(Integer idCurso) {
		BD miBD = new BD(server, databaseName);
		List<Object[]> datos = miBD.Select("SELECT * FROM Curso WHERE idCurso = " + idCurso);
		this.nombre = datos.get(0);
		this.descripcion = datos.get(1);
		this.imagen = datos.get(2);
		this.publico = datos.get(3);
		this.aforo = datos.get(4);
		this.presencial = datos.get(5);
		this.tieneForo = datos.get(6);
		
		this.profesor = new Profesor(datos.get(7));
		this.foro = new Foro(datos.get(8));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getPublico() {
		return publico;
	}

	public void setPublico(Boolean publico) {
		this.publico = publico;
	}

	public Integer getAforo() {
		return aforo;
	}

	public void setAforo(Integer aforo) {
		this.aforo = aforo;
	}

	public Boolean getPresencial() {
		return presencial;
	}

	public void setPresencial(Boolean presencial) {
		this.presencial = presencial;
	}

	public List<Usuario> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Usuario> estudiantes) {
		this.estudiantes = estudiantes;
	}
}
