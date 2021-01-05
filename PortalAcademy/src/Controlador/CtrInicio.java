package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Administrador;
import Modelo.BD;
import Modelo.Curso;
import Modelo.EnviarCorreo;
import Modelo.ErrorBD;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;
import Vista.AdminInicio;
import Vista.Explorar;
import Vista.Inicio;
import Vista.Main;
import Vista.Registro;

public class CtrInicio implements ActionListener {

	private Inicio ventana;

	public CtrInicio(Inicio v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("REGISTRATE")) {
			CtrRegistro cr = new CtrRegistro(new Registro());
			Main.setPanel(cr.getPanel());
		}

		if (e.getActionCommand().equals("RECUPERAR")) {
			try {
				if (!correoValido()) {
					throw new ErrorBD("Introduzca un correo válido.");
				}
				if (!correoRegistrado()) {
					throw new ErrorBD("El correo introducido no está vinculado con ninguna cuenta");
				}
				JOptionPane.showMessageDialog(ventana,
						"Se ha enviado un correo al indicado con las instrucciones para recuperar tu cuenta.",
						"Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
				BD bd = new BD();
				String pass = bd
						.SelectEscalar("SELECT contrasena FROM Usuario WHERE correo = '" + ventana.getCorreo() + "'")
						.toString();
				bd.finalize();
				EnviarCorreo.enviarGmailUnico(ventana.getCorreo(), "PortalAcademy",
						"Hola buenas,\n\nLe envío su contraseña actual. Recuerde que en caso de tener algún problema para recordarla siempre cambiarla en la pestaña de Ajustes.\nLa contraseña es: "
								+ pass + "\n\nUn cordial saludo de la comunidad NoTrabaJava.");
			} catch (ErrorBD err) {
				JOptionPane.showMessageDialog(ventana, err.getMessage(), "Recuperar contraseña",
						JOptionPane.ERROR_MESSAGE);
			}

		}

		if (e.getActionCommand().equals("VOLVER")) {

			CtrExplorar ex = new CtrExplorar(
					new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
			Main.setPanel(ex.getPanel());

		}

		if (e.getActionCommand().equals("INICIAR")) {
			ventana.ocultarError();
			Usuario u = new Usuario(ventana.getUser(), ventana.getPass());
			List<Usuario> users = Usuario.getUsuarios();

			if (users.contains(u)) {
				Usuario ini = new Usuario(u.getNick());

				BD bd = BD.getBD();

				if (Integer.parseInt(
						bd.SelectEscalar("SELECT COUNT(nick) FROM Estudiante WHERE nick = '" + u.getNick() + "'")
								.toString()) == 1) {
					bd.finalize();

					Estudiante est = null;
					try {
						est = new Estudiante(ini.getNick());
						est.setListaCursos();
						est.setListaActividades();
					} catch (ParseException e2) {
						e2.printStackTrace();
					} finally {
						Main.setUser(est);
					}

					CtrExplorar ex = new CtrExplorar(
							new Explorar(est, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
					Main.setPanel(ex.getPanel());

				} else if (Integer.parseInt(
						bd.SelectEscalar("SELECT COUNT(nick) FROM Organizacion WHERE nick = '" + u.getNick() + "'")
								.toString()) == 1) {
					bd.finalize();
					Organizacion est = null;
					try {
						est = new Organizacion(ini.getNick());
						est.setListaActividades();
						est.setListaCursos();
					} finally {
						Main.setUser(est);
					}

					CtrExplorar ex = new CtrExplorar(
							new Explorar(est, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
					Main.setPanel(ex.getPanel());

				} else if (Integer.parseInt(
						bd.SelectEscalar("SELECT COUNT(nick) FROM Profesor WHERE nick = '" + u.getNick() + "'")
								.toString()) == 1) {
					bd.finalize();
					Profesor est = null;
					try {
						est = new Profesor(ini.getNick());
						est.setListaActividades();
						est.setListaCursos();
					} finally {
						Main.setUser(est);
					}

					Main.setUser(est);
					CtrExplorar ex = new CtrExplorar(
							new Explorar(est, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
					Main.setPanel(ex.getPanel());
				} else if (Integer.parseInt(
						bd.SelectEscalar("SELECT COUNT(nick) FROM Administrador WHERE nick = '" + u.getNick() + "'")
								.toString()) == 1) {
					Administrador est = null;
					try {
						est = new Administrador(ini.getNick());
					} finally {
						Main.setUser(est);
					}
					CtrAdminInicio cai = new CtrAdminInicio(new AdminInicio());
					Main.setPanel(cai.getPanel());
				} else {
					JOptionPane.showMessageDialog(ventana, "El usuario o contraseña introducidos son erróneos");
				}
			} else {
				JOptionPane.showMessageDialog(ventana, "El usuario o contraseña introducidos son erróneos");
			}

		}
	}

	public boolean correoValido() {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$");
		Matcher mather = pattern.matcher(ventana.getCorreo());
		return mather.find();
	}

	private boolean correoRegistrado() {
		BD bd = BD.getBD();
		int ccorreo = Integer.parseInt(bd
				.SelectEscalar("SELECT COUNT(correo) FROM Usuario WHERE Usuario.correo = '" + ventana.getCorreo() + "'")
				.toString());
		bd.finalize();
		return ccorreo == 1;
	}

	public JPanel getPanel() {
		return ventana;
	}
}
