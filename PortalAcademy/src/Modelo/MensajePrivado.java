package Modelo;

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
		this.emisor = new Usuario(tupla[2].toString());
		this.receptor = new Usuario(tupla[3].toString());
	}
	
	public Integer getIdMensaje() {
		return idMensajePrivado;
	}

	public String getTexto() {
		return texto;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public Usuario getReceptor() {
		return receptor;
	}
}
