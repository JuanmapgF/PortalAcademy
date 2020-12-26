package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nick;
	private String correo;
	private String password;
	private static BD bd;

	public Usuario(String nick) {
		bd = BD.getBD();
		Object[] user = bd.Select("SELECT * FROM Usuario WHERE Usuario.nick = '" + nick + "'").get(0);
		bd.finalize();
		this.nick = user[0].toString();
		this.correo = user[1].toString();
		this.password = user[2].toString();
	}

	public Usuario(String nick, String correo, String password) {
		this.nick = nick;
		this.correo = correo;
		this.password = password;
		bd = BD.getBD();
		bd.Insert("INSERT INTO Usuario (nick, correo, contrasena) VALUES ( '" + this.getNick() + "', '"
				+ this.getCorreo() + "', '" + this.getPassword() + "')");
		bd.finalize();
	}

	public Usuario(String nick, String pass) {
		this.nick = nick;
		this.password = pass;
	}

	public String getNick() {
		return nick;
	}

	public String getCorreo() {
		return correo;
	}

	private String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		bd = BD.getBD();
		bd.Update("UPDATE Usuario SET contrasena = '" + this.getPassword() + "' WHERE Usuario.nick = '" + this.getNick()
				+ "'");
		bd.finalize();
	}

	public void eliminarUsuario() {
		bd = BD.getBD();
		bd.Delete("DELETE FROM Usuario WHERE Usuario.nick = '" + this.getNick() + "'");
		bd.finalize();
		this.nick = "";
		this.correo = "";
		this.password = "";
	}
	
	public List<Usuario> usuariosCompartiendoChat() {
		List<Usuario> usuarios = new ArrayList<>();
		BD miBD = BD.getBD();
		List<Object[]> users = miBD.Select("SELECT idMensajePrivado, nickUsuarioEmisor "
				+ "FROM (SELECT MAX(idMensajePrivado), nickUsuarioEmisor FROM MensajePrivado WHERE nickUsuarioReceptor = '" + this.getNick() + "') AS a "
				+ "WHERE idMensajePrivado > "
				+ "(SELECT MAX(idMensajePrivado) FROM MensajePrivado as s1 WHERE nickUsuarioEmisor = '" + this.getNick() + "' AND nickUsuarioReceptor = a.nickUsuarioEmisor) "
				+ "UNION SELECT idMensajePrivado, nickUsuarioReceptor "
				+ "FROM (SELECT MAX(idMensajePrivado), nickUsuarioReceptor FROM MensajePrivado WHERE nickUsuarioEmisor = '" + this.getNick() + "') AS b "
				+ "WHERE idMensajePrivado > "
				+ "(SELECT MAX(idMensajePrivado) FROM MensajePrivado as s2 WHERE nickUsuarioReceptor = '" + this.getNick() + "' AND nickUsuarioEmisor = b.nickUsuarioReceptor)");
		BD.contadorFinalize(users.size() + 1);
		miBD.finalize();
		for (Object[] tupla : users) {
			usuarios.add(new Usuario((String) tupla[1]));
		}
		return usuarios;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Usuario) {
			Usuario u = (Usuario) o;
			return this.getNick().equals(u.nick) && this.getPassword().equals(u.password);
		} else {
			return false;
		}
	}

	public static List<Usuario> getUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		BD miBD = BD.getBD();
		List<Object[]> users = miBD.Select("SELECT nick FROM Usuario");
		BD.contadorFinalize(users.size() + 1);
		miBD.finalize();
		for (Object[] tupla : users) {
			usuarios.add(new Usuario((String) tupla[0]));
		}
		return usuarios;
	}

	public String toString() {
		return getNick();
	}
}
