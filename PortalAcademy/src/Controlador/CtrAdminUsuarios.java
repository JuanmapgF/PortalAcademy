package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Usuario;
import Vista.AdminActividades;
import Vista.AdminCursos;
import Vista.AdminInicio;
import Vista.AdminUsuarios;
import Vista.Explorar;
import Vista.Main;

public class CtrAdminUsuarios implements ActionListener {

	private AdminUsuarios vista;

	public CtrAdminUsuarios(AdminUsuarios v) {
		vista = v;
		vista.bActividades_1.addActionListener(this);
		vista.bAjustes.addActionListener(this);
		vista.bCerrarSesion.addActionListener(this);
		vista.bCursos_1.addActionListener(this);
		vista.bInicio.addActionListener(this);
		vista.bUsuarios_1.addActionListener(this);
		vista.bEliminar.addActionListener(this);
	}

	public AdminUsuarios getPanel() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// pulsar en el botón "ELIMINAR" tras seleccionar un curso
		if (e.getSource() == vista.bEliminar) {
			Usuario u = vista.getUsuario();
			if (u != null) {
				u.eliminarUsuario();
				JOptionPane.showMessageDialog(vista, "Usuario eliminado de forma satisfactoria", "Usuario eliminado",
						JOptionPane.INFORMATION_MESSAGE);
				CtrAdminUsuarios ctr = new CtrAdminUsuarios(new AdminUsuarios());
				Main.setPanel(ctr.getPanel());
			}
		}

		// pulsar en cualquiera de los dos botones de "ACTIVIDAD"
		if (e.getSource() == vista.bActividades_1) {
			CtrAdminActividades ctr = new CtrAdminActividades(new AdminActividades());
			Main.setPanel(ctr.getPanel());
		}

		// pulsar en el botón "AJUSTES"
		if (e.getSource() == vista.bAjustes) {

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
	}

}
