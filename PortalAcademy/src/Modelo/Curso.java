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
	
	private List<Mensaje> mensajes;
	private Profesor profesor;
	private List<Usuario> estudiantes;
	
	public Curso(String nombre, String descripcion, String imagen, Boolean publico, Integer aforo,
			Boolean presencial, Boolean tieneForo, Profesor profesor) {
		BD miBD = BD.getBD();
		miBD.Insert("INSERT INTO Curso (NOMBRE, DESCRIPCION, IMAGEN, PUBLICO, AFORO, PRESENCIAL, TIENEFORO, ID_PROFESOR)"
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
		
	}

	public Curso(Integer idCurso) {
		BD miBD = BD.getBD();
		Object[] tupla = miBD.Select("SELECT * FROM Curso WHERE ID_CURSO = " + idCurso).get(0);
		
		this.idCurso = Integer.parseInt(tupla[0].toString());
		this.nombre = tupla[1].toString();
		this.descripcion = tupla[2].toString();
		this.imagen = tupla[3].toString();
		this.publico = Boolean.parseBoolean(tupla[4].toString());
		this.aforo = Integer.parseInt(tupla[5].toString());
		this.presencial = Boolean.parseBoolean(tupla[6].toString());
		this.tieneForo = Boolean.parseBoolean(tupla[7].toString());
		
		this.profesor = new Profesor(tupla[8].toString());
		
		List<Object[]> tuplaEstudiantes = miBD.Select("SELECT * FROM RelCursoUsuario WHERE ID_CURSO = " + idCurso);
		for (Object[] o : tuplaEstudiantes) {
			this.estudiantes.add(new Usuario((String) o[1]));
		}
		miBD.finalize();
	}

	public Integer getId() {
		return idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET NOMBRE = '"+nombre+"' WHERE ID_CURSO = "+this.idCurso);
		miBD.finalize();
		this.nombre = nombre;	
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET DESCRIPCION = '"+descripcion+"' WHERE ID_CURSO = "+this.idCurso);
		miBD.finalize();
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET IMAGEN = '"+imagen+"' WHERE ID_CURSO = "+this.idCurso);
		miBD.finalize();
		this.imagen = imagen;
	}

	public Boolean getPublico() {
		return publico;
	}

	public void setPublico(Boolean publico) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET PUBLICO = "+publico+" WHERE ID_CURSO = "+this.idCurso);
		miBD.finalize();
		this.publico = publico;
	}

	public Integer getAforo() {
		return aforo;
	}

	public void setAforo(Integer aforo) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET AFORO = "+aforo+" WHERE ID_CURSO = "+this.idCurso);
		miBD.finalize();
		this.aforo = aforo;
	}

	public Boolean getPresencial() {
		return presencial;
	}

	public void setPresencial(Boolean presencial) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET PRESENCIAL = "+presencial+" WHERE ID_CURSO = "+this.idCurso);
		miBD.finalize();
		this.presencial = presencial;

	}

	public Boolean getTieneForo() {
		return tieneForo;
	}

	public void setTieneForo(Boolean tieneForo) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Curso SET TIENEFORO = "+tieneForo+" WHERE ID_CURSO = "+this.idCurso);
		miBD.finalize();
		this.tieneForo = tieneForo;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public List<Mensaje> getMensajes() {
		if (tieneForo) {
			BD miBD = BD.getBD();
			List<Object[]> tuplaMensajes = miBD.Select("SELECT * FROM MENSAJE WHERE ID_CURSO = " + idCurso);
			miBD.finalize();
			for (Object[] o : tuplaMensajes) {
				this.mensajes.add(new Mensaje((Integer) o[1]));
			}
			return mensajes;
		} else {
			return null;
		}
	}
	
	public List<Usuario> getEstudiantes() {
		return estudiantes;
	}
	
	public void addEstudiante(Usuario estudiante) {
		BD miBD = BD.getBD();
		miBD.Insert("INSERT INTO RelCursoUsuario (ID_USUARIO, ID_CURSO) VALUES ('"+estudiante.getNick()+"',"+this.idCurso+")");
		miBD.finalize();
		this.estudiantes.add(estudiante);
	}
	
	public String ToString() {
		return nombre;
	}
}
