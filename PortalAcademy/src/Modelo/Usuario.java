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
		List<Object[]> users = miBD.Select("SELECT a.idMensajePrivado, a.nickUsuarioEmisor, a.nickUsuarioReceptor "
				+ "FROM MensajePrivado AS a "
				+ "WHERE nickUsuarioReceptor = '" + this.getNick() + "' AND "
						+ "NOT EXISTS (SELECT s1.idMensajePrivado, s1.nickUsuarioEmisor, s1.nickUsuarioReceptor FROM MensajePrivado AS s1 WHERE s1.nickUsuarioReceptor = '" + this.getNick() + "' "
						+ "AND a.idMensajePrivado < s1.idMensajePrivado) AND "
						+ "NOT EXISTS (SELECT s2.idMensajePrivado, s2.nickUsuarioEmisor, s2.nickUsuarioReceptor FROM MensajePrivado AS s2 WHERE s2.nickUsuarioEmisor = '" + this.getNick() + "' "
								+ "AND a.nickUsuarioEmisor = s2.nickUsuarioReceptor AND a.idMensajePrivado < s2.idMensajePrivado) "
				+ "UNION SELECT b.idMensajePrivado, b.nickUsuarioReceptor, b.nickUsuarioReceptor "
				+ "FROM MensajePrivado AS b "
				+ "WHERE nickUsuarioEmisor = '" + this.getNick() + "' AND "
						+ "NOT EXISTS (SELECT s3.idMensajePrivado, s3.nickUsuarioEmisor, s3.nickUsuarioReceptor FROM MensajePrivado AS s3 WHERE s3.nickUsuarioEmisor = '" + this.getNick() + "' "
						+ "AND b.idMensajePrivado < s3.idMensajePrivado) AND "
						+ "NOT EXISTS (SELECT s4.idMensajePrivado, s4.nickUsuarioEmisor, s4.nickUsuarioReceptor FROM MensajePrivado AS s4 WHERE s4.nickUsuarioReceptor = '" + this.getNick() + "' "
								+ "AND b.nickUsuarioReceptor = s4.nickUsuarioEmisor AND b.idMensajePrivado < s4.idMensajePrivado) "
				+ "ORDER BY 1");
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
