package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Vista.AdminActividades;
import Vista.AdminCursos;
import Vista.AdminForos;
import Vista.AdminInicio;
import Vista.AdminNoticias;
import Vista.AdminUsuarios;
import Vista.Explorar;
import Vista.Main;

public class CtrAdminForos implements ActionListener {

	private AdminForos vista;

	public CtrAdminForos(AdminForos v) {
		vista = v;

		vista.bActividades_1.addActionListener(this);
		vista.bForos_1.addActionListener(this);
		vista.bNoticias_1.addActionListener(this);
		vista.bCerrarSesion.addActionListener(this);
		vista.bCursos_1.addActionListener(this);
		vista.bInicio.addActionListener(this);
		vista.bUsuarios_1.addActionListener(this);
		vista.bEliminar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// pulsar en el botón "ELIMINAR" tras seleccionar un curso

		if (e.getSource() == vista.bNoticias_1) {
			CtrAdminNoticias ctrAdminNoticias = new CtrAdminNoticias(new AdminNoticias());
			Main.setPanel(ctrAdminNoticias.getPanel());
		}

		if (e.getSource() == vista.bForos_1) {
			CtrAdminForos ctrAdminForos = new CtrAdminForos(new AdminForos());
			Main.setPanel(ctrAdminForos.getPanel());
		}

		if (e.getSource() == vista.bEliminar) {
			Curso cur = vista.getCurso();
			if (cur != null) {
				cur.setTieneForo(false);
				JOptionPane.showMessageDialog(vista, "Se ha eliminado el foro del curso de forma satisfactoria",
						"Eliminar foro", JOptionPane.INFORMATION_MESSAGE);
				CtrAdminForos ctr = new CtrAdminForos(new AdminForos());
				Main.setPanel(ctr.getPanel());
			}
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
	}

	public JPanel getPanel() {
		return vista;
	}

}
