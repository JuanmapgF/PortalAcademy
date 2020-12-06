import java.util.List;

public abstract class Conexion {
	static final String driver = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://rds-mysql-ingreq-2021.cobadwnzalab.eu-central-1.rds.amazonaws.com";
	static final String schema = "grupo09_mysql";
	static final String user = "grupo09";
	static final String pass = "IngReq09";
	
	public abstract Integer crearCurso(String nombre, String descripcion, String imagen, Boolean publico, Integer aforo,
			Boolean presencial, Boolean tieneForo, Profesor profesor, Foro foro, List<Usuario> estudiantes);
	public abstract Integer crearCurso(String nombre, String descripcion, String imagen, Boolean publico, Integer aforo,
			Boolean presencial, Boolean tieneForo, Profesor profesor, List<Usuario> estudiantes);
	public abstract Object[] obtenerCurso(Integer idCurso);
	public abstract void cambiarNombreCurso(String nombre, Integer idCurso);
	public abstract void cambiarDescripcionCurso(String descripcion, Integer idCurso);
	public abstract void cambiarImagenCurso(String imagen, Integer idCurso);
	public abstract void cambiarPrivacidadCurso(Boolean publico, Integer idCurso);
	public abstract void cambiarAforoCurso(Integer aforo, Integer idCurso);
	public abstract void cambiarModalidadCurso(Boolean presencial, Integer idCurso);
	public abstract void cambiarTieneForoCurso(Boolean tieneForo, Integer idCurso);
}
