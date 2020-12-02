package Modelo;

public class Curso {
	
	private Integer idCurso;
	private String nombre;
	private String descripcion;
	private String imagen;
	private Boolean publico;
	private Integer aforo;
	private Boolean presencial;
	private Boolean tieneForo;
	
	private Profesor idProfesor;
	private Foro idForo;
	
	private String server;
	private String databaseName;
	
	public Curso(String nombre, String descripcion, String imagen, Boolean publico, Integer aforo, Boolean presencial, Boolean tieneForo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.publico = publico;
		this.aforo = aforo;
		this.presencial = presencial;
		this.tieneForo = tieneForo;
		
		
		//
	}

	public Curso(Integer idCurso) {
		BD miBD = new BD(server, databaseName);
		List<Object[]> datos = miBD.Select("SELECT * FROM Curso WHERE idCurso = " + idCurso);
		this.nombre = datos[0];
		this.descripcion = datos[1];
		this.imagen = datos[2];
		this.publico = datos[3];
		this.aforo = datos[4];
		this.presencial = datos[5];
		this.tieneForo = datos[6];
		
		this.idProfesor = datos[7];
		this.idForo = datos[8];
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
}
