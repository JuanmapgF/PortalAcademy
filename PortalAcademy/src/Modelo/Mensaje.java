package Modelo;

public class Mensaje {
	
	private Integer idMensaje;
	private String texto;
	
	private Usuario emisor;
	private Curso curso;
	
	public Mensaje(String texto, Usuario emisor, Curso curso) {
		BD miBD = BD.getBD();
		miBD.Insert("INSERT INTO Mensaje (TEXTO, ID_USUARIO, ID_CURSO)"
				+ "VALUES ('"+texto+"',"+emisor.getNick()+","+curso.getId()+")");
		miBD.finalize();
		
		this.texto = texto;
		this.emisor = emisor;
		this.curso = curso;
	}
	
	public Mensaje(Integer idMensaje) {
		BD miBD = BD.getBD();
		Object[] tupla = miBD.Select("SELECT * FROM Mensaje WHERE ID_MENSAJE = " + idMensaje).get(0);
		miBD.finalize();
		
		this.idMensaje = Integer.parseInt(tupla[0].toString());
		this.texto = tupla[1].toString();
		this.emisor = new Usuario(tupla[2].toString());
		this.curso = new Curso(Integer.parseInt(tupla[3].toString()));
	}

}
