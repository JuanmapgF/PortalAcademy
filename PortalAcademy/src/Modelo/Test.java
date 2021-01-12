package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	private String nombre;
	private String descripcion;
	private String link;
	private static BD bd;
	
	public Test (String n, String d, String l) {
		nombre = n;
		descripcion = d;
		link = l;
	}
	
	public static List<Test> getTodosLosTests(int idCurso){
		List<Test> res = new ArrayList<Test>();
		bd = BD.getBD();
		List<Object[]> tests = bd.Select("SELECT * FROM Test WHERE idCurso = "+ idCurso + ";");
		bd.finalize();
		for (Object[] tupla : tests) {
			res.add(new Test(tupla[1].toString(),tupla[2].toString(),tupla[3].toString()));
		}
		return res;
	}
	
	public  void addTest(int idCurso) {
		bd = BD.getBD();
		bd.Insert("INSERT INTO Test VALUES (" + idCurso + ",'" + nombre + "', '"+ descripcion +
				"', '" + link + "')");
		bd.finalize();
	}
	
	public String toString() {
		return nombre;
	}
}
