package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class CtrAdminInicio implements ActionListener {

	private AdminInicio vista;

	public CtrAdminInicio(AdminInicio v) {
		vista = v;

		vista.bActividades.addActionListener(this);
		vista.bActividades_1.addActionListener(this);
		vista.bCerrarSesion.addActionListener(this);
		vista.bCursos.addActionListener(this);
		vista.bCursos_1.addActionListener(this);
		vista.bInicio.addActionListener(this);
		vista.bUsuarios.addActionListener(this);
		vista.bUsuarios_1.addActionListener(this);
		vista.bNoticias.addActionListener(this);
		vista.bForos.addActionListener(this);
		vista.bForos_1.addActionListener(this);
	}

	public AdminInicio getPanel() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.bForos || e.getSource() == vista.bForos_1) {
			CtrAdminForos ctrAdminForos = new CtrAdminForos(new AdminForos());
			Main.setPanel(ctrAdminForos.getPanel());
		}

		// pulsar en cualquiera de los dos botones de "ACTIVIDAD"
		if (e.getSource() == vista.bActividades || e.getSource() == vista.bActividades_1) {
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
		if (e.getSource() == vista.bCursos || e.getSource() == vista.bCursos_1) {
			CtrAdminCursos ctr = new CtrAdminCursos(new AdminCursos());
			Main.setPanel(ctr.getPanel());
		}

		// pulsar en el botón "INICIO"
		if (e.getSource() == vista.bInicio) {
			CtrAdminInicio ctr = new CtrAdminInicio(new AdminInicio());
			Main.setPanel(ctr.getPanel());
		}

		// pulsar en el botón "USUARIOS"
		if (e.getSource() == vista.bUsuarios || e.getSource() == vista.bUsuarios_1) {
			CtrAdminUsuarios ctr = new CtrAdminUsuarios(new AdminUsuarios());
			Main.setPanel(ctr.getPanel());
		}

		if (e.getSource() == vista.bNoticias || e.getSource() == vista.bNoticias_1) {
			CtrAdminNoticias ctr = new CtrAdminNoticias(new AdminNoticias());
			Main.setPanel(ctr.getPanel());
		}

	}

}
