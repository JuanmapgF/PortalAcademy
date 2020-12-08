package Modelo;

public class Pruebesita {

	public static void main(String[] args) {
		
		for (Curso u : Curso.getTodosLosCursos()) {
			System.out.println(u.getNombre());
		}
	}

}
