package Modelo;

public class Pruebesita {

	public static void main(String[] args) {
		
		for (Usuario u : Usuario.getUsuarios()) {
			System.out.println(u.getNick());
		}
	}

}
