package Modelo;

import java.util.ArrayList;
import java.util.List;

public class MensajePrivado {
	private Integer idMensajePrivado;
	private String texto;

	private Usuario emisor;
	private Usuario receptor;
	
	private static BD bd;
	
	public MensajePrivado(String texto, Usuario emisor, Usuario receptor) {
		bd = BD.getBD();
		bd.Insert("INSERT INTO MensajePrivado (texto, nickUsuarioEmisor, nickUsuarioReceptor)" + "VALUES ('" + texto + "', '" + emisor.getNick()
				+ "','" + receptor.getNick() + "')");
		bd.finalize();

		this.texto = texto;
		this.emisor = emisor;
		this.receptor = receptor;
	}

	public MensajePrivado(Integer idMensajePrivado) {
		bd = BD.getBD();
		Object[] tupla = bd.Select("SELECT * FROM MensajePrivado WHERE idMensajePrivado = " + idMensajePrivado).get(0);
		bd.finalize();
		this.idMensajePrivado = Integer.parseInt(tupla[0].toString());
		this.texto = tupla[1].toString();
	}
	
	public Integer getIdMensaje() {
		return idMensajePrivado;
	}

	public String getTexto() {
		return texto;
	}

	public Usuario getEmisor() {
		if (this.emisor == null) {
			bd = BD.getBD();
			Object[] tupla = bd.Select("SELECT nickUsuarioEmisor FROM MensajePrivado WHERE idMensajePrivado = " + idMensajePrivado).get(0);
			bd.finalize();
			this.emisor = new Usuario(tupla[0].toString());
		}
		return emisor;
	}

	public Usuario getReceptor() {
		if (this.receptor == null) {
			bd = BD.getBD();
			Object[] tupla = bd.Select("SELECT nickUsuarioReceptor FROM MensajePrivado WHERE idMensajePrivado = " + idMensajePrivado).get(0);
			bd.finalize();
			this.receptor = new Usuario(tupla[0].toString());
		}
		return receptor;
	}
	
	public static List<MensajePrivado> getMensajesDeConversacion(Usuario user, Usuario seleccionado) {
		List<MensajePrivado> mensajes = new ArrayList<>();
		bd = BD.getBD();
		List<Object[]> tuplas = bd.Select("SELECT idMensajePrivado FROM MensajePrivado "
				+ "WHERE nickUsuarioEmisor = '" + user.getNick() + "' AND nickUsuarioReceptor = '" + seleccionado.getNick() 
				+ "' OR nickUsuarioEmisor = '" + seleccionado.getNick() + "' AND nickUsuarioReceptor = '" + user.getNick() + "' ORDER BY idMensajePrivado ASC");
		BD.contadorFinalize(tuplas.size() + 1);
		bd.finalize();
		for (Object[] tupla : tuplas) {
			mensajes.add(new MensajePrivado(Integer.parseInt(tupla[0].toString())));
		}
		return mensajes;
		
	}
}
