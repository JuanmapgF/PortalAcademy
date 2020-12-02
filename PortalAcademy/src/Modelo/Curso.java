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
		Object[] aux = datos.get(0);
		this.nombre = aux[0].toString();
		this.descripcion = aux[1].toString();
		this.imagen = aux[2].toString();
		this.publico = Boolean.parseBoolean(aux[3].toString());
		this.aforo = Integer.parseInt(aux[4].toString());
		this.presencial = Boolean.parseBoolean(aux[5].toString());
		this.tieneForo = Boolean.parseBoolean(aux[6].toString());
		this.profesor = new Profesor(aux[7].toString());
		if(this.tieneForo) {
			this.foro = new Foro(Integer.parseInt(aux[8].toString()));
		} else {
			this.foro = null;
		}
	}

	public Integer getId() {
		return idCurso;
	}

	public void setId(Integer idCurso) {
		this.idCurso = idCurso;
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

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Boolean getTieneForo() {
		return tieneForo;
	}

	public void setTieneForo(Boolean tieneForo) {
		this.tieneForo = tieneForo;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Foro getForo() {
		return foro;
	}

	public void setForo(Foro foro) {
		this.foro = foro;
	}
}
