package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Actividad {
	
	private Integer idActividad;
	private String nombre;
	private String descripcion;
	private String imagen;
	private int aforo;
	private Date fecha;
	private String lugar;
	
	private Organizacion organizacion;
	private List<Usuario> participantes;
	
	public Actividad(String nombre, String descripcion, String imagen, int aforo, Date fecha, String lugar, Organizacion organizacion) {
		BD miBD = BD.getBD();
		miBD.Insert("INSERT INTO Curso (NOMBRE, DESCRIPCION, IMAGEN, AFORO, FECHA, LUGAR, ID_ORGANIZACION)"
				+ "VALUES ('"+nombre+"','"+descripcion+"','"+imagen+"',"+aforo+","+fecha+","+lugar+",'"+organizacion.getNick()+"')");
		miBD.finalize();
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.aforo = aforo;
		this.fecha = fecha;
		this.lugar = lugar;
		this.organizacion = organizacion;
	}

	public Actividad(Integer idActividad) throws ParseException {
		BD miBD = BD.getBD();
		Object[] tupla = miBD.Select("SELECT * FROM Curso WHERE idActividad = " + idActividad).get(0);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		this.idActividad = Integer.parseInt(tupla[0].toString());
		this.nombre = tupla[1].toString();
		this.descripcion = tupla[2].toString();
		this.imagen = tupla[3].toString();
		this.aforo = Integer.parseInt(tupla[4].toString());
		this.fecha = formato.parse(tupla[5].toString());
		this.lugar = tupla[6].toString();
		
		this.organizacion = new Organizacion(tupla[7].toString());
		
		List<Object[]> tuplaParticipantes = miBD.Select("SELECT * FROM RelActividadParticipantes WHERE ID_ACTIVIDAD = " + idActividad);
		for (Object[] o : tuplaParticipantes) {
			this.participantes.add(new Usuario((String) o[1]));
		}
		miBD.finalize();
	}

	public Integer getIdActividad() {
		return idActividad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Actividad SET NOMBRE = '"+nombre+"' WHERE ID_ACTIVIDAD = "+this.idActividad);
		miBD.finalize();
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Actividad SET DESCRIPCION = '"+descripcion+"' WHERE ID_ACTIVIDAD = "+this.idActividad);
		miBD.finalize();
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Actividad SET IMAGEN = '"+imagen+"' WHERE ID_ACTIVIDAD = "+this.idActividad);
		miBD.finalize();
		this.imagen = imagen;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Actividad SET AFORO = "+aforo+" WHERE ID_ACTIVIDAD = "+this.idActividad);
		miBD.finalize();
		this.aforo = aforo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Actividad SET FECHA = "+fecha+" WHERE ID_ACTIVIDAD = "+this.idActividad);
		miBD.finalize();
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		BD miBD = BD.getBD();
		miBD.Update("UPDATE Actividad SET LUGAR = "+lugar+" WHERE ID_ACTIVIDAD = "+this.idActividad);
		miBD.finalize();
		this.lugar = lugar;
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}
	
	public List<Usuario> getParticipantes() {
		return participantes;
	}
	
	public void addParticipante(Usuario participante) {
		BD miBD = BD.getBD();
		miBD.Insert("INSERT INTO RelActividadUsuario (ID_ACTIVIDAD, ID_USUARIO) VALUES ("+this.idActividad+", '"+participante.getNick()+"')");
		miBD.finalize();
		this.participantes.add(participante);
	}
	
	public String ToString() {
		return nombre;
	}
}
