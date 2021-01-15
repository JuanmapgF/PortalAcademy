package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.EnviarCorreo;
import Modelo.MensajeNoticia;
import Modelo.Usuario;
import Vista.AdminActividades;
import Vista.AdminCursos;
import Vista.AdminForos;
import Vista.AdminInicio;
import Vista.AdminNoticias;
import Vista.AdminUsuarios;
import Vista.Explorar;
import Vista.Main;

public class CtrAdminNoticias implements ActionListener {

	private AdminNoticias vista;

	public CtrAdminNoticias(AdminNoticias v) {
		vista = v;

		vista.bActividades_1.addActionListener(this);
		vista.bCerrarSesion.addActionListener(this);
		vista.bCursos_1.addActionListener(this);
		vista.bInicio.addActionListener(this);
		vista.bUsuarios_1.addActionListener(this);
		vista.agregarNoticia.addActionListener(this);
		vista.bForos_1.addActionListener(this);
		vista.bNoticias_1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.bNoticias_1) {
			CtrAdminNoticias ctrAdminNoticias = new CtrAdminNoticias(new AdminNoticias());
			Main.setPanel(ctrAdminNoticias.getPanel());
		}

		if (e.getSource() == vista.bForos_1) {
			CtrAdminForos ctrAdminForos = new CtrAdminForos(new AdminForos());
			Main.setPanel(ctrAdminForos.getPanel());
		}

		// pulsar en cualquiera de los dos botones de "ACTIVIDAD"
		if (e.getSource() == vista.bActividades_1) {
			CtrAdminActividades ctr = new CtrAdminActividades(new AdminActividades());
			Main.setPanel(ctr.getPanel());
		}

		// pulsar en el botón "CERRARSESION"
		if (e.getSource() == vista.bCerrarSesion) {
			CtrExplorar c = new CtrExplorar(
					new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
			Main.setPanel(c.getPanel());
		}

		// pulsar en el botón "CURSOS"
		if (e.getSource() == vista.bCursos_1) {
			CtrAdminCursos ctr = new CtrAdminCursos(new AdminCursos());
			Main.setPanel(ctr.getPanel());
		}

		// pulsar en el botón "INICIO"
		if (e.getSource() == vista.bInicio) {
			CtrAdminInicio ctr = new CtrAdminInicio(new AdminInicio());
			Main.setPanel(ctr.getPanel());
		}

		// pulsar en el botón "USUARIOS"
		if (e.getSource() == vista.bUsuarios_1) {
			CtrAdminUsuarios ctr = new CtrAdminUsuarios(new AdminUsuarios());
			Main.setPanel(ctr.getPanel());
		}

		if (e.getSource() == vista.agregarNoticia) {
			String noticia = vista.getNoticia();

			if (noticia.length() > 80) {
				JOptionPane.showMessageDialog(vista, "La noticia ha superado los 80 caracteres permitidos");
			} else if (noticia.equals("") || noticia.charAt(0) == ' ') {
				JOptionPane.showMessageDialog(vista, "La noticia debe empezar por algun caracter");
			} else {
				new MensajeNoticia(noticia);
				CtrAdminNoticias ctr = new CtrAdminNoticias(new AdminNoticias());
				Main.setPanel(ctr.getPanel());
				for (Usuario u : Usuario.getUsuarios()) {
					EnviarCorreo.enviarGmailUnico(u.getCorreo(), "Noticias",
							"Hola buenas " + u.getNick() + ",\n\nLe adjuntamos la siguiente noticia:\n" + noticia
									+ "\n\nUn cordial saludo de la comunidad NoTrabaJava.");
				}
			}
		}

	}

	public JPanel getPanel() {
		return vista;
	}

}
