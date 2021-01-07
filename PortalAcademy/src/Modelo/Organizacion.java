package Modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Organizacion extends Usuario {

	private String sede;
	private static BD bd;

	public Organizacion(String nick, String correo, String password, String sede) {
		super(nick, correo, password);
		this.sede = sede;
		bd = BD.getBD();
		bd.Insert("INSERT INTO Organizacion (nick,sede) VALUES ('" + this.getNick() + "', '" + this.getSede() + "')");
		bd.finalize();
	}

	public Organizacion(String nick) {
		super(nick);
	}

	public List<Actividad> getActividades() {
		List<Actividad> ac = new ArrayList<Actividad>();
		bd = BD.getBD();
		List<Object[]> actividades = bd
				.Select("SELECT idActividad FROM Actividad WHERE nickOrganizacion = '" + this.getNick() + "'");
		BD.contadorFinalize(actividades.size() + 1);
		bd.finalize();
		for (Object[] o : actividades) {
			ac.add(new Actividad(Integer.parseInt(o[0].toString())));
		}
		return ac;
	}

	public String getSede() {
		if (sede.isEmpty()) {
			bd = BD.getBD();
			Object user = bd
					.SelectEscalar("SELECT sede FROM Organizacion WHERE Organizacion.nick = '" + this.getNick() + "'");
			bd.finalize();
			this.sede = user.toString();
		}
		return sede;
	}
	
	public List<Actividad> getActividadesFechaA(Date d) {
		List<Actividad> p = getActividades();
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
	
	@Override
	public void eliminarUsuario() {
		super.eliminarUsuario();
	}

	@Override
	public void setPassword(String p) {
		super.setPassword(p);
	}

}
