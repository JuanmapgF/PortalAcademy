package Modelo;

public class Curso {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private Boolean publico;
	private Integer aforo;
	private Boolean presencial;
	
	public Curso(String nombre, String descripcion, String imagen, Boolean publico, Integer aforo, Boolean presencial) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.publico = publico;
		this.aforo = aforo;
		this.presencial = presencial;
	}

	public Curso(Integer id) {
		
	}
}
