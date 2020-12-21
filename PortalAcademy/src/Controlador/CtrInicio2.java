package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.Actividad;
import Modelo.Administrador;
import Modelo.BD;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;
import Vista.AdminInicio;
import Vista.Explorar;
import Vista.Inicio;
import Vista.Main;

public class CtrInicio2 implements KeyListener {

	private Inicio ventana;

	public CtrInicio2(Inicio v) {
		ventana = v;
		ventana.controladorEnter(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ENTER) {
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

					CtrExplorar ex = new CtrExplorar(new Explorar(est, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
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
					CtrExplorar ex = new CtrExplorar(new Explorar(est, Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
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

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
