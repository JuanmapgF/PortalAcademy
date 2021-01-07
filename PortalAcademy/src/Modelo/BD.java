package Modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BD {

	private static final String URL = "jdbc:mysql://ingreq2021-mysql.cobadwnzalab.eu-central-1.rds.amazonaws.com";
	private static final String SCHEMA = "apsgrupo09";
	private static final String USERNAME = "grupo09";
	private static final String PASSWORD = "morenobecerra2021";

	private Connection con;

	private static BD bd;
	private static int cnt = 0;

	public BD() {
		try {
			con = DriverManager.getConnection(URL + "/" + SCHEMA, USERNAME, PASSWORD);
		} catch (SQLException e) {
			throw new ErrorBD("Error al iniciar la conexion con la base de datos: " + e.getMessage());
		} catch (Exception e) {
			throw new ErrorBD("Error inesperado: " + e.getMessage());
		}
	}

	// Utilizar este metodo para construir objetos de BD (singleton):

	public static BD getBD() {
		if (bd == null) {
			bd = new BD();
		}
		return bd;
	}

	// ------------------------

	public void finalize() {
		try {
			if (cnt == 0) {
				if (con != null) {
					con.close();
					bd = null;
				}
			} else {
				cnt--;
			}
		} catch (SQLException e) {
			throw new ErrorBD("Error al Cerrar la Conexi�n." + e.getMessage());
		}
	}

	public static void contadorFinalize(int cnt) {
		BD.cnt = cnt;
	}

	public Object SelectEscalar(String sel) {
		if (!sel.toUpperCase().startsWith("SELECT"))
			throw new ErrorBD("SELECT Sytanx Error: " + sel);

		ResultSet rset;
		Object res = null;
		try {
			Statement stmt = con.createStatement();
			rset = stmt.executeQuery(sel);
			rset.next();
			res = rset.getObject(1);
			rset.close();
			stmt.close();
		} catch (SQLException ex) {
			throw new ErrorBD("Error en el SELECT: " + sel + ". " + ex.getMessage());
		}

		return res;
	}

	public List<Object[]> Select(String sel) {
		if (!sel.toUpperCase().startsWith("SELECT"))
			throw new ErrorBD("SELECT Sytanx Error: " + sel);

		ResultSet rset;
		List<Object[]> lista = new ArrayList<Object[]>();
		try {
			Statement stmt = con.createStatement();
			rset = stmt.executeQuery(sel);
			ResultSetMetaData meta = rset.getMetaData();
			int numCol = meta.getColumnCount();
			while (rset.next()) {
				Object[] tupla = new Object[numCol];
				for (int i = 0; i < numCol; ++i) {
					tupla[i] = rset.getObject(i + 1);
				}
				lista.add(tupla);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			throw new ErrorBD("Error en el SELECT: " + sel + ". " + e.getMessage());
		}

		return lista;
	}

	public File SelectImagenCurso(Integer idCurso) {
		File file = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT imagen FROM Curso WHERE idCurso = " + idCurso);
			if (rs.next()) {
				Blob blob = rs.getBlob("imagen");
				if (blob != null) {
					file = new File("Curso" + idCurso + ".jpg");
					InputStream lecturaFich = blob.getBinaryStream();
					BufferedInputStream in = new BufferedInputStream(lecturaFich);
					BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
					byte[] buffer = new byte[8096];
					int length = 0;
					while ((length = in.read(buffer)) > 0) {
						out.write(buffer, 0, length);
					}
					out.flush();
					out.close();
					in.close();
				}
			}
		} catch (FileNotFoundException e) {
			throw new ErrorBD("Error al encontrar la imagen. " + e.getMessage());
		} catch (SQLException e) {
			throw new ErrorBD("Error en el Select de la imagen. " + e.getMessage());
		} catch (IOException e) {
			throw new ErrorBD("Error al leer la Imagen. " + e.getMessage());
		}

		return file;
	}

	public File SelectImagenActividad(Integer idActividad) {
		File file = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT imagen FROM Actividad WHERE idActividad = " + idActividad);
			if (rs.next()) {
				Blob blob = rs.getBlob("imagen");
				if (blob != null) {
					file = new File("Actividad" + idActividad + ".jpg");
					InputStream lecturaFich = blob.getBinaryStream();
					BufferedInputStream in = new BufferedInputStream(lecturaFich);
					BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
					byte[] buffer = new byte[8096];
					int length = 0;
					while ((length = in.read(buffer)) > 0) {
						out.write(buffer, 0, length);
					}
					out.flush();
					out.close();
					in.close();
				}
			}
		} catch (FileNotFoundException e) {
			throw new ErrorBD("Error al encontrar la imagen. " + e.getMessage());
		} catch (SQLException e) {
			throw new ErrorBD("Error en el Select de la imagen. " + e.getMessage());
		} catch (IOException e) {
			throw new ErrorBD("Error al leer la Imagen. " + e.getMessage());
		}

		return file;
	}

	public void Insert(String ins) {
		if (!ins.toUpperCase().startsWith("INSERT"))
			throw new ErrorBD("INSERT Sytanx Error: " + ins);

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(ins);
			stmt.close();
		} catch (SQLException e) {
			throw new ErrorBD("Error en el INSERT: " + ins + ". " + e.getMessage());
		}
	}

	public void InsertCurso(String nombre, String descripcion, File imagen, Boolean publico, Integer aforo,
			Boolean presencial, Boolean tieneForo, String profesor) {
		try {
			FileInputStream fis = null;
			if (imagen != null) {
				fis = new FileInputStream(imagen);
			}

			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO Curso 	(nombre, descripcion, imagen, publico, aforo, presencial, tieneForo, nickProfesor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, nombre);
			ps.setString(2, descripcion);
			ps.setBlob(3, fis);
			ps.setInt(4, ((publico) ? 1 : 0));
			ps.setInt(5, aforo);
			ps.setInt(6, ((presencial) ? 1 : 0));
			ps.setInt(7, ((tieneForo) ? 1 : 0));
			ps.setString(8, profesor);
			ps.execute();
			ps.close();
		} catch (FileNotFoundException e) {
			throw new ErrorBD("Error al encontrar el archivo. " + e.getMessage());
		} catch (SQLException e) {
			throw new ErrorBD("Error en el insert de imagen. " + e.getMessage());
		}
	}

	public void InsertActividad(String nombre, String descripcion, File imagen, int aforo, String fecha, String lugar,
			String organizacion) {
		try {
			FileInputStream fis = null;
			if (imagen != null) {
				fis = new FileInputStream(imagen);
			}
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO Actividad (nombre, descripcion, imagen, aforo, fecha, lugar, nickOrganizacion) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, nombre);
			ps.setString(2, descripcion);
			ps.setBlob(3, fis);
			ps.setInt(4, aforo);
			ps.setString(5, fecha);
			ps.setString(6, lugar);
			ps.setString(7, organizacion);
			ps.execute();
			ps.close();
		} catch (FileNotFoundException e) {
			throw new ErrorBD("Error al encontrar el archivo. " + e.getMessage());
		} catch (SQLException e) {
			throw new ErrorBD("Error en el insert de imagen. " + e.getMessage());
		}
	}

	public void Delete(String del) {
		if (!del.toUpperCase().startsWith("DELETE"))
			throw new ErrorBD("DELETE Sytanx Error: " + del);
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(del);
			stmt.close();
		} catch (SQLException e) {
			throw new ErrorBD("Error en el DELETE: " + del + ". " + e.getMessage());
		}
	}

	public void Update(String up) {
		if (!up.toUpperCase().startsWith("UPDATE"))
			throw new ErrorBD("UPDATE Sytanx Error: " + up);

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(up);
			stmt.close();
		} catch (SQLException e) {
			throw new ErrorBD("Error en el UPDATE: " + up + ". " + e.getMessage());
		}
	}

	public void UpdateImagenCurso(File imagen, int idCurso) {
		try {
			FileInputStream fis = null;
			if (imagen != null) {
				fis = new FileInputStream(imagen);
			}
			PreparedStatement ps = con.prepareStatement("UPDATE Curso SET imagen = ? WHERE idCurso = ?");
			ps.setBlob(1, fis);
			ps.setInt(2, idCurso);
			ps.execute();
			ps.close();
		} catch (FileNotFoundException e) {
			throw new ErrorBD("Error al encontrar el archivo. " + e.getMessage());
		} catch (SQLException e) {
			throw new ErrorBD("Error en el update de imagen. " + e.getMessage());
		}
	}

	public void UpdateImagenActividad(File imagen, int idActividad) {
		try {
			FileInputStream fis = null;
			if (imagen != null) {
				fis = new FileInputStream(imagen);
			}
			PreparedStatement ps = con.prepareStatement("UPDATE Actividad SET imagen = ? WHERE idActividad = ?");
			ps.setBlob(1, fis);
			ps.setInt(2, idActividad);
			ps.execute();
			ps.close();
		} catch (FileNotFoundException e) {
			throw new ErrorBD("Error al encontrar el archivo. " + e.getMessage());
		} catch (SQLException e) {
			throw new ErrorBD("Error en el update de imagen. " + e.getMessage());
		}
	}

	public void CallProcedure(String name, Object[] param) {
		try {
			if (param == null || param.length == 0) {
				Statement stmt = con.createStatement();
				stmt.executeQuery("{call  " + name + "}");
				stmt.close();
			} else {
				String sentencia = "{call " + name + " (?";
				for (int i = 1; i < param.length; ++i)
					sentencia += ",?";
				sentencia += ")}";
				PreparedStatement pstmt = con.prepareStatement(sentencia);
				for (int i = 0; i < param.length; ++i)
					pstmt.setObject(i + 1, param[i]);
				pstmt.execute();
				pstmt.close();
			}
		} catch (SQLException e) {
			throw new ErrorBD("Error en el CallProcedure: " + name + ". " + e.getMessage());
		}
	}

	public Object FunctionCall(String name, int retType, Object[] param) {
		Object res = null;
		String sentencia = "{? = call " + name + " (";
		int l = (param == null ? 0 : param.length);

		try {
			if (l > 0) {
				sentencia += "?";
				for (int i = 1; i < param.length; ++i)
					sentencia += ",?";
			}
			sentencia += ")}";

			CallableStatement cstmt = con.prepareCall(sentencia);
			cstmt.registerOutParameter(1, retType);

			for (int i = 0; i < param.length; ++i)
				cstmt.setObject(i + 2, param[i]);
			cstmt.execute();
			res = cstmt.getObject(1);
			cstmt.close();
		} catch (SQLException e) {
			throw new ErrorBD("Error en el FunctionCall: " + name + ". " + e.getMessage());
		}

		return res;
	}

	public String[] getNombreColumnas(String tableName) {
		String[] res = null;

		try {
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM " + tableName + ";");
			ResultSetMetaData rsetMD = rset.getMetaData();
			res = new String[rsetMD.getColumnCount()];
			for (int i = 0; i < rsetMD.getColumnCount(); ++i)
				res[i] = rsetMD.getColumnName(i + 1);
		} catch (SQLException e) {
			throw new ErrorBD("Error en el getNombreColumnas: " + tableName + ". " + e.getMessage());
		}

		return res;

	}
}
