import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import prLIGAppControlador.ConexionJDBC;

public class ConexionJDBC extends Conexion {
	private Connection con;
	private static ConexionJDBC instanciaInterfaz = null;
	
	private ConexionJDBC() {
		try {
			con = DriverManager.getConnection(url + "/" + schema, user, pass);
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ConexionJDBC getInstance() {
		if (instanciaInterfaz == null) {
			instanciaInterfaz = new ConexionJDBC();
		}
		
		return instanciaInterfaz;
	}
	
	
	public Integer crearCurso(String nombre, String descripcion, String imagen, Boolean publico, Integer aforo,
			Boolean presencial, Boolean tieneForo, Profesor profesor, Foro foro, List<Usuario> estudiantes) {
		Integer idCurso = 0;
		String query = "INSERT INTO Curso (NOMBRE, DESCRIPCION, IMAGEN, PUBLICO, AFORO, PRESENCIAL, TIENEFORO, ID_PROFESOR, ID_FORO)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String query2 = "INSERT INTO RelCursoEstudiante (ID_CURSO, ID_ESTUDIANTE) VALUES (?, ?)";
		try {
			java.sql.PreparedStatement pS = (PreparedStatement) con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pS.setString(1, nombre);
			pS.setString(2, descripcion);
			pS.setString(3, imagen);
			pS.setBoolean(4, publico);
			pS.setInt(5, aforo);
			pS.setBoolean(6, presencial);
			pS.setBoolean(7, tieneForo);
			pS.setInt(8, profesor.getId());
			pS.setInt(9, foro.getId());
			int res = pS.executeUpdate();
			ResultSet rs = pS.getGeneratedKeys();
			idCurso = rs.getInt(1);
				
			for (Usuario estudiante : estudiantes) {
				java.sql.PreparedStatement pS2 = (PreparedStatement) con.prepareStatement(query2, PreparedStatement.RETURN_GENERATED_KEYS);
				pS2.setInt(1, cursoId);
				pS2.setInt(2, estudiante.getId());
				int res = pS.executeUpdate();
				ResultSet rs = pS.getGeneratedKeys();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idCurso;
	}
	
	private 
}
