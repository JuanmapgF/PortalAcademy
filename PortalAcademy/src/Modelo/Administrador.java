package Modelo;

public class Administrador extends Usuario {
	public Administrador(String nick) {
		super(nick);
	}

	public Administrador(String nick, String correo, String contrasena) {
		super(nick, correo, contrasena);
	}
}
