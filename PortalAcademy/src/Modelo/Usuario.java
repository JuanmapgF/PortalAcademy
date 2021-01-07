package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;

public class Usuario {

	private String nick;
	private String correo;
	private String password;
	private static BD bd;
	private static List<Curso> listaCursos;
	private static List<Actividad> listaActividades;

	private static SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	
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

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public List<Actividad> getListaActividades() {
		return listaActividades;
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
		listaCursos = null;
		listaActividades = null;
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

	public void setListaCursos() {
		List<Curso> c = new ArrayList<Curso>();
		bd = BD.getBD();
		List<Object[]> cursos = bd.Select("SELECT * FROM RelCursoUsuario WHERE nickUsuario = '" + this.getNick() + "'");
		BD.contadorFinalize(cursos.size() + 1);
		bd.finalize();
		for (Object[] o : cursos) {
			c.add(new Curso((int) o[1]));
		}
		listaCursos = c;
	}

	public void setListaActividades() {
		List<Actividad> ac = new ArrayList<Actividad>();
		bd = BD.getBD();
		List<Object[]> actividades = bd
				.Select("SELECT * FROM RelActividadUsuario WHERE nickUsuario = '" + this.getNick() + "'");
		BD.contadorFinalize(actividades.size() + 1);
		bd.finalize();
		for (Object[] e : actividades) {
			ac.add(new Actividad((int) e[1]));
		}
		listaActividades = ac;
	}

	public Boolean estaEnCurso(Curso curso) {
		return getListaCursos().contains(curso);
	}

	public Boolean estaEnActividad(Actividad actividad) {
		return getListaActividades().contains(actividad);
	}
	
	public List<Date> getFechas() {
		List<Date> c = new ArrayList<Date>();
		bd = BD.getBD();
		List<Object[]> fechas = bd.Select("SELECT fecha FROM FechasUsuarios WHERE nickUsuario = '" + this.getNick() + "'");
		bd.finalize();
		for (Object[] o : fechas) {
			try {
				c.add(formato.parse(o[0].toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return c;
	}
	
	public List<String> getInformacion(Date d) {
		List<String> c = new ArrayList<String>();
		bd = BD.getBD();
		List<Object[]> info = bd.Select("SELECT informacion FROM FechasUsuarios WHERE nickUsuario = '"+ this.getNick() + "' AND fecha = '" + formato.format(d) + "'");
		bd.finalize();
		for (Object[] o : info) {
				c.add(o[0].toString());
		}
		return c;
	}
	
	public List<Actividad> getActividadesFecha(Date d) {
		setListaActividades();
		List<Actividad> p = getListaActividades();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(d);
		//JLabel lblNewLabel = new JLabel("Eventos del día " + cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR));
		List<Actividad> c = new ArrayList<Actividad>();
		for(Actividad x : p) {
			Calendar cal1 = Calendar.getInstance();
		    cal1.setTime(x.getFecha());
			if(cal.get(Calendar.DAY_OF_MONTH)   == cal1.get(Calendar.DAY_OF_MONTH) &&cal.get(Calendar.MONTH) == cal1.get(Calendar.MONTH) &&  cal.get(Calendar.YEAR) ==  cal1.get(Calendar.YEAR)) {
				c.add(x);
			}
		}
		return c;
	}
	
	public void addFecha(Date fecha, String informacion) {
		bd = BD.getBD();
		bd.Insert("INSERT INTO FechasUsuarios VALUES ( " + this.getNick() + ", '" +  formato.format(fecha) + "', '" + informacion + "');") ;
		bd.finalize();
	}
}
