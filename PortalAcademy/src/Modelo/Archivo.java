package Modelo;

public class Archivo {
	private String nombre;
	private int id;

	public Archivo(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void descargar(String direccion) {
		BD bd = BD.getBD();
		bd.SelectArchivoCurso(getId(), getNombre(), direccion);
		bd.finalize();
	}

	public void borrar() {
		BD bd = BD.getBD();
		bd.Delete("DELETE  FROM ArchivoCurso WHERE idArchivo = " + getId());
		bd.finalize();
	}

}
