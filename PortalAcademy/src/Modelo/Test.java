package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Test {

	private String nombre;
	private String descripcion;
	private String link;
	private static BD bd;
	private int id;

	public Test(int id, String n, String d, String l) {
		nombre = n;
		descripcion = d;
		link = l;
		this.id = id;
	}

	public Test(String n, String d, String l) {
		nombre = n;
		descripcion = d;
		link = l;
	}

	public static List<Test> getTodosLosTests(int idCurso) {
		List<Test> res = new ArrayList<Test>();
		bd = BD.getBD();
		List<Object[]> tests = bd.Select("SELECT * FROM Test WHERE idCurso = " + idCurso + ";");
		bd.finalize();
		for (Object[] tupla : tests) {
			res.add(new Test(Integer.parseInt(tupla[0].toString()), tupla[1].toString(), tupla[2].toString(),
					tupla[3].toString()));
		}
		return res;
	}

	public void addTest(int idCurso) {
		bd = BD.getBD();
		bd.Insert("INSERT INTO Test (idCurso, nombre, descripcion, link) VALUES (" + idCurso + ",'" + nombre + "', '"
				+ descripcion + "', '" + link + "')");
		bd.finalize();
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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

	public String toString() {
		return nombre;
	}

	public int getID() {
		return id;
	}

	public void borrar() {
		bd = BD.getBD();
		bd.Delete("DELETE FROM Test WHERE idTest = " + id);
		bd.finalize();
		this.id = -1;
		this.descripcion = "";
		this.link = "";
		this.nombre = "";
	}
}
