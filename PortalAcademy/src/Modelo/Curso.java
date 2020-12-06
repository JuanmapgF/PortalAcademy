package Modelo;

import java.util.List;

public class Curso {
	private Integer idCurso;
	private String nombre;
	private String descripcion;
	private String imagen;
	private Boolean publico;
	private Integer aforo;
	private Boolean presencial;
		
	private Boolean tieneForo;
	private Profesor profesor;
	private Foro foro;
	private List<Usuario> estudiantes;
	
	public Curso(String nombre, String descripcion, String imagen, Boolean publico, Integer aforo,
			Boolean presencial, Boolean tieneForo, Profesor profesor, List<Usuario> estudiantes) {
		Conexion miBD = ConexionJDBC.getInstance();
		this.idCurso = miBD.crearCurso(nombre, descripcion, imagen, publico, aforo, presencial, tieneForo, profesor, new Foro(), estudiantes);
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.publico = publico;
		this.aforo = aforo;
		this.presencial = presencial;
		this.tieneForo = tieneForo;
		
		this.profesor = profesor;
		if (tieneForo) {
			this.foro = new Foro();
		}
		this.estudiantes = estudiantes.clone();
	}

	public Curso(Integer idCurso) {
		BD miBD = new BD(server, databaseName, user, pass);
		Object[] datos = miBD.Select("SELECT * FROM Curso WHERE idCurso = " + idCurso).get(0);
		this.nombre = datos[0].toString();
		this.descripcion = datos[1].toString();
		this.imagen = datos[2].toString();
		this.publico = Boolean.parseBoolean(datos[3].toString());
		this.aforo = Integer.parseInt(datos[4].toString());
		this.presencial = Boolean.parseBoolean(datos[5].toString());
		this.tieneForo = Boolean.parseBoolean(datos[6].toString());
		
		this.profesor = new Profesor(datos[7].toString());
		if(this.tieneForo) {
			this.foro = new Foro(Integer.parseInt(datos[8].toString()));
		} else {
			this.foro = null;
		}
		
		List<Object[]> datos2 = miBD.Select("SELECT * FROM RelCursoEstudiante WHERE idCurso = " + idCurso);
		for (Object[] o : datos2) {
			this.estudiantes.add(new Estudiante(o[1]));
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
	
	public void addEstudiante(Usuario estudiante) {
		this.estudiantes.add(estudiante);
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
	
	public static String getUser() {
		return user;
	}

	public static String getServer() {
		return server;
	}

	public static void setServer(String server) {
		Curso.server = server;
	}

	public static String getDatabaseName() {
		return databaseName;
	}

	public static void setDatabaseName(String databaseName) {
		Curso.databaseName = databaseName;
	}

	public static void setUser(String user) {
		Curso.user = user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Curso.password = password;
	}
}
