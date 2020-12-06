import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import prLIGAppControlador.ConexionJDBC;
import prLIGAppModelo.Usuario;

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
	
	//==============================================================================
	//============================= CURSO ==========================================
	
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
	
	public Integer crearCurso(String nombre, String descripcion, String imagen, Boolean publico, Integer aforo,
			Boolean presencial, Boolean tieneForo, Profesor profesor, List<Usuario> estudiantes) {
		Integer idCurso = 0;
		String query = "INSERT INTO Curso (NOMBRE, DESCRIPCION, IMAGEN, PUBLICO, AFORO, PRESENCIAL, TIENEFORO, ID_PROFESOR, ID_FORO)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
	
	public Object[] obtenerCurso(Integer idCurso) {
		Object lista[] = new Object[10];
		String query = "SELECT * FROM Curso WHERE idCurso";
		Statement querySt;
		try {
			querySt = con.createStatement();
			ResultSet rs = querySt.executeQuery(query);

			lista.add(rs.getInt(1));
			lista.add(rs.getString(2));
			lista.add(rs.getString(3));
			lista.add(rs.getString(4));
			lista.add(rs.getBoolean(5));
			lista.add(rs.getInt(6));
			lista.add(rs.getBoolean(7));
			lista.add(rs.getBoolean(8));
			lista.add(rs.getInt(9));
			lista.add(rs.getInt(10));
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void cambiarNombreCurso(String nombre, Integer idCurso) {
		PreparedStatement ps = null;
		String query;
		try {
			query = "UPDATE Curso SET NOMBRE = ? WHERE ID_CURSO = ?";
			ps = (PreparedStatement) con.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setInt(2, idCurso);
			int res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cambiarDescripcionCurso(String descripcion, Integer idCurso) {
		PreparedStatement ps = null;
		String query;
		try {
			query = "UPDATE Curso SET DESCRIPCION = ? WHERE ID_CURSO = ?";
			ps = (PreparedStatement) con.prepareStatement(query);
			ps.setString(1, descripcion);
			ps.setInt(2, idCurso);
			int res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cambiarImagenCurso(String imagen, Integer idCurso) {
		PreparedStatement ps = null;
		String query;
		try {
			query = "UPDATE Curso SET IMAGEN = ? WHERE ID_CURSO = ?";
			ps = (PreparedStatement) con.prepareStatement(query);
			ps.setString(1, imagen);
			ps.setInt(2, idCurso);
			int res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cambiarPrivacidadCurso(Boolean publico, Integer idCurso) {
		PreparedStatement ps = null;
		String query;
		try {
			query = "UPDATE Curso SET PUBLICO = ? WHERE ID_CURSO = ?";
			ps = (PreparedStatement) con.prepareStatement(query);
			ps.setBoolean(1, publico);
			ps.setInt(2, idCurso);
			int res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cambiarAforoCurso(Integer aforo, Integer idCurso) {
		PreparedStatement ps = null;
		String query;
		try {
			query = "UPDATE Curso SET AFORO = ? WHERE ID_CURSO = ?";
			ps = (PreparedStatement) con.prepareStatement(query);
			ps.setInt(1, aforo);
			ps.setInt(2, idCurso);
			int res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cambiarModalidadCurso(Boolean presencial, Integer idCurso) {
		PreparedStatement ps = null;
		String query;
		try {
			query = "UPDATE Curso SET PRESENCIAL = ? WHERE ID_CURSO = ?";
			ps = (PreparedStatement) con.prepareStatement(query);
			ps.setBoolean(1, presencial);
			ps.setInt(2, idCurso);
			int res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cambiartieneForoCurso(Boolean tieneForo, Integer idCurso) {
		PreparedStatement ps = null;
		String query;
		try {
			query = "UPDATE Curso SET TIENEFORO = ? WHERE ID_CURSO = ?";
			ps = (PreparedStatement) con.prepareStatement(query);
			ps.setBoolean(1, tieneForo);
			ps.setInt(2, idCurso);
			int res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertarEstudianteEnCurso(Usuario estudiante, Integer idCurso) {
		PreparedStatement ps = null;
		String query = "INSERT INTO RelCursoEstudiante (ID_CURSO, ID_ESTUDIANTE) VALUES (?, ?)";
		
		try {
			java.sql.PreparedStatement pS = (PreparedStatement) con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pS.setString(1, idCurso);
			pS.setString(2, estudiante.getId());
			int res = pS.executeUpdate();
			ResultSet rs = pS.getGeneratedKeys();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//==============================================================================
	//============================= ACTIVIDAD ======================================
	
	
	
}
