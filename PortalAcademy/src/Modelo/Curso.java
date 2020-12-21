package Modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Curso {

	private Integer idCurso;
	private String nombre;
	private String descripcion;
	private File imagen;
	private Boolean publico;
	private Integer aforo;
	private Boolean presencial;
	private Boolean tieneForo;

	private List<Mensaje> mensajes;
	private Profesor profesor;
	private List<Usuario> estudiantes;

	private static BD bd;

	public Curso(String nombre, String descripcion, File imagen, Boolean publico, Integer aforo, Boolean presencial,
			Boolean tieneForo, Profesor profesor) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.publico = publico;
		this.aforo = aforo;
		this.presencial = presencial;
		this.tieneForo = tieneForo;
		this.profesor = profesor;

		bd = BD.getBD();
		if (imagen == null) {
			bd.Insert(
					"INSERT INTO Curso (nombre, descripcion, imagen, publico, aforo, presencial, tieneforo, nickProfesor)"
							+ "VALUES ('" + nombre + "', '" + descripcion + "', '" + null + "', "
							+ ((publico) ? 1 : 0) + ", " + aforo + ", " + ((presencial) ? 1 : 0) + ", "
							+ ((tieneForo) ? 1 : 0) + ",'" + profesor.getNick() + "')");
		} else {
			bd.InsertCursoConImagen(nombre, descripcion, imagen, publico, aforo, presencial, tieneForo, profesor);
		}
		bd.finalize();
		mensajes = new ArrayList<Mensaje>();
		estudiantes = new ArrayList<Usuario>();
	}

	public Curso(Integer idCurso) {
		BD miBD = BD.getBD();
		Object[] tupla = miBD.Select(
				"SELECT idCurso,nombre,descripcion,publico,aforo,presencial,tieneForo FROM Curso WHERE idCurso = "
						+ idCurso)
				.get(0);
		miBD.finalize();

		this.idCurso = Integer.parseInt(tupla[0].toString());
		this.nombre = tupla[1].toString();
		this.descripcion = tupla[2].toString();
		this.publico = tupla[3].toString().equals("1") ? true : false;
		this.aforo = Integer.parseInt(tupla[4].toString());
		this.presencial = tupla[5].toString().equals("1") ? true : false;
		this.tieneForo = tupla[6].toString().equals("1") ? true : false;
		this.estudiantes = new ArrayList<Usuario>();
		this.mensajes = new ArrayList<Mensaje>();

	}

	public Integer getId() {
		return idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		bd = BD.getBD();
		bd.Update("UPDATE Curso SET nombre = '" + nombre + "' WHERE idCurso = " + this.idCurso);
		bd.finalize();
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		bd = BD.getBD();
		bd.Update("UPDATE Curso SET descripcion = '" + descripcion + "' WHERE idCurso = " + this.idCurso);
		bd.finalize();
		this.descripcion = descripcion;
	}

	public File getImagen() {
		this.imagen = bd.SelectImagenCurso(this.idCurso);
		return imagen;
	}

	public void setImagen(File imagen) { // Redefinir con archivos
//		bd = BD.getBD();
//		bd.Update("UPDATE Curso SET imagen = '" + imagen + "' WHERE idCurso = " + this.idCurso);
//		bd.finalize();
//		this.imagen = imagen;
	}

	public Boolean getPublico() {
		return publico;
	}

	public void setPublico(Boolean publico) {
		bd = BD.getBD();
		bd.Update("UPDATE Curso SET publico = " + ((publico) ? 1 : 0) + " WHERE idCurso = " + this.idCurso);
		bd.finalize();
		this.publico = publico;
	}

	public Integer getAforo() {
		return aforo;
	}

	public void setAforo(Integer aforo) {
		bd = BD.getBD();
		bd.Update("UPDATE Curso SET aforo = " + aforo + " WHERE idCurso = " + this.idCurso);
		bd.finalize();
		this.aforo = aforo;
	}

	public Boolean getPresencial() {
		return presencial;
	}

	public void setPresencial(Boolean presencial) {
		bd = BD.getBD();
		bd.Update("UPDATE Curso SET presencial = " + ((presencial) ? 1 : 0) + " WHERE idCurso = " + this.idCurso);
		bd.finalize();
		this.presencial = presencial;

	}

	public Boolean getTieneForo() {
		return tieneForo;
	}

	public void setTieneForo(Boolean tieneForo) {
		bd = BD.getBD();
		bd.Update("UPDATE Curso SET tieneforo = " + ((tieneForo) ? 1 : 0) + " WHERE idCurso = " + this.idCurso);
		bd.finalize();
		this.tieneForo = tieneForo;
	}

	public Profesor getProfesor() {
		if (profesor == null) {
			bd = BD.getBD();
			Object[] tupla = bd.Select("SELECT * FROM Curso WHERE idCurso = " + idCurso).get(0);
			bd.finalize();
			this.profesor = new Profesor(tupla[8].toString());
		}
		return profesor;
	}

	public List<Mensaje> getMensajes() {
		mensajes = new ArrayList<Mensaje>();
		if (tieneForo) {
			bd = BD.getBD();
			List<Object[]> tuplaMensajes = bd.Select("SELECT * FROM Mensaje WHERE idCurso = " + idCurso);
			BD.contadorFinalize(tuplaMensajes.size() + tuplaMensajes.size() * 2 + 1);
			bd.finalize();
			for (Object[] o : tuplaMensajes) {
				this.mensajes.add(new Mensaje(Integer.parseInt(o[0].toString())));
			}
			return mensajes;
		} else {
			return null;
		}
	}

	public List<Usuario> getEstudiantes() {
		estudiantes = new ArrayList<Usuario>();
		bd = BD.getBD();
		List<Object[]> tuplaEstudiantes = bd.Select("SELECT * FROM RelCursoUsuario WHERE idCurso = " + idCurso);
		BD.contadorFinalize(tuplaEstudiantes.size() + 1);
		bd.finalize();
		for (Object[] o : tuplaEstudiantes) {
			this.estudiantes.add(new Usuario(o[0].toString()));
		}

		return estudiantes;
	}

	public void addEstudiante(Usuario estudiante) {
		bd = BD.getBD();
		bd.Insert("INSERT INTO RelCursoUsuario (nickUsuario, idCurso) VALUES ('" + estudiante.getNick() + "',"
				+ this.idCurso + ")");
		bd.finalize();
	}

	public void eliminarCurso() {
		bd = BD.getBD();
		bd.Delete("DELETE FROM Curso WHERE idCurso = " + idCurso);
		bd.finalize();
		this.nombre = "";
		this.descripcion = "";
		this.imagen = null;
		this.publico = null;
	}

	public Boolean quedanPlazas() {
		if (estudiantes == null) {
			getEstudiantes();
		}
		return getAforo() > estudiantes.size();
	}

	public static List<Curso> getTodosLosCursos() {
		List<Curso> listaCursos = new ArrayList<>();
		bd = BD.getBD();
		List<Object[]> cursos = bd.Select("SELECT * FROM Curso");
		BD.contadorFinalize(cursos.size() + 1);
		bd.finalize();
		for (Object[] tupla : cursos) {
			listaCursos.add(new Curso(Integer.parseInt(tupla[0].toString())));
		}
		return listaCursos;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public boolean equals(Object o) {
		if (o instanceof Curso) {
			Curso u = (Curso) o;
			return this.getId().equals(u.getId());
		} else {
			return false;
		}
	}
}
