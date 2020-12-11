package Modelo;

import java.util.ArrayList;
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
	
	private List<Mensaje> mensajes;
	private Profesor profesor;
	private List<Usuario> estudiantes;
	
	public Curso(String nombre, String descripcion, String imagen, Boolean publico, Integer aforo,
			Boolean presencial, Boolean tieneForo, Profesor profesor) {
		BD miBD = BD.getBD();
		miBD.Insert("INSERT INTO Curso (nombre, descripcion, imagen, publico, aforo, presencial, tieneforo, nickProfesor)"
				+ "VALUES ('"+nombre+"','"+descripcion+"','"+imagen+"',"+publico+","+aforo+","+presencial+","+tieneForo+",'"+profesor.getNick()+")");
		miBD.finalize();
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.publico = publico;
		this.aforo = aforo;
		this.presencial = presencial;
		this.tieneForo = tieneForo;
		this.profesor = profesor;
		
		mensajes = new ArrayList<Mensaje>();
		estudiantes = new ArrayList<Usuario>();
		
	}

	public Curso(Integer idCurso) {
		BD miBD = BD.getBD();
		Object[] tupla = miBD.Select("SELECT * FROM Curso WHERE idCurso = " + idCurso).get(0);
		miBD.finalize();
		
		this.idCurso = Integer.parseInt(tupla[0].toString());
		this.nombre = tupla[1].toString();
		this.descripcion = tupla[2].toString();
		this.imagen = tupla[3].toString();
		this.publico = Boolean.parseBoolean(tupla[4].toString());
		this.aforo = Integer.parseInt(tupla[5].toString());
		this.presencial = Boolean.parseBoolean(tupla[6].toString());
		this.tieneForo = Boolean.parseBoolean(tupla[7].toString());
		
		mensajes = new ArrayList<Mensaje>();
		estudiantes = new ArrayList<Usuario>();
		
	}

	public Integer getId() {
		return idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET nombre = '"+nombre+"' WHERE idCurso = "+this.idCurso);
		miBD.finalize();
		this.nombre = nombre;	
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET descripcion = '"+descripcion+"' WHERE idCurso = "+this.idCurso);
		miBD.finalize();
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET imagen = '"+imagen+"' WHERE idCurso = "+this.idCurso);
		miBD.finalize();
		this.imagen = imagen;
	}

	public Boolean getPublico() {
		return publico;
	}

	public void setPublico(Boolean publico) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET publico = "+publico+" WHERE idCurso = "+this.idCurso);
		miBD.finalize();
		this.publico = publico;
	}

	public Integer getAforo() {
		return aforo;
	}

	public void setAforo(Integer aforo) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET aforo = "+aforo+" WHERE idCurso = "+this.idCurso);
		miBD.finalize();
		this.aforo = aforo;
	}

	public Boolean getPresencial() {
		return presencial;
	}

	public void setPresencial(Boolean presencial) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET presencial = "+presencial+" WHERE idCurso = "+this.idCurso);
		miBD.finalize();
		this.presencial = presencial;

	}

	public Boolean getTieneForo() {
		return tieneForo;
	}

	public void setTieneForo(Boolean tieneForo) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET tieneforo = "+tieneForo+" WHERE idCurso = "+this.idCurso);
		miBD.finalize();
		this.tieneForo = tieneForo;
	}

	public Profesor getProfesor() {
		BD miBD = BD.getBD();
		Object[] tupla = miBD.Select("SELECT * FROM Curso WHERE idCurso = " + idCurso).get(0);
		miBD.finalize();
		this.profesor = new Profesor(tupla[8].toString());
		return profesor;
	}

	public List<Mensaje> getMensajes() {
		if (tieneForo) {
			BD miBD = BD.getBD();
			List<Object[]> tuplaMensajes = miBD.Select("SELECT * FROM mensaje WHERE idCurso = " + idCurso);
			miBD.finalize();
			for (Object[] o : tuplaMensajes) {
				this.mensajes.add(new Mensaje(Integer.parseInt(o[0].toString())));
			}
			return mensajes;
		} else {
			return null;
		}
	}
	
	public List<Usuario> getEstudiantes() {
		BD miBD = BD.getBD();
		List<Object[]> tuplaEstudiantes = miBD.Select("SELECT * FROM RelCursoUsuario WHERE idCurso = " + idCurso);
		miBD.finalize();
		for (Object[] o : tuplaEstudiantes) {
			this.estudiantes.add(new Usuario(o[0].toString()));
		}
		
		return estudiantes;
	}
	
	public void addEstudiante(Usuario estudiante) {
		BD miBD = BD.getBD();
		miBD.Insert("INSERT INTO RelCursoUsuario (nickUsuario, idCurso) VALUES ('"+estudiante.getNick()+"',"+this.idCurso+")");
		miBD.finalize();
		this.estudiantes.add(estudiante);
	}
	
	public void eliminarCurso() {
		BD miBD = BD.getBD();
    	miBD.Delete("DELETE FROM Curso WHERE idCurso = " + idCurso);
    	miBD.finalize();
    	this.nombre = "";
    	this.descripcion = "";
    	this.imagen = "";
    	this.publico = null;
	}
	
	public static List<Curso> getTodosLosCursos() {
		List<Curso> listaCursos = new ArrayList<>();
		BD miBD = BD.getBD();
		List<Object[]> cursos = miBD.Select("SELECT * FROM Curso");
		for (Object[] tupla : cursos) {
			listaCursos.add(new Curso(Integer.parseInt(tupla[0].toString())));
		}
		return listaCursos;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
