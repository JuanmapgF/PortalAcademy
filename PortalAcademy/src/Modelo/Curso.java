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
		if (tieneForo) {
			this.idCurso = miBD.crearCurso(nombre, descripcion, imagen, publico, aforo, presencial, tieneForo, profesor, new Foro(), estudiantes);
		} else {
			this.idCurso = miBD.crearCurso(nombre, descripcion, imagen, publico, aforo, presencial, tieneForo, profesor, estudiantes);
		}
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.publico = publico;
		this.aforo = aforo;
		this.presencial = presencial;
		this.tieneForo = tieneForo;
		
		this.profesor = profesor;
		this.estudiantes = estudiantes;
	}

	public Curso(Integer idCurso) {
		Conexion miBD = ConexionJDBC.getInstance();
		Object[] lista = miBD.obtenerCurso(idCurso);
		
		this.idCurso = Integer.parseInt(lista[0].toString());
		this.nombre = lista[1].toString();
		this.descripcion = lista[2].toString();
		this.imagen = lista[3].toString();
		this.publico = Boolean.parseBoolean(lista[4].toString());
		this.aforo = Integer.parseInt(lista[5].toString());
		this.presencial = Boolean.parseBoolean(lista[6].toString());
		this.tieneForo = Boolean.parseBoolean(lista[7].toString());
		
		this.profesor = new Profesor(lista[8].toString());
		if(this.tieneForo) {
			this.foro = new Foro(Integer.parseInt(lista[9].toString()));
		} else {
			this.foro = null;
		}
		
		List<Object[]> datos = miBD.Select("SELECT * FROM RelCursoEstudiante WHERE idCurso = " + idCurso);
		for (Object[] o : datos) {
			this.estudiantes.add(new Estudiante(o[1]));
		}
	}

	public Integer getId() {
		return idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		Conexion miBD = ConexionJDBC.getInstance();
		miBD.cambiarNombreCurso(nombre, this.idCurso);
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		Conexion miBD = ConexionJDBC.getInstance();
		miBD.cambiarDescripcionCurso(descripcion, this.idCurso);
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		Conexion miBD = ConexionJDBC.getInstance();
		miBD.cambiarImagenCurso(imagen, this.idCurso);
		this.imagen = imagen;
	}

	public Boolean getPublico() {
		return publico;
	}

	public void setPublico(Boolean publico) {´
		Conexion miBD = ConexionJDBC.getInstance();
		miBD.cambiarPrivacidadCurso(publico, this.idCurso);
		this.publico = publico;
	}

	public Integer getAforo() {
		return aforo;
	}

	public void setAforo(Integer aforo) {
		Conexion miBD = ConexionJDBC.getInstance();
		miBD.cambiarAforoCurso(aforo, this.idCurso);
		this.aforo = aforo;
	}

	public Boolean getPresencial() {
		return presencial;
	}

	public void setPresencial(Boolean presencial) {
		Conexion miBD = ConexionJDBC.getInstance();
		miBD.cambiarModalidadCurso(presencial, this.idCurso);
		this.presencial = presencial;
	}

	public List<Usuario> getEstudiantes() {
		return estudiantes;
	}
	
	public void addEstudiante(Usuario estudiante) {
		this.estudiantes.add(estudiante);
	}

	public Boolean getTieneForo() {
		return tieneForo;
	}

	public void setTieneForo(Boolean tieneForo) {
		Conexion miBD = ConexionJDBC.getInstance();
		miBD.cambiarTieneForoCurso(nombre, this.idCurso);
		this.tieneForo = tieneForo;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public Foro getForo() {
		return foro;
	}
}
