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
		this.emisor = (new Usuario(tupla[2].toString()));
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
		BD.contadorFinalize(2 * tuplas.size() + 1);
		bd.finalize();
		for (Object[] tupla : tuplas) {
			mensajes.add(new MensajePrivado(Integer.parseInt(tupla[0].toString())));
		}
		return mensajes;
		
	}
	
	public static List<Usuario> usuariosCompartiendoChat(Usuario user) {
		List<Usuario> usuarios = new ArrayList<>();
		BD miBD = BD.getBD();
		List<Object[]> users = miBD.Select("SELECT a.idMensajePrivado, a.nickUsuarioEmisor, a.nickUsuarioReceptor "
				+ "FROM MensajePrivado AS a "
				+ "WHERE nickUsuarioReceptor = '" + user.getNick() + "' AND "
						+ "NOT EXISTS (SELECT s1.idMensajePrivado, s1.nickUsuarioEmisor, s1.nickUsuarioReceptor FROM MensajePrivado AS s1 WHERE s1.nickUsuarioReceptor = '" + user.getNick() + "' "
						+ "AND a.idMensajePrivado < s1.idMensajePrivado) AND "
						+ "NOT EXISTS (SELECT s2.idMensajePrivado, s2.nickUsuarioEmisor, s2.nickUsuarioReceptor FROM MensajePrivado AS s2 WHERE s2.nickUsuarioEmisor = '" + user.getNick() + "' "
								+ "AND a.nickUsuarioEmisor = s2.nickUsuarioReceptor AND a.idMensajePrivado < s2.idMensajePrivado) "
				+ "UNION SELECT b.idMensajePrivado, b.nickUsuarioReceptor, b.nickUsuarioReceptor "
				+ "FROM MensajePrivado AS b "
				+ "WHERE nickUsuarioEmisor = '" + user.getNick() + "' AND "
						+ "NOT EXISTS (SELECT s3.idMensajePrivado, s3.nickUsuarioEmisor, s3.nickUsuarioReceptor FROM MensajePrivado AS s3 WHERE s3.nickUsuarioEmisor = '" + user.getNick() + "' "
						+ "AND b.idMensajePrivado < s3.idMensajePrivado) AND "
						+ "NOT EXISTS (SELECT s4.idMensajePrivado, s4.nickUsuarioEmisor, s4.nickUsuarioReceptor FROM MensajePrivado AS s4 WHERE s4.nickUsuarioReceptor = '" + user.getNick() + "' "
								+ "AND b.nickUsuarioReceptor = s4.nickUsuarioEmisor AND b.idMensajePrivado < s4.idMensajePrivado) "
				+ "ORDER BY 1");
		BD.contadorFinalize(users.size() + 1);
		miBD.finalize();
		for (Object[] tupla : users) {
			usuarios.add(new Usuario((String) tupla[1]));
		}
		return usuarios;
	}

}
