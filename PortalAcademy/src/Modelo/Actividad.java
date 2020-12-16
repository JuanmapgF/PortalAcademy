package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

	private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

	private static BD bd;

	public Actividad(String nombre, String descripcion, String imagen, int aforo, Date fecha, String lugar,
			Organizacion organizacion) {
		bd = BD.getBD();
		bd.Insert("INSERT INTO Actividad (nombre, descripcion, imagen, aforo, fecha, lugar, nickOrganizacion)"
				+ "VALUES ('" + nombre + "', '" + descripcion + "', '" + imagen + "'," + aforo + ", '"
				+ formato.format(fecha) + "','" + lugar + "','" + organizacion.getNick() + "')");
		bd.finalize();

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.aforo = aforo;
		this.fecha = fecha;
		this.lugar = lugar;
		this.organizacion = organizacion;
	}

	public Actividad(Integer idActividad) {
		bd = BD.getBD();
		Object[] tupla = bd.Select("SELECT * FROM Actividad WHERE idActividad = " + idActividad).get(0);
		bd.finalize();

		this.idActividad = Integer.parseInt(tupla[0].toString());
		this.nombre = tupla[1].toString();
		this.descripcion = tupla[2].toString();
		this.imagen = tupla[3].toString();
		this.aforo = Integer.parseInt(tupla[4].toString());
		try {
			this.fecha = formato.parse(tupla[5].toString());
		} catch (ParseException e) {
			throw new ErrorBD("Error en la conversión del tipo fecha: " + e.getMessage());
		}
		this.lugar = tupla[6].toString();
	}

	public Integer getId() {
		return idActividad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		bd = BD.getBD();
		bd.Update("UPDATE Actividad SET nombre = '" + nombre + "' WHERE idActividad = " + this.idActividad);
		bd.finalize();
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		bd = BD.getBD();
		bd.Update("UPDATE Actividad SET descripcion = '" + descripcion + "' WHERE idActividad = " + this.idActividad);
		bd.finalize();
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		bd = BD.getBD();
		bd.Update("UPDATE Actividad SET imagen = '" + imagen + "' WHERE idActividad = " + this.idActividad);
		bd.finalize();
		this.imagen = imagen;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		bd = BD.getBD();
		bd.Update("UPDATE Actividad SET aforo = " + aforo + " WHERE idActividad = " + this.idActividad);
		bd.finalize();
		this.aforo = aforo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		bd = BD.getBD();
		bd.Update("UPDATE Actividad SET fecha = '" + formato.format(fecha) + "' WHERE idActividad = " + this.idActividad);
		bd.finalize();
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		bd = BD.getBD();
		bd.Update("UPDATE Actividad SET lugar = " + lugar + " WHERE idActividad = " + this.idActividad);
		bd.finalize();
		this.lugar = lugar;
	}

	public Organizacion getOrganizacion() {
		if (organizacion == null) {
			bd = BD.getBD();
			Object[] tupla = bd.Select("SELECT nickOrganizacion FROM Curso WHERE idActividad = " + idActividad).get(0);
			bd.finalize();
			this.organizacion = new Organizacion(tupla[7].toString());
		}
		return organizacion;
	}

	public List<Usuario> getParticipantes() {
		participantes = new ArrayList<>();
		bd = BD.getBD();
		List<Object[]> tuplaParticipantes = bd
				.Select("SELECT * FROM RelActividadUsuario WHERE idActividad = " + idActividad);
		BD.contadorFinalize(tuplaParticipantes.size() + 1);
		bd.finalize();
		for (Object[] o : tuplaParticipantes) {
			this.participantes.add(new Usuario(o[0].toString()));
		}
		return participantes;
	}

	public void addParticipante(Usuario participante) {
		bd = BD.getBD();
		bd.Insert("INSERT INTO RelActividadUsuario (nickUsuario, idActividad) VALUES ('" + participante.getNick() + "',"
				+ this.idActividad + ")");
		bd.finalize();
	}

	public void eliminarActividad() {
		bd = BD.getBD();
		bd.Delete("DELETE FROM Actividad WHERE idActividad =" + idActividad);
		bd.finalize();
		this.nombre = null;
		this.descripcion = null;
		this.imagen = null;
		this.lugar = null;
	}

	public Boolean quedanPlazas() {
		if (participantes == null) {
			getParticipantes();
		}
		return getAforo() > participantes.size();
	}

	public static List<Actividad> getTodasLasActividades() {
		List<Actividad> listaActividades = new ArrayList<>();
		bd = BD.getBD();
		List<Object[]> actividades = bd.Select("SELECT * FROM Actividad");
		BD.contadorFinalize(actividades.size() + 1);
		bd.finalize();
		for (Object[] tupla : actividades) {
			listaActividades.add(new Actividad(Integer.parseInt(tupla[0].toString())));
		}
		return listaActividades;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public boolean equals(Object o) {
		if (o instanceof Actividad) {
			Actividad u = (Actividad) o;
			return this.getId().equals(u.getId());
		} else {
			return false;
		}
	}
}
