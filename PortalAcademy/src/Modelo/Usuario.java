package Modelo;

public abstract class Usuario {
	
	private String nick;
	private String correo;
	private String password;

	public Usuario(String idUsuario) {
		//ACCESO BASEDATOS PARA OBTENER INFO USUARIO
		this.nick = nick;
		this.correo = correo;
		this.password = password;
	}
	
	public Usuario(String nick, String correo, String password) {
		this.nick = nick;
		this.correo = correo;
		this.password = password;
	}
	
	public String getNick() {
		return nick;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		//ACCESO BASEDATOS PARA CAMBIAR PASSWORD
		this.password = password;
	}
	
	
}
