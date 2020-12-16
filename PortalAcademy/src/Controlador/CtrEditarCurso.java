package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
			} else {
				JOptionPane.showMessageDialog(ventana, "El aforo debe ser un entero positivo");
			}
		}
		
		if (e.getActionCommand().equals("ELIMINAR")) {
			curso.eliminarCurso();
		}
		
		if (e.getActionCommand().equals("VOLVER")) {
			
		}
		
		if (e.getActionCommand().equals("CERRAR_SESION")) {
			
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
	}

}
