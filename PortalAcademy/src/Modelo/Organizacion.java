package Modelo;

public class Organizacion extends Usuario {

	private String sede;
	private List<Actividad> actividades;

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}
}
