package Modelo;

import java.util.List;

public class Foro {
	
	private List<Mensaje> mensajes;
	
	public Foro() {
		// TODO Auto-generated constructor stub
	}

	public Foro(int idForo) {
		
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
}
