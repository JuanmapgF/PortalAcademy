package Modelo;

public class Usuario {

	private String nick;
	private String correo;
	private String password;
	private BD bd;

	public Usuario(String nick) {
		bd = BD.getBD();
		Object [] user = bd.Select("SELECT * FROM Usuario WHERE Usuario.nick = '" + nick + "'").get(0);
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
		bd.Insert("INSERT INTO Usuario (nick, correo, contrasena) VALUES ( '"+this.getNick().toUpperCase()+"', '"+this.getCorreo()+"', '"+this.getPassword()+"')");
		bd.finalize();
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
		bd.Update("UPDATE Usuario SET contrasena = '"+this.getPassword()+"' WHERE Usuario.nick = '"+this.getNick()+"'");
		bd.finalize();
	}

	public void eliminarUsuario() {
		bd = BD.getBD();
		bd.Delete("DELETE FROM Usuario WHERE Usuario.nick = '"+this.getNick()+"'");
		bd.finalize();
		this.nick = "";
		this.correo = "";
		this.password = "";
	}

}
