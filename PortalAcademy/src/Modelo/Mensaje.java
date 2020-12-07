package Modelo;

public class Mensaje {
	
	private Integer idMensaje;
	private String contenido;
	
	
	private String texto;
	public Mensaje(Integer integer) {
		// TODO Auto-generated constructor stub
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Usuario getEmisor() {
		return emisor;
	}
	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}
	private Usuario emisor;

}
