package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MensajeNoticia {
	private Integer idMensajeNoticia;
	private String texto;
	private Date fecha;
	
	private static BD bd;
	private static SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	
	public MensajeNoticia(String texto, Date fecha) {
		bd.Insert("INSERT INTO MensajeNoticia (texto, fecha)" + "VALUES ('" + texto + "','" + formato.format(fecha) + "')");
		bd.finalize();

		this.texto = texto;
		this.fecha = fecha;
	}

	public MensajeNoticia(Integer idMensajeNoticia) {
		bd = BD.getBD();
		Object[] tupla = bd.Select("SELECT * FROM MensajeNoticia WHERE idMensajeNoticia = " + idMensajeNoticia).get(0);
		bd.finalize();
		this.idMensajeNoticia = Integer.parseInt(tupla[0].toString());
		this.texto = tupla[1].toString();
		try {
			this.fecha = formato.parse(tupla[2].toString());
		} catch (ParseException e) {
			throw new ErrorBD("Error en la conversión del tipo fecha: " + e.getMessage());
		}
	}
	
	public Integer getIdMensaje() {
		return idMensajeNoticia;
	}

	public String getTexto() {
		return texto;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public static List<MensajeNoticia> getTodasLasNoticias() {
		List<MensajeNoticia> listaNoticias = new ArrayList<>();
		bd = BD.getBD();
		List<Object[]> noticias = bd.Select("SELECT idMensajeNoticia FROM MensajeNoticia ORDER BY idMensajeNoticia DESC");
		BD.contadorFinalize(noticias.size() + 1);
		bd.finalize();
		for (Object[] tupla : noticias) {
			listaNoticias.add(new MensajeNoticia(Integer.parseInt(tupla[0].toString())));
		}
		return listaNoticias;
	}
	
}
