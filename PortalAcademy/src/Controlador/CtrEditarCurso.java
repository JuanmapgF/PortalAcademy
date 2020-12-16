package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Profesor;
import Vista.Ajustes;
import Vista.EditarCurso;
import Vista.Explorar;
import Vista.Main;
import Vista.MisCursos;

public class CtrEditarCurso implements ActionListener {

	private EditarCurso ventana;
	private Curso curso;
	private Profesor profesor;

	public CtrEditarCurso(EditarCurso v) {
		ventana = v;
		ventana.controlador(this);
		curso = ventana.getC();
		profesor = ventana.getUsuario();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("GUARDAR")) {
			if (ventana.getAforo() > 0) {
				curso.setAforo(ventana.getAforo());
				curso.setDescripcion(ventana.getDescripcion());
				curso.setNombre(ventana.getNombre());
				curso.setPresencial(ventana.getPresencial());
				curso.setPublico(ventana.getPublico());
				curso.setTieneForo(ventana.getForo());

				JOptionPane.showMessageDialog(ventana, "Se ha actualizado la información del curso correctamente");

				CtrInformacionCurso c = new CtrInformacionCurso(profesor, curso);
				Main.setPanel(c.getPanel());
			} else {
				JOptionPane.showMessageDialog(ventana, "El aforo debe ser un entero positivo");
			}
		}

		if (e.getActionCommand().equals("ELIMINAR")) {
			curso.eliminarCurso();
			CtrMisCursos c = new CtrMisCursos(new MisCursos(profesor));
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("VOLVER")) {
			int res = JOptionPane.showConfirmDialog(ventana, "¿Salir sin guardar?");

			if (res == 0) {
				CtrInformacionCurso c = new CtrInformacionCurso(profesor, curso);
				Main.setPanel(c.getPanel());
			}
		}

		if (e.getActionCommand().equals("CERRAR_SESION")) {

			CtrExplorar c = new CtrExplorar(
					new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
			Main.setPanel(c.getPanel());

		}

		if (e.getActionCommand().equals("EXPLORAR")) {
			CtrExplorar c = new CtrExplorar(new Explorar(profesor, Curso.getTodosLosCursos()));
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("CURSOS")) {
			CtrMisCursos c = new CtrMisCursos(new MisCursos(profesor));
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("AJUSTES")) {
			CtrAjustes c = new CtrAjustes(new Ajustes(profesor));
			Main.setPanel(c.getPanel());
		}

		if (e.getActionCommand().equals("PUBLICO")) {
			ventana.setPublico(true);
			ventana.setPrivado(false);
		}

		if (e.getActionCommand().equals("PRIVADO")) {
			ventana.setPublico(false);
			ventana.setPrivado(true);
		}

		if (e.getActionCommand().equals("PRESENCIAL")) {
			ventana.setPresencial(true);
			ventana.setOnline(false);
		}

		if (e.getActionCommand().equals("ONLINE")) {
			ventana.setPresencial(false);
			ventana.setOnline(true);
		}
	}

	public JPanel getPanel() {
		return ventana;
	}

}
