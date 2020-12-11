package Modelo;

public class Mensaje {

	private Integer idMensaje;
	private String texto;

	private Usuario emisor;
	private Curso curso;

	private static BD bd;

	public Mensaje(String texto, Usuario emisor, Curso curso) {
		bd = BD.getBD();
		bd.Insert("INSERT INTO Mensaje (texto, nickUsuario, idCurso)" + "VALUES ('" + texto + "'," + emisor.getNick()
				+ "," + curso.getId() + ")");
		bd.finalize();

		this.texto = texto;
		this.emisor = emisor;
		this.curso = curso;
	}

	public Mensaje(Integer idMensaje) {
		bd = BD.getBD();
		Object[] tupla = bd.Select("SELECT * FROM Mensaje WHERE idMensaje = " + idMensaje).get(0);
		bd.finalize();

		this.idMensaje = Integer.parseInt(tupla[0].toString());
		this.texto = tupla[1].toString();
		this.emisor = new Usuario(tupla[2].toString());
	}

	public Integer getIdMensaje() {
		return idMensaje;
	}

	public String getTexto() {
		return texto;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public Curso getCurso() {
		bd = BD.getBD();
		Object c = bd.SelectEscalar("SELECT  FROM Mensaje WHERE idMensaje = " + idMensaje);
		bd.finalize();
		this.curso = new Curso(Integer.parseInt(c.toString()));
		return curso;
	}

}
