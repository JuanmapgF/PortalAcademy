package Controlador;

import java.awt.event.*;
import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Vista.*;
import Modelo.*;

public class CtrInicio implements ActionListener {

	private Inicio ventana;

	public CtrInicio(Inicio v) {
		ventana = v;
		ventana.controlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("REGISTRATE")) {
			CtrRegistro cr = new CtrRegistro(new Registro());
			Main.setPanel(cr.getPanel());
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

					} catch (ParseException e2) {
						// TODO Auto-generated catch block
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
					} finally {
						Main.setUser(est);
					}

					CtrExplorar ex = new CtrExplorar(new Explorar(est, Actividad.getTodasLasActividades()));
					Main.setPanel(ex.getPanel());

				} else if (Integer.parseInt(
						bd.SelectEscalar("SELECT COUNT(nick) FROM Profesor WHERE nick = '" + u.getNick() + "'")
								.toString()) == 1) {
					bd.finalize();
					Profesor est = null;
					try {
						est = new Profesor(ini.getNick());
					} finally {
						Main.setUser(est);
					}

					Main.setUser(est);
					CtrExplorar ex = new CtrExplorar(new Explorar(est, Curso.getTodosLosCursos()));
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

	public JPanel getPanel() {
		return ventana;
	}
}
